package com.github.RevatureTechSupport.Transcripts.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Chat {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    UUID chatID;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    int userID;
    @Column
    String transcript;

    public Chat(UUID chatID, int userID, String transcript) {
        this.chatID = chatID;
        this.userID = userID;
        this.transcript = transcript;
    }

    public Chat(String transcript, int userID) {
        this.chatID = UUID.randomUUID();
        this.userID = userID;
        this.transcript = transcript;
    }

    public Chat() {
    }

    public UUID getChatID() {
        return chatID;
    }

    public void setChatID(UUID chatID) {
        this.chatID = chatID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }
}
