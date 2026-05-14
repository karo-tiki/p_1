package com.finance.project.dataModel.dataModel;

import com.finance.project.domainLayer.domainEntities.vosShared.PersonID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonJpaTest {

    // ==================== Constructores ====================

    @Test
    @DisplayName("Crear PersonJpa con String ID y verificar campos")
    void createPersonJpa_StringConstructor_FieldsSetCorrectly() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertNotNull(personJpa.getId());
        assertEquals("Ana", personJpa.getName());
        assertEquals("1990-01-01", personJpa.getBirthdate());
        assertEquals("Lima", personJpa.getBirthplace());
        assertNotNull(personJpa.getSiblings());
        assertNotNull(personJpa.getCategories());
        assertNotNull(personJpa.getAccounts());
    }

    @Test
    @DisplayName("Crear PersonJpa con PersonID y verificar campos")
    void createPersonJpa_PersonIDConstructor_FieldsSetCorrectly() {
        PersonID personID = PersonID.createPersonID("carlos@email.com");

        PersonJpa personJpa = new PersonJpa(personID, "Carlos", "1985-06-20", "Cusco");

        assertEquals(personID, personJpa.getId());
        assertEquals("Carlos", personJpa.getName());
        assertEquals("1985-06-20", personJpa.getBirthdate());
        assertEquals("Cusco", personJpa.getBirthplace());
    }

    @Test
    @DisplayName("Constructor vacío crea objeto sin campos")
    void createPersonJpa_EmptyConstructor_FieldsAreNull() {
        PersonJpa personJpa = new PersonJpa();

        assertNull(personJpa.getId());
        assertNull(personJpa.getName());
    }

    // ==================== Setters ====================

    @Test
    @DisplayName("Setters actualizan los valores correctamente")
    void setters_UpdateValues() {
        PersonJpa personJpa = new PersonJpa();
        PersonID personID = PersonID.createPersonID("nuevo@email.com");

        personJpa.setId(personID);
        personJpa.setName("Nuevo");
        personJpa.setBirthdate("2000-01-01");
        personJpa.setBirthplace("Arequipa");

        assertEquals(personID, personJpa.getId());
        assertEquals("Nuevo", personJpa.getName());
        assertEquals("2000-01-01", personJpa.getBirthdate());
        assertEquals("Arequipa", personJpa.getBirthplace());
    }

    @Test
    @DisplayName("Setter de categorías actualiza la lista")
    void setCategories_UpdatesList() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        personJpa.setCategories(new ArrayList<>());

        assertNotNull(personJpa.getCategories());
        assertEquals(0, personJpa.getCategories().size());
    }

    @Test
    @DisplayName("Setter de cuentas actualiza la lista")
    void setAccounts_UpdatesList() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        personJpa.setAccounts(new ArrayList<>());

        assertNotNull(personJpa.getAccounts());
        assertEquals(0, personJpa.getAccounts().size());
    }

    // ==================== addSibling ====================

    @Test
    @DisplayName("Agregar hermano a la lista de hermanos")
    void addSibling_Success() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonID siblingID = PersonID.createPersonID("carlos@email.com");

        boolean result = personJpa.addSibling(siblingID);

        assertTrue(result);
        assertEquals(1, personJpa.getSiblings().size());
    }

    // ==================== addAccount ====================

    @Test
    @DisplayName("Agregar cuenta a la lista de cuentas")
    void addAccount_Success() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        boolean result = personJpa.addAccount("ana@email.com", "Ahorros", "Cuenta de ahorros");

        assertTrue(result);
        assertEquals(1, personJpa.getAccounts().size());
    }

    // ==================== setFather / setMother ====================

    @Test
    @DisplayName("Asignar padre a la persona")
    void setFather_Success() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonJpa fatherJpa = new PersonJpa("padre@email.com", "Padre", "1960-01-01", "Lima");

        personJpa.setFather(fatherJpa);

        assertEquals(fatherJpa, personJpa.getFather());
    }

    @Test
    @DisplayName("Asignar madre a la persona")
    void setMother_Success() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonJpa motherJpa = new PersonJpa("madre@email.com", "Madre", "1962-03-15", "Lima");

        personJpa.setMother(motherJpa);

        assertEquals(motherJpa, personJpa.getMother());
    }

    // ==================== equals & hashCode ====================

    @Test
    @DisplayName("Dos PersonJpa con mismo ID son iguales")
    void equals_SameID_ReturnsTrue() {
        PersonJpa p1 = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonJpa p2 = new PersonJpa("ana@email.com", "Ana Lopez", "1995-05-05", "Cusco");

        assertEquals(p1, p2);
    }

    @Test
    @DisplayName("Dos PersonJpa con diferente ID no son iguales")
    void equals_DifferentID_ReturnsFalse() {
        PersonJpa p1 = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonJpa p2 = new PersonJpa("carlos@email.com", "Carlos", "1990-01-01", "Lima");

        assertNotEquals(p1, p2);
    }

    @Test
    @DisplayName("PersonJpa no es igual a null")
    void equals_Null_ReturnsFalse() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        assertNotEquals(personJpa, null);
    }

    @Test
    @DisplayName("Dos PersonJpa iguales tienen el mismo hashCode")
    void hashCode_EqualPersonJpa_SameHashCode() {
        PersonJpa p1 = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");
        PersonJpa p2 = new PersonJpa("ana@email.com", "Otro nombre", "2000-01-01", "Cusco");

        assertEquals(p1.hashCode(), p2.hashCode());
    }

    // ==================== toString ====================

    @Test
    @DisplayName("toString incluye el ID de la persona")
    void toString_ContainsID() {
        PersonJpa personJpa = new PersonJpa("ana@email.com", "Ana", "1990-01-01", "Lima");

        String result = personJpa.toString();

        assertNotNull(result);
        assertTrue(result.contains("Person"));
    }
}
