<%@ page import="Recruteur.DAORec.RecruteurDAO" %>
<%@ page import="Recruteur.ModelRec.Recruteur" %>

<%
    // Get the recruiter ID from the URL
    String idParam = request.getParameter("id");
    int recruiterId = (idParam != null) ? Integer.parseInt(idParam) : -1;

    // Fetch recruiter details
    RecruteurDAO recruteurDAO = new RecruteurDAO();
    Recruteur recruteur = recruteurDAO.getRecruteurById(recruiterId); // Assuming this method exists

    if (recruteur == null) {
        out.println("<h2 class='text-red-500 text-center'>Recruiter not found!</h2>");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Recruiter</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-50 flex items-center justify-center min-h-screen">
<div class="bg-white shadow-lg rounded-lg p-8 w-96">
    <h2 class="text-2xl font-semibold text-blue-600 text-center mb-4">Edit Recruiter</h2>

    <form action="UpdateRecruteurServlet" method="post">
        <input type="hidden" name="id" value="<%= recruteur.getId() %>">
        <div class="space-y-4">
            <div>
                <label class="block text-gray-700">Name:</label>
                <input type="text" name="nom" value="<%= recruteur.getNom() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div>
                <label class="block text-gray-700">Email:</label>
                <input type="email" name="email" value="<%= recruteur.getEmail() %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div>
                <label class="block text-gray-700">Entreprise:</label>
                <input type="text" name="entreprise" value="<%= recruteur.getEntreprise() != null ? recruteur.getEntreprise() : "" %>" class="w-full px-4 py-2 border rounded-lg">
            </div>
            <div class="text-center">
                <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-blue-600 transition">Update</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>