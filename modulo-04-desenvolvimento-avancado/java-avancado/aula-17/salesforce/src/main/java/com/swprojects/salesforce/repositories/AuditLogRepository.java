package com.swprojects.salesforce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.salesforce.entities.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{
    
}
