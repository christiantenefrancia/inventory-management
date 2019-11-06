package com.inventorymanagement.dao;

import java.util.List;

import com.inventorymanagement.entities.History;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDaoImpl implements HistoryDaoInterface {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void save(History history) {
    getSession().save(history);
  }

  @Override
  public void update(History history) {
    getSession().update(history);
  }

  @Override
  public History getById(int id) {
    return (History) getSession().get(History.class, id);
  }
  
  @Override
  public List<History> getByUserId(int id) {
    DetachedCriteria criteria = DetachedCriteria.forClass(History.class);
    criteria.add(Restrictions.isNull("returnTimestamp"));
    DetachedCriteria userCriteria = criteria.createCriteria("user");
    userCriteria.add(Restrictions.eq("id", id));
    @SuppressWarnings("unchecked")
    List<History> history = (List<History>) userCriteria.getExecutableCriteria(getSession()).list();
    return history;
  }
}
