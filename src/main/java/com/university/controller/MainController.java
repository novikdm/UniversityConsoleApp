package com.university.controller;


import com.university.entity.Department;
import com.university.entity.Lector;
import com.university.service.implementation.DepartmentServiceImpl;
import com.university.service.implementation.LectorsServiceImpl;
import org.hibernate.LazyInitializationException;

import java.util.List;


public final class MainController{
  public List<Lector> findLectorsByTemplate(String template) {
    LectorsServiceImpl service = new LectorsServiceImpl();
    return service.findLectors(template);
  }

  public Lector findLectorById(int id) throws LazyInitializationException {
    LectorsServiceImpl service = new LectorsServiceImpl();
    return service.findById(id);
  }
  public Department findDepartmentById(int id) throws LazyInitializationException {
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    return service.findById(id);
  }

  public Lector getHeadOfDepartment(String departmentName) throws LazyInitializationException {
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    return service.getHeadOfDepartment(departmentName);
  }

  public List<String> getDepartmentStatistic(String departmentName) {
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    return service.showDepartmentStatistic(departmentName);
  }

  public double getAverageDepartmentSalary(String departmentName) {
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    return service.averageSalaryInDepartment(departmentName);
  }

  public int getCountEmployeeForDepartment(String departmentName) {
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    return service.countOfEmployee(departmentName);
  }
}
