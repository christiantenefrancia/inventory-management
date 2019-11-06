package com.inventorymanagement.dao;

import com.inventorymanagement.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDaoInterface {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void save(Product product) {
    getSession().save(product);
  }

  @Override
  public void delete(Product product) {
    getSession().delete(product);
  }

  @Override
  public void update(Product product) {
    getSession().update(product);
  }

  @Override
  public void flush() {
    getSession().flush();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Product> getAll() {
    List<Product> products = getSession().createCriteria(Product.class).list();
    return products;
  }

  @Override
  public Product getById(int id) {
    return (Product) getSession().get(Product.class, id);
  }

}
