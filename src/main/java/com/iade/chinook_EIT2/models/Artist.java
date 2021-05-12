package com.iade.chinook_EIT2.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Artist")
public class Artist {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="artistid")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany
    @JoinColumn(name="artistid")
    // {} permite ignorar mais do que um, por exemplo {"artist","coverURL"}
    @JsonIgnoreProperties({"artist"})
    private List<Album> albuns;

    public Artist() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    // Se calhar nem precisamos
    public Artist(String name) {
        this.name = name;
    }

}
