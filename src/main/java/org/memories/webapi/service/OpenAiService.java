package org.memories.webapi.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {
    private final ChatModel chatModel;
    public OpenAiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }
}
