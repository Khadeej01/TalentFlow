<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Candidat Registration</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex justify-center items-center h-screen bg-gray-100">
<form action="RegisterCandidat" method="post" class="bg-white p-8 rounded-lg shadow-lg w-96">
  <!-- Title with better visibility -->
  <h2 class="text-3xl font-bold text-center text-blue-600 mb-10">Candidat Registration</h2>

  <div class="mb-4">
    <label for="nom" class="block text-gray-700 font-medium mb-2">Name</label>
    <input type="text" name="nom" id="nom" placeholder="Enter your name" required class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
  </div>

  <div class="mb-4">
    <label for="email" class="block text-gray-700 font-medium mb-2">Email</label>
    <input type="email" name="email" id="email" placeholder="Enter your email" required class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
  </div>

  <div class="mb-4">
    <label for="password" class="block text-gray-700 font-medium mb-2">Password</label>
    <input type="password" name="password" id="password" placeholder="Enter your password" required class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
  </div>

  <div class="mb-4">
    <label for="telephone" class="block text-gray-700 font-medium mb-2">Phone (optional)</label>
    <input type="tel" name="telephone" id="telephone" placeholder="Enter your phone number" class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
  </div>

  <div class="mb-4">
    <label for="cv" class="block text-gray-700 font-medium mb-2">CV (Upload file)</label>
    <input type="file" name="cv" id="cv" class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
  </div>

  <button type="submit" class="w-full bg-blue-600 text-white py-3 rounded-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500">Register</button>
</form>
</body>
</html>
