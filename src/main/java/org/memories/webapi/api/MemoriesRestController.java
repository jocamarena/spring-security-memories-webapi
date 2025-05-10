package org.memories.webapi.api;

import org.memories.webapi.security.AuthenticatedUser;
import org.memories.webapi.service.MemoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/private/memories")
public class MemoriesRestController {
    private final MemoryService memoryService;
    public MemoriesRestController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }
    @GetMapping
    public String getAllMemoriesByUsername(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        String username = authenticatedUser.getUsername();
        return memoryService.findAllByUserName(username).toString();
    }
    @PostMapping
    public ResponseEntity<String> createMemory(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        String username = authenticatedUser.getUsername();
        return ResponseEntity.ok("Memory created for user: " + username);
    }
}
