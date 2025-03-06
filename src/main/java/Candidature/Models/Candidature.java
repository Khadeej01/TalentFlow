package Candidature.Models;

public class Candidature {

    private int candidatId;
    private String nom;
    private String telephone;
    private String email;
    private int offreId;
    private String statut;

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



    public Candidature(int candidatId, String nom, String telephone, String email, int offreId, String statut) {
        this.candidatId = candidatId;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.offreId = offreId;
        this.statut = statut;
    }



}