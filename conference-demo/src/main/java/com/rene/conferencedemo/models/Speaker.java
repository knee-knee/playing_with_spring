package com.rene.conferencedemo.models;

import org.hibernate.annotations;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers") // this is the table in the DB
public class Speaker {
    @Id // Lets spring know this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // lets spring know how this is generated
    @Column(name = "speaker_id") // is the actual name for the column in the db.
    private Long speakerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "title")
    private String title;
    @Column(name = "company")
    private String company;
    @Column(name = "speaker_bio")
    private String speakerBio;
    @ManyToMany(mappedBy = "speakers") // we set up the other side on the sessions class
    private List<Session>  sessions;

    public Speaker() {

    }
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Session> getSessions() {
        return sessions;
    }
    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeakerBio() {
        return speakerBio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speakerBio = speakerBio;
    }
}
