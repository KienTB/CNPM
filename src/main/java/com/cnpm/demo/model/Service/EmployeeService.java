package com.cnpm.demo.model.Service;

import com.cnpm.demo.model.DTO.EmployeeDTO;
import com.cnpm.demo.model.Model.Employee;
import com.cnpm.demo.model.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // Lấy tất cả các nhân viên từ DB
        return employees.stream()
                .filter(emp -> !"admin".equalsIgnoreCase(emp.getRole()))
                .map(emp -> new EmployeeDTO((int) emp.getIdEmployee(), emp.getName()))  // Chuyển đổi sang EmployeeDTO
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }
    public boolean existsByUsername(String username) {
        return employeeRepository.existsByUsername(username);
    }
}
