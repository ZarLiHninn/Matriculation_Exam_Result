package com.dat.mer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dat.mer.model.AdminModel;
@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long> {
	@Query(nativeQuery=true,value="Select * from admin a where a.admin_id=:adminId")
	public AdminModel getAdmin(@Param("adminId") Long adminId);
}

