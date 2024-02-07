package csaback.csabackend.service.etudiant;

import csaback.csabackend.modele.Etudiant;
import csaback.csabackend.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EtudiantServiceImplTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Test
    void creer() {
        // Préparation des données de test
        Etudiant etudiant = new Etudiant();
        etudiant.setNoEtudiantNat("1234567890");
        etudiant.setAnneePro("2024");
        etudiant.setCodeCom("VotreCodeCom");
        etudiant.setNoEtudiantUbo("VotreNumeroUbo");
        etudiant.setSexe("M"); // ou "F" selon le sexe
        etudiant.setNom("NomEtudiant");
        etudiant.setPrenom("PrenomEtudiant");
        etudiant.setDateNaissance(Instant.now()); // Remplacer par la date de naissance appropriée
        etudiant.setLieuNaissance("Lieu de naissance");
        etudiant.setSituation("Situation");
        etudiant.setNationalite("Nationalité");
        etudiant.setTelPort("Numéro de téléphone portable");
        etudiant.setTelFixe("Numéro de téléphone fixe");
        etudiant.setEmail("Adresse email");
        etudiant.setActuAdresse("Adresse actuelle");
        etudiant.setActuCp("Code postal actuel");
        etudiant.setActuVille("Ville actuelle");
        etudiant.setActuPays("Pays actuel");
        etudiant.setPermAdresse("Adresse permanente");
        etudiant.setPermCp("Code postal permanent");
        etudiant.setPermVille("Ville permanente");
        etudiant.setPermPays("Pays permanent");
        etudiant.setDernierDiplome("Dernier diplôme");
        etudiant.setUniversite("Université");
        etudiant.setSigleEtu("Sig");
        etudiant.setCompteCri("Compte CRI");
        etudiant.setUboEmail("Email UBO");
        etudiant.setGrpeAnglais((byte) 1);
        etudiant.setAbandonMotif("Motif d'abandon");
        etudiant.setAbandonDate(Instant.now());
        etudiant.setEstDiplome('O');

        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);

        // Appeler la méthode à tester
        Etudiant resultat = etudiantService.creer(etudiant);


        // Vérifier si l'étudiant retourné est celui que nous avons sauvegardé
        assertEquals(etudiant, resultat);
    }


    @Test
    void lire() {
        // Données de test
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNom("Nom1");
        // Initialisez les autres propriétés selon vos besoins

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNom("Nom2");
        // Initialisez les autres propriétés selon vos besoins

        List<Etudiant> etudiants = Arrays.asList(etudiant1, etudiant2);

        // Configuration du comportement du mock repository
        when(etudiantRepository.findAll()).thenReturn(etudiants);

        // Appel de la méthode à tester
        List<Etudiant> resultat = etudiantService.lire();

        // Vérification
        assertEquals(2, resultat.size());
        assertEquals(etudiants, resultat);
    }

    @Test
    void modifier() {
        // Données de test
        Long idEtudiant = 1L;
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("NouveauNom");
        // Initialisez les autres propriétés selon vos besoins

        // Mock de l'étudiant existant dans la base de données
        Etudiant etudiantExistant = new Etudiant();
        etudiantExistant.setNoEtudiantNat("1234567890");
        etudiantExistant.setAnneePro("2024");
        etudiantExistant.setNom("AncienNom");
        // Initialisez les autres propriétés selon vos besoins

        // Configuration du comportement du mock repository
        when(etudiantRepository.findById(idEtudiant)).thenReturn(Optional.of(etudiantExistant));
        when(etudiantRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Appel de la méthode à tester
        Etudiant resultat = etudiantService.modifier(idEtudiant, etudiant);

        // Vérification
        assertEquals(etudiant.getNom(), resultat.getNom());
        // Vérifiez les autres propriétés modifiées selon vos besoins
    }


    @Test
    void supprimer() {
        // Données de test
        Long idEtudiant = 1L;

        // Appel de la méthode à tester
        String resultat = etudiantService.supprimer(idEtudiant);

        // Vérification
        assertEquals("Etudiant Supprimer avec succès", resultat);
        // Vérifiez si l'appel de deleteById() a été fait correctement selon vos besoins
    }



}
