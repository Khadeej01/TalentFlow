package Offre_Emploi.Models;

import java.sql.Date;
import java.time.LocalDate;

public class OffreEmploi {
    private int id;
    private String titre;
    private String description;
    private LocalDate datePublication;
    private String recruteurEmail;

    public OffreEmploi() {}

    public OffreEmploi(String titre, String description, LocalDate datePublication, String recruteurEmail) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.recruteurEmail = recruteurEmail;
    }

    public OffreEmploi(int id, String titre, String description, LocalDate datePublication, String recruteurEmail) {
    }

    public OffreEmploi(int id, String titre, String description, String entreprise, String localisation, Date datePublication) {
    }


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

    @Override
    public String toString() {
        return "OffreEmploi{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", recruteurEmail='" + recruteurEmail + '\'' +
                '}';
    }
}

