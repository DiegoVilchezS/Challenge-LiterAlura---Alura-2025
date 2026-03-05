Challenge LiterAlura - Alura & ONE
¡Bienvenido, mi nombre es Diego Vilchez y soy de Perú!

Este proyecto es una aplicación de consola en Java que funciona como un catálogo literario inteligente, permitiendo buscar libros y autores a través de la API de Gutendex, gestionando la información de manera eficiente mediante una base de datos relacional PostgreSQL.

Funcionalidades
Consultas a la API Gutendex: Obtiene datos bibliográficos en tiempo real directamente desde la fuente externa.

Persistencia de Datos: Almacena de forma permanente los libros y autores consultados utilizando PostgreSQL.

Menú interactivo: Interfaz sencilla en consola que permite realizar búsquedas, listar registros y aplicar filtros específicos.

Validación de Duplicados: Sistema inteligente que verifica si un libro ya existe en la base de datos antes de registrarlo para mantener la integridad de la información.

Filtros Avanzados: Capacidad de listar autores vivos en años determinados y filtrar libros por siglas de idioma (es, en, fr, pt).

Tecnologías Utilizadas
Java JDK 17+: Lenguaje base utilizado para el desarrollo de la lógica del backend.

Spring Boot 3.4.x: Framework principal para la gestión de dependencias e inversión de control.

Spring Data JPA: Utilizado para el mapeo objeto-relacional (ORM) y la comunicación con la base de datos.

PostgreSQL / Postgres.app: Motor de base de datos relacional para el almacenamiento de la información en macOS.

Jackson Library: Para la manipulación y el análisis (parsing) de los datos JSON recibidos de la API.

Estructura del Proyecto
El código sigue los principios de la Programación Orientada a Objetos (POO) y una arquitectura de capas limpia:

Principal: Clase encargada de gestionar el menú interactivo y la lógica directa con el usuario.

Modelo (Libro/Autor): Entidades JPA que representan las tablas y relaciones dentro de la base de datos.

Repository: Interfaces que extienden de JpaRepository para gestionar las operaciones CRUD.

Service (ConsumoAPI/ConvierteDatos): Clases especializadas en la comunicación HTTP externa y la conversión de datos JSON.

DTOs: Records de Java para el mapeo seguro y eficiente de las respuestas de la API.

Configuración
Para ejecutar este proyecto en tu entorno local:

Clona el repositorio.

Asegúrate de tener instalado Postgres.app o PostgreSQL y crea una base de datos vacía llamada literalura.

Configura tus credenciales de acceso (usuario y contraseña) en el archivo src/main/resources/application.properties.

Ejecuta la clase DemoApplication.

Desarrollado por: Diego Vilchez - Estudiante de Ingeniería de Sistemas e Informática (UTP) 🇵🇪
