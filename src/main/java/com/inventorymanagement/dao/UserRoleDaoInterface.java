package com.inventorymanagement.dao;

import com.inventorymanagement.entities.UserRole;

public interface UserRoleDaoInterface {
  public void save(UserRole user);

  public void refresh(UserRole userRole);
}
