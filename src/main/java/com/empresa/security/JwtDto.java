package com.empresa.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String login;
    private String nombreCompleto;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token,String login, String nombreCompleto, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.login = login;
        this.nombreCompleto = nombreCompleto;
        this.authorities = authorities;
    }

    
}
