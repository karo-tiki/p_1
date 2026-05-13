package com.example.finance.domainLayer;

/**
 * ============================================================
 *  TEST LAYER — xUnit + Mockito + JaCoCo
 * ============================================================
 *
 *  SEPARACIÓN REQUERIDA:
 *
 *  src/
 *  ├── main/java/com/example/finance/    ← código de producción
 *  └── test/java/com/example/finance/    ← código de pruebas (AQUÍ)
 *
 *  Estructura de tests sugerida (espejo del main):
 *
 *  test/
 *  ├── domainLayer/
 *  │   ├── PersonTest.java
 *  │   ├── GroupTest.java
 *  │   └── ...
 *  ├── applicationLayer/
 *  │   ├── PersonServiceTest.java        ← usa Mockito para mockear repos
 *  │   └── ...
 *  ├── controllerLayer/
 *  │   ├── PersonControllerTest.java     ← puede usar MockMvc
 *  │   └── ...
 *  └── infrastructureLayer/
 *      └── PersonRepositoryImplTest.java
 *
 *  TAREAS PENDIENTES (pom.xml):
 *
 *  TODO 1 — Importar JUnit 5 (xUnit):
 *      <dependency>
 *          <groupId>org.junit.jupiter</groupId>
 *          <artifactId>junit-jupiter-api</artifactId>
 *          <version>5.5.2</version>
 *          <scope>test</scope>
 *      </dependency>
 *      <dependency>
 *          <groupId>org.junit.jupiter</groupId>
 *          <artifactId>junit-jupiter-engine</artifactId>
 *          <version>5.5.2</version>
 *          <scope>test</scope>
 *      </dependency>
 *
 *  TODO 2 — Importar JaCoCo (Code Coverage):
 *      <plugin>
 *          <groupId>org.jacoco</groupId>
 *          <artifactId>jacoco-maven-plugin</artifactId>
 *          <version>0.8.5</version>
 *          <executions>
 *              <execution><id>prepare-agent</id><goals><goal>prepare-agent</goal></goals></execution>
 *              <execution><id>report</id><goals><goal>report</goal></goals></execution>
 *          </executions>
 *      </plugin>
 *
 *  TODO 3 — Importar Mockito (Mocking):
 *      <dependency>
 *          <groupId>org.mockito</groupId>
 *          <artifactId>mockito-core</artifactId>
 *          <version>3.3.3</version>
 *          <scope>test</scope>
 *      </dependency>
 *
 *  TODO 4 — Agregar spring-boot-starter-test:
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-test</artifactId>
 *          <scope>test</scope>
 *      </dependency>
 */
public class TestLayerPlaceholder {
    // Este archivo es solo orientativo. Colócalo en src/TEST (no en src/main).
    // Elimínalo cuando empieces a escribir tus tests reales.
}
