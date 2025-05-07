package org.memories.webapi.service;

import jakarta.transaction.Transactional;
import org.memories.webapi.model.SystemUser;
import org.memories.webapi.repository.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SystemUserService {
    private final SystemUserRepository systemUserRepository;
    public SystemUserService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }
    public SystemUser findByUsername(String username) {
        return systemUserRepository.findByUsername(username);
    }
    public SystemUser save(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }
}
