package org.realiquez.lab_VI.entity;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anioPublicacion;
    private String estado;

    public Libro(){}

    public Libro(String titulo, String autor, String isbn, Integer anioPublicacion, String estado){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
    }

    //getters and setters
    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getTitulo(){return this.titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}

    public String getAutor(){return this.autor;}
    public void setAutor(String autor){this.autor = autor;}

    public String getISBN(){return this.isbn;}
    public void setISBN(String isbn){this.isbn = isbn;}

    public Integer getAnioPublicacion(){return this.anioPublicacion;}
    public void setAnioPublicacion(Integer anioPublicacion){ this.anioPublicacion = anioPublicacion;}

    public String getEstado(){return this.estado;}
    public void setEstado(String estado){this.estado = estado;}
}
