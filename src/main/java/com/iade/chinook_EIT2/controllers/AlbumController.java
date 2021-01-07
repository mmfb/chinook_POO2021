package com.iade.chinook_EIT2.controllers;

import java.util.Optional;

import com.iade.chinook_EIT2.models.Album;
import com.iade.chinook_EIT2.models.exceptions.NotFoundException;
import com.iade.chinook_EIT2.models.repositories.AlbumRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/albums")
public class AlbumController {
    private Logger logger = LoggerFactory.getLogger(AlbumController.class);
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> getAlbums() {
        logger.info("Sending all albums");
        return albumRepository.findAll();
    }

    
    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Album getUnit(@PathVariable int id) {
        logger.info("Sending album with id "+id);
        Optional<Album> _album = albumRepository.findById(id);
        if (_album.isEmpty()) throw new NotFoundException(""+id,"Album","id");
        else return _album.get() ;
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Album saveAlbum(@RequestBody Album newAlbum) {
        logger.info("Saving album with title: "+newAlbum.getTitle());
        Album album = albumRepository.save(newAlbum);
        return album;
    }
   

}
