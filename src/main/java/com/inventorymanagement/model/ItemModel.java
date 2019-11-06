package com.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inventorymanagement.entities.Item;
import com.inventorymanagement.entities.Product;

public class ItemModel {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private int itemId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private int productId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String name;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String company;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String version;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tag;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String available;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String message;

  public ItemModel() {}

  public ItemModel(Product product) {
    this.productId = product.getId();
  }

  public ItemModel(Item item, String message) {
    Product product = item.getProduct();
    this.itemId = item.getId();
    this.tag = item.getTag();
    this.message = message;
    this.name = product.getName();
    this.company = product.getCompany();
    this.version = product.getVersion();
  }

  public ItemModel(Item item, String tag, String message) {
    Product product = item.getProduct();
    this.itemId = item.getId();
    this.tag = tag;
    this.message = message;
    this.name = product.getName();
    this.company = product.getCompany();
    this.version = product.getVersion();
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getAvailable() {
    return available;
  }

  public void setAvailable(String available) {
    this.available = available;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

}
