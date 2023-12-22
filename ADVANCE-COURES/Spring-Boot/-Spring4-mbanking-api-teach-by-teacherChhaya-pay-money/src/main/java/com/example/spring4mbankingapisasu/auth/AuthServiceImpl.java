package com.example.spring4mbankingapisasu.auth;

import com.example.spring4mbankingapisasu.auth.web.AuthDto;
import com.example.spring4mbankingapisasu.auth.web.LoginDto;
import com.example.spring4mbankingapisasu.auth.web.RegisterDto;
import com.example.spring4mbankingapisasu.security.SecurityBean;
import com.example.spring4mbankingapisasu.user.User;
import com.example.spring4mbankingapisasu.user.UserMapStruct;
import com.example.spring4mbankingapisasu.util.MailUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {


    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final AuthMapper authMapper;
    private final UserMapStruct userMapStruct;
    private final MailUtil mailUtil;
    private final SecurityBean securityBean;
    private final JwtEncoder jwtEncoder;

    @Value("${spring.mail.username}")
    private String appMail;

    @Override
    public void register(RegisterDto registerDto) {

        User user = userMapStruct.fromRegoisterDtoToUser(registerDto);
        user.setIsVerified(false);
        user.setPassword(securityBean.encoder().encode(registerDto.password()));
        System.out.println(user);
        if (authMapper.register(user)) {
            for (Integer role : registerDto.roleIds()) {
                authMapper.insertRole(role, user.getId());
            }
        }
    }


    @Override
    public void verify(String email) {
        User user = authMapper.selectByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Email is not found."));
        //need to create String code
        String verifiedCode = UUID.randomUUID().toString();
        if (authMapper.updateIsVerified(email, verifiedCode)) {
            user.setVerifiedCode(verifiedCode);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "User can not be verified !!"
            );
        }
        MailUtil.Meta<?> meta = MailUtil.Meta.builder()
                .to(email)
                .from(appMail)
                .subject("Account Verify")
                .templateUrl("auth/verify")
                .data(user)
                .build();
        try {
            mailUtil.sendMail(meta);
        } catch (MessagingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public void checkVerifiedCode(String email, String verifiedCode) {
        System.out.println("chento : " + authMapper.selectByEmailAndVerifiedCode(email, verifiedCode));
        User user = authMapper.selectByEmailAndVerifiedCode(email, verifiedCode).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Email is search not found"
                )
        );
        System.out.println("User verify : " + user);
        if (!user.getIsVerified()) {
            authMapper.verify(email, verifiedCode);
        }
    }

    @Override
    public AuthDto login(LoginDto loginDto) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        authentication = daoAuthenticationProvider.authenticate(authentication);
//       log.info("Authentication: {}" , authentication);
//       log.info("Authentication: {}" , authentication.getName());
//       log.info("Authentication: {}",authentication.getCredentials());
//       //logic on basic authorization header
//        String basicAuthFormat = authentication.getName()+":"+authentication.getCredentials();
//                String encodeing  = Base64.getEncoder().encodeToString(basicAuthFormat.getBytes());
//                log.info("Basic {}" , encodeing);
//        return new AuthDto(String.format("Basic %s",encodeing));
        //create time now
        Instant now = Instant.now();

        //Define Scope
//        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority("READ"));
//        String scope = authorityList.stream()
//                .map(SimpleGrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));

        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(auth -> !auth.startsWith("ROLE_"))
                .collect(Collectors.joining(" "));

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("")
                .issuedAt(now)
                .subject(authentication.getName())
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .claim("scope", scope)
                .build();
        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        return new AuthDto("Bearer", accessToken);

    }
}
