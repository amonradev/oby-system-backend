package com.backend.oby.repository;

import com.backend.oby.entity.SysConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfig, Long> {
    
}
