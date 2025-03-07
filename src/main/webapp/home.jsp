
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TalentFlow - Plateforme de Recrutement</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #1e88e5;
            --secondary-color: #4caf50;
            --accent-color: #ff5722;
            --dark-color: #303f9f;
            --light-color: #f5f5f5;
            --text-color: #333333;
            --border-radius: 0.375rem;
        }

        body {
            font-family: 'Roboto', sans-serif;
            color: var(--text-color);
            background: linear-gradient(135deg, #f8f9fa, #e0e7ff);
            overflow-x: hidden;
        }

        .navbar {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-weight: 700;
            color: var(--primary-color) !important;
            font-size: 1.8rem;
            transition: color 0.3s;
        }
        .navbar-brand:hover {
            color: var(--dark-color) !important;
        }
        .nav-link {
            color: var(--text-color) !important;
            font-weight: 500;
            transition: color 0.3s;
        }
        .nav-link.active, .nav-link:hover {
            color: var(--primary-color) !important;
        }

        .btn-primary {
            background: linear-gradient(45deg, var(--primary-color), #7986cb);
            border: none;
            padding: 10px 25px;
            border-radius: 25px;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .btn-primary:hover {
            background: var(--dark-color);
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(63, 81, 181, 0.4);
        }
        .btn-outline-primary {
            color: var(--primary-color);
            border-color: var(--primary-color);
            border-radius: 25px;
            transition: all 0.3s;
        }
        .btn-outline-primary:hover {
            background: var(--primary-color);
            color: white;
            transform: translateY(-3px);
        }

        .bg-primary {
            background: linear-gradient(135deg, var(--primary-color), #7986cb);
            position: relative;
            overflow: hidden;
        }
        .bg-primary::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(255, 255, 255, 0.2), transparent);
            animation: pulse 8s infinite;
        }
        .hero-text h1 {
            font-size: 3.5rem;
            font-weight: 900;
            text-shadow: 0 0 15px rgba(255, 255, 255, 0.5);
            animation: fadeInDown 1s ease-out;
        }
        .hero-text p {
            font-size: 1.4rem;
            animation: fadeInUp 1.5s ease-out;
        }
        .hero-img {
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            transform: translateY(20px);
            animation: float 3s ease-in-out infinite;
        }

        .card {
            border-radius: var(--border-radius);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            border: none;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
        }
        .card i {
            transition: transform 0.3s;
        }
        .card:hover i {
            transform: scale(1.2);
        }

        .job-card {
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .job-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        .footer {
            background: linear-gradient(135deg, #343a40, #495057);
            color: white;
            padding: 3rem 0;
            border-top: 2px solid var(--primary-color);
        }

        .modal-content {
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        @keyframes pulse {
            0% { transform: scale(1); }
            50% { transform: scale(1.1); }
            100% { transform: scale(1); }
        }
        @keyframes fadeInDown {
            from { opacity: 0; transform: translateY(-50px); }
            to { opacity: 1; transform: translateY(0); }
        }
        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(50px); }
            to { opacity: 1; transform: translateY(0); }
        }
        @keyframes float {
            0% { transform: translateY(20px); }
            50% { transform: translateY(0); }
            100% { transform: translateY(20px); }
        }
    </style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm sticky-top">
    <div class="container">
        <a class="navbar-brand" href="index.html">
            <i class="fas fa-briefcase me-2"></i>TalentFlow
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.html">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="offres-emploi.jsp">Offres d'emploi</a>
                </li>
            </ul>
            <div>
                <button class="btn btn-outline-primary me-2">Connexion</button>
                <button class="btn btn-primary">Inscription</button>
            </div>
        </div>
    </div>
</nav>

<!-- Main Content Area -->
<div id="page-content">
    <section id="home-content">
        <div class="bg-primary text-white py-5">
            <div class="container py-5">
                <div class="row align-items-center">
                    <div class="col-lg-6 hero-text">
                        <h1 class="display-4 fw-bold mb-4">Simplifiez votre recrutement avec TalentFlow</h1>
                        <p class="lead mb-4">La plateforme qui connecte les meilleurs talents avec les entreprises qui recrutent.</p>
                        <div class="d-flex gap-3">
                            <a href="register.html?type=candidate" class="btn btn-light btn-lg">Je cherche un emploi</a>
                            <a href="register.html?type=recruiter" class="btn btn-outline-light btn-lg">Je recrute</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <img src="https://cdn.aarp.net/content/dam/aarp/work/job-search/2020/08/1140-new-job-keyboard.jpg" alt="Recrutement" class="img-fluid hero-img">
                    </div>
                </div>
            </div>
        </div>

        <div class="container py-5">
            <h2 class="text-center mb-5 fw-bold text-primary">Pourquoi choisir TalentFlow ?</h2>
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card h-100 text-center p-4">
                        <div class="mb-3">
                            <i class="fas fa-tachometer-alt text-primary" style="font-size: 3rem;"></i>
                        </div>
                        <h3 class="h5">Processus simplifié</h3>
                        <p class="text-muted">Gérez efficacement toutes les étapes du recrutement avec notre interface intuitive.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100 text-center p-4">
                        <div class="mb-3">
                            <i class="fas fa-search text-primary" style="font-size: 3rem;"></i>
                        </div>
                        <h3 class="h5">Trouvez les meilleurs talents</h3>
                        <p class="text-muted">Accédez à une base de candidats qualifiés pour votre entreprise.</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100 text-center p-4">
                        <div class="mb-3">
                            <i class="fas fa-lock text-primary" style="font-size: 3rem;"></i>
                        </div>
                        <h3 class="h5">Sécurité et confidentialité</h3>
                        <p class="text-muted">Vos données sont protégées avec les standards de sécurité les plus élevés.</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10">
                    <div class="card bg-primary text-white p-5 text-center">
                        <h2 class="mb-4 fw-bold">Prêt à transformer votre processus de recrutement ?</h2>
                        <p class="lead mb-4">Rejoignez TalentFlow dès aujourd'hui et trouvez les talents qui feront la différence.</p>
                        <div class="d-flex justify-content-center gap-3">
                            <a href="register.html?type=recruiter" class="btn btn-light">Espace recruteur</a>
                            <a href="register.html?type=candidate" class="btn btn-outline-light">Espace candidat</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- Footer -->
<footer class="footer text-center text-lg-start">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 mb-4 mb-lg-0">
                <h5 class="text-uppercase mb-3">TalentFlow</h5>
                <p>Simplifiez le recrutement et trouvez les meilleurs talents avec notre plateforme.</p>
            </div>
            <div class="col-lg-3 mb-4 mb-lg-0">
                <h5 class="text-uppercase mb-3">Liens rapides</h5>
                <ul class="list-unstyled">
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="job-listings.html">Offres d'emploi</a></li>
                    <li><a href="login.html">Connexion</a></li>
                    <li><a href="register.html">Inscription</a></li>
                </ul>
            </div>
            <div class="col-lg-3">
                <h5 class="text-uppercase mb-3">Contact</h5>
                <ul class="list-unstyled">
                    <li><i class="fas fa-envelope me-2"></i>contact@talentflow.fr</li>
                    <li><i class="fas fa-phone me-2"></i>+33 1 23 45 67 89</li>
                </ul>
            </div>
        </div>
        <div class="text-center mt-4">
            <p>© 2025 TalentFlow by Noobs. Tous droits réservés.</p>
        </div>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
