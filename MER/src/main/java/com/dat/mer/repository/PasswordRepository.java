package com.dat.mer.repository;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dat.mer.model.PasswordModel;
import com.dat.mer.model.StudentModel;
@Repository
public interface PasswordRepository extends JpaRepository<PasswordModel, Long> {
	@Query("Select a.passwordModel.update_timestamp from AdminModel a,PasswordModel p where a.passwordModel.password_id = p.password_id AND a.admin_id=:adminId")
	public String getUpdateTimestamp(@Param("adminId") Long adminId);
	
	//update password p inner join admin a on p.password_id=a.password_id SET p.is_logged_in=true where a.admin_id=1001; 
	
	
	@Query("Select r.studentModel.stu_id from ResultModel r where r.id=:userId")
	public Long findByResId(@Param("userId") Long userId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM student s,password p WHERE s.password_id = p.password_id AND s.stu_id=:stu_Id")
	public PasswordModel findByStuID(@Param("stu_Id") Long stu_Id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM admin a,password p WHERE a.password_id = p.password_id AND a.admin_id=:adminId")
	public PasswordModel findByID(@Param("adminId") Long adminId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM password WHERE password_id = :passwordId" )
	public PasswordModel findByPassID(@Param("passwordId") Long passwordId);
	
	@Transactional
	@Modifying@Query("Update  PasswordModel p set p.isLoggedIn=:isLoggedIn where p.password_id=:passwordId ")
	public void setLoggedIn(@Param("isLoggedIn") Boolean isLoggedIn,@Param("passwordId") Long passwordId);
	
	
	@Transactional
	@Modifying@Query("Update  PasswordModel p set p.password=:password where p.password_id=:passwordId ")
	public void passwordChange(@Param("password") String password,@Param("passwordId") Long passwordId);
	
	@Transactional
	@Modifying@Query("Update  PasswordModel p set p.update_timestamp=:updateTimestamp where p.password_id=:passwordId ")
	public void updateTimestamp(@Param("updateTimestamp") Timestamp updateTimestamp,@Param("passwordId") Long passwordId);

	
}
