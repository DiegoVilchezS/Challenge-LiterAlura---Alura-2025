package com.example.demo.principal;

import com.example.demo.dtochallenge.DatosGenerales;
import com.example.demo.dtochallenge.DatosLibro;
import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.ConsumoAPI;
import com.example.demo.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    \n--- LiterAlura ---
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    Elija una opción:
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> buscarLibroWeb();
                case 2 -> listarLibrosRegistrados();
                case 3 -> listarAutoresRegistrados();
                case 4 -> listarAutoresVivos();
                case 5 -> listarLibrosPorIdioma();
                case 0 -> System.out.println("Cerrando la aplicación...");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void buscarLibroWeb() {
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "%20"));
        DatosGenerales datos = convierteDatos.obtenerDatos(json, DatosGenerales.class);

        if (datos.resultados().isEmpty()) {
            System.out.println("Libro no encontrado en la API.");
            return;
        }

        DatosLibro datosLibro = datos.resultados().get(0);
        Optional<Libro> libroExistente = libroRepository.findByTituloContainsIgnoreCase(datosLibro.titulo());

        if (libroExistente.isPresent()) {
            System.out.println("El libro '" + datosLibro.titulo() + "' ya está registrado en la base de datos.");
            return;
        }

        Autor autor = null;
        if (!datosLibro.autores().isEmpty()) {
            var datosAutor = datosLibro.autores().get(0);
            autor = autorRepository.findByNombreIgnoreCase(datosAutor.nombre())
                    .orElseGet(() -> autorRepository.save(new Autor(datosAutor)));
        }

        Libro libro = new Libro(datosLibro, autor);
        libroRepository.save(libro);
        System.out.println("Libro registrado con éxito: " + libro.getTitulo());
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(l -> System.out.println("Libro: " + l.getTitulo() + " | Idioma: " + l.getIdioma() + " | Descargas: " + l.getNumeroDeDescargas()));
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(a -> System.out.println("Autor: " + a.getNombre() + " | Nacimiento: " + a.getFechaDeNacimiento() + " | Fallecimiento: " + a.getFechaDeFallecimiento()));
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el año que desea consultar:");
        var anio = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autores = autorRepository.autoresVivosEnDeterminadoAnio(anio);
        if(autores.isEmpty()){
             System.out.println("No se encontraron autores vivos en el año " + anio);
        } else {
             autores.forEach(a -> System.out.println("Autor: " + a.getNombre()));
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma para buscar los libros (ej: en, es, fr, pt):");
        var idioma = teclado.nextLine();
        List<Libro> libros = libroRepository.findByIdioma(idioma);
        if(libros.isEmpty()){
            System.out.println("No hay libros registrados en el idioma '" + idioma + "'.");
        } else {
            libros.forEach(l -> System.out.println("Libro: " + l.getTitulo()));
        }
    }
}