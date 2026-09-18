# Laboratorio VI — Diseño y Desarrollo de APIs REST
 
## Información académica
 
- **Universidad:** Universidad Mariano Gálvez de Guatemala
- **Carrera:** Ingeniería en Sistemas
- **Semestre:** 4to semestre
- **Ingeniero:** Cristopher Renato de la Cruz
- **Estudiante:** Joshua Realiquez
- **Carnet:** 0900 25 12387
## Objetivo del laboratorio
 
Reforzar los conocimientos adquiridos en el Módulo II mediante la resolución de ejercicios prácticos de diseño (Swagger/OpenAPI) y desarrollo (Java + Spring Boot) de APIs REST, como preparación para el segundo parcial.
 
---
 
## Estructura del repositorio
 
```
LaboratorioVI/
├── Ejercicio1/              → Diseño de API: Biblioteca (libros)
│   └── biblioteca-api.yaml
├── Ejercicio2/              → Diseño de API: Cursos universitarios
│   └── curso-api.yaml
├── Ejercicio3/              → Diseño de API: Reservas de hotel
│   └── reserva-api.yaml
└── lab-VI/                  → Proyecto Spring Boot (Ejercicios 4, 5 y 6)
    └── src/main/java/org/realiquez/lab_VI/
        ├── Ejercicio1/      (referencia al diseño, sin código)
        ├── Ejercicio2/      (referencia al diseño, sin código)
        ├── Ejercicio3/      (referencia al diseño, sin código)
        └── Ejercicio4a6/    → Implementación de las 3 APIs
            ├── controller/
            ├── dto/
            ├── entity/
            ├── exception/
            ├── mapper/
            ├── repository/
            └── service/
```
 
> **Nota sobre la organización:** los ejercicios 4, 5 y 6 (desarrollo de las APIs de Libro, Curso y Reserva) se implementaron dentro de un único proyecto Spring Boot, bajo el paquete `Ejercicio4a6`, dado que las tres entidades comparten exactamente la misma arquitectura por capas. Esta decisión se tomó por eficiencia de desarrollo, manteniendo una organización clara por capa técnica (controller, service, repository, etc.) en la que cada capa contiene las clases correspondientes a las tres entidades, diferenciadas por su nombre (`CursoController`, `LibroController`, `ReservaController`, etc.).
 
---
 
## Ejercicios de diseño (Swagger / OpenAPI)
 
### Ejercicio 1 — API de Biblioteca
 
Administra los libros de una biblioteca.
 
**Entidad `Libro`:** `id`, `titulo`, `autor`, `isbn`, `anioPublicacion`, `estado`
 
**Endpoints:**
| Método | Ruta | Descripción |
|---|---|---|
| POST | `/libros` | Registrar un nuevo libro |
| GET | `/libros` | Consultar todos los libros (filtro opcional por `titulo`) |
| PUT | `/libros/{id}` | Actualizar un libro existente |
| DELETE | `/libros/{id}` | Eliminar un libro |
 
Archivo de diseño: [`Ejercicio1/biblioteca-api.yaml`](../Ejercicio1/biblioteca-api.yaml)
 
---
 
### Ejercicio 2 — API de Cursos Universitarios
 
Administra los cursos de una universidad.
 
**Entidad `Curso`:** `id`, `nombre`, `codigo`, `creditos`, `estado`
 
**Endpoints:**
| Método | Ruta | Descripción |
|---|---|---|
| POST | `/cursos` | Crear un nuevo curso |
| GET | `/cursos` | Consultar todos los cursos (filtro opcional por `codigo`) |
| PUT | `/cursos/{id}` | Actualizar un curso existente |
| DELETE | `/cursos/{id}` | Eliminar un curso |
 
Archivo de diseño: [`Ejercicio2/curso-api.yaml`](../Ejercicio2/curso-api.yaml)
 
---
 
### Ejercicio 3 — API de Reservas de Hotel
 
Administra las reservas de habitaciones de un hotel.
 
**Entidad `Reserva`:** `id`, `nombreCliente`, `habitacion`, `fechaEntrada`, `fechaSalida`, `estado`
 
**Endpoints:**
| Método | Ruta | Descripción |
|---|---|---|
| POST | `/reservas` | Crear una nueva reserva |
| GET | `/reservas` | Consultar todas las reservas |
| GET | `/reservas/{id}` | Consultar una reserva por id |
| PUT | `/reservas/{id}` | Actualizar una reserva |
| PATCH | `/reservas/{id}/cancelar` | Cancelar una reserva (cambio de estado, no elimina el registro) |
 
Archivo de diseño: [`Ejercicio3/reserva-api.yaml`](../Ejercicio3/reserva-api.yaml)
 
---
 
## Ejercicios de desarrollo (Java + Spring Boot)
 
Los ejercicios 4, 5 y 6 implementan, respectivamente, las APIs diseñadas en los ejercicios 1, 2 y 3, aplicando una **arquitectura organizada por capas** y utilizando **listas en memoria** como mecanismo de almacenamiento (sin base de datos).
 
### Arquitectura por capas
 
```
Controller → Service → Repository → Entity
     ↑           ↑
   DTO ←──── Mapper
```
 
| Capa | Responsabilidad |
|---|---|
| **Entity** | Representa el dato interno de la aplicación (`Libro`, `Curso`, `Reserva`) |
| **Repository** | Acceso a los datos; implementado con `ArrayList` en memoria |
| **Service** | Lógica de negocio y validaciones; lanza excepciones propias ante errores |
| **DTO** | Objetos usados exclusivamente para la comunicación por HTTP (Request/Response), separados de la Entity |
| **Mapper** | Convierte entre DTOs y Entities |
| **Controller** | Expone los endpoints REST y traduce excepciones a respuestas HTTP |
| **Exception** | Excepciones de negocio personalizadas (`NoEncontradoException`, `DuplicadoException`, `DatosInvalidosException`) manejadas globalmente con `@RestControllerAdvice` |
 
### Manejo de errores
 
Las excepciones de negocio se capturan de forma centralizada mediante un `GlobalExceptionHandler`, que traduce cada tipo de excepción a su código HTTP correspondiente:
 
| Excepción | Código HTTP |
|---|---|
| `*NoEncontradoException` | 404 Not Found |
| `*DuplicadoException` | 409 Conflict |
| `DatosInvalidosException` | 400 Bad Request |
 
### Tecnologías utilizadas
 
- Java
- Spring Boot
- Maven
- Swagger / OpenAPI 3.0 (fase de diseño)
### Evidencias de funcionamiento
 
Las capturas de pantalla que evidencian el correcto funcionamiento de cada endpoint (creación, consulta, actualización y eliminación/cancelación) se encuentran documentadas en el PDF de entrega final, junto con el enlace a este repositorio.
 
---
 
## Cómo ejecutar el proyecto
 
```bash
cd lab-VI
mvn spring-boot:run
```
 
La aplicación queda disponible en `http://localhost:8080`.
 
### Ejemplo de endpoints disponibles
 
```
GET    http://localhost:8080/cursos
GET    http://localhost:8080/cursos?codigo=POO-101
POST   http://localhost:8080/cursos
PUT    http://localhost:8080/cursos/{id}
DELETE http://localhost:8080/cursos/{id}
```
 
(Análogo para `/libros` y `/reservas` según sus endpoints definidos en el diseño.)
 