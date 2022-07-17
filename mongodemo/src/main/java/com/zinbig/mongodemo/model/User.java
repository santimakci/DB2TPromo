package com.zinbig.mongodemo.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String username;

  private String password;

  private String name;

  public int version;

  public User() {
  }

  public User(String anUsername, String aPassword, String aName) {
    this.setUsername(anUsername);
    this.setName(aName);
    this.setPassword(aPassword);
  }

  public String getId() {
    return this.id;
  }

  public void setId(String anId) {
    this.id = anId;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String anUsername) {
    this.username = anUsername;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String aPassword) {
    this.password = aPassword;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String aName) {
    this.name = aName;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}
