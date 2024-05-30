package com.akatsuki.pioms.admin.repository;

import com.akatsuki.pioms.admin.aggregate.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByAdminId(String adminId);

    Admin findByAdminName(String userName);
}
