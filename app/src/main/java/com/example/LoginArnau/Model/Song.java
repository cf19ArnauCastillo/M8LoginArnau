package com.example.LoginArnau.Model;

public class Song {
    String Artista;
    String Nombre;
    public Song() {
        this.Artista = "";
        this.Nombre = "";
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String artista) {
        Artista = artista;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
