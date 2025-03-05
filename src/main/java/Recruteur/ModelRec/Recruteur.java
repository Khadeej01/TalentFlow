package Recruteur.ModelRec;
import User.Models.User;

public class Recruteur extends User {
    private String entreprise;
    private String secteur;


    public Recruteur(int id, String nom, String email, String password, String role, String entreprise, String secteur) {
        super(id, nom, email, password, role);
        this.entreprise = entreprise;
        this.secteur = secteur;
    }


    public Recruteur(String nom, String email, String password, String role, String entreprise, String secteur) {
        super(nom, email, password, role);
        this.entreprise = entreprise;
        this.secteur = secteur;
    }


    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }


    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Recruteur{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role='" + getRole() + '\'' +
                ", entreprise='" + entreprise + '\'' +
                ", secteur='" + secteur + '\'' +
                '}';
    }
}
