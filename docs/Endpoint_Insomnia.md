# Documentación de la API - Ecommerce

## Endpoints - Productos

### 📌 Crear producto
**Método:** `POST`  
**URL:** `http://localhost:8080/products`

**Body (JSON):**
```json
{
  "name": "Mouse Genius",
  "price": 20.0,
  "stock": 20,
  "image": "",
  "category": "Accesorios",
  "description": "Mouse óptico básico"
}
```

---

### ❌ Eliminar producto
**Método:** `DELETE`  
**URL:** `http://localhost:8080/products/{id}`

---

### ✏️ Actualizar producto (completar todos los campos)
**Método:** `PUT`  
**URL:** `http://localhost:8080/products/{id}`

**Body (JSON):**
```json
{
  "id": 1,
  "name": "Monitor Samsung 24",
  "image": "https://tccommercear.vtexassets.com/arquivos/ids/161111/159696-800-auto.png",
  "price": 199.99,
  "stock": 40,
  "category": "Electrónica",
  "description": "Monitor LED de 24 pulgadas con resolución Full HD."
}
```

---

### 📃 Listar productos
**Método:** `GET`  
**URL:** `http://localhost:8080/products`

---

### 🔍 Buscar producto por ID
**Método:** `GET`  
**URL:** `http://localhost:8080/products/{id}`

---

### 🔎 Buscar producto por nombre
**Método:** `GET`  
**URL:** `/products/search?queryName=teclado`

---

## Endpoints - Pedidos

### 🛒 Crear pedido
**Método:** `POST`  
**URL:** `http://localhost:8080/orders`

**Body (JSON):**
```json
{
  "items": [
    {
      "productId": 10,
      "quantity": 5
    }
  ]
}
```

---

### ❌ Eliminar pedido
**Método:** `DELETE`  
**URL:** `http://localhost:8080/orders/{id}`

---

### 📃 Listar pedidos
**Método:** `GET`  
**URL:** `http://localhost:8080/orders`

---

### 🔍 Buscar pedido por ID
**Método:** `GET`  
**URL:** `http://localhost:8080/orders/{id}`

