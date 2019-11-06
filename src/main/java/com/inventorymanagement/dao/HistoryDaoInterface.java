package com.inventorymanagement.dao;

import com.inventorymanagement.entities.History;

import java.util.List;

public interface HistoryDaoInterface {

  public void save(History history);

  public void update(History history);

  public History getById(int id);

  List<History> getByUserId(int id);

}
