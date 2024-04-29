package com.authentication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.user.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{
    
}
