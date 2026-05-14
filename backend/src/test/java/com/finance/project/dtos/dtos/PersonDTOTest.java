package com.finance.project.dtos.dtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDTOTest {

    // ==================== Constructor completo ====================

    @Test
    @DisplayName("Crear PersonDTO con todos los campos")
    void createPersonDTO_FullConstructor_GettersReturnCorrectValues() {
        PersonDTO dto = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima", "padre@email.com", "madre@email.com");

        assertEquals("ana@email.com", dto.getEmail());
        assertEquals("Ana", dto.getName());
        assertEquals("1990-01-01", dto.getBirthdate());
        assertEquals("Lima", dto.getBirthplace());
        assertEquals("padre@email.com", dto.getFather());
        assertEquals("madre@email.com", dto.getMother());
        assertEquals("", dto.getLedger());
    }

    @Test
    @DisplayName("Crear PersonDTO sin padre ni madre")
    void createPersonDTO_WithoutParents_GettersReturnCorrectValues() {
        PersonDTO dto = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertEquals("ana@email.com", dto.getEmail());
        assertEquals("Ana", dto.getName());
        assertEquals("1990-01-01", dto.getBirthdate());
        assertEquals("Lima", dto.getBirthplace());
        assertNull(dto.getFather());
        assertNull(dto.getMother());
    }

    @Test
    @DisplayName("Crear PersonDTO con ledger explícito")
    void createPersonDTO_WithLedger_GetterReturnsLedger() {
        PersonDTO dto = new PersonDTO("ana@email.com", "ledger-id-123", "Ana", "1990-01-01", "Lima", "padre@email.com", "madre@email.com");

        assertEquals("ledger-id-123", dto.getLedger());
    }

    @Test
    @DisplayName("Crear PersonDTO vacío")
    void createPersonDTO_EmptyConstructor_GettersReturnNull() {
        PersonDTO dto = new PersonDTO();

        assertNull(dto.getEmail());
        assertNull(dto.getName());
    }

    // ==================== Setters ====================

    @Test
    @DisplayName("Setters actualizan los valores correctamente")
    void setters_UpdateValues() {
        PersonDTO dto = new PersonDTO();

        dto.setEmail("nuevo@email.com");
        dto.setName("Nuevo Nombre");
        dto.setBirthdate("2000-06-15");
        dto.setBirthplace("Cusco");
        dto.setFather("padre@email.com");
        dto.setMother("madre@email.com");
        dto.setLedger("ledger-abc");

        assertEquals("nuevo@email.com", dto.getEmail());
        assertEquals("Nuevo Nombre", dto.getName());
        assertEquals("2000-06-15", dto.getBirthdate());
        assertEquals("Cusco", dto.getBirthplace());
        assertEquals("padre@email.com", dto.getFather());
        assertEquals("madre@email.com", dto.getMother());
        assertEquals("ledger-abc", dto.getLedger());
    }

    // ==================== equals ====================

    @Test
    @DisplayName("Dos PersonDTOs con mismos datos son iguales")
    void equals_SameData_ReturnsTrue() {
        PersonDTO dto1 = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima", "padre@email.com", "madre@email.com");
        PersonDTO dto2 = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima", "padre@email.com", "madre@email.com");

        assertEquals(dto1, dto2);
    }

    @Test
    @DisplayName("Dos PersonDTOs con diferente email no son iguales")
    void equals_DifferentEmail_ReturnsFalse() {
        PersonDTO dto1 = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonDTO dto2 = new PersonDTO("carlos@email.com", "Carlos", "1990-01-01", "Lima");

        assertNotEquals(dto1, dto2);
    }

    @Test
    @DisplayName("PersonDTO no es igual a null")
    void equals_Null_ReturnsFalse() {
        PersonDTO dto = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertNotEquals(dto, null);
    }

    @Test
    @DisplayName("PersonDTO es igual a sí mismo")
    void equals_SameInstance_ReturnsTrue() {
        PersonDTO dto = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertEquals(dto, dto);
    }

    // ==================== hashCode ====================

    @Test
    @DisplayName("Dos PersonDTOs iguales tienen el mismo hashCode")
    void hashCode_EqualDTOs_SameHashCode() {
        PersonDTO dto1 = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonDTO dto2 = new PersonDTO("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
