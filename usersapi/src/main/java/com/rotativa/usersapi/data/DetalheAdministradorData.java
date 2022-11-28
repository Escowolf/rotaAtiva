package com.rotativa.usersapi.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rotativa.usersapi.model.AdministradorModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheAdministradorData implements UserDetails {

    private final Optional<AdministradorModel> administrador;

    public DetalheAdministradorData(Optional<AdministradorModel> administrador) {
        this.administrador = administrador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return administrador.orElse(new AdministradorModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return administrador.orElse(new AdministradorModel()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
