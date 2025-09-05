package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
  private final EmployeeService service;
  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping
  public List<Employee> all() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getOne(@PathVariable Long id) {
    return service.findById(id)
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Employee> create(@RequestBody Employee e) {
    Employee saved = service.save(e);
    return ResponseEntity.created(URI.create("/api/employees/" + saved.getId())).body(saved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee e) {
    return service.findById(id).map(existing -> {
      existing.setName(e.getName());
      existing.setEmail(e.getEmail());
      existing.setSalary(e.getSalary());
      Employee saved = service.save(existing);
      return ResponseEntity.ok(saved);
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return service.findById(id).map(existing -> {
      service.deleteById(id);
      return ResponseEntity.noContent().<Void>build();
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
