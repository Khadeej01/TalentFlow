package Candidat.Models; // Ensure this is correct

import User.Models.User;

public class Candidat extends User {
    private String telephone;
    private String cv;

    // Constructors, getters, and setters
    public Candidat() {}

    public Candidat(String nom, String email, String password, String telephone, String cv) {
        super(nom, email, password);
        this.telephone = telephone;
        this.cv = cv;
    }

    public Candidat(int id, String nom, String email, String password, String telephone, String cv) {
        super(id, nom, email, password);
        this.telephone = telephone;
        this.cv = cv;
    }

    public String getTelephone() { return telephone; }
    public String getCv() { return cv; }

    public void setCv(String cv) { this.cv = cv; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
}