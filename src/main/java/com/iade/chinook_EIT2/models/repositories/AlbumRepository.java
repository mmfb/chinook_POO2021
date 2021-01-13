package com.iade.chinook_EIT2.models.repositories;

import com.iade.chinook_EIT2.models.Album;
import com.iade.chinook_EIT2.models.views.TrackView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    String trackQuery = "SELECT  TrackId as id, track.Name as name, UnitPrice as price, "+
    "mediatype.Name as mediaType, genre.Name as genre " +
    "FROM track, mediatype, genre "+
    "WHERE track.GenreId = genre.GenreId " + 
    "AND track.MediaTypeId = mediatype.MediaTypeId "+
    "AND track.AlbumId = :albumId";

    @Query(value=trackQuery, nativeQuery=true)
    Iterable<TrackView> findAlbumTracks(@Param("albumId") int albumId);
}
