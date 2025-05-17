package org.memories.webapi.api;

import org.memories.webapi.model.OpenAiDto;
import org.memories.webapi.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/private/openai")
public class OpenAiRestController {
    private final OpenAiService openAiService;
    public OpenAiRestController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }
    @PostMapping
    public String getResponse(@RequestBody OpenAiDto prompt) {
        return openAiService.getResponse(prompt.prompt());
    }
}
