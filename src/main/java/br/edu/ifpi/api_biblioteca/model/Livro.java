package br.edu.ifpi.api_biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "livros")
public class Livro {
    
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private Boolean disponivel;


    protected Livro(){

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }   
    public void setAutor(String autor){
        this.autor = autor;
    }
    public Integer getAnoPublicacao(){
        return anoPublicacao;
    }
    public void setAnoPublicacao(Integer anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    public Boolean getDisponivel(){
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel){
        this.disponivel = disponivel;
    }
}
