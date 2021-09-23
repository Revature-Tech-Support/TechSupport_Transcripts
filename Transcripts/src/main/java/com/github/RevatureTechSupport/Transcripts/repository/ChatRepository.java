package com.github.RevatureTechSupport.Transcripts.repository;

import com.github.RevatureTechSupport.Transcripts.domain.Chat;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface ChatRepository extends ReactiveCassandraRepository<Chat, UUID> {

    @Query("SELECT * FROM chat WHERE user = ?0")
    public Flux<Chat> findChatsByUser(UUID user);
}
