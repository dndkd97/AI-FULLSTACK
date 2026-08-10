package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Image;

@Repository	
public interface ImageRepository extends JpaRepository<Image,Long>{ // Entity , PK (★기본키)

}
/*
created - save      : insert 
read    - findAll   : select * from 테이블명
	      findById  : select * from 테이블명 where id=?
updated - save		: updated 테이블명 set 컬럼1=? ,,, where id=?
delete  - delete	: deleted from 테이블명 where id=?
*/
