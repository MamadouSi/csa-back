package csaback.csabackend.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @Column(name = "ANNEE_PRO", nullable = false, length = 10)
    private String anneePro;

    @Column(name = "CODE_FORMATION", length = 8)
    private String codeFormation;

    @Column(name = "NO_ENSEIGNANT")
    private Integer noEnseignant;

    @Column(name = "SIGLE_PRO", nullable = false, length = 5)
    private String siglePro;

    @Column(name = "NB_ETU_SOUHAITE", nullable = false)
    private Short nbEtuSouhaite;

    @Column(name = "ETAT_PRESELECTION", nullable = false, length = 3)
    private String etatPreselection;

    @Column(name = "DATE_RENTREE")
    private Instant dateRentree;

    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;

    @Column(name = "DATE_REPONSE_LP")
    private Instant dateReponseLp;

    @Column(name = "COMMENTAIRE")
    private String commentaire;

    @Column(name = "DATE_REPONSE_LALP")
    private Instant dateReponseLalp;

    @Column(name = "PROCESSUS_STAGE", length = 5)
    private String processusStage;

    @Column(name = "NO_EVALUATION")
    private Double noEvaluation;

    @Column(name = "NO_BAREME")
    private Double noBareme;

}