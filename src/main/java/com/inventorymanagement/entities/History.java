package com.inventorymanagement.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "history", catalog = "inventory")
public class History implements java.io.Serializable {

  private static final long serialVersionUID = 6518556062188561612L;
  private Integer id;
  private Item item;
  private Product product;
  private User user;
  private Date issueTimestamp;
  private Date returnTimestamp;

  public History() {}

  public History(User user, Product product, Item item) {
    this.item = item;
    this.product = product;
    this.user = user;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  public Item getItem() {
    return this.item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prod_id", nullable = false)
  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "issue_timestamp", nullable = false, insertable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", length = 19)
  public Date getIssueTimestamp() {
    return this.issueTimestamp;
  }

  public void setIssueTimestamp(Date issueTimestamp) {
    this.issueTimestamp = issueTimestamp;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "return_timestamp", length = 19)
  public Date getReturnTimestamp() {
    return this.returnTimestamp;
  }

  public void setReturnTimestamp(Date returnTimestamp) {
    this.returnTimestamp = returnTimestamp;
  }

}
