package Candidat.Models;

import User.Models.User;

public class Candidat extends User {
    private String telephone;
    private String cv;

    public Candidat(String nom, String email, String password, String telephone, String cv) {
        super(nom, email, password);
        this.telephone = telephone;
        this.cv = cv;
    }

    public Candidat() {

    }

    public String getTelephone() { return telephone; }
    public String getCv() { return cv; }
}

