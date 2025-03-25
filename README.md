# API de Gestión de Reservas de Hotel

## Objetivo
Desarrollar una API REST con **Spring Boot** para la gestión de reservas de habitaciones de hotel. Se implementan las mejores prácticas de desarrollo, incluyendo:

- Uso correcto de los códigos de estado HTTP.
- Validaciones de datos y reglas de negocio.
- Manejo centralizado de errores.
- Diseño modular con controladores, servicios y repositorios.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- H2 Database (para pruebas)
- JUnit 5 y Mockito
- Springdoc OpenAPI (Swagger)
- Makefile (Opcional)
- Docker (Opcional)

## Instalación y Ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/hotel-booking-api.git
   cd hotel-booking-api
   ```
2. Compilar y ejecutar el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```
- OPCIONAL Levantar Docker previamente y ejecutar el Makefile default:
   ```bash
   make
   ```
3. Acceder a la documentación de la API en Swagger:
   - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

4. Acceder a la base de datos H2:
   - [http://localhost:8080/h2](http://localhost:8080/h2)

---

## Endpoints y Respuestas Esperadas

### Habitaciones
| Método | Endpoint         | Descripción | Respuesta |
|---------|-----------------|-------------|-----------|
| GET     | `/rooms`        | Obtener todas las habitaciones disponibles | `200 OK` |
| POST    | `/rooms`        | Crear una nueva habitación | `201 Created` |
| GET     | `/rooms/{id}`   | Obtener detalles de una habitación | `200 OK`, `404 Not Found` |
| PUT     | `/rooms/{id}`   | Actualizar información de una habitación | `200 OK`, `400 Bad Request` |
| DELETE  | `/rooms/{id}`   | Eliminar una habitación si no está reservada | `204 No Content`, `409 Conflict` |

### Reservas
| Método | Endpoint             | Descripción | Respuesta |
|---------|---------------------|-------------|-----------|
| POST    | `/reservations`     | Crear una reserva | `201 Created`, `400 Bad Request`, `409 Conflict` |
| GET     | `/reservations/{id}` | Obtener detalles de una reserva | `200 OK`, `404 Not Found` |
| DELETE  | `/reservations/{id}` | Cancelar una reserva | `204 No Content`, `404 Not Found` |

---
## Reglas de Negocio
- Una habitación solo puede reservarse si está disponible.
- No se permiten reservas con fechas pasadas.
- Si se cancela una reserva, la habitación vuelve a estar disponible.
- No se permite eliminar habitaciones con reservas activas.

---

## Manejo de Errores
Se implementa un controlador global con `@ControllerAdvice` para manejar excepciones y devolver respuestas JSON estandarizadas.

- **NotFoundException** (`404 Not Found`)
- **BadRequestException** (`400 Bad Request`)
- **ConflictException** (`409 Conflict`)

---

## Testing
Se implementarán pruebas unitarias y de integración con **JUnit 5** y **Mockito**.

Para ejecutar las pruebas:
```bash
mvn test
```

---

## Documentación con Swagger
La API aun NO está documentada con **Springdoc OpenAPI** y se puede acceder en:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Entrega Final
- Repositorio Git con el código fuente.
- Archivo `README.md` con instrucciones de instalación y uso.
- Documentación generada con Swagger.
- Evidencia de pruebas ejecutadas.

---

## Autor
Instagram: @programando_con_jorge

## Colaboradores
GitHub: @manubravo