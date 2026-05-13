package com.example.finance.applicationLayer;

/**
 * ============================================================
 *  APPLICATION LAYER — DDD + Clean Architecture
 * ============================================================
 *
 *  Aquí van los Services que coordinan los casos de uso.
 *  NO contienen lógica de negocio; solo orquestan el dominio.
 *
 *  applicationLayer/
 *  ├── PersonService.java           ← Implementa IPersonService
 *  ├── IPersonService.java          ← Interfaz del servicio
 *  ├── GroupService.java
 *  ├── IGroupService.java
 *  ├── AccountService.java
 *  ├── IAccountService.java
 *  ├── TransactionService.java
 *  ├── ITransactionService.java
 *  └── utils/
 *      ├── PersonDTO.java           ← Data Transfer Objects
 *      ├── GroupDTO.java
 *      ├── CreatePersonAccountDTO.java
 *      ├── PersonDTOAssembler.java  ← Ensamblan DTO ↔ Dominio
 *      └── ...
 *
 *  REGLAS:
 *  - Los servicios solo dependen de interfaces de repositorios (del domainLayer).
 *  - Se comunican con el controlador mediante DTOs (nunca exponen clases del dominio).
 */
public class ApplicationLayerPlaceholder {
    // Este archivo es solo orientativo. Elimínalo cuando crees tus clases.
}
