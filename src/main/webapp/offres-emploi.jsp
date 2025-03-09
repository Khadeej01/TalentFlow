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
    <h2 class="text-center mb-5 fw-bold text-primary">Créer une nouvelle offre</h2>

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
</div>
<div class="text-center mt-4 col-12 ">
    <a href="offres.jsp" class="btn btn-primary">Voir toutes les offres</a>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
