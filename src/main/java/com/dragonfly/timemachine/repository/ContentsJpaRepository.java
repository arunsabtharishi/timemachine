package com.dragonfly.timemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.timemachine.domain.Contents;

@Repository
public interface ContentsJpaRepository extends JpaRepository<Contents, String> {

}
