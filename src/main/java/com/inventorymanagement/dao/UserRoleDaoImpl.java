package com.inventorymanagement.dao;

import com.inventorymanagement.entities.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDaoInterface {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void save(UserRole user) {
    getSession().save(user);
  }

  @Override
  public void refresh(UserRole userRole) {
    getSession().refresh(userRole);
  }
}
