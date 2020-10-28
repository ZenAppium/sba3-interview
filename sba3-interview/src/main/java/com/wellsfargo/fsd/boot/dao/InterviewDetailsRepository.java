package com.wellsfargo.fsd.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.boot.entity.InterviewDetails;
@Repository
public interface InterviewDetailsRepository extends JpaRepository<InterviewDetails, Integer> {
		
		@Query("SELECT i FROM InterviewDetails i WHERE i.interviewId=:interviewId")
		List<InterviewDetails> findAllByInterviewId(Integer interviewId);
		
		@Query("SELECT i FROM InterviewDetails i WHERE i.interviewName=:interviewName or i.interviewerName=:interviewerName")
		List<InterviewDetails> findByInterviewerName(String interviewName,String interviewerName);		
		
}
