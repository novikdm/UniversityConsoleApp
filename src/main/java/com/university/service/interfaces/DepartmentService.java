package com.university.service.interfaces;

import com.university.entity.Department;
import com.university.entity.Lector;

import java.util.List;

public interface DepartmentService {
  Department findById(int id);
  Lector getHeadOfDepartment(String departmentName);
  List<String> showDepartmentStatistic(String departmentName);
  double averageSalaryInDepartment(String departmentName);
  int countOfEmployee(String departmentName);
}