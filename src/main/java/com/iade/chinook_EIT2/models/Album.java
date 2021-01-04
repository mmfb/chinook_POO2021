package com.iade.chinook_EIT2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="album")
public class Album {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="albumid")
    private int id;

    @Column(name="title")
    private String title;

    //@Column(name="cover")
    //private String coverURL;

    @ManyToOne
    @JoinColumn(name="artistid")
    @JsonIgnoreProperties({"albuns"})
    private Artist artist; 

    public Album() {}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    //public String getCoverURL() {
    //    return coverURL;
   // }

    public Artist getArtist() {
        return artist;
    }

}
