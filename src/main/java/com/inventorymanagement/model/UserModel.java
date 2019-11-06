package com.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inventorymanagement.entities.User;
import com.inventorymanagement.entities.UserRole;

import java.util.Set;

public class UserModel {

  private int id;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String name;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String email;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Set<UserRole> role;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String message;

  public UserModel() {}

  public UserModel(int id, String message) {
    this.id = id;
    this.message = message;
  }

  public UserModel(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.role = user.getUserRoles();
  }

  public UserModel(User user, String message) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.role = user.getUserRoles();
    this.message = message;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Set<UserRole> getRole() {
    return role;
  }

  public void setRole(Set<UserRole> role) {
    this.role = role;
  }

}
