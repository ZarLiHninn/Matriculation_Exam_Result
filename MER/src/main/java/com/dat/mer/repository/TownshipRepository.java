package com.dat.mer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import com.dat.mer.model.TownshipModel;

public interface TownshipRepository extends JpaRepository<TownshipModel, Integer> {
	@Query("SELECT t.twn_name from TownshipModel t where t.division.div_name = :div_name")
	public List<String> getTownshipsByDivision(@Param("div_name") String div_name);
	
	@Query("Select t.twn_code from TownshipModel t where t.twn_name = :townName")
	public String getTwnCode(@Param("townName") String town);
	
	@Query("SELECT t from TownshipModel t where t.twn_name = :townName")
	public TownshipModel findByNameLike(@Param("townName")  String town_name);
	
	@Query("Select count(*) from TownshipModel t where t.twn_name = :townName")
	public int isTownExist(@Param("townName") String townName);
}

