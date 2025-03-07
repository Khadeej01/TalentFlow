package Candidature.Models;

public class Candidature {

    private int candidatId;
    private String nom;
    private String telephone;
    private String email;
    private String cv;

    public Candidature(int candidatId, String nom, String telephone, String email, String cv) {
        this.candidatId = candidatId;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.cv = cv;
    }

    public Candidature(String nom, String telephone, String email, String cv) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "candidatId=" + candidatId +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}