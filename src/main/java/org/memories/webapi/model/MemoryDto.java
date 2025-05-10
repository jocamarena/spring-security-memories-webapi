package org.memories.webapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MemoryDto(@NotBlank(message = "The content field is required")
@Size(min=3,max=3000)
                        String content) {
    public MemoryDto {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
    }
}
