<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Candidat Registration</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex justify-center items-center min-h-screen bg-gradient-to-r from-blue-50 to-purple-50">
<form action="RegisterCandidat" method="post" class="bg-white p-8 rounded-xl shadow-2xl w-full max-w-md">
  <!-- Title with gradient text -->
  <h2 class="text-3xl font-bold text-center bg-gradient-to-r from-blue-600 to-purple-600 bg-clip-text text-transparent mb-8">
    Candidat Registration
  </h2>

  <!-- Name Field -->
  <div class="mb-6">
    <label for="nom" class="block text-gray-700 font-semibold mb-2">Name</label>
    <input type="text" name="nom" id="nom" placeholder="Enter your name" required
           class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all">
  </div>

  <!-- Email Field -->
  <div class="mb-6">
    <label for="email" class="block text-gray-700 font-semibold mb-2">Email</label>
    <input type="email" name="email" id="email" placeholder="Enter your email" required
           class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all">
  </div>

  <!-- Password Field -->
  <div class="mb-6">
    <label for="password" class="block text-gray-700 font-semibold mb-2">Password</label>
    <input type="password" name="password" id="password" placeholder="Enter your password" required
           class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all">
  </div>

  <!-- Phone Field -->
  <div class="mb-6">
    <label for="telephone" class="block text-gray-700 font-semibold mb-2">Phone (optional)</label>
    <input type="tel" name="telephone" id="telephone" placeholder="Enter your phone number"
           class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all">
  </div>

  <!-- CV Upload Field -->
  <div class="mb-6">
    <label for="cv" class="block text-gray-700 font-semibold mb-2">CV (Upload file)</label>
    <input type="file" name="cv" id="cv"
           class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all">
  </div>

  <!-- Submit Button -->
  <button type="submit"
          class="w-full bg-gradient-to-r from-blue-600 to-purple-600 text-white py-3 rounded-lg font-semibold hover:from-blue-700 hover:to-purple-700 focus:outline-none focus:ring-2 focus:ring-blue-500 transition-all">
    Register
  </button>
</form>
</body>
</html>