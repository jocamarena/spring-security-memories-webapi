package org.memories.webapi.api;

import org.memories.webapi.model.Memory;
import org.memories.webapi.model.MemoryDto;
import org.memories.webapi.security.AuthenticatedUser;
import org.memories.webapi.service.MemoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
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
    public ResponseEntity<URL> createMemory(@AuthenticationPrincipal AuthenticatedUser authenticatedUser,
                                               @RequestBody MemoryDto memoryDto) throws MalformedURLException {
        String username = authenticatedUser.getUsername();
        Memory memory = Memory.builder()
                .username(username)
                .content(memoryDto.content())
                .build();
        Memory savedMemory = memoryService.save(memory);
        URL location = new URL("http://localhost:8080/api/v1/private/memories/" + savedMemory.getId());
        return ResponseEntity.ok(location);
    }
}
