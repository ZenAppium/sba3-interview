package com.wellsfargo.fsd.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.fsd.boot.entity.InterviewDetails;

public interface InterviewDetailsRepository extends JpaRepository<InterviewDetails, Integer> {
	//boolean existsByMobile(String mobile);
		//User findByMobile(String mobile);
		//List<User> findAllByGroup(String group);
		//@Query("select c from Contact c where c.dateOfBirth between :start and :end")
		//List<User> findAllBorInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE) LocalDate end);
}
