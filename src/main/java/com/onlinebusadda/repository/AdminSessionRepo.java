package com.onlinebusadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebusadda.model.CurrentAdminSession;

@Repository
public interface AdminSessionRepo extends JpaRepository<CurrentAdminSession, Integer> {

	public  CurrentAdminSession findByUuid(String uUid);
	
}
