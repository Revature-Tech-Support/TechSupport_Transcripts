package com.github.RevatureTechSupport.Transcripts.repository;

import com.github.RevatureTechSupport.Transcripts.domain.Chat;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface ChatRepository extends ReactiveCassandraRepository<Chat, UUID> {

    @Query("SELECT * FROM chat WHERE userID = ?0 ALLOW FILTERING")
    public Flux<Chat> findChatsByUser(Integer user);
}
