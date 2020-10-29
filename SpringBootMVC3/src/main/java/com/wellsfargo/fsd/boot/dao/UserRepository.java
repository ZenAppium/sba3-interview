package com.wellsfargo.fsd.boot.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.boot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
}
