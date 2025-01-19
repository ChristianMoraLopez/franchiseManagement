# Sistema de Gestión de Franquicias

API REST para la gestión de franquicias, sucursales y productos.

## Prerequisitos

- Java 17 o superior
- Docker y Docker Compose
- PostgreSQL (si se ejecuta localmente)

## Opciones de Ejecución

### 1. Usando Docker (Recomendado)

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/franchise-management.git
cd franchise-management
```

2. Construir y ejecutar con Docker:
```bash
docker build -t franchise-management .
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:postgresql://us-east-1.63a4bee5-d0c1-4ab7-a511-d9de7eb71fd6.aws.yugabyte.cloud:5433/yugabyte?sslmode=verify-full \
-e SPRING_DATASOURCE_USERNAME=admin \
-e SPRING_DATASOURCE_PASSWORD=9Wev6TRsf4JAmYxcG3ZjJzhJKL07Wi \
franchise-management
```

O simplemente:
```bash
docker-compose up
```

### 2. Ejecución Local

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/franchise-management.git
cd franchise-management
```

2. Ejecutar con Gradle:
```bash
# En Linux/MacOS:
chmod +x gradlew
./gradlew bootRun

# En Windows:
.\gradlew.bat bootRun
```

## Estructura del Proyecto

```
franchise-management/
├── src/main/
│   └── java/com/franchise/
│       ├── controller/     # Controladores REST
│       ├── model/         # Entidades
│       ├── repository/    # Repositorios JPA
│       ├── service/      # Servicios
│       └── dto/          # DTOs
├── Dockerfile           # Configuración de Docker
├── docker-compose.yml   # Configuración de Docker Compose
└── build.gradle        # Configuración de Gradle
```

## API Endpoints

### Franquicias

#### Crear Franquicia
```bash
curl -X POST http://localhost:8080/api/franchises \
     -H "Content-Type: application/json" \
     -d '{"name": "Mi Franquicia"}'
```

#### Actualizar Nombre de Franquicia
```bash
curl -X PUT http://localhost:8080/api/franchises/1/name \
     -H "Content-Type: application/json" \
     -d '{"name": "Nuevo Nombre"}'
```

### Sucursales

#### Agregar Sucursal a Franquicia
```bash
curl -X POST http://localhost:8080/api/branches/franchise/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Sucursal Centro"}'
```

### Productos

#### Agregar Producto a Sucursal
```bash
curl -X POST http://localhost:8080/api/products/branch/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Producto 1", "stock": 100}'
```

#### Actualizar Stock de Producto
```bash
curl -X PUT http://localhost:8080/api/products/1/stock \
     -H "Content-Type: application/json" \
     -d '{"stock": 150}'
```

#### Obtener Productos con Mayor Stock
```bash
curl -X GET http://localhost:8080/api/products/franchise/1/highest-stock
```

## Solución de Problemas Comunes

### Error de Conexión a la Base de Datos
Si aparece el error "Connection refused" al usar curl desde WSL:
- Usar la IP de Windows en lugar de localhost
- Usar Postman o el cmd de Windows

### Error de Permisos en gradlew
En Linux/MacOS, si aparece "Permission denied":
```bash
chmod +x gradlew
```

### Error de Java Home
Si aparece error de JAVA_HOME:
1. Instalar Java 17:
```bash
# En Ubuntu/Debian
sudo apt install openjdk-17-jdk
```
2. Configurar JAVA_HOME:
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

## Variables de Entorno

La aplicación usa las siguientes variables de entorno que pueden ser configuradas:

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://us-east-1.63a4bee5-d0c1-4ab7-a511-d9de7eb71fd6.aws.yugabyte.cloud:5433/yugabyte?sslmode=verify-full
SPRING_DATASOURCE_USERNAME=admin
SPRING_DATASOURCE_PASSWORD=9Wev6TRsf4JAmYxcG3ZjJzhJKL07Wi
```

## Tests

Para ejecutar los tests:
```bash
./gradlew test
```

## Construcción

Para construir el proyecto:
```bash
./gradlew build
```

## Licencia

Este proyecto está bajo la Licencia MIT. 
