package com.usuario_service.usuario_service.modelo;

public class Moto {
    private int id;
    private String marca;
    private String clase;
    private int anno;
    private int usuarioID;
    public int getUsuarioID() {
        return usuarioID;
    }
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getClase() {
        return clase;
    }
    public void setClase(String clase) {
        this.clase = clase;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }

}
