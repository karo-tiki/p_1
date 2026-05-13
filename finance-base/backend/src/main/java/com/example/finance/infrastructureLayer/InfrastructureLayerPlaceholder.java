package com.example.finance.infrastructureLayer;

/**
 * ============================================================
 *  INFRASTRUCTURE LAYER — DDD + Clean Architecture
 * ============================================================
 *
 *  Aquí van las implementaciones de persistencia.
 *  Implementa las interfaces de repositorio definidas en el domainLayer.
 *
 *  infrastructureLayer/
 *  ├── repositories/
 *  │   ├── PersonRepositoryImpl.java    ← Implementa IPersonRepository
 *  │   ├── GroupRepositoryImpl.java
 *  │   └── ...
 *  ├── dataModel/                       ← Copia del dominio para JPA (@Entity)
 *  │   ├── PersonJPA.java
 *  │   ├── GroupJPA.java
 *  │   └── ...
 *  ├── dataAssembler/                   ← Transforma Domain ↔ JPA
 *  │   ├── PersonDataAssembler.java
 *  │   └── ...
 *  └── jpaRepositories/                ← Interfaces JPA (Spring Data)
 *      ├── IPersonJPARepository.java   ← extends JpaRepository<PersonJPA, ...>
 *      └── ...
 *
 *  REGLAS:
 *  - Las clases @Entity van aquí (NO en el domainLayer).
 *  - El domainLayer nunca importa clases de este paquete.
 *  - Usar DataAssemblers para convertir entre Domain Model y Data Model.
 */
public class InfrastructureLayerPlaceholder {
    // Este archivo es solo orientativo. Elimínalo cuando crees tus clases.
}
