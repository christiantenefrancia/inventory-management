package com.inventorymanagement.dao;

import com.inventorymanagement.entities.User;

import java.util.List;

public interface UserDaoInterface {

  public void save(User user);

  public List<User> getAll();

  public User getUserByEmail(String email);

  User getById(int id);

  public void refresh(User user);
}
