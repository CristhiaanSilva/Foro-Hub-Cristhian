<p align="center">
  	<img width="auto" height="auto" src="img/Badge_ForoHub_ONE.png">
</p>

# ForoHub - Oracle y Alura Challenge

**ForoHub** es una aplicación web desarrollada en Java con Spring Boot para gestionar tópicos en un foro, una solución para el cuarto desafío de programación de Oracle Next Generation (ONE) de Alura. La aplicación permite a los usuarios autenticados crear, listar, actualizar y eliminar tópicos. Utiliza MySQL como sistema de gestión de bases de datos y está diseñada para seguir buenas prácticas de desarrollo de APIs REST.

## Características

- **Gestión de tópicos:** Crea, lee, actualiza y elimina tópicos en el foro.
- **Autenticación de usuarios:** Solo usuarios autenticados pueden interactuar con la API.
- **Persistencia de datos:** Utiliza MySQL para almacenar datos.
- **Migraciones de base de datos:** Flyway para gestionar cambios en el esquema de la base de datos.
- **Validación de datos:** Asegura la calidad de los datos mediante validaciones.
- **Documentación de API:** Swagger UI para explorar y probar los endpoints de la API.

## Tecnologías

- **Java:** Versión 17.
- **Maven:** Gestión de dependencias y construcción del proyecto.
- **Spring Boot:** Framework para desarrollar la aplicación. Versión 3.
- **MySQL:** Sistema de gestión de bases de datos.
- **Flyway:** Migraciones de base de datos
- **Spring Security:** Seguridad y autenticación de usuarios

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

- **config**: Configuraciones de Spring Boot, incluyendo la configuración de seguridad.
- **controller**: Controladores REST que gestionan las solicitudes de la API.
- **model**: Clases de modelo que representan las entidades de la base de datos.
- **repository**: Repositorios para acceder a los datos en la base de datos.
- **service**: Lógica de negocio de la aplicación.
- **dto**: Clases de transferencia de datos (DTO) para las solicitudes y respuestas de la API.

## Diagrama de Base de Datos

A continuación, se muestra un diagrama sugerido para la base de datos:

<p align="center">
  	<img width="auto" height="auto" src="img/forohub_db.png">
</p>

>[!NOTE]
> Este diagrama es una referencia; puedes adaptar la estructura según tus necesidades.

>[!IMPORTANT]
> ## Migraciones con Flyway

Para gestionar las migraciones de base de datos, Flyway se encarga de aplicar los scripts SQL en orden. Asegúrate de mantener el orden de las migraciones y crear los archivos en el directorio `src/main/resources/db/migration`.

### Comandos Útiles de Flyway

- **Limpiar la Base de Datos**:
    ```bash
    mvn flyway:clean
    ```

- **Aplicar Migraciones**:
    ```bash
    mvn flyway:migrate
    ```

- **Deshacer la Última Migración**:
    ```bash
    mvn flyway:undo
    ```

- **Mostrar el Estado de las Migraciones**:
    ```bash
    mvn flyway:info
    ```

>[!NOTE]
> Si decides cambiar a MySQL, asegúrate de ajustar los scripts SQL para ser compatibles con MySQL y cambiar la URL de conexión en `application.properties`.

## Autenticación

La API utiliza autenticación básica para proteger los endpoints. Asegúrate de enviar un encabezado `Authorization` con las credenciales en formato `Basic` para acceder a los recursos de la API.

## Instalación

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/forohub.git
   cd forohub
   ```

2. **Configurar PostgreSQL:**

   Crea una base de datos en PostgreSQL y actualiza el archivo `src/main/resources/application.properties` con los detalles de tu base de datos y reemplaza `tu_usuario` y `tu_contraseña` con tus credenciales de PostgreSQL.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forohub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. **Ejecutar Migraciones:**

   Asegúrate de que las migraciones están aplicadas. Puedes ejecutar las migraciones con:

   ```bash
   mvn flyway:migrate
   ```

4. **Ejecutar la Aplicación:**

   Inicia la aplicación con el siguiente comando:

   ```bash
   mvn spring-boot:run
   ```

## Uso

Una vez que la aplicación esté en ejecución, puedes interactuar con la API a través de los siguientes endpoints:

- **POST** `/api/topics`: Crear un nuevo tópico.
- **GET** `/api/topics`: Listar todos los tópicos.
- **GET** `/api/topics/{id}`: Obtener los detalles de un tópico por ID.
- **PUT** `/api/topics/{id}`: Actualizar un tópico existente.
- **DELETE** `/api/topics/{id}`: Eliminar un tópico por ID.

Visita `http://localhost:8080/swagger-ui/` para explorar y probar los endpoints de la API con Swagger UI.

## Comandos para Probar la API

Puedes probar los endpoints de la API usando herramientas como [Soap UI](https://www.soapui.org/) o [Postman](https://www.postman.com/).

### Ejemplos de Endpoints

- **Registrar un Tópico**:
    - **POST** `/topicos`
    - **Body**:
        ```json
        {
            "titulo": "Título del Tópico",
            "mensaje": "Mensaje del Tópico",
            "autor": "Autor del Tópico",
            "curso": "Curso del Tópico"
        }
        ```

- **Listar Tópicos**:
    - **GET** `/topicos`

- **Detalle de un Tópico**:
    - **GET** `/topicos/{id}`

- **Actualizar un Tópico**:
    - **PUT** `/topicos/{id}`
    - **Body**:
        ```json
        {
            "titulo": "Nuevo Título del Tópico",
            "mensaje": "Nuevo Mensaje del Tópico",
            "autor": "Nuevo Autor del Tópico",
            "curso": "Nuevo Curso del Tópico"
        }
        ```

- **Eliminar un Tópico**:
    - **DELETE** `/topicos/{id}`

## Contribuciones

Las contribuciones son bienvenidas. Si tienes sugerencias o encuentras errores, por favor abre un **issue** o envía un **pull request**.
