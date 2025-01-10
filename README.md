<p align="center">
  <img src="https://github.com/user-attachments/assets/9db3369e-9f26-4fdc-8ec0-f69afe7baa25">
</p>

## <P> Foro Hub API Rest</P>

API Rest desarrollada en Java con el Framework Spring Boot para la gestión de un foro en línea. Permite a los usuarios
registrarse, iniciar sesión, publicar temas, responderlos y más.

> **NOTE:** Este proyecto ha sido desarrollado con la ayuda de asistentes de inteligencia artificial como
> JetBrains AI Assistant, ChatGPT, Claude, Gemini y GitHub Copilot.

## Índice

1. [Características](#características)
2. [Requisitos Previos](#requisitos-previos)
3. [Configuración](#configuración)
4. [Uso](#uso)
5. [Estructura del Proyecto](#estructura-del-proyecto)
6. [Contribución](#contribución)

## Características

- Registro y autenticación de usuarios
- Gestión de Temas, Usuarios, Cursos y Respuestas
- Mostrar Temas ordenados por fecha
- Documentación con Swagger
- Persistencia de datos con MySQL
- Autenticación con la librería JWT

## Requisitos Previos

- **Java versión 17 o superior**
- **Maven 3.8**
- **Spring Boot 3.4**

## Configuración

1. Clonar el repositorio

   ```bash
   git clone https://github.com/carlosferreyra/HubApi
   cd HubApi
2. Configurar el entorno o editar el archivo application.properties para la conexión con tu base de datos

   ```yaml
    spring.datasource.url=jdbc:postgresql://localhost:5432/foro_db
    spring.datasource.username=[user]
    spring.datasource.password=[password]
    spring.jpa.hibernate.ddl-auto=update

3. Compilar y ejecutar el proyecto

   ```bash
   mvn clean install
   mvn spring-boot:run

4. Abrir `http:localhost:8080` en tu navegador para probar la API.

## Uso

1. Abrir `http://localhost:8080/swagger-ui/index.html#/` en tu navegador para el uso de la API
2. Inicia sesión con tu correo electrónico y contraseña para obtener el token bearer.

   ![image](https://github.com/user-attachments/assets/41e58795-1853-4d74-bf73-73b77caf4c67)

3. Copiar el token bearer

4. ![image](https://github.com/user-attachments/assets/78624638-dc6d-4473-8e3f-8337207e1660)

5. Pegarlo en el campo authentication bearer-key para habilitar el resto de los endpoints y ¡listo!

   ![image](https://github.com/user-attachments/assets/307455c1-6581-4428-872a-9a8701ba6752)

```




