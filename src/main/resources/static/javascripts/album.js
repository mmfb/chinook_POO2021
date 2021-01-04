

window.onload = async function() {
    let albumId = sessionStorage.getItem("albumId");

    let album = await $.ajax({
        url: "/api/albums/"+albumId,
        method: "get",
        dataType: "json"
    });
    console.log(album);
    //document.getElementById("cover").src = "/images/cover" + album.AlbumId + ".jpg";  
    
    
    //if (album.Cover != null) {
    //     document.getElementById("cover").src = album.Cover;
    //}
    

    document.getElementById("titulo").innerHTML = album.title;
    document.getElementById("artista").innerHTML = album.artist.name;

    /*
    let html = "";
    for(let track of album.tracks) {
        html+= "<p>"+track.Name+" - "+track.UnitPrice+" €</p>";
    }
    document.getElementById("tracks").innerHTML = html;
    */
}