package com.inventorymanagement.dao;

import com.inventorymanagement.entities.Request;

import java.util.List;


public interface RequestDaoInterface {

  public void save(Request request);

  public void update(Request request);

  public List<Request> getAll();

  public Request getById(int id);

  public void refresh(Request request);

  List<Request> getByUserId(int id);

}
