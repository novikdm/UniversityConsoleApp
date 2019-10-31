package com.university.config;

import com.university.entity.Degree;
import com.university.entity.Department;
import com.university.entity.Lector;
import com.university.entity.LectorsDepartment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateSessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Degree.class);
        configuration.addAnnotatedClass(Lector.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(LectorsDepartment.class);
        ServiceRegistry service = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(service);
      } catch (Exception e) {
        System.out.println("Exception: " + e);
      }
    }
    return sessionFactory;
  }

  public static Session getSession() throws HibernateException {
    return getSessionFactory().openSession();
  }
}
