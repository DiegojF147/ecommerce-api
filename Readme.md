# 🛒 E-Commerce API 

API REST desarrollada con Spring Boot para gestionar productos y pedidos en un sistema de comercio electrónico.

---

## 🚀 Características principales

- ✅ Gestión completa de productos: crear, leer, actualizar y eliminar.
- ✅ Gestión completa de pedidos (orders): crear, leer, actualizar y eliminar.
- 🔍 Búsqueda avanzada por nombre de producto.
- 🖼️ Soporte para imágenes, stock, categorías y descripciones detalladas.
- 🔐 Autenticación básica (HTTP Basic) con usuarios en memoria.
- 🛡️ Preparado para autenticación con JWT (token bearer).
- 🌱 Perfiles `prod` y `dev` separados con su configuración correspondiente (H2 / MySQL).
- 🧪 Probado con Insomnia.
- 🧩 Separación por capas: entidad, DTO, servicio, repositorio y controlador.
- 📝 Documentación OpenAPI con Swagger lista para integrar.

---

## 📋 Endpoints disponibles

### 🔧 Productos

| Método | Endpoint            | Descripción                         |
|--------|---------------------|-------------------------------------|
| GET    | `/products`         | Listar todos los productos          |
| GET    | `/products/{id}`    | Obtener producto por ID             |
| GET    | `/products/search?queryName=` | Buscar productos por nombre |
| POST   | `/products`         | Crear nuevo producto                |
| PUT    | `/products/{id}`    | Actualizar producto existente       |
| DELETE | `/products/{id}`    | Eliminar producto por ID            |

### 📦 Pedidos (Orders)

| Método | Endpoint            | Descripción                         |
|--------|---------------------|-------------------------------------|
| GET    | `/orders`           | Listar todos los pedidos            |
| GET    | `/orders/{id}`      | Obtener pedido por ID               |
| POST   | `/orders`           | Crear nuevo pedido                  |
| PUT    | `/orders/{id}`      | Actualizar pedido existente         |
| DELETE | `/orders/{id}`      | Eliminar pedido por ID              |

📂 Ejemplos de uso con Insomnia disponibles en: [`Endpoint_Insomnia.md`](docs/Endpoint_Insomnia.md)

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- H2 Database (perfil `dev`)
- MySQL (perfil `prod`)
- Maven
- DTO Pattern
- Swagger / OpenAPI
- Insomnia (para testing de endpoints)

---

## ⚙️ Instalación y ejecución local

### 1. Clonar el repositorio

```bash
git clone https://github.com/TuUsuario/ecommerce-api.git
cd ecommerce-api
