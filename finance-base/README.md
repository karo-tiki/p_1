# 📁 Base del Proyecto — Personal Finance Management
## DDD + Clean Architecture + xUnit + Mockito + JaCoCo

---

## 🎯 Objetivo

Este es el **esqueleto vacío** del proyecto. Tu tarea es implementar todo lo listado abajo
siguiendo las prácticas de **DDD (Domain-Driven Design) + Clean Architecture**.

---

## 📂 Estructura del proyecto

```
finance-base/
├── pom.xml                                  ← Gestión de dependencias (Maven)
├── backend/
│   └── src/
│       ├── main/
│       │   ├── java/com/example/finance/
│       │   │   ├── domainLayer/             ← Entidades, VOs, Aggregates, interfaces Repos
│       │   │   ├── applicationLayer/        ← Services + DTOs + Assemblers
│       │   │   ├── controllerLayer/         ← REST Controllers
│       │   │   └── infrastructureLayer/     ← JPA Repos, DataModel, DataAssemblers
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│           └── java/com/example/finance/    ← AQUÍ van tus tests (espejo del main)
└── src/                                     ← Frontend (React)
```

---

## ✅ Lista de tareas (lo que debes implementar tú)

### 1. xUnit Framework — JUnit 5
- [ ] Agregar dependencias `junit-jupiter-api` y `junit-jupiter-engine` en `pom.xml`
- [ ] Agregar `maven-surefire-plugin` para ejecutar los tests
- [ ] Crear tests en `src/test/java/...` para cada capa

### 2. Code Coverage — JaCoCo
- [ ] Agregar el plugin `jacoco-maven-plugin` en `pom.xml`
- [ ] Configurar los goals `prepare-agent` y `report`
- [ ] Ejecutar `mvn test` y revisar el reporte en `target/site/jacoco/`

### 3. Mocking Framework — Mockito
- [ ] Agregar dependencia `mockito-core` en `pom.xml`
- [ ] Usar `@Mock` y `@InjectMocks` en los tests de servicios
- [ ] Mockear las interfaces de repositorio en los tests de la capa de aplicación

### 4. Spring Boot Test
- [ ] Agregar `spring-boot-starter-test` con `scope=test`

### 5. Implementar el código de producción (DDD + Clean Architecture)
- [ ] **domainLayer**: Person, Group, Account, Category, Transaction, Ledger (Entities + VOs)
- [ ] **domainLayer**: Interfaces de repositorios (IPersonRepository, etc.)
- [ ] **applicationLayer**: Services + DTOs + DTOAssemblers
- [ ] **controllerLayer**: REST Controllers
- [ ] **infrastructureLayer**: JPA Entities (dataModel), DataAssemblers, JpaRepository implementations

---

## 🏗️ Reglas de arquitectura DDD a respetar

| Capa | Puede importar |
|------|---------------|
| `domainLayer` | Nada externo (solo Java puro) |
| `applicationLayer` | `domainLayer` |
| `controllerLayer` | `applicationLayer` (interfaces) |
| `infrastructureLayer` | `domainLayer`, Spring Data JPA |

- Las clases `@Entity` van **solo** en `infrastructureLayer/dataModel/`
- El `domainLayer` NO conoce JPA ni Spring
- Los `Controllers` NO acceden a repositorios directamente

---

## 🚀 Cómo correr el proyecto (cuando esté completo)

```bash
# Backend (Java/Spring Boot)
mvn spring-boot:run
# Acceder a: http://localhost:8080/h2-console

# Frontend (React)
npm install
npm start
# Acceder a: http://localhost:3000
```

---

## 📌 Recuerda

> Los archivos `*Placeholder.java` son guías orientativas. **Elimínalos** conforme vayas creando las clases reales.
