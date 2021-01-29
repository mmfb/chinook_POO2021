package com.iade.chinook_EIT2.models.views;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TrackFullView {
    private int id;
    private String name;
    private int albumId;
    private int mediaTypeId;
    private int genreId;
    private String composer;
    private int milliseconds;
    private int bytes;
    private double price;
    
    public TrackFullView() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getMediaTypeId() {
        return mediaTypeId;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getComposer() {
        return composer;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public int getBytes() {
        return bytes;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "TrackSaveView [albumId=" + albumId + ", bytes=" + bytes + ", composer=" + composer + ", genreId="
                + genreId + ", id=" + id + ", mediaTypeId=" + mediaTypeId + ", milliseconds=" + milliseconds + ", name="
                + name + ", price=" + price + "]";
    }

    

}
