package com.job_room.hr_ervice.service.serviceImp;

import com.job_room.hr_ervice.model.announcement.AnnouncementResponse;
import com.job_room.hr_ervice.model.company.Company;
import com.job_room.hr_ervice.model.company.CompanyDto;
import com.job_room.hr_ervice.model.company.CompanyResponse;
import com.job_room.hr_ervice.repository.CompanyRepository;
import com.job_room.hr_ervice.rest.message.BaseApiResponse;
import com.job_room.hr_ervice.rest.message.CompanyAnnouncement;
import com.job_room.hr_ervice.service.CompanyService;
import com.job_room.hr_ervice.utils.PaginationUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    private CompanyRepository companyRepository;

    private ModelMapper modelMapper;

    private RestTemplate restTemplate;

    HttpHeaders headers;

    HttpEntity<String> entity;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



    //For Admin

    //TODO: Select all companies =========================================================
    @Override
    public Page<CompanyDto> findAll(String name, Pageable pagination) {

        Page<Company> companies = companyRepository.findAllByNameContainingAndStatusIsTrue(name, pagination);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        PaginationUtils<CompanyDto, Page<Company>> paging = new PaginationUtils<>(CompanyDto.class);
        paging.setData(companies);
        Page<CompanyDto> companyDtos = paging;

        return companyDtos;
    }

    @Override
    public CompanyDto ban(int id) {

        Company company = companyRepository.findByIdAndStatusIsTrue(id);
        if(company==null){
            return null;
        }
        company.setBanned(true);

        Company isUpdated = companyRepository.save(company);

        CompanyDto companyDto = modelMapper.map(company,CompanyDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return companyDto;
    }

    @Override
    public CompanyDto unban(int id) {

        Company company = companyRepository.findByIdAndStatusIsTrue(id);
        if(company==null){
            return null;
        }
        company.setBanned(false);

        Company isUpdated = companyRepository.save(company);

        CompanyDto companyDto = modelMapper.map(company,CompanyDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return companyDto;
    }

    @Override
    public int countAllCompany() {
        return companyRepository.countAllAndStatusIsTrue();
    }


    //For HR

    //TODO: Select company by id =========================================================
    @Override
    public CompanyDto selectById(int id) {

        Company company = companyRepository.findByIdAndStatusIsTrue(id);

        if (company == null)
            return null;

        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

        return companyDto;
    }



    //TODO: Insert company =========================================================
    @Override
    public CompanyDto insert(CompanyDto companyDto) {

        companyDto.setStatus(true);

        Company company = modelMapper.map(companyDto, Company.class);

        Company isInserted = companyRepository.save(company);

        companyDto.setId(company.getId());

        if (isInserted == null) {
            return null;
        } else
            return companyDto;
    }

    //TODO: Delete company =========================================================
    @Override
    public CompanyDto delete(int id) {

        Company company = companyRepository.findByIdAndStatusIsTrue(id);

        if (company == null)
            return null;

        company.setStatus(false);

        companyRepository.save(company);

        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

        return companyDto;
    }

    //TODO: Update company =========================================================
    @Override
    public CompanyDto update(CompanyDto companyDto) {

        Company company = modelMapper.map(companyDto, Company.class);

        if (companyRepository.findByIdAndStatusIsTrue(company.getId()) == null)
            return null;

        Company isUpdated = companyRepository.save(company);

        if (isUpdated == null) {
            return null;
        } else
            return companyDto;
    }

    //TODO: Select company with announcements =========================================================
    @Override
    public CompanyAnnouncement selectCompanyWithAnnouncements(int id) {

        CompanyAnnouncement companyAnnouncement = new CompanyAnnouncement();
        Company company = companyRepository.findByIdAndStatusIsTrue(id);

        if(company==null)
            return null;

        CompanyResponse companyResponse = modelMapper.map(company, CompanyResponse.class);

        ParameterizedTypeReference<BaseApiResponse<List<AnnouncementResponse>>> parameterizedTypeReference =
                new ParameterizedTypeReference<BaseApiResponse<List<AnnouncementResponse>>>() {
                };
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<BaseApiResponse<List<AnnouncementResponse>>> result = restTemplate.exchange("http://localhost:8082/api/v1/announcements/company/" + id, HttpMethod.GET, entity, parameterizedTypeReference);
        if (result.getBody().getData() == null) {
            return null;
        }

        companyAnnouncement.setCompanyResponse(companyResponse);
        companyAnnouncement.setAnnouncementResponseList(result.getBody().getData());

        return companyAnnouncement;
    }

}