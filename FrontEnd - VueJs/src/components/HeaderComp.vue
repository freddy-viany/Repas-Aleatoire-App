<template>
  <!--
<div class="container-fluid p-0">
  <div class="row align-items-center">
    <div class="col-3 ">
      <img src="../assets/logo.png" alt="Logo" class="img-fluid">
    </div>
    <div class="col-9">
      <video src="../assets/ads-header.mp4" autoplay loop muted class="w-100" height="150px"></video>
    </div>
  </div>
</div>
-->

  <div class="container-fluid">


    <div class="row row-cols-2 text-bg-light"  >
        <div class="col-3 ">
          <router-link to="/"  style="text-decoration: none;"><img src="../assets/logo-recipe-no-bg.svg"  alt="Logo" class="img-fluid" style="max-width: 75px;"> </router-link> 
     
      </div>
    <div class="col-9">
      <p class=""> <i class="bi bi-telephone-fill"></i><i class="bi bi-arrow-left-right"></i><i class="bi bi-whatsapp text-success"></i><i class="text-success">: 620 19 85 71</i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="bi bi-envelope-at"></i> <i class="text-primary">: info@mesrepas.com</i></p>
            
    </div>
    </div>




    <div class="row align-items-center">




      <div class="">
        <div style="max-width: 100%;"
          id="carouselExampleControls"
          class="carousel slide"
          data-bs-ride="carousel"
        >
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="../assets/slide1.jpg" class="d-block w-100" alt="Image 1"  height="200px"/>
            </div>
            <div class="carousel-item">
              <img src="../assets/slide2.jpg" class="d-block w-100" alt="Image 2" height="200px"/>
            </div>
            <div class="carousel-item">
              <img src="../assets/slide3.jpg" class="d-block w-100" alt="Image 3" height="200px"/>
            </div>
            <div class="carousel-item">
              <img src="../assets/slide4.jpg" class="d-block w-100" alt="Image 4" height="200px"/>
            </div>
          </div>
          
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleControls"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleControls"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
  
  

<script>
export default {
  name: "HeaderComp",
};
</script>


<style  scoped>
.banner {
  display: flex;
  align-items: center;
  height: 200px;
}

.logo {
  flex: 1;
  padding: 20px;
}

.video {
  flex: 1;
}

.video video {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>>
   

  