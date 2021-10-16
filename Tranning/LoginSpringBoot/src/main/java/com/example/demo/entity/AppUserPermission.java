package com.example.demo.entity;

public enum AppUserPermission {
  ADMINPAGE_READ("admin:read"),
  ADMINPAGE_WRITE("admin:write");

  private final String permission;

  AppUserPermission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}
