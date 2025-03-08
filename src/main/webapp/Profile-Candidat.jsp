<%@ page import="Candidat.DAO.CandidatDAO" %>
<%@ page import="Candidat.Models.Candidat" %>
<%@ page import="java.io.*, java.util.*, jakarta.servlet.*, jakarta.servlet.http.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Candidate Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-50 flex items-center justify-center min-h-screen">

<%
    // Handle ID retrieval safely
    String idParam = request.getParameter("id");
    int candidateId = 0;
    Candidat candidat = null;

    if (idParam != null && !idParam.isEmpty()) {
        try {
            candidateId = Integer.parseInt(idParam);
            CandidatDAO candidatDAO = new CandidatDAO();
            candidat = candidatDAO.getCandidatById(candidateId);
        } catch (NumberFormatException e) {
            out.println("<p class='text-red-500'>Invalid candidate ID</p>");
        }
    } else {
        out.println("<p class='text-red-500'>No candidate ID provided</p>");
    }
%>

<% if (candidat != null) { %>
<div class="bg-white shadow-lg rounded-lg p-8 w-96">
    <h2 class="text-2xl font-semibold text-blue-600 text-center mb-4">Candidate Profile</h2>

    <div class="space-y-2">
        <p class="text-gray-700"><strong>Name:</strong> <%= candidat.getNom() %></p>
        <p class="text-gray-700"><strong>Email:</strong> <%= candidat.getEmail() %></p>
        <p class="text-gray-700"><strong>Phone:</strong> <%= candidat.getTelephone() %></p>
        <p class="text-gray-700"><strong>CV:</strong>
            <a href="<%= candidat.getCv() %>" class="text-blue-500 hover:underline">View CV</a>
        </p>
    </div>

    <div class="mt-6 flex justify-between">
        <a href="editCandidat.jsp?id=<%= candidat.getId() %>"
           class="bg-blue-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-blue-600 transition">Edit</a>

        <form action="DeleteCandidatServlet" method="post">
            <input type="hidden" name="id" value="<%= candidat.getId() %>">
            <button type="submit" class="bg-red-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-red-600 transition">Delete</button>
        </form>
    </div>
</div>
<% } else { %>
<p class="text-gray-700 text-center">Candidate not found.</p>
<% } %>

</body>
</html>
