package com.iade.chinook_EIT2.controllers;
import com.iade.chinook_EIT2.models.Artist;
import com.iade.chinook_EIT2.models.repositories.ArtistRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/artists")
public class ArtistController {
    private Logger logger = LoggerFactory.getLogger(ArtistController.class);
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artist> getArtists() {
        logger.info("Sending all albums");
        return artistRepository.findAll();
    }

}
