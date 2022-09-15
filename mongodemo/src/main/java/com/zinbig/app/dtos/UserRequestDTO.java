package com.zinbig.app.dtos;

public class UserRequestDTO {

  public String id;

  public String name;

  public String username;

  public String password;

  public UserRequestDTO(String id, String name, String username, String password) {
    super();
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
  }
}
