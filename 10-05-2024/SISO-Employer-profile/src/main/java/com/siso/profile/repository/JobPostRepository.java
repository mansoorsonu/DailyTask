package com.siso.profile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.JobPostEntity;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Long>{

	

	Optional<JobPostEntity> findByJobPostId(Long jobPostId);

	void save(Optional<JobPostEntity> job);
	 @Query("SELECT DISTINCT e FROM JobPostEntity j JOIN j.applicants e WHERE j.employer.employerId = :employerId")
	    List<EmployeeEntity> findApplicantsByEmployerId(@Param("employerId") String employerId);

}
