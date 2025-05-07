package org.memories.webapi.service;

import org.memories.webapi.model.SystemUser;
import org.memories.webapi.security.AuthenticatedUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JpaUserDetailsService implements UserDetailsService {
    private final SystemUserService systemUserService;
    public JpaUserDetailsService(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserService.findByUsername(username);
        if (systemUser == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return AuthenticatedUser.builder()
                .systemUser(systemUser)
                .build();
    }
}
