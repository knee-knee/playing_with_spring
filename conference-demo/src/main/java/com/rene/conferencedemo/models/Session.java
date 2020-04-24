package com.rene.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
public class Session {
    @Id // Lets spring know this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // lets spring know how this is generated
    @Column(name = "session_id") // is the actual name for the column in the db.
    private Long sessionId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_length")
    private Integer sessionLength;

    @ManyToMany //setting up a many to many realtionship and this join table exists in the db
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Session() {
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }
}
