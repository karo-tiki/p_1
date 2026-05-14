package com.finance.project.dtos.dtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateGroupDTOTest {

    // ==================== Constructor y Getters ====================

    @Test
    @DisplayName("Crear GroupDTO con datos válidos y verificar getters")
    void createGroupDTO_Success_GettersReturnCorrectValues() {
        CreateGroupDTO dto = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");

        assertEquals("admin@email.com", dto.getEmail());
        assertEquals("Familia", dto.getDenomination());
        assertEquals("Grupo familiar", dto.getDescription());
    }

    @Test
    @DisplayName("Crear GroupDTO con persona a cargo")
    void createGroupDTO_WithPersonInCharge_GettersReturnCorrectValues() {
        CreateGroupDTO dto = new CreateGroupDTO("admin@email.com", "Trabajo", "admin@email.com", "Grupo laboral");

        assertEquals("admin@email.com", dto.getEmail());
        assertEquals("Trabajo", dto.getDenomination());
        assertEquals("admin@email.com", dto.getPersonInCharge());
        assertNotNull(dto.getDateOfCreation());
        assertNotNull(dto.getLedgerID());
    }

    @Test
    @DisplayName("Fecha de creación se puede actualizar con setter")
    void setDateOfCreation_UpdatesValue() {
        CreateGroupDTO dto = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");

        dto.setDateOfCreation("2024-01-01");

        assertEquals("2024-01-01", dto.getDateOfCreation());
    }

    // ==================== equals ====================

    @Test
    @DisplayName("Dos GroupDTOs con mismos datos son iguales")
    void equals_SameData_ReturnsTrue() {
        CreateGroupDTO dto1 = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");
        CreateGroupDTO dto2 = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");

        assertEquals(dto1, dto2);
    }

    @Test
    @DisplayName("Dos GroupDTOs con diferente denominación no son iguales")
    void equals_DifferentDenomination_ReturnsFalse() {
        CreateGroupDTO dto1 = new CreateGroupDTO("admin@email.com", "Familia", "desc");
        CreateGroupDTO dto2 = new CreateGroupDTO("admin@email.com", "Trabajo", "desc");

        assertNotEquals(dto1, dto2);
    }

    @Test
    @DisplayName("GroupDTO no es igual a null")
    void equals_Null_ReturnsFalse() {
        CreateGroupDTO dto = new CreateGroupDTO("admin@email.com", "Familia", "desc");

        assertNotEquals(dto, null);
    }

    @Test
    @DisplayName("GroupDTO es igual a sí mismo")
    void equals_SameInstance_ReturnsTrue() {
        CreateGroupDTO dto = new CreateGroupDTO("admin@email.com", "Familia", "desc");

        assertEquals(dto, dto);
    }

    // ==================== hashCode ====================

    @Test
    @DisplayName("Dos GroupDTOs iguales tienen el mismo hashCode")
    void hashCode_EqualDTOs_SameHashCode() {
        CreateGroupDTO dto1 = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");
        CreateGroupDTO dto2 = new CreateGroupDTO("admin@email.com", "Familia", "Grupo familiar");

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
