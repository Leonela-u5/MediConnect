# 🏥 MediConnect – Plataforma Web de Gestión de Citas Médicas

## 📌 Descripción del Proyecto

**MediConnect** es una aplicación web desarrollada con **Angular (Frontend)** y **Spring Boot (Backend)** que permite a los pacientes registrarse, iniciar sesión y acceder a un dashboard donde pueden buscar especialistas médicos y gestionar su información de usuario.

El sistema está orientado a la digitalización de servicios médicos, mejorando la experiencia del usuario mediante una interfaz moderna, rápida e intuitiva.

---

## ⚙️ Tecnologías Utilizadas

### Frontend

* Angular
* TypeScript
* HTML5 / CSS3
* RxJS
* LocalStorage para sesión de usuario

### Backend

* Spring Boot
* Spring Security
* Spring Data JPA
* BCryptPasswordEncoder
* API REST

### Base de Datos

* PostgreSQL (o MySQL según configuración)

---

## 🧠 Funcionalidades Implementadas

### 🔐 Autenticación

* Registro de pacientes con nombre, apellido, correo y contraseña
* Inicio de sesión seguro con validación en backend
* Mensajes dinámicos de error y éxito
* Manejo de sesión con `localStorage`

### 👤 Gestión de Usuario

* Visualización del nombre del usuario logueado en el dashboard
* Persistencia de datos del usuario después del login
* Botón de cerrar sesión

### 📊 Dashboard del Paciente

* Barra de navegación fija con logo y usuario activo
* Buscador de especialistas médicos
* Sección de especialidades populares
* Módulo de próximas citas médicas (UI simulada)

---

## 🔄 Comunicación Frontend – Backend

El sistema funciona mediante una API REST:

* `POST /api/auth/registro` → Registro de usuario
* `POST /api/auth/login` → Autenticación de usuario

El backend devuelve respuestas en formato JSON, incluyendo el objeto `usuario`, el cual es almacenado en el frontend para mostrar la información personalizada.

---

## 🛠️ Arquitectura del Proyecto

El proyecto está organizado en módulos:

```
src/app/
├── auth/
│   ├── login
│   ├── registro-paciente
├── paciente/
│   ├── dashboard-paciente
├── services/
├── models/
```

---

## 🔐 Seguridad

* Contraseñas encriptadas con BCrypt
* Validación de credenciales en backend
* Rutas protegidas por Spring Security
* Acceso público solo a endpoints de autenticación

---

## 🚀 Estado del Proyecto

✔ Registro de usuarios funcional
✔ Login conectado a backend
✔ Dashboard del paciente implementado
✔ Sesión persistente en frontend
✔ Interfaz moderna y responsiva

---

## 📌 Mejoras Futuras

* Implementación de sistema de roles (Paciente / Especialista / Admin)
* Gestión real de citas médicas
* Notificaciones en tiempo real
* Filtros avanzados de búsqueda de médicos
* Integración con calendario

---

## 👩‍💻 Autor

**Leonela Lema**
Proyecto académico – Sistema de Gestión Médica MediConnect

---

