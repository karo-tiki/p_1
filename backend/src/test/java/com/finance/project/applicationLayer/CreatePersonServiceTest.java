package com.finance.project.applicationLayer.applicationServices.personServices;

import com.finance.project.domainLayer.domainEntities.aggregates.person.Person;
import com.finance.project.domainLayer.domainEntities.vosShared.*;
import com.finance.project.domainLayer.exceptions.InvalidArgumentsBusinessException;
import com.finance.project.domainLayer.exceptions.NotFoundArgumentsBusinessException;
import com.finance.project.domainLayer.repositoriesInterfaces.*;
import com.finance.project.dtos.dtos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreatePersonServiceTest {

    @Mock
    private IPersonRepository personRepository;

    @Mock
    private ILedgerRepository ledgerRepository;

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private IAccountRepository accountRepository;

    @InjectMocks
    private CreatePersonService createPersonService;

    private CreatePersonDTO createPersonDTO;
    private Person mockPerson;

    @BeforeEach
    void setUp() {
        createPersonDTO = new CreatePersonDTO("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
        mockPerson = Person.createPerson("ana@email.com", "Ana", LocalDate.of(1990, 1, 1), "Lima");
    }

    // ==================== createPerson ====================

    @Test
    @DisplayName("Crear persona exitosamente cuando no existe")
    void createPerson_Success() {
        // Arrange
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.empty());
        when(personRepository.save(any(Person.class))).thenReturn(mockPerson);

        // Act
        PersonDTO result = createPersonService.createPerson(createPersonDTO);

        // Assert
        assertNotNull(result);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    @DisplayName("Lanza excepción si persona ya existe")
    void createPerson_AlreadyExists_ThrowsException() {
        // Arrange
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));

        // Act & Assert
        assertThrows(InvalidArgumentsBusinessException.class, () ->
                createPersonService.createPerson(createPersonDTO)
        );
        verify(personRepository, never()).save(any(Person.class));
    }

    // ==================== getPersonByEmail ====================

    @Test
    @DisplayName("Obtener persona por email exitosamente")
    void getPersonByEmail_Success() {
        // Arrange
        PersonEmailDTO emailDTO = new PersonEmailDTO("ana@email.com");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));

        // Act
        PersonDTO result = createPersonService.getPersonByEmail(emailDTO);

        // Assert
        assertNotNull(result);
        verify(personRepository, times(1)).findById(any(PersonID.class));
    }

    @Test
    @DisplayName("Lanza excepción si persona no existe al buscar por email")
    void getPersonByEmail_NotFound_ThrowsException() {
        // Arrange
        PersonEmailDTO emailDTO = new PersonEmailDTO("noexiste@email.com");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundArgumentsBusinessException.class, () ->
                createPersonService.getPersonByEmail(emailDTO)
        );
    }

    // ==================== addCategoryToPerson ====================

    @Test
    @DisplayName("Agregar categoría a persona exitosamente")
    void addCategoryToPerson_Success() {
        // Arrange
        CreatePersonCategoryDTO categoryDTO = new CreatePersonCategoryDTO("ana@email.com", "Food");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));
        when(categoryRepository.findById(anyString(), anyString())).thenReturn(Optional.empty());
        when(personRepository.addAndSaveCategory(any(Person.class))).thenReturn(true);

        // Act
        boolean result = createPersonService.addCategoryToPerson(categoryDTO);

        // Assert
        assertTrue(result);
        verify(personRepository, times(1)).addAndSaveCategory(any(Person.class));
    }

    @Test
    @DisplayName("Lanza excepción al agregar categoría si persona no existe")
    void addCategoryToPerson_PersonNotFound_ThrowsException() {
        // Arrange
        CreatePersonCategoryDTO categoryDTO = new CreatePersonCategoryDTO("noexiste@email.com", "Food");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundArgumentsBusinessException.class, () ->
                createPersonService.addCategoryToPerson(categoryDTO)
        );
        verify(personRepository, never()).addAndSaveCategory(any(Person.class));
    }

    @Test
    @DisplayName("Lanza excepción al agregar categoría duplicada")
    void addCategoryToPerson_CategoryAlreadyExists_ThrowsException() {
        // Arrange
        CreatePersonCategoryDTO categoryDTO = new CreatePersonCategoryDTO("ana@email.com", "Food");
        PersonID personID = PersonID.createPersonID("ana@email.com");
        CategoryID existingCategory = CategoryID.createCategoryID("Food", personID);

        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));
        when(categoryRepository.findById(anyString(), anyString()))
                .thenReturn(Optional.of(mock(com.finance.project.domainLayer.domainEntities.aggregates.category.Category.class)));

        // Act & Assert
        assertThrows(NotFoundArgumentsBusinessException.class, () ->
                createPersonService.addCategoryToPerson(categoryDTO)
        );
    }

    // ==================== addAccountToPerson ====================

    @Test
    @DisplayName("Agregar cuenta a persona exitosamente")
    void addAccountToPerson_Success() {
        // Arrange
        CreatePersonAccountDTO accountDTO = new CreatePersonAccountDTO("ana@email.com", "Savings", "My savings account");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));
        when(accountRepository.findById(anyString(), anyString())).thenReturn(Optional.empty());
        when(personRepository.addAndSaveAccount(any(Person.class), anyString())).thenReturn(true);

        // Act
        boolean result = createPersonService.addAccountToPerson(accountDTO);

        // Assert
        assertTrue(result);
        verify(personRepository, times(1)).addAndSaveAccount(any(Person.class), anyString());
    }

    @Test
    @DisplayName("Lanza excepción al agregar cuenta si persona no existe")
    void addAccountToPerson_PersonNotFound_ThrowsException() {
        // Arrange
        CreatePersonAccountDTO accountDTO = new CreatePersonAccountDTO("noexiste@email.com", "Savings", "desc");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundArgumentsBusinessException.class, () ->
                createPersonService.addAccountToPerson(accountDTO)
        );
    }

    @Test
    @DisplayName("Lanza excepción al agregar cuenta duplicada")
    void addAccountToPerson_AccountAlreadyExists_ThrowsException() {
        // Arrange
        CreatePersonAccountDTO accountDTO = new CreatePersonAccountDTO("ana@email.com", "Savings", "desc");
        when(personRepository.findById(any(PersonID.class))).thenReturn(Optional.of(mockPerson));
        when(accountRepository.findById(anyString(), anyString()))
                .thenReturn(Optional.of(mock(com.finance.project.domainLayer.domainEntities.aggregates.account.Account.class)));

        // Act & Assert
        assertThrows(NotFoundArgumentsBusinessException.class, () ->
                createPersonService.addAccountToPerson(accountDTO)
        );
    }

    // ==================== constantes ====================

    @Test
    @DisplayName("Verificar constantes del servicio")
    void constants_AreCorrect() {
        assertEquals("Account created and added", CreatePersonService.SUCCESS);
        assertEquals("Person does not exist", CreatePersonService.PERSON_DOES_NOT_EXIST);
        assertEquals("Person already exists", CreatePersonService.PERSON_ALREADY_EXIST);
        assertEquals("Category already exists", CreatePersonService.CATEGORY_ALREADY_EXIST);
        assertEquals("Account already exists", CreatePersonService.ACCOUNT_ALREADY_EXIST);
    }
}
