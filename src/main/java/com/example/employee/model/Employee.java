package com.example.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private Double salary;

  public Employee() {}

  public Employee(String name, String email, Double salary) {
    this.name = name;
    this.email = email;
    this.salary = salary;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Double getSalary() {
    return salary;
  }
  public void setSalary(Double salary) {
    this.salary = salary;
  }
}
