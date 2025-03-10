<%@ page import="Candidat.DAO.CandidatDAO" %>
<%@ page import="Candidat.Models.Candidat" %>

<%
    // Get the candidate ID from the URL
    String idParam = request.getParameter("id");
    int candidateId = (idParam != null) ? Integer.parseInt(idParam) : -1;

    // Fetch candidate details
    CandidatDAO candidatDAO = new CandidatDAO();
    Candidat candidat = candidatDAO.getCandidatById(candidateId);

    if (candidat == null) {
        out.println("<h2 class='text-red-500 text-center'>Candidate not found!</h2>");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Candidate</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-50 flex items-center justify-center min-h-screen">
<div class="bg-white shadow-lg rounded-lg p-8 w-96">
    <h2 class="text-2xl font-semibold text-blue-600 text-center mb-4">Edit Candidate</h2>

    <form action="UpdateCandidatServlet" method="post">
        <input type="hidden" name="id" value="<%= candidat.getId() %>">
        <div class="space-y-4">
            <div>
                <label class="block text-gray-700">Name:</label>
                <input type="text" name="nom" value="<%= candidat.getNom() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div>
                <label class="block text-gray-700">Email:</label>
                <input type="email" name="email" value="<%= candidat.getEmail() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div>
                <label class="block text-gray-700">Phone:</label>
                <input type="text" name="telephone" value="<%= candidat.getTelephone() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div>
                <label class="block text-gray-700">CV URL:</label>
                <input type="file" name="cv" value="<%= candidat.getCv() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div class="text-center">
                <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-blue-600 transition">Update</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>