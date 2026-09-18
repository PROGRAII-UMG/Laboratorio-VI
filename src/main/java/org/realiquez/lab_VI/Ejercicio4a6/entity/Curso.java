package org.realiquez.lab_VI.Ejercicio4a6.entity;

public class Curso {
    private Long id;
    private String nombre;
    private String codigo;
    private Integer creditos;
    private boolean estado;

    public Curso(){}

    public Curso(String nombre, String codigo, Integer creditos, boolean estado){
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.estado = estado;
    }

    //getters and setters
    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getCodigo(){return this.codigo;}
    public void setCodigo(String cod){this.codigo = cod;}

    public Integer getCreditos(){return this.creditos;}
    public void setCreditos(Integer cred){this.creditos = cred;}

    public boolean isEstado(){return this.estado;}
    public void setEstado(boolean estado){ this.estado = estado;}
}
