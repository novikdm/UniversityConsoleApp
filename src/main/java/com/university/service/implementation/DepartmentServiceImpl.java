package com.university.service.implementation;

import com.university.config.HibernateSessionFactory;
import com.university.entity.*;
import com.university.service.interfaces.DepartmentService;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
  @Override
  public Department findById(int id) {
    return HibernateSessionFactory.getSession().get(Department.class, id);
  }

  @Override
  public Lector getHeadOfDepartment(String departmentName) {
    List<Department> resultList = getDepartmentByDepartmentName(departmentName);
    Lector lector = resultList.isEmpty()? null : resultList.get(0).getHeadOfDepartment();
    return lector;
  }

  @Override
  public List<String> showDepartmentStatistic(String departmentName) {
    List<String> departmentStatistic = new ArrayList<>();
    List<Department> departments = getDepartmentByDepartmentName(departmentName);
    int id = departments.isEmpty() ? 0 : departments.get(0).getDepartmentId();
    if(id > 0) {
      Session session = HibernateSessionFactory.getSession();
      String s = "SELECT L.degree, COUNT(L.degree) degreeCount FROM lectorsdepartment LD JOIN lector L ON LD.lectorId = L.id AND LD.departmentId =" + id + " GROUP BY L.degree";
      Query query = session.createSQLQuery(s);
      List<Object[]> resultList = query.getResultList();
      for (Object[] obj : resultList) {
        int degree = (int)obj[0];
        String countOfEmployeeString = DegreeEnum.values()[degree-1].toString() + ": " + obj[1];
        departmentStatistic.add(countOfEmployeeString);
      }
    }
    return departmentStatistic;
  }

  @Override
  public double averageSalaryInDepartment(String departmentName) {
    double averageSalary = 0;
    List<Department> departments = getDepartmentByDepartmentName(departmentName);
    int id = departments.isEmpty() ? 0 : departments.get(0).getDepartmentId();
    if(id > 0) {
      Session session = HibernateSessionFactory.getSession();
      String s = "SELECT L.salary FROM lectorsdepartment LD JOIN lector L ON LD.lectorId = L.id AND LD.departmentId = " + id;
      Query query = session.createSQLQuery(s);

      List<Double> resultList = query.getResultList();
      for (Double salary : resultList) {
        averageSalary += salary;
      }
      averageSalary = averageSalary/resultList.size();
    }
    return averageSalary;
  }

  @Override
  public int countOfEmployee(String departmentName) {
    int employeeCount = 0;
    List<Department> departments = getDepartmentByDepartmentName(departmentName);
    int id = departments.isEmpty() ? 0 : departments.get(0).getDepartmentId();
    if(id > 0) {
      Session session = HibernateSessionFactory.getSession();
      String s = "SELECT * FROM lectorsdepartment WHERE departmentId = " + id;
      Query query = session.createSQLQuery(s);
      List<LectorsDepartment> resultList = query.getResultList();
      employeeCount = resultList.size();
    }
    return employeeCount;
  }

  private List<Department> getDepartmentByDepartmentName(String departmentName) {
    Session session = HibernateSessionFactory.getSession();
    Query query = session.createQuery("From Department WHERE departmentName like :templ");
    query.setParameter("templ", departmentName);
    List<Department> resultList = query.getResultList();
    return resultList;
  }
}
