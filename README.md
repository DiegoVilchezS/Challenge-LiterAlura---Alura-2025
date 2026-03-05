Challenge LiterAlura - Alura & ONE
¡Bienvenido, mi nombre es Diego Vilchez y soy de Perú!

Este proyecto es una aplicación de consola en Java que funciona como un catálogo literario, permitiendo buscar libros y autores a través de la API de Gutendex, gestionando la información de manera eficiente mediante una base de datos relacional.

Funcionalidades
Consultas a la API Gutendex: Obtiene datos bibliográficos en tiempo real directamente desde la fuente.

Persistencia de Datos: Almacena de forma permanente los libros y autores consultados en una base de datos PostgreSQL.

Menú Interactivos: Interfaz sencilla en consola que permite realizar búsquedas, listar registros y filtrar autores por año.

Validación de Duplicados: Sistema inteligente que verifica si un libro ya existe en la base de datos antes de registrarlo para mantener la integridad de la información.

Filtros Avanzados: Capacidad de listar autores vivos en años específicos y filtrar libros por siglas de idioma (es, en, fr, pt).

Tecnologías Utilizadas
Java JDK 17+: Lenguaje base utilizado para el desarrollo de la lógica del backend.

Spring Boot 3.4.x: Framework principal para la gestión de dependencias e inversión de control.

Spring Data JPA: Para el mapeo objeto-relacional (ORM) y la comunicación con la base de datos.

PostgreSQL / Postgres.app: Motor de base de datos relacional para el almacenamiento de la información.

Jackson Library: Para la manipulación y análisis de datos JSON recibidos de la API.

Estructura del Proyecto
El código sigue los principios de la Programación Orientada a Objetos (POO) y una arquitectura de capas limpia:

Principal: Clase que gestiona el menú interactivo y la lógica de usuario.

Modelo (Libro/Autor): Entidades JPA que representan las tablas en la base de datos.

Repository: Interfaces que extienden de JpaRepository para las operaciones CRUD.

Service (ConsumoAPI/ConvierteDatos): Clases encargadas de la comunicación externa y el parseo de datos.

DTOs: Records de Java para el mapeo seguro de las respuestas de la API.

Configuración
Para ejecutar este proyecto en tu entorno local:

Clona el repositorio.

Asegúrate de tener instalado Postgres.app o PostgreSQL y crea una base de datos llamada literalura.

Configura tus credenciales de base de datos en el archivo src/main/resources/application.properties.

Ejecuta la clase DemoApplication.

Desarrollado por: Diego Vilchez - Estudiante de Ingeniería de Sistemas e Informática (UTP) 🇵🇪
