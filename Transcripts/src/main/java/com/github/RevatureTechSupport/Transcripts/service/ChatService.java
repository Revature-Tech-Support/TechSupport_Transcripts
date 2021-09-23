package com.github.RevatureTechSupport.Transcripts.service;

import com.github.RevatureTechSupport.Transcripts.domain.Chat;
import com.github.RevatureTechSupport.Transcripts.repository.ChatRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ChatService {

    ChatRepository repository;

    public Flux<Chat> getAll() {
        return repository.findAll();
    }

    public Flux<Chat> getChatsByUser(UUID user) {
        return repository.findChatsByUser(user);
    }

    public Flux<String> getTranscriptsByUser(UUID user) {
        return repository.findChatsByUser(user)
                .flatMap(x -> Mono.just(x.getTranscript()));
    }

    public void insertTranscript(Chat chat) {
        repository.save(chat);
    }

    public void insertTranscript(String chat, UUID user) {
        
    }



}
