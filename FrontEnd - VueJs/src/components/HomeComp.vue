<template>
    <div>
      <!-- Navigation bar -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Menu</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#"> <router-link to="/display-meal-week"  style="text-decoration: none;">Tous les repas</router-link></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Menu végétariens</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Menu Perte de poids</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Menu Prise de poids</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Conseil de la semaine</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

  
      <!-- Main content -->
      <div class="container mt-4">
        <div class="row">
          <div class="col-md-4">
            <h1>Bienvenue &#x1F607; </h1>
            <p>Bien se nourrir et savoir quoi manger.</p>


          </div>
          <div class="col-md-4">

            <a class="btn btn-lg btn-danger btn-sm rounded-pill px-2 py-2">
               <router-link to="/display-meal-week" class="text-white" style="text-decoration: none;"> Consulter le menu de la semaine  </router-link>  </a>

          </div>
          <div class="col-md-4 mt-3">
            <h3>Notre mission</h3>
            <p>Nous croyons que manger sainement est essentiel pour une vie saine et heureuse. C'est pourquoi nous proposons une grande variété de repas sains et délicieux pour vous aider à atteindre vos objectifs de santé et de bien-être.</p>
          </div>
        </div>
      </div>
  
    
    </div>
  </template>

<script>

export default{
    name:"HomeCome"
}

</script>