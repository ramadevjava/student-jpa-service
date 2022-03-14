package com.student.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.demo.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	


}
