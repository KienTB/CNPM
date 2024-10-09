package com.cnpm.demo.model.Repository;

import com.cnpm.demo.model.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
    boolean existsByUsername(String username);
}
//truy vấn thông tin từ bảng employee, để tìm Employee theo username.