package com.zinbig.app.dtos;

public class UserDTO {

  private String id;

  private String name;

  private String username;

  private int version;

  public UserDTO(String anId, String anUsername, String aName, int aVersion) {
    this.setId(anId);
    this.setName(aName);
    this.setUsername(anUsername);
    this.setVersion(aVersion);
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

  public String getName() {
    return this.name;
  }

  public void setName(String aName) {
    this.name = aName;
  }

  public int getVersion() {
    return this.version;
  }

  private void setVersion(int version) {
    this.version = version;
  }
}
