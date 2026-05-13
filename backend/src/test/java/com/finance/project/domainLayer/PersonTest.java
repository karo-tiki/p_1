package com.finance.project.domainLayer.domainEntities.aggregates.person;

import com.finance.project.domainLayer.domainEntities.vosShared.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    // ==================== createPerson ====================

    @Test
    @DisplayName("Crear persona válida sin padres")
    void createPerson_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");

        assertNotNull(person);
        assertEquals("Ana", person.getName().getName());
        assertEquals("ana@email.com", person.getEmail().getEmail());
        assertEquals("Lima", person.getBirthplace().getBirthplace());
        assertEquals(LocalDate.of(1990, 1, 1), person.getBirthdate().getBirthdate());
    }

    @Test
    @DisplayName("Crear persona con email nulo lanza excepción")
    void createPerson_NullEmail_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson(null, "Ana", LocalDate.of(1990, 1, 1), "Lima")
        );
    }

    @Test
    @DisplayName("Crear persona con email vacío lanza excepción")
    void createPerson_EmptyEmail_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson("", "Ana", LocalDate.of(1990, 1, 1), "Lima")
        );
    }

    @Test
    @DisplayName("Crear persona con nombre nulo lanza excepción")
    void createPerson_NullName_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson("ana@email.com", null, LocalDate.of(1990, 1, 1), "Lima")
        );
    }

    @Test
    @DisplayName("Crear persona con nombre vacío lanza excepción")
    void createPerson_EmptyName_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson("ana@email.com", "", LocalDate.of(1990, 1, 1), "Lima")
        );
    }

    @Test
    @DisplayName("Crear persona con birthdate nulo lanza excepción")
    void createPerson_NullBirthdate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson("ana@email.com", "Ana", null, "Lima")
        );
    }

    @Test
    @DisplayName("Crear persona con birthplace nulo lanza excepción")
    void createPerson_NullBirthplace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), null)
        );
    }

    // ==================== addSibling ====================

    @Test
    @DisplayName("Agregar hermano exitosamente")
    void addSibling_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID siblingID = PersonID.createPersonID("carlos@email.com");

        boolean result = person.addSibling(siblingID);

        assertTrue(result);
        assertTrue(person.getListOfSiblings().contains(siblingID));
    }

    @Test
    @DisplayName("No agregar hermano duplicado")
    void addSibling_Duplicate_ReturnsFalse() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID siblingID = PersonID.createPersonID("carlos@email.com");

        person.addSibling(siblingID);
        boolean result = person.addSibling(siblingID);

        assertFalse(result);
        assertEquals(1, person.getListOfSiblings().size());
    }

    // ==================== addAccount ====================

    @Test
    @DisplayName("Agregar cuenta exitosamente")
    void addAccount_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        AccountID accountID = AccountID.createAccountID("Savings", personID);

        boolean result = person.addAccount(accountID);

        assertTrue(result);
        assertTrue(person.getListOfAccounts().contains(accountID));
    }

    @Test
    @DisplayName("No agregar cuenta duplicada")
    void addAccount_Duplicate_ReturnsFalse() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        AccountID accountID = AccountID.createAccountID("Savings", personID);

        person.addAccount(accountID);
        boolean result = person.addAccount(accountID);

        assertFalse(result);
    }

    // ==================== addCategory ====================

    @Test
    @DisplayName("Agregar categoría exitosamente")
    void addCategory_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        CategoryID categoryID = CategoryID.createCategoryID("Food", personID);

        boolean result = person.addCategory(categoryID);

        assertTrue(result);
        assertTrue(person.getListOfCategories().contains(categoryID));
    }

    // ==================== equals & hashCode ====================

    @Test
    @DisplayName("Dos personas con mismo email son iguales")
    void equals_SameEmail_ReturnsTrue() {
        Person p1 = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        Person p2 = Person.createPerson("ana@email.com", "Ana Lopez", LocalDate.of(1995, 5, 5), "Arequipa");

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    @DisplayName("Dos personas con distinto email no son iguales")
    void equals_DifferentEmail_ReturnsFalse() {
        Person p1 = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        Person p2 = Person.createPerson("carlos@email.com", "Carlos", LocalDate.of(1990, 1, 1), "Lima");

        assertNotEquals(p1, p2);
    }

    @Test
    @DisplayName("Persona no es igual a null")
    void equals_Null_ReturnsFalse() {
        Person p1 = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");

        assertNotEquals(p1, null);
    }

    // ==================== addMother / addFather ====================

    @Test
    @DisplayName("Agregar madre exitosamente")
    void addMother_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID motherID = PersonID.createPersonID("madre@email.com");

        boolean result = person.addMother(motherID);

        assertTrue(result);
        assertEquals(motherID, person.getMother());
    }

    @Test
    @DisplayName("No se puede agregar madre si ya existe")
    void addMother_AlreadyExists_ReturnsFalse() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID motherID = PersonID.createPersonID("madre@email.com");

        person.addMother(motherID);
        boolean result = person.addMother(PersonID.createPersonID("otra@email.com"));

        assertFalse(result);
    }

    @Test
    @DisplayName("Agregar padre exitosamente")
    void addFather_Success() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID fatherID = PersonID.createPersonID("padre@email.com");

        boolean result = person.addFather(fatherID);

        assertTrue(result);
        assertEquals(fatherID, person.getFather());
    }

    // ==================== checkIfPersonHasAccount ====================

    @Test
    @DisplayName("Verificar si persona tiene cuenta existente")
    void checkIfPersonHasAccount_Exists_ReturnsTrue() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        AccountID accountID = AccountID.createAccountID("Savings", personID);

        person.addAccount(accountID);

        assertTrue(person.checkIfPersonHasAccount(accountID));
    }

    @Test
    @DisplayName("Verificar si persona no tiene cuenta inexistente")
    void checkIfPersonHasAccount_NotExists_ReturnsFalse() {
        Person person = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        AccountID accountID = AccountID.createAccountID("Savings", personID);

        assertFalse(person.checkIfPersonHasAccount(accountID));
    }
}
