package com.usuario_service.usuario_service.modelo;

public class Carro {
    private int id;
    private String marca;
    private String serie;
    private int anno;
    private int usuarioId;
    public Carro() {
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public int getId() {
        return id;
    }
    public int getUsuarioId() {
        return usuarioId;
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
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
}
