package com.inventorymanagement.dao;

import com.inventorymanagement.entities.Product;

import java.util.List;

public interface ProductDaoInterface {

  public void save(Product product);

  public void delete(Product product);

  public void update(Product product);

  public List<Product> getAll();

  public Product getById(int id);

  void flush();

}
