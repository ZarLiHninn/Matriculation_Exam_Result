package com.dat.mer.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dat.mer.model.DivisionModel;

@Repository
public interface DivisionRepository extends JpaRepository<DivisionModel, Integer> {
	@Query("Select d.div_name from DivisionModel d")
	public List<String> getAllDivName();
	
	@Query("Select count(*) from DivisionModel d where d.div_name = :divisionName")
	public int isDivisionExist(@Param("divisionName") String divisionName);
}
