package csaback.csabackend;

import csaback.csabackend.modele.Etudiant;
import csaback.csabackend.repository.EtudiantRepository;
import csaback.csabackend.service.etudiant.EtudiantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EtudiantServiceImplTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testLireEtudiants() {
        // Given
        List<Etudiant> etudiants = new ArrayList<>();


        when(etudiantRepository.findAll()).thenReturn(etudiants);

        // When
        List<Etudiant> retrievedEtudiants = etudiantService.lire();

        // Then
        assertNotNull(retrievedEtudiants);
        assertEquals(etudiants.size(), retrievedEtudiants.size());
        // Add more assertions based on your requirements

        verify(etudiantRepository, times(1)).findAll();
        verifyNoMoreInteractions(etudiantRepository);
    }


}
