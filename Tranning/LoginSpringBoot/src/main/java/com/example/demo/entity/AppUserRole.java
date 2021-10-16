package com.example.demo.entity;

import static com.example.demo.entity.AppUserPermission.ADMINPAGE_READ;
import static com.example.demo.entity.AppUserPermission.ADMINPAGE_WRITE;

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum AppUserRole {
  USER (Sets.newHashSet()),
  ADMIN (Sets.newHashSet(ADMINPAGE_READ, ADMINPAGE_WRITE)),
  SUPPORTER(Sets.newHashSet(ADMINPAGE_READ));

  private final Set<AppUserPermission> permissions;

  AppUserRole (Set<AppUserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<AppUserPermission> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
    Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toSet());
    permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return permissions;
  }

}
