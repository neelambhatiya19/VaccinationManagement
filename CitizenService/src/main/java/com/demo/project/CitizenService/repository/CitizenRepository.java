package com.demo.project.CitizenService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.CitizenService.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinationCenterId(Integer id);

}
