<%@ page import="Offre_Emploi.Models.OffreEmploi" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    OffreEmploi offre = (OffreEmploi) request.getAttribute("offre");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Modifier Offre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="mb-4">Modifier l'Offre</h2>

<form action="ModifierOffreServlet" method="post">
    <input type="hidden" name="id" value="<%= offre.getId() %>">

    <div class="mb-3">
        <label for="titre" class="form-label">Titre</label>
        <input type="text" class="form-control" id="titre" name="titre" value="<%= offre.getTitre() %>" required>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea class="form-control" id="description" name="description" required><%= offre.getDescription() %></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer</button>
    <a href="offres.jsp" class="btn btn-secondary">Annuler</a>
</form>

</body>
</html>
