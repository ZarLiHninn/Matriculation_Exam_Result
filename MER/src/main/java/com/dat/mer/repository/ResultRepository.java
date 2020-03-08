package com.dat.mer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dat.mer.model.ResultModel;
@Repository
public interface ResultRepository extends JpaRepository<ResultModel, Long> {
	@Query("Select r.studentModel.stu_id from ResultModel r where r.studentModel.stu_id = :IsduplicateStuId")
	public Long IsduplicateStuId(@Param("IsduplicateStuId") Long IsduplicateStuId);
	

	//@Query("Select r from ResultModel r where r.studentModel.year=:year and ((r.studentModel.year=:year and r.studentModel.stu_rollno=:rollno) or (r.studentModel.year=:year and r.studentModel.stu_name=:name) or (r.studentModel.year=:year and r.studentModel.stu_rollno=:rollno) or (r.studentModel.year=:year and r.studentModel.stu_rollno=null) or (r.studentModel.year=:year and r.studentModel.stu_name=null))")	
		@Query("Select r from ResultModel r where r.studentModel.year=:year and ((r.studentModel.year=:year and r.studentModel.stu_rollno=:rollno) or (r.studentModel.year=:year and r.studentModel.stu_name=:name) or (r.studentModel.stu_name=:name and r.studentModel.stu_rollno=:rollno) or (r.studentModel.year=:year and r.studentModel.stu_rollno=null and r.studentModel.stu_name=null) )")
		public List<ResultModel> findByAllByList(@Param("year") String year,@Param("name") String name,@Param("rollno") String rollno);

		@Query("Select r from ResultModel r where  r.studentModel.year=(select max(r1.studentModel.year) from ResultModel r1)")
		public List<ResultModel> findByYear();
		
		@Query("Select r from ResultModel r where r.studentModel.year=:year")
		public List<ResultModel> findBySelectYear(@Param("year") String year);

	
	
}
