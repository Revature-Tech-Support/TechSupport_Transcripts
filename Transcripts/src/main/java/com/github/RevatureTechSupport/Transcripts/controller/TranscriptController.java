package com.github.RevatureTechSupport.Transcripts.controller;

import com.github.RevatureTechSupport.Transcripts.domain.Chat;
import com.github.RevatureTechSupport.Transcripts.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transcripts")
public class TranscriptController {

    final ChatService service;

    public TranscriptController(ChatService service) {
        this.service = service;
    }

    @PostMapping("/{userID}")
    public void insertTranscript(@RequestBody String chat, @PathVariable("userID") Integer userID){
        service.insertTranscript(chat,userID);
    }

    @GetMapping("/retrieve/{userID}")
    public Flux<String> getTranscripts(@PathVariable("userID") Integer userID){
        return service.getTranscriptsByUser(userID);
    }

}
