<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Offres d'Emploi - TalentFlow</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container py-5">
    <h2 class="text-center mb-5 fw-bold text-primary">Offres d'Emploi</h2>

    <!-- Formulaire de création d'une nouvelle offre -->
    <div class="card shadow p-4 mb-5">
        <h4 class="mb-4">Créer une nouvelle offre</h4>
        <form action="offre-emploi" method="post">
            <div class="row g-3">
                <div class="col-md-6">
                    <label for="titre" class="form-label">Titre :</label>
                    <input type="text" class="form-control" id="titre" name="titre" required>
                </div>
                <div class="col-md-6">
                    <label for="datePublication" class="form-label">Date de publication :</label>
                    <input type="date" class="form-control" id="datePublication" name="datePublication" required>
                </div>
                <div class="col-12">
                    <label for="description" class="form-label">Description :</label>
                    <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                </div>
                <div class="col-md-6">
                    <label for="recruteurEmail" class="form-label">Email du recruteur :</label>
                    <input type="email" class="form-control" id="recruteurEmail" name="recruteurEmail" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary w-100">Créer l'offre</button>
                </div>
            </div>
        </form>
    </div>

    <!-- Liste des offres d'emploi -->
    <div class="row g-4">
        <c:forEach var="offre" items="${offres}">
            <div class="col-md-4">
                <div class="card h-100 shadow">
                    <div class="card-body">
                        <h5 class="card-title text-primary fw-bold">${offre.titre}</h5>
                        <p class="card-text">${offre.description}</p>
                        <p><strong>Entreprise :</strong> ${offre.entreprise}</p>
                        <p><strong>Localisation :</strong> ${offre.localisation}</p>
                        <p><strong>Date de publication :</strong> ${offre.datePublication}</p>
                        <a href="details-offre.jsp?id=${offre.id}" class="btn btn-outline-primary w-100">Voir les détails</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="Offre_Emploi.Models.OffreEmploi" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="fr">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Offres d'Emploi - TalentFlow</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>



<%--<h2 class="text-center">Offres d'Emploi</h2>--%>


<%--<form action="offre-emploi" method="post">--%>
<%--    <label for="titre">Titre :</label>--%>
<%--    <input type="text" id="titre" name="titre" required>--%>

<%--    <label for="description">Description :</label>--%>
<%--    <textarea id="description" name="description" required></textarea>--%>

<%--    <label for="datePublication">Date de publication :</label>--%>
<%--    <input type="date" id="datePublication" name="datePublication" required>--%>

<%--    <label for="recruteurEmail">Email du recruteur :</label>--%>
<%--    <input type="email" id="recruteurEmail" required>--%>

<%--    <button type="submit">Créer l’offre</button>--%>
<%--</form>--%>

<%--&lt;%&ndash;<!-- Affichage des offres -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:forEach var="offre" items="${offres}">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="card">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h3>${offre.titre}</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p>${offre.description}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p><strong>Entreprise :</strong> ${offre.entreprise}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p><strong>Localisation :</strong> ${offre.localisation}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p><strong>Date de publication :</strong> ${offre.datePublication}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="details-offre.jsp?id=${offre.id}" class="btn btn-primary">Voir les détails</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>


<%--&lt;%&ndash;<div class="container py-5">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h2 class="text-center mb-5 fw-bold text-primary">Offres d'Emploi</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="row g-4">&ndash;%&gt;--%>

<%--&lt;%&ndash;        <form action="offreEmploi" method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <label for="titre">Titre :</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="text" id="titre" name="titre" required>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <label for="description">Description :</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <textarea id="description" name="description" required></textarea>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <label for="datePublication">Date de publication :</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="date" id="datePublication" name="datePublication" required>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <label for="recruteurEmail">Email du recruteur :</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="email" id="recruteurEmail" name="recruteurEmail" required>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <button type="submit">Créer l’offre</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </form>&ndash;%&gt;--%>


<%--        <c:forEach var="offreEmploi" items="${offres}">--%>
<%--            <div class="col-md-4">--%>
<%--                <div class="card h-100">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">${offreEmploi.titre}</h5>--%>
<%--                        <p class="card-text">${offreEmploi.description}</p>--%>
<%--                        <p><strong>Entreprise:</strong> ${offreEmploi.entreprise}</p>--%>
<%--                        <p><strong>Localisation:</strong> ${offreEmploi.localisation}</p>--%>
<%--                        <p><strong>Date de publication:</strong> ${offreEmploi.datePublication}</p>--%>
<%--                        <a href="details-offre.jsp?id=${offreEmploi.id}" class="btn btn-primary">Voir les détails</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
