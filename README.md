# Video Store Application

## Objetivo del Proyecto

El objetivo principal de este proyecto es proporcionar un entorno de aplicación realista para aprender y practicar el uso de Angular y Spring Boot. Es un recurso personal de aprendizaje y desarrollo de habilidades.Este proyecto es una aplicación de tienda de videos con una parte de frontend desarrollada en Angular y una parte de backend desarrollada en Java con Spring Boot. 

## Características

- Registro y login de usuarios
- Préstamo de películas
- Devolución de películas
- Listado de películas alquiladas
- Login como administrador
- Listado de clientes registrados
- Listado de películas registradas
- Registro de películas
- Eliminación de películas
- Consultar disponibilidad de películas

## Tecnologías utilizadas

### Frontend
- Angular
- Jasmine (para pruebas)
- Karma (como corredor de pruebas)

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Boot Devtools
- PostgreSQL (base de datos)
- Lombok (para reducir código boilerplate)
- Java JWT (para autenticación)

## Cómo ejecutar el proyecto

### Frontend

1. Asegúrate de tener Node.js y NPM instalados en tu sistema.
2. Navega al directorio del frontend en la línea de comandos.
3. Ejecuta `npm install` para instalar las dependencias.
4. Ejecuta `ng serve` para iniciar el servidor de desarrollo de Angular.
5. Abre un navegador web y navega a `http://localhost:4200`.

### Backend

1. Asegúrate de tener Java y Maven instalados en tu sistema.
2. Navega al directorio del backend en la línea de comandos.
3. Ejecuta `mvn spring-boot:run` para iniciar la aplicación Spring Boot.
4. La API REST estará disponible en `http://localhost:8080`.

## Pruebas

Para ejecutar las pruebas en el frontend, utiliza el comando `ng test`. Las pruebas se ejecutarán automáticamente utilizando Karma y Jasmine.

Para ejecutar las pruebas en el backend, utiliza el comando `mvn test`.

## Estado

El proyecto está aún sin finalizar ya que voy añadiendo los features a lo largo del tiempo.
