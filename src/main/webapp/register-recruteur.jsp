<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Recruteur Registration</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex justify-center items-center h-screen bg-gray-100">
<form action="RegisterRecruteurServlet" method="post" class="bg-white p-8 rounded-lg shadow-md w-96">
  <h2 class="text-xl font-semibold text-center mb-6">Recruteur Registration</h2>
  <input type="text" name="nom" placeholder="Name" required class="w-full p-2 border rounded mb-4">
  <input type="email" name="email" placeholder="Email" required class="w-full p-2 border rounded mb-4">
  <input type="password" name="password" placeholder="Password" required class="w-full p-2 border rounded mb-4">
  <input type="text" name="entreprise" placeholder="Company Name" required class="w-full p-2 border rounded mb-4">
  <button type="submit" class="w-full bg-green-500 text-white py-2 rounded-lg hover:bg-green-600">Register</button>
</form>
</body>
</html>