package com.github.RevatureTechSupport.Transcripts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.ws.rs.Path;
import java.util.UUID;

@RestController
@RequestMapping("/transcripts")
public class TranscriptController {

    @Autowired ChatService service;

    @PostMapping("/{userID}")
    public void insertTranscript(@RequestBody String chat, @PathVariable("userID") UUID userID){
        service.insertTranscript(chat,userID);
    }

    @GetMapping("/retrieveTranscript/{userID}")
    public Flux<String> getTranscripts(@PathVariable("userID") UUID userID){
        return transcriptService.getTranscriptsByUser(userID);
    }

}
