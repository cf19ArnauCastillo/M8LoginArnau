package com.example.LoginArnau.Model;

public class Song {
    public String nombre;
    public String artista;

    public Song(String nombre,String artista) {
        this.artista = artista;
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        artista = artista;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        nombre = nombre;
    }
}
