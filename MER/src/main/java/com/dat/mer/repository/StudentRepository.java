package com.dat.mer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dat.mer.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM StudentModel WHERE stu_name = :stu_name")
	public List<StudentModel> findByNameLike(@Param("stu_name") String stu_name);
	@Query("Select a.passwordModel.password from AdminModel a,PasswordModel p where a.passwordModel.password_id = p.password_id AND  a.admin_id=:adminId")
	public String getIsAdmin(@Param("adminId") Long adminId);
	@Query("Select s.year from StudentModel s order by s.year desc")
	public List<String> getAllYear();
	
	@Query("Select s.stu_rollno from StudentModel s where s.year = :selectedyear")
	public List<String> getAllRollno(@Param("selectedyear") String selectedyear);
	@Query("Select s.stu_id,s.stu_name from StudentModel s where s.year = :selectedYear AND s.stu_rollno = :selectedRollno")
	public List<String> getAllStudentName(@Param("selectedYear") String selectedyear,@Param("selectedRollno") String selectedRollno);
	@Query("Select s.year,s.stu_rollno,s.stu_name from StudentModel s where s.stu_id = :stuId")
	public String GetStudentInfo(@Param("stuId") Long stuId);
	
	@Query("SELECT s.stu_rollno,s.stu_name,s.townshipModel.division.div_name,s.townshipModel.twn_name from StudentModel s,DivisionModel d,TownshipModel t,ResultModel r where r.studentModel.stu_id=s.stu_id and s.townshipModel.id=t.id and t.division.div_id=d.div_id and s.stu_name=:findbyname")
	public List<String> findByName(@Param("findbyname") String findbyname);
	
	@Query("Select s.year from StudentModel s where s.stu_rollno=:rollNo")
	public List<String> findByRollno(@Param("rollNo") String rollNo);
	
	@Query("Select count(*) from StudentModel s where s.stu_rollno=:rollNo and s.year=:year")
	public int countByRollAndYear(@Param("rollNo")String rollNo , @Param("year")String year);
	
	@Query("Select max(s.year) from StudentModel s")
	public String getMaxYear();
	
	
}
