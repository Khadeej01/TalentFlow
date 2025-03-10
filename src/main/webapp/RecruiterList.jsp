<%@ page import="java.util.*" %>
<%@ page import="Recruteur.DAORec.RecruteurDAO" %>
<%@ page import="Recruteur.ModelRec.Recruteur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Fetch all recruiters from the database
    RecruteurDAO recruteurDAO = new RecruteurDAO();
    List<Recruteur> recruteurs = recruteurDAO.getAllRecruteurs(); // Assuming this method exists
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="TalentFlow Dashboard - Manage recruiters efficiently.">
    <title>TalentFlow Dashboard - Recruiters</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #1e88e5;
            --secondary-color: #4caf50;
            --dark-color: #303f9f;
            --light-color: #f5f5f5;
            --text-color: #333333;
            --border-radius: 0.375rem;
        }

        body {
            font-family: 'Roboto', sans-serif;
            color: var(--text-color);
            background: linear-gradient(135deg, #e3f2fd, #f8f9fa);
            overflow-x: hidden;
        }

        .sidebar {
            height: 100vh;
            width: 250px;
            position: fixed;
            background: linear-gradient(135deg, var(--primary-color), #7986cb);
            color: white;
            padding-top: 20px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            transition: width 0.3s ease;
        }
        .sidebar .brand {
            font-weight: 700;
            font-size: 1.8rem;
            color: white;
            text-align: center;
            margin-bottom: 30px;
            transition: color 0.3s;
        }
        .sidebar .brand:hover {
            color: var(--light-color);
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            padding: 15px 20px;
            display: block;
            font-weight: 500;
            transition: background 0.3s, padding-left 0.3s;
        }
        .sidebar a:hover {
            background: var(--dark-color);
            padding-left: 25px;
        }
        .sidebar a i {
            margin-right: 10px;
        }

        .content {
            margin-left: 250px;
            padding: 20px;
            min-height: 100vh;
        }
        .navbar {
            background: rgba(255, 255, 255, 0.95) !important;
            backdrop-filter: blur(10px);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .navbar .navbar-brand {
            color: var(--primary-color) !important;
            font-weight: 700;
            font-size: 1.5rem;
        }
        .navbar-toggler {
            border-color: var(--primary-color);
        }
        .navbar-toggler-icon {
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath stroke='%231e88e5' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
        }

        .table-responsive {
            margin-top: 20px;
        }

        @media (max-width: 768px) {
            .sidebar {
                width: 80px;
            }
            .sidebar .brand, .sidebar a span {
                display: none;
            }
            .sidebar a {
                text-align: center;
                padding: 15px;
            }
            .content {
                margin-left: 80px;
            }
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        .content {
            animation: fadeIn 0.5s ease-in;
        }
    </style>
</head>
<body>
<!-- Sidebar -->
<div class="sidebar">
    <a href="index.jsp" class="brand"><i class="fas fa-briefcase me-2"></i>TalentFlow</a>
    <a href="CandidatList.jsp"><i class="fas fa-users"></i> <span>Candidates</span></a>
    <a href="RecruiterList.jsp"><i class="fas fa-user-tie"></i> <span>Recruiters</span></a>
    <a href="offres-emploi.jsp"><i class="fas fa-briefcase"></i> <span>Jobs</span></a>
</div>

<!-- Content Area -->
<div class="content">
    <nav class="navbar navbar-expand-lg shadow-sm p-3">
        <div class="container-fluid">
            <span class="navbar-brand">Dashboard</span>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a href="LogoutServlet" class="ml-6 bg-red-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-red-600 transition" id="logoutLink">Logout</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="fw-bold text-primary mb-4">Recruiters</h2>
        <div class="table-responsive">
            <table class="min-w-full bg-white border border-gray-300 shadow-md rounded-lg">
                <thead class="bg-blue-600 text-white">
                <tr>
                    <th class="py-3 px-6 text-center font-semibold border-b">ID</th>
                    <th class="py-3 px-6 text-center font-semibold border-b">Name</th>
                    <th class="py-3 px-6 text-center font-semibold border-b">Email</th>
                    <th class="py-3 px-6 text-center font-semibold border-b">Entreprise</th>
                    <th class="py-3 px-6 text-center font-semibold border-b">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Recruteur recruteur : recruteurs) { %>
                <tr class="hover:bg-blue-100">
                    <td class="py-2 px-4 border-b text-center"><%= recruteur.getId() %></td>
                    <td class="py-2 px-4 border-b text-center"><%= recruteur.getNom() %></td>
                    <td class="py-2 px-4 border-b text-center"><%= recruteur.getEmail() %></td>
                    <td class="py-2 px-4 border-b text-center"><%= recruteur.getEntreprise() != null ? recruteur.getEntreprise() : "N/A" %></td>
                    <td class="py-2 px-4 border-b text-center space-x-2">
                        <!-- Edit Button -->
                        <a href="editRecruteur.jsp?id=<%= recruteur.getId() %>" class="bg-blue-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-blue-600 transition">
                            Edit
                        </a>
                        <!-- Delete Button -->
                        <form action="DeleteRecruteurServlet" method="post" class="inline-block">
                            <input type="hidden" name="id" value="<%= recruteur.getId() %>">
                            <button type="submit" class="bg-red-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-red-600 transition">
                                Delete
                            </button>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>