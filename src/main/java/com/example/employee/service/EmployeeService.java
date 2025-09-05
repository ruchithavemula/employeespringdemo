package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  private final EmployeeRepository repo;
  public EmployeeService(EmployeeRepository repo) {
    this.repo = repo;
  }
  public List<Employee> findAll() {
    return repo.findAll();
  }
  public Optional<Employee> findById(Long id) {
    return repo.findById(id);
  }
  public Employee save(Employee e) {
    return repo.save(e);
  }
  public void deleteById(Long id) {
    repo.deleteById(id);
  }
}
