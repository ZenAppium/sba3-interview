package com.wellsfargo.fsd.boot.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.boot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	//boolean existsByMobile(String mobile);
	//User findByMobile(String mobile);
	//List<User> findAllByGroup(String group);
	//@Query("select c from Contact c where c.dateOfBirth between :start and :end")
	//List<User> findAllBorInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE) LocalDate end);
}
