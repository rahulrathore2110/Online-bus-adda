package com.onlinebusadda.repository;

import com.onlinebusadda.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

    public CurrentUserSession findByUuid(String Uuid);

    public CurrentUserSession findByEmail(String email);



}
