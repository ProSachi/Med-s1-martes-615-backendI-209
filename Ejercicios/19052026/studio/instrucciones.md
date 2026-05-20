# Studio - Sistema de Gestión de Inventario y Ventas

## 📋 Descripción del Proyecto

Sistema backend desarrollado con Spring Boot para la gestión de inventario, productos, categorías y ventas. Incluye control de stock, categorización de productos y registro detallado de transacciones de venta.

## 🛠️ Tecnologías Utilizadas

- **Java**: 21
- **Spring Boot**: 3.5.14
- **Gestor de Dependencias**: Maven
- **Base de Datos**: H2 (en memoria)
- **ORM**: Spring Data JPA
- **API REST**: Spring Web

## 📦 Dependencias Principales

```xml
- spring-boot-starter-web       → Creación de APIs REST
- spring-boot-starter-data-jpa  → Persistencia con JPA/Hibernate
- spring-boot-devtools          → Herramientas de desarrollo
- h2                            → Base de datos en memoria
```

## 🗂️ Estructura del Proyecto

```
studio/
├── src/
│   ├── main/
│   │   ├── java/com/visual/studio/
│   │   │   ├── model/              # Entidades JPA ✅
│   │   │   │   ├── Categoria.java
│   │   │   │   ├── Producto.java
│   │   │   │   ├── Inventario.java
│   │   │   │   ├── Venta.java
│   │   │   │   └── DetalleVenta.java
│   │   │   ├── repository/         # Repositorios JPA ✅
│   │   │   │   ├── CategoriaRepository.java
│   │   │   │   ├── ProductoRepository.java
│   │   │   │   ├── InventarioRepository.java
│   │   │   │   ├── VentaRepository.java
│   │   │   │   └── DetalleVentaRepository.java
│   │   │   └── StudioApplication.java  # Main con menú CRUD ✅
│   │   └── resources/
│   │       ├── application.properties  # Configurado con H2 ✅
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com/visual/studio/
├── pom.xml
└── instrucciones.md
```

## 🗄️ Modelo de Datos

### Entidades

#### 1. **Categoria**
- `id` (Long) - Identificador único
- `nombre` (String) - Nombre de la categoría
- Relación: Una categoría tiene muchos productos

#### 2. **Producto**
- `id` (Long) - Identificador único
- `nombre` (String) - Nombre del producto
- `descripcion` (String) - Descripción del producto
- `precio` (BigDecimal) - Precio del producto
- `stock` (Integer) - Cantidad en stock
- `categoria_id` (Long) - FK a Categoria
- Relaciones:
  - Pertenece a una Categoría
  - Tiene muchos registros de Inventario
  - Aparece en muchos DetalleVenta

#### 3. **Inventario**
- `id` (Long) - Identificador único
- `producto_id` (Long) - FK a Producto
- `cantidad` (Integer) - Cantidad registrada
- `fecha` (ZonedDateTime) - Fecha del movimiento
- Relación: Cada registro pertenece a un Producto

#### 4. **Venta**
- `id` (Long) - Identificador único
- `fecha` (ZonedDateTime) - Fecha de la venta
- `total` (BigDecimal) - Total de la venta
- Relación: Una venta tiene múltiples detalles

#### 5. **DetalleVenta**
- `id` (Long) - Identificador único
- `venta_id` (Long) - FK a Venta
- `producto_id` (Long) - FK a Producto
- `cantidad` (Integer) - Cantidad vendida
- `precio_unitario` (BigDecimal) - Precio al momento de la venta
- Relaciones:
  - Pertenece a una Venta
  - Referencia a un Producto

## ⚙️ Configuración

### application.properties

```properties
# Configuración de H2
spring.datasource.url=jdbc:h2:mem:studiodb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Consola H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Puerto del servidor
server.port=8080
```

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- JDK 21 instalado
- Maven instalado (o usar el wrapper incluido)

### Pasos

1. **Clonar/Abrir el proyecto**
   ```bash
   cd studio
   ```

2. **Compilar el proyecto**
   ```bash
   mvn clean install
   ```

3. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```
   
   O usando el wrapper:
   ```bash
   # Windows
   .\mvnw.cmd spring-boot:run
   
   # Linux/Mac
   ./mvnw spring-boot:run
   ```

4. **Acceder a la aplicación**
   - API REST: `http://localhost:8080`
   - Consola H2: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:studiodb`
     - Username: `sa`
     - Password: (vacío)

## 🎯 Estado Actual del Proyecto

### Completado ✅
- **Entidades del modelo** (Categoria, Producto, Inventario, Venta, DetalleVenta)
- **Relaciones JPA bidireccionales** entre entidades
- **Configuración de H2** con consola habilitada
- **Repositorios JPA** para todas las entidades
- **Menú de consola interactivo** con operaciones CRUD completas
- **Función de poblar datos de prueba**

### Características del Menú
El sistema incluye un menú de consola completo con las siguientes funcionalidades:

#### 📁 Gestión de Categorías (Opciones 1-5)
- Crear, listar, buscar, actualizar y eliminar categorías

#### 📦 Gestión de Productos (Opciones 6-11)
- CRUD completo de productos
- Filtrar productos por categoría
- Asignación de categoría al producto

#### 📊 Gestión de Inventario (Opciones 12-14)
- Registrar movimientos de inventario
- Consultar todo el inventario
- Ver historial de un producto específico

#### 💰 Gestión de Ventas (Opciones 15-17)
- Crear ventas con múltiples productos
- Listar todas las ventas
- Ver detalle completo de cada venta

#### 🗄️ Poblar Base de Datos (Opción 18)
- Carga automática de datos de prueba:
  - 3 Categorías (Electrónica, Ropa, Alimentos)
  - 4 Productos con precios y stock
  - 4 Registros de inventario
  - 1 Venta de ejemplo con 2 productos

### No Implementado (Fuera del Alcance Actual)
- Servicios de negocio (capa de servicio)
- Controladores REST (API endpoints)
- DTOs para transferencia de datos
- Validaciones avanzadas
- Manejo de excepciones personalizado
- Pruebas unitarias
- Documentación API

> **Nota:** Este proyecto implementa **operaciones CRUD directas desde el main** usando repositorios JPA. Las capas de servicio y controlador no se implementan en esta fase. El objetivo es probar y validar la persistencia en la base de datos H2.

## 📝 Notas de Desarrollo

- La base de datos H2 se reinicia cada vez que se detiene la aplicación (modo `mem`)
- Las tablas se crean automáticamente gracias a `ddl-auto=update`
- Los logs SQL están habilitados para debug (`show-sql=true`)
- El proyecto usa Java 21, asegúrate de tener la versión correcta instalada

## 👥 Información del Proyecto

- **Grupo**: com.visual
- **Artifact**: studio
- **Versión**: 0.0.1-SNAPSHOT
- **Package**: com.visual.studio

---

*Última actualización: 19 de mayo de 2026*
