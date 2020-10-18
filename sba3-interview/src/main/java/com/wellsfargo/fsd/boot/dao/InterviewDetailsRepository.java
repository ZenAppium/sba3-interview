package com.wellsfargo.fsd.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.boot.entity.InterviewDetails;
@Repository
public interface InterviewDetailsRepository extends JpaRepository<InterviewDetails, Integer> {
		List<InterviewDetails> findByInterviewName(String interviewName);
		List<InterviewDetails> findByInterviewerName(String interviewerName);		
		
}
