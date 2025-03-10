CREATE DATABASE TalentFlow2;
USE TalentFlow2;


CREATE TABLE Recruteurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    entreprise VARCHAR(100)
);


CREATE TABLE Candidats (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    telephone VARCHAR(12),
    cv VARCHAR(100)
);


CREATE TABLE OffreEmploi (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    recruteur_id INT NOT NULL,
    FOREIGN KEY (recruteur_id) REFERENCES Recruteurs(id) ON DELETE CASCADE
);


CREATE TABLE Candidatures (
    id INT PRIMARY KEY AUTO_INCREMENT,
    candidat_id INT NOT NULL,
    offre_id INT NOT NULL,
    statut ENUM('En attente', 'Accepter', 'Refuser') DEFAULT 'En attente',
    date_postulation DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (candidat_id) REFERENCES Candidats(id) ON DELETE CASCADE,
    FOREIGN KEY (offre_id) REFERENCES OffreEmploi(id) ON DELETE CASCADE
);

select * from Candidats;
SHOW TABLES;

ALTER USER 'root'@'localhost' IDENTIFIED BY 'Root@123';