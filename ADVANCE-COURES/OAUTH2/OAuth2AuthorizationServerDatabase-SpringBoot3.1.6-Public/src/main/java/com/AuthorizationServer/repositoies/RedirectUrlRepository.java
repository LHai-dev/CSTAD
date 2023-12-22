package com.AuthorizationServer.repositoies;

import com.AuthorizationServer.entities.RedirectUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedirectUrlRepository extends JpaRepository<RedirectUrl,Long> {
}
