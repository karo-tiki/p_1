package com.example.finance.controllerLayer;

/**
 * ============================================================
 *  CONTROLLER LAYER — DDD + Clean Architecture
 * ============================================================
 *
 *  Aquí van los REST Controllers (@RestController).
 *  Solo reciben peticiones HTTP y delegan al applicationLayer.
 *
 *  controllerLayer/
 *  ├── PersonController.java
 *  ├── GroupController.java
 *  ├── AccountController.java
 *  ├── TransactionController.java
 *  └── CategoryController.java
 *
 *  REGLAS:
 *  - Inyectar servicios mediante su interfaz (IPersonService, etc.).
 *  - No acceder directamente a repositorios ni al dominio.
 *  - Retornar ResponseEntity<> con los DTOs correspondientes.
 *
 *  Ejemplo básico:
 *
 *  @RestController
 *  @RequestMapping("/persons")
 *  public class PersonController {
 *
 *      private final IPersonService personService;
 *
 *      public PersonController(IPersonService personService) {
 *          this.personService = personService;
 *      }
 *
 *      @PostMapping("/{email}/accounts")
 *      public ResponseEntity<Object> createAccount(
 *              @RequestBody NewAccountInfoDTO info,
 *              @PathVariable String email) {
 *          PersonDTO result = personService.createAccount(...);
 *          return ResponseEntity.ok(result);
 *      }
 *  }
 */
public class ControllerLayerPlaceholder {
    // Este archivo es solo orientativo. Elimínalo cuando crees tus clases.
}
