package org.memories.webapi.service;

import jakarta.transaction.Transactional;
import org.memories.webapi.model.Memory;
import org.memories.webapi.repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MemoryService {
    private final MemoryRepository memoryRepository;
    public MemoryService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }
    public List<Memory> findAllByUserName(String username) {
        return memoryRepository.findAllByUsername(username);
    }
    public Memory save(Memory memory) {
        return memoryRepository.save(memory);
    }
}
