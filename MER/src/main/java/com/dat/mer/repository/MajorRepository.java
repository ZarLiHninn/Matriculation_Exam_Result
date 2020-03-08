package com.dat.mer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dat.mer.model.MajorModel;
@Repository
public interface MajorRepository extends JpaRepository<MajorModel, Long> {
@Query(nativeQuery=true,value="SELECT * from MajorModel where major_name = :name")
public MajorModel findByName(@Param("name") String major_name);
}
