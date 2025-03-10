<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex justify-center items-center h-screen bg-gradient-to-r from-blue-400 to-purple-500">

<div class="bg-white p-8 rounded-2xl shadow-2xl w-96 transform transition duration-500 hover:scale-105">
    <h2 class="text-3xl font-bold text-center text-gray-900 mb-6">Login</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="text-red-500 text-center mb-4 animate-pulse"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <form action="Login" method="post" class="space-y-4">
        <div>
            <label for="email" class="block text-gray-700 font-medium">Email</label>
            <input type="email" name="email" id="email" placeholder="Enter your email" required
                   class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition-all">
        </div>

        <div>
            <label for="password" class="block text-gray-700 font-medium">Password</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" required
                   class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition-all">
        </div>

        <button type="submit"
                class="w-full bg-blue-600 text-white py-3 rounded-lg hover:bg-blue-700 transition-all duration-300 transform hover:scale-105">
            Login
        </button>
    </form>

    <div class="mt-6 flex justify-between">
        <a href="Home-Register.jsp"
           class="text-blue-600 font-medium hover:underline hover:text-blue-800 transition-all">Register</a>
        <a href="index.jsp"
           class="text-gray-600 font-medium hover:underline hover:text-gray-800 transition-all">Return to Home</a>
    </div>
</div>

</body>
</html>
