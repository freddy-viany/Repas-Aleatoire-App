<template>
<div class="container">

  <div class="row">
    <div class="col-sm-12 col-lg-6">
        <h2 class="font-weight">Menu de la semaine</h2> 
      </div>
      <div class="">
        <button  type="button"  class="btn btn-success p-1 m-1" @click="redirectMe()"
        style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
       
          <i class="bi bi-arrow-clockwise"></i>
        générer un autre menu
      
    </button>

    <!-- Download button PDF-->

    <button type="button"  class="btn btn-danger" @click="downloadPDF"  
    style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
    <i class="bi bi-filetype-pdf"></i> Télécharger en PDF</button>
    
       
      </div>
  </div>
  <div class="row">
   
    <div class="col-sm-6 col-md-4 col-lg-3 mt-2" v-for="(repas, index) in repasByWeek" :key="index">

      <div class="card h-100 border border-primary">
        <!--<img class="card-img-top" :src="repas.plat.image" alt="Image plat">-->
        <div class="card-body">

          <h5><span class="badge bg-secondary">{{ 'Jour ' + (index + 1) }}</span></h5>

          <div>
            <div  class=" mb-2">
                <img :src="pathImage + repas.entree.image" alt="Image entrée" class="img-fluid rounded " width="200" height="200">
                
            </div>
            <div class="card-text text-success fw-bold">
              <i class="bi bi-egg-fried"></i> DÉJEÛNER
              <p class="text-primary fw-bold">{{ repas.entree.nameEntree }}</p>
              <button type="button" class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdropDejeuner">Details</button>

                <!-- Modal section-->

      <!-- Modal DÉJEÛNER-->
<div class="modal fade" id="staticBackdropDejeuner" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
  aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Details du DÉJEÛNER</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p class="font-weight text-info">Ingredients: </p>
        <p class="card-title">
          {{repas.entree.ingredients }}

        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
       
      </div>
    </div>
  </div>
</div>

      <!-- End Modal DÉJEÛNER-->
            </div>
          
          </div>

         
         <hr>
         <div>
            <div class=" mb-2">
            <img :src="pathImage + repas.plat.image" alt="Image plat" class="img-fluid rounded " width="300" height="200">
          
            </div>

            <div class="card-text text-success fw-bold">
              <i class="bi bi-archive-fill"></i> PLAT PRINCIPAL
              <p class="text-primary fw-bold">{{ repas.plat.namePlat }}</p>
              <button type="button" class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdropPlat">Details</button>

                   <!-- Modal PLAT-->
<div class="modal fade" id="staticBackdropPlat" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
  aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Details du PLAT PRINCIPAL</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p class="text-primary"><i class="bi bi-people-fill"></i> Pour 4 personnes</p>
        <p class="font-weight text-info"><i class="bi bi-arrows-fullscreen"></i> Ingredients: </p>
        <p class="card-title text-black">
          {{repas.plat.ingredients }}

        </p>
        <hr>
        <p class="font-weight text-info"><i class="bi bi-archive-fill"></i> Preparation:  </p>
       
          
          <p class="text-black">
            <span v-if="repas.plat.preparationPlat" v-html="repas.plat.preparationPlat.split(';').map((etape) => ('- ' + etape)).join('<br>')"></span>

            <span v-else>Aucune préparation pour ce plat.</span>
          </p>


      

      </div>
      <div class="modal-footer">

        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
       
      </div>
    </div>
  </div>
</div>

      <!-- End Modal PLAT-->
            </div>
      

         </div>
         <hr>

         <div>
            <div class=" mb-2">
              <img :src="pathImage + repas.dessert.image" alt="Image dessert rounded " class="img-fluid" width="200" height="200">
          
            </div>

            <div class="card-text text-success fw-bold">
              <i class="bi bi-apple"></i> DESSERT
              <p class="text-primary fw-bold">{{ repas.dessert.nameDessert }}</p>
              <button type="button" class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdropDessert">Details</button>

                                 <!-- Modal Dessert-->
<div class="modal fade" id="staticBackdropDessert" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
  aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Details du DESSERT</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p class="font-weight text-info">Ingredients: </p>
        <p class="card-title">
          {{repas.dessert.ingredients }}
      
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
        
      </div>
    </div>
  </div>
</div>

      <!-- End Modal Dessert-->
            </div>
      

         </div>
         
          
        </div>
      </div>

      <!-- End Download PDF-->

    </div>
  </div>


    
</div>

</template>

<script>
import axios from 'axios';
import URLAPI from '@/service/URLAPI';

import jsPDF from 'jspdf';
import 'jspdf-autotable';


export default {
  name:"DisplayMealByWeekComp",
    
  data() {
    return {
      repasByWeek: [],
      pathImage:URLAPI.URL_IMAGE,
    };
  },
  async created() {
    const response = await axios.get(URLAPI.URL+'/api/user/meal/generer-repas-week');
    this.repasByWeek = response.data;
  },
  methods: {
         redirectMe() {
            this.$router.go(0);
         },

         downloadPDF() {
       // const doc = new jsPDF();
        const doc = new jsPDF('p', 'pt');
        const rows = [];

        // Définir les couleurs des colonnes
      const colors = ['#d8eafd', '#fff0f6', '#f0f5ff', '#fcffe6'];

        this.repasByWeek.forEach((repas, index) => {
  rows.push([
    'jour ' + (index + 1),
    'Déjeuner',
    repas.entree ? repas.entree.nameEntree : 'N/A',
   // repas.entree ? repas.entree.preparationPlat || 'N/A' : 'N/A'
  ]);
  rows.push([
    '',
    'Plat principal',
    repas.plat.namePlat,
    //repas.plat.preparationPlat || 'N/A'
  ]);
  rows.push([
    '',
    'Dessert',
    repas.dessert ? repas.dessert.nameDessert : 'N/A',
   // repas.dessert ? repas.dessert.preparationDessert || 'N/A' : 'N/A'
  ]);
});

      doc.text('Menu de la semaine - By Mes Repas', 40, 30);


        doc.autoTable({
          head: [['Jour','Type', 'Nom', 'Préparation']],
          body: rows,
          startY: 60,
    headStyles: {
      fillColor: colors[0],
      textColor: '#fff',
      lineWidth: 0.2,
      lineColor: '#fff'
    },
    bodyStyles: {
      lineWidth: 0.2,
      lineColor: '#ccc'
    },
    alternateRowStyles: {
      fillColor: colors[3]
    },
    columnStyles: {
      0: {
        fillColor: colors[1],
        textColor: '#000',
        halign: 'center',
        cellPadding: 5
      },
      1: {
        fillColor: colors[2],
        textColor: '#000',
        cellPadding: 5
      },
      2: {
        cellPadding: 5
      },
      3: {
        fillColor: colors[2],
        textColor: '#000',
        cellPadding: 5
      }
    }
          
        });

        doc.text('Bon appétit!', 40, doc.autoTable.previous.finalY + 30);



        doc.save('menu-semaine.pdf');
      },
         
},
}
</script>

<style>
@media (max-width: 768px) {
  table {
    font-size: 14px;
  }
}
</style>
