package Offre_Emploi.Models;

import java.sql.Date;
import java.time.LocalDate;

public class OffreEmploi {
    private int id;
    private String titre;
    private String description;
    private LocalDate datePublication;
    private String recruteurEmail;
    private String entreprise;

    public OffreEmploi() {}

    public OffreEmploi(int id, String titre, String description, LocalDate datePublication, String recruteurEmail, String entreprise) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.recruteurEmail = recruteurEmail;
        this.entreprise = entreprise;
    }

    public OffreEmploi(String titre, String description, LocalDate datePublication, String recruteurEmail, String entreprise) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.recruteurEmail = recruteurEmail;
        this.entreprise = entreprise;
    }

    public OffreEmploi(int id, String titre, String description, LocalDate datePublication, String entreprise) {
    }

    public OffreEmploi(int id, String titre, String description, String entreprise, Date datePublication) {
    }

    public OffreEmploi(int id, String titre, String description) {
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDatePublication() { return datePublication; }
    public void setDatePublication(LocalDate datePublication) { this.datePublication = datePublication; }

    public String getRecruteurEmail() { return recruteurEmail; }
    public void setRecruteurEmail(String recruteurEmail) { this.recruteurEmail = recruteurEmail; }

    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }

    @Override
    public String toString() {
        return "OffreEmploi{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", recruteurEmail='" + recruteurEmail + '\'' +
                ", entreprise='" + entreprise + '\'' +
                '}';
    }
}
