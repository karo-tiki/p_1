package com.finance.project.dtos.dtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreatePersonDTOTest {

    // ==================== Constructor y Getters ====================

    @Test
    @DisplayName("Crear DTO con datos válidos y verificar getters")
    void createPersonDTO_Success_GettersReturnCorrectValues() {
        LocalDate birthdate = LocalDate.of(1990, 5, 15);

        CreatePersonDTO dto = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");

        assertEquals("ana@email.com", dto.getEmail());
        assertEquals("Ana", dto.getName());
        assertEquals(birthdate, dto.getBirthdate());
        assertEquals("Lima", dto.getBirthplace());
    }

    @Test
    @DisplayName("Crear DTO con email nulo")
    void createPersonDTO_NullEmail_GetterReturnsNull() {
        CreatePersonDTO dto = new CreatePersonDTO(null, "Ana", LocalDate.of(1990, 1, 1), "Lima");

        assertNull(dto.getEmail());
    }

    @Test
    @DisplayName("Crear DTO con nombre nulo")
    void createPersonDTO_NullName_GetterReturnsNull() {
        CreatePersonDTO dto = new CreatePersonDTO("ana@email.com", null, LocalDate.of(1990, 1, 1), "Lima");

        assertNull(dto.getName());
    }

    // ==================== equals ====================

    @Test
    @DisplayName("Dos DTOs con mismos datos son iguales")
    void equals_SameData_ReturnsTrue() {
        LocalDate birthdate = LocalDate.of(1990, 5, 15);
        CreatePersonDTO dto1 = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");
        CreatePersonDTO dto2 = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");

        assertEquals(dto1, dto2);
    }

    @Test
    @DisplayName("Dos DTOs con diferente email no son iguales")
    void equals_DifferentEmail_ReturnsFalse() {
        LocalDate birthdate = LocalDate.of(1990, 5, 15);
        CreatePersonDTO dto1 = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");
        CreatePersonDTO dto2 = new CreatePersonDTO("carlos@email.com", "Ana", birthdate, "Lima");

        assertNotEquals(dto1, dto2);
    }

    @Test
    @DisplayName("DTO no es igual a null")
    void equals_Null_ReturnsFalse() {
        CreatePersonDTO dto = new CreatePersonDTO("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");

        assertNotEquals(dto, null);
    }

    @Test
    @DisplayName("DTO es igual a sí mismo")
    void equals_SameInstance_ReturnsTrue() {
        CreatePersonDTO dto = new CreatePersonDTO("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");

        assertEquals(dto, dto);
    }

    // ==================== hashCode ====================

    @Test
    @DisplayName("Dos DTOs iguales tienen el mismo hashCode")
    void hashCode_EqualDTOs_SameHashCode() {
        LocalDate birthdate = LocalDate.of(1990, 5, 15);
        CreatePersonDTO dto1 = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");
        CreatePersonDTO dto2 = new CreatePersonDTO("ana@email.com", "Ana", birthdate, "Lima");

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
