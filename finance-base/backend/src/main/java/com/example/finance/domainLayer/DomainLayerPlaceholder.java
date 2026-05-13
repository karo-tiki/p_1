package com.example.finance.domainLayer;

/**
 * ============================================================
 *  DOMAIN LAYER — DDD + Clean Architecture
 * ============================================================
 *
 *  Aquí van las clases del dominio. Estructura sugerida:
 *
 *  domainLayer/
 *  ├── model/
 *  │   ├── person/
 *  │   │   ├── Person.java          ← Aggregate Root (Entity)
 *  │   │   ├── PersonID.java        ← Value Object
 *  │   │   └── ...
 *  │   ├── group/
 *  │   │   ├── Group.java
 *  │   │   ├── GroupID.java
 *  │   │   └── ...
 *  │   ├── account/
 *  │   │   ├── Account.java
 *  │   │   ├── AccountID.java
 *  │   │   └── ...
 *  │   ├── transaction/
 *  │   │   ├── Transaction.java
 *  │   │   └── ...
 *  │   ├── category/
 *  │   │   ├── Category.java
 *  │   │   └── ...
 *  │   └── ledger/
 *  │       ├── Ledger.java
 *  │       └── ...
 *  └── repositories/               ← Interfaces (contratos)
 *      ├── IPersonRepository.java
 *      ├── IGroupRepository.java
 *      └── ...
 *
 *  REGLAS DDD:
 *  - Las Entities tienen identidad (ID propio).
 *  - Los Value Objects son inmutables y sin identidad.
 *  - Un Aggregate Root controla el acceso a su agregado.
 *  - Los Repositories son interfaces aquí; la implementación va en infrastructureLayer.
 */
public class DomainLayerPlaceholder {
    // Este archivo es solo orientativo. Elimínalo cuando crees tus clases.
}
