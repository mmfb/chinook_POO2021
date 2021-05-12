package com.iade.chinook_EIT2.models.repositories;

import com.iade.chinook_EIT2.models.Album;
import com.iade.chinook_EIT2.models.views.TrackFullView;
import com.iade.chinook_EIT2.models.views.TrackView;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    String trackQuery = "SELECT  TrackId as id, Track.Name as name, UnitPrice as price, "+
    "MediaType.Name as mediaType, Genre.Name as genre " +
    "FROM Track, MediaType, Genre "+
    "WHERE Track.GenreId = Genre.GenreId " + 
    "AND Track.MediaTypeId = MediaType.MediaTypeId "+
    "AND Track.AlbumId = :albumId";

    @Query(value=trackQuery, nativeQuery=true)
    Iterable<TrackView> findAlbumTracks(@Param("albumId") int albumId);
   
    String saveTrackQuery = "INSERT INTO Track (AlbumId,  Name, MediaTypeId, GenreId, "+
    "Composer, Milliseconds, Bytes, UnitPrice) VALUES (:albumId, :#{#track.getName()}, "+
    ":#{#track.getMediaTypeId()}, :#{#track.getGenreId()}, :#{#track.composer}, "+
    ":#{#track.getMilliseconds()}, :#{#track.getBytes()}, :#{#track.getPrice()} )";
    @Modifying
    @Transactional
    @Query(value=saveTrackQuery, nativeQuery=true)
    int saveAlbumTrack(@Param("albumId") int albumId, @Param("track") TrackFullView track);
}
