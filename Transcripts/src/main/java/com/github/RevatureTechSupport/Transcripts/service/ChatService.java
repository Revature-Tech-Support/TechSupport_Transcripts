package com.github.RevatureTechSupport.Transcripts.service;

import com.github.RevatureTechSupport.Transcripts.domain.Chat;
import com.github.RevatureTechSupport.Transcripts.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ChatService {

    @Autowired
    ChatRepository repository;

    public Flux<Chat> getAll() {
        return repository.findAll();
    }

    public Flux<Chat> getChatsByUser(Integer user) {
        return repository.findChatsByUser(user);
    }

    public Flux<String> getTranscriptsByUser(Integer user) {
        return repository.findChatsByUser(user)
                .flatMap(x -> Mono.just(x.getTranscript()));
    }

    public void insertTranscript(Chat chat) {
        repository.save(chat).subscribe();
    }

    public void insertTranscript(String chat, Integer user) {
        insertTranscript(new Chat(chat, user));
    }



}
