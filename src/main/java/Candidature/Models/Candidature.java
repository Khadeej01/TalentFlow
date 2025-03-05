package Candidature.Models;

public class Candidature {
    private int id;
    private int candidatId;
    private int offreId;
    private String statut;

    public Candidature(int id, int candidatId, int offreId, String statut) {
        this.id = id;
        this.candidatId = candidatId;
        this.offreId = offreId;
        this.statut = statut;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCandidatId() { return candidatId; }
    public void setCandidatId(int candidatId) { this.candidatId = candidatId; }

    public int getOffreId() { return offreId; }
    public void setOffreId(int offreId) { this.offreId = offreId; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
