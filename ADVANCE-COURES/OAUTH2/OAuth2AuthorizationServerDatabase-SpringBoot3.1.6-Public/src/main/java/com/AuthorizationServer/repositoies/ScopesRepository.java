package com.AuthorizationServer.repositoies;

import com.AuthorizationServer.entities.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopesRepository extends JpaRepository<Scope,Long> {

}
