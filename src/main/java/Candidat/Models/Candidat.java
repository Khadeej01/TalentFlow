package Candidat.Models;

public class Candidat {

    private String nom;
    private String email;
    private String telephone;
    private String cv;
    private String password;

    public Candidat() {}

    public Candidat(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public Candidat(String nom, String email, String telephone, String cv, String password) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.cv = cv;
        this.password = password;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Candidat{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}

