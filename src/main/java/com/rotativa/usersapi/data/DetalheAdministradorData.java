package com.rotativa.usersapi.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rotativa.usersapi.model.Administrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheAdministradorData implements UserDetails {

    private final Optional<Administrador> administrador;

    public DetalheAdministradorData(Optional<Administrador> administrador) {
        this.administrador = administrador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return administrador.orElse(new Administrador()).getPassword();
    }

    @Override
    public String getUsername() {
        return administrador.orElse(new Administrador()).getEmail();
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
