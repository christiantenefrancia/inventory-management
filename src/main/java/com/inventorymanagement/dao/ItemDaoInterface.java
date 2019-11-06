package com.inventorymanagement.dao;

import com.inventorymanagement.entities.Item;

import java.util.List;

public interface ItemDaoInterface {

  public void save(Item item);

  public void delete(Item item);

  public void update(Item item);

  public List<Item> getAll();

  public Item getById(int id);

  int getCountByProductId(int id);

  Item getByItemTag(String tag);

  void refresh(Item item);

  void flush();

  List<Item> getItemsByProductId(int id);

  public void clear();
}
