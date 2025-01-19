# 🏪 Sistema de Gestión de Franquicias 🍔

¡Bienvenido al asombroso y súper estilizado README del Sistema de Gestión de Franquicias! 🎉 Esta impresionante API REST te permitirá gestionar tus franquicias, sucursales y productos como todo un pro. 😎

## 📋 Prerequisitos

- ☕ Java 17 o superior (porque el café es vida)
- 🐳 Docker y Docker Compose (para navegantes intrépidos)
- 🐘 PostgreSQL (si te gusta la aventura local)

## 🚀 Opciones de Ejecución

### 1. 🐳 Usando Docker (Recomendado para los amantes de la simplicidad)

1. Clona el repositorio como un verdadero hacker:
```bash
git clone https://github.com/tu-usuario/franchise-management.git
cd franchise-management
```

2. Construye y ejecuta con Docker como un maestro de la containerización:
```bash
docker build -t franchise-management .
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:postgresql://us-east-1.63a4bee5-d0c1-4ab7-a511-d9de7eb71fd6.aws.yugabyte.cloud:5433/yugabyte?sslmode=verify-full \
-e SPRING_DATASOURCE_USERNAME=admin \
-e SPRING_DATASOURCE_PASSWORD=9Wev6TRsf4JAmYxcG3ZjJzhJKL07Wi \
franchise-management
```

O simplemente deja que Docker Compose haga su magia:
```bash  
docker-compose up
```

### 2. 💻 Ejecución Local (Para los valientes)

1. Clona el repositorio como un verdadero hacker (sí, otra vez):
```bash
git clone https://github.com/tu-usuario/franchise-management.git  
cd franchise-management
```

2. Ejecuta con Gradle como un maestro de la construcción:
```bash
# En Linux/MacOS (porque eres cool):
chmod +x gradlew
./gradlew bootRun

# En Windows (no te juzgamos):  
.\gradlew.bat bootRun
```

## 🏗️ Estructura del Proyecto

```
franchise-management/
├── src/main/
│   └── java/com/franchise/
│       ├── controller/     # Controladores REST (donde la magia ocurre)
│       ├── model/          # Entidades (tus nuevos mejores amigos)  
│       ├── repository/     # Repositorios JPA (buscadores de tesoros)
│       ├── service/        # Servicios (tus fieles sirvientes)
│       └── dto/            # DTOs (porque a veces menos es más)
├── Dockerfile              # Configuración de Docker (para dominar el mundo)
├── docker-compose.yml      # Configuración de Docker Compose (orquestando contenedores)
└── build.gradle            # Configuración de Gradle (el chef de la construcción)
```

## 🌐 API Endpoints

### 🏪 Franquicias

#### 🆕 Crear Franquicia
```bash
curl -X POST http://localhost:8080/api/franchises \
     -H "Content-Type: application/json" \
     -d '{"name": "Mi Súper Franquicia"}'  
```

#### ✏️ Actualizar Nombre de Franquicia
```bash
curl -X PUT http://localhost:8080/api/franchises/1/name \
     -H "Content-Type: application/json" \
     -d '{"name": "Nuevo Nombre Súper Cool"}'
```

### 🏬 Sucursales

#### ➕ Agregar Sucursal a Franquicia
```bash
curl -X POST http://localhost:8080/api/branches/franchise/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Sucursal Centro (la mejor)"}'
```  

### 📦 Productos

#### ➕ Agregar Producto a Sucursal
```bash
curl -X POST http://localhost:8080/api/products/branch/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Producto Súper Genial", "stock": 100}'
```

#### 📈 Actualizar Stock de Producto
```bash
curl -X PUT http://localhost:8080/api/products/1/stock \
     -H "Content-Type: application/json" \
     -d '{"stock": 150}'
```

#### 🏆 Obtener Productos con Mayor Stock
```bash
curl -X GET http://localhost:8080/api/products/franchise/1/highest-stock
```

## 🚨 Solución de Problemas Comunes

### 🔌 Error de Conexión a la Base de Datos
Si aparece el error "Connection refused" al usar curl desde WSL:
- Usa la IP de Windows en lugar de localhost (porque a veces Windows es especial)
- Usa Postman o el cmd de Windows (si te rindes con WSL)

### 🔒 Error de Permisos en gradlew
En Linux/MacOS, si aparece "Permission denied" (porque la seguridad importa):
```bash
chmod +x gradlew
```

### ☕ Error de Java Home
Si aparece error de JAVA_HOME (porque Java es quisquilloso):
1. Instala Java 17 como un verdadero profesional:
```bash
# En Ubuntu/Debian
sudo apt install openjdk-17-jdk
```
2. Configura JAVA_HOME como un experto:
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64  
```

## 🌍 Variables de Entorno

La aplicación usa las siguientes variables de entorno que pueden ser configuradas (porque a veces el cambio es bueno):

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://us-east-1.63a4bee5-d0c1-4ab7-a511-d9de7eb71fd6.aws.yugabyte.cloud:5433/yugabyte?sslmode=verify-full
SPRING_DATASOURCE_USERNAME=admin
SPRING_DATASOURCE_PASSWORD=9Wev6TRsf4JAmYxcG3ZjJzhJKL07Wi  
```

## 🧪 Tests

Para ejecutar los tests (porque la calidad es importante):
```bash
./gradlew test  
```

## 🏗️ Construcción

Para construir el proyecto (como un arquitecto de software):
```bash
./gradlew build
```  

## 📜 Licencia

Este proyecto está bajo la Licencia MIT (porque compartir es amor).

¡Ahora ve y conquista el mundo de las franquicias con este asombroso sistema! 🌍🚀