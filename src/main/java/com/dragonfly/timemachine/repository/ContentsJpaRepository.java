package com.dragonfly.timemachine.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dragonfly.timemachine.domain.Contents;

@Repository
public interface ContentsJpaRepository extends JpaRepository<Contents, String> {

	  @Query("select c.content, c.contentDate from Contents c where c.contentDate >= ?1 and c.contentDate < ?2 and c.userName = ?3")
	  List<Contents> findByContentDate(Date contentDate1, Date contentDate2, String userName);
}
