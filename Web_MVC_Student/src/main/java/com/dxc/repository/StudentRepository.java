package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
