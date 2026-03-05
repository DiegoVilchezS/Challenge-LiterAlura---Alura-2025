package com.example.demo.modelo;

import com.example.demo.dtochallenge.DatosLibro;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String titulo;
    
    private String idioma;
    private Double numeroDeDescargas;

    @ManyToOne
    private Autor autor;

    // Constructor predeterminado
    public Libro() {}

    // Constructor personalizado
    public Libro(DatosLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        // Tomamos solo el primer idioma, como pide el requerimiento
        this.idioma = datosLibro.idiomas() != null && !datosLibro.idiomas().isEmpty() ? datosLibro.idiomas().get(0) : "N/A";
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        this.autor = autor;
    }

    // --- ¡ATENCIÓN! FALTA ALGO AQUÍ ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", idioma=" + idioma + ", numeroDeDescargas=" + numeroDeDescargas + ", autor=" + autor + '}';
    }
    
}