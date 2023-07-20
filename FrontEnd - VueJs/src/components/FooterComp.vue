<template>
    <footer class="bg-light py-3 mt-4">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <p class="mb-0"> © {{ currentYear }}
              {{ companyName }}. Tous droits réservés.</p>
            <p>{{ companyAddress }}</p>
          </div>
          <div class="col-md-6 text-md-end">
            <p class="mb-0"> Email: {{ companyEmail }}</p>
            <p> Tel: {{ companyPhone }}</p>
          </div>
        </div>
      </div>
    </footer>

  </template>
  
  <script>
  export default {
    data() {
      return {
        currentYear: new Date().getFullYear(),
        companyName: 'Mes repas',
        companyAddress: 'Cameroon',
        companyEmail: 'info@mesrepas.com',
        companyPhone: '+237 620 19 85 71'
      };
    }
  };
  </script>
  