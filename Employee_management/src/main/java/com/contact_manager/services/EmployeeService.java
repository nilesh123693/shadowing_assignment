package com.contact_manager.services;

import com.contact_manager.entity.Employee;
import com.contact_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee e) {
        employeeRepository.save(e);
    }
    public List<Employee> getAllemployee() {
        return employeeRepository.findAll();
    }
    public Employee getEmpById(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
