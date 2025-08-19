# 📌 API REST - Gestión de Tópicos  

Este proyecto es una **API REST desarrollada en Java 21 con Spring Boot**, cuyo propósito es gestionar **tópicos**. Implementa operaciones CRUD completas, con persistencia en base de datos, validaciones de reglas de negocio y seguridad para el acceso controlado a la información.  

---

## 🚀 Funcionalidades  

La API permite:  
- **Crear un nuevo tópico**  
- **Mostrar todos los tópicos creados**  
- **Consultar un tópico específico por ID**  
- **Actualizar un tópico existente**  
- **Eliminar un tópico**  

Estas operaciones siguen las mejores prácticas del modelo **REST**.  

---

## 🛠️ Tecnologías utilizadas  

- ☕ **Java 21**  
- 🌱 **Spring Boot** (Framework principal)  
- 🔐 **Spring Security** (Autenticación y autorización)  
- 🗄️ **JPA / Hibernate** (Persistencia de datos)  
- 🛠️ **Flyway** (Migración de base de datos)  
- ✨ **Lombok** (Reducción de código repetitivo)  
- 🐬 **MySQL** (Base de datos relacional)  
- 📦 **Maven** (Gestión de dependencias)  
- 🧪 **Insomnia** (Cliente para pruebas de la API)  

---

## 🔐 Seguridad  

La API cuenta con **Spring Security**, lo que permite proteger las rutas y restringir el acceso a los recursos mediante autenticación y autorización.  

---

## ⚙️ Configuración  

1. **Clonar el repositorio**  
   ```bash
   git clone https://github.com/tuusuario/tu-repo.git
   ```

2. **Configurar la base de datos** en `application.properties`:  
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_basedatos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=validate
   ```

3. **Ejecutar migraciones** con **Flyway** (se correrán automáticamente al levantar la app).  

4. **Compilar y ejecutar el proyecto con Maven**:  
   ```bash
   mvn spring-boot:run
   ```

---

## 📡 Endpoints principales  

| Método | Endpoint         | Descripción                     |
|--------|-----------------|---------------------------------|
| POST   | `/topicos`      | Crear un nuevo tópico           |
| GET    | `/topicos`      | Listar todos los tópicos        |
| GET    | `/topicos/{id}` | Obtener un tópico por ID        |
| PUT    | `/topicos/{id}` | Actualizar un tópico existente  |
| DELETE | `/topicos/{id}` | Eliminar un tópico              |

---

## 🧪 Pruebas  

Se recomienda usar **Insomnia** o **Postman** para probar los endpoints.  

---

## 📖 Reglas de negocio implementadas  

- ✅ Todos los campos de un tópico son **obligatorios**.  
- 🚫 No se permite registrar **tópicos duplicados** (mismo título y mensaje).  
- 🔒 Acceso a la información restringido mediante **autenticación**.  

---

## 👨‍💻 Autor  

Proyecto desarrollado por **Pinto Juan**, como parte de la práctica de construcción de API REST con Spring Boot.  
