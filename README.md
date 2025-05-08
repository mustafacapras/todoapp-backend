# ToDo App Backend

## 🇬🇧 English
A Spring Boot backend application for the ToDo App with the following features:
- User authentication with JWT
- Task management (CRUD operations)
- Category management
- PostgreSQL database integration
- Docker support

### Prerequisites
- Java 17
- Maven
- PostgreSQL
- Docker (optional)

### Environment Variables
```
JDBC_DATABASE_URL=your-postgres-connection-url
JDBC_DATABASE_USERNAME=your-postgres-username
JDBC_DATABASE_PASSWORD=your-postgres-password
JWT_SECRET=your-jwt-secret
CORS_ALLOWED_ORIGINS=your-frontend-url
```

### Running Locally
```bash
mvn spring-boot:run
```

### Building Docker Image
```bash
docker build -t todoapp-backend .
docker run -p 8080:8080 todoapp-backend
```

## 🇹🇷 Turkish
ToDo Uygulaması için Spring Boot backend uygulaması aşağıdaki özelliklere sahiptir:
- JWT ile kullanıcı kimlik doğrulama
- Görev yönetimi (CRUD işlemleri)
- Kategori yönetimi
- PostgreSQL veritabanı entegrasyonu
- Docker desteği

### Gereksinimler
- Java 17
- Maven
- PostgreSQL
- Docker (isteğe bağlı)

### Ortam Değişkenleri
```
JDBC_DATABASE_URL=postgres-baglanti-url'niz
JDBC_DATABASE_USERNAME=postgres-kullanici-adiniz
JDBC_DATABASE_PASSWORD=postgres-sifreniz
JWT_SECRET=jwt-gizli-anahtariniz
CORS_ALLOWED_ORIGINS=frontend-url'niz
```

### Yerel Olarak Çalıştırma
```bash
mvn spring-boot:run
```

### Docker Image Oluşturma
```bash
docker build -t todoapp-backend .
docker run -p 8080:8080 todoapp-backend
``` 