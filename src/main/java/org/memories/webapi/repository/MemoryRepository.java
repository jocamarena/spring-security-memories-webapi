package org.memories.webapi.repository;

import org.memories.webapi.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
    List<Memory> findAllByUsername(String username);
}
