package com.university.service.implementation;

import com.university.config.HibernateSessionFactory;
import com.university.entity.Lector;
import com.university.service.interfaces.LectorsService;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.transaction.Transactional;
import java.util.List;

public class LectorsServiceImpl implements LectorsService {

  public List<Lector> findLectors(String template) throws LazyInitializationException {
    Session session = HibernateSessionFactory.getSession();
    Query query = session.createQuery("From Lector WHERE firstName like concat('%', :templ, '%') or lastName like concat('%', :templ, '%')");
    query.setParameter("templ", template);
    List<Lector> resultList = query.getResultList();
    return resultList;
  }

  @Transactional
  public Lector findById(int id) {
    return HibernateSessionFactory.getSession().get(Lector.class, id);
  }
}
