package org.memories.webapi.model;

public record OpenAiDto(String prompt) {
    public OpenAiDto(String prompt) {
        this.prompt = prompt;
    }
}
