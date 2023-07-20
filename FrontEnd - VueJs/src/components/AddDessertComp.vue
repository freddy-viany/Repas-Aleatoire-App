<template>
    <div class="container">

     <form @submit.prevent="registerDessert()" method="post" enctype="multipart/form-data">

        
    <div class="row">
       <div class="col-lg-6 col-md-10 col-xs-12">

            <div class="form-floating mt-3 mb-3">
                <input v-model="dessert.nameDessert" type="text" class="form-control" id="dessertName" name="nameDessert" placeholder="Nom Dessert"  required>  
                <label for="dessertName" >Nom Dessert :</label>
            </div>


            <div class="form-floating mb-3">
                <textarea v-model="dessert.ingredients" class="form-control" id="dessertIngredient" placeholder="ingredients" rows="3" name="ingredients" maxlength="300"
                    style="height: 150px; padding-top: 40px;" required  ></textarea>

                <label for="dessertIngredient" class="form-control">Entrez les ingredients :</label>
            </div>

            <div class="mb-5">
                <label for="file">Image:</label>
                <input  type="file" name="file" id="file" @change="handleFileChange"><br>
            </div>

            <div class="mb-3">
                <input type="submit" class="btn btn-primary" value="Envoyer"/>

            </div>


           
        </div>

        <div class="col-lg-6 col-md-10 col-xs-12">
            <img src="../assets/love-signup-login.png"
            class="img-fluid" alt="Sample image">
        </div>
    </div>


</form>
        
    </div>
</template>


<script>

import axios from 'axios';
import URLAPI from '@/service/URLAPI';

export default{
    name:"AddDessertComp",
    
    data(){
        return{
            dessert:{
                nameDessert:"",
                ingredients:""
            },
            errorForm:false,
            fileImage:""
        }
    },

    methods:{
        
        handleFileChange(event) {
      const file = event.target.files[0];
      this.fileImage = file;
      
     // const formData = new FormData();
     // formData.append('file', file);
     //Envoi de formData via Axios
    },
        registerDessert(){

            let configHeader = { 
                     headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'multipart/form-data'
                                //"Access-Control-Allow-Origin": "*"
                                /*
                                "Access-Control-Allow-Origin": '*',
                                "Access-Control-Allow-Methods": 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
                                "Access-Control-Allow-Headers": 'Origin, Content-Type, X-Auth-Token, Accept',
                                */
                             }
                            };


                            //we send the form
                axios.post(URLAPI.URL+"/api/meal/addDessert", 
                {
                    'nameDessert':this.dessert.nameDessert,
                    'ingredients': this.dessert.ingredients,
                    'file':this.fileImage
                }, 
                 configHeader)
                    .then((response) =>{
                        console.log(this.dessert.nameDessert);
                        console.log(this.dessert.ingredients);
                        console.log("success");
                        console.log(response.status); 

                        //here, we have no error if form
                        this.errorForm = false;

                        //this.$router.push("/email-verification-out");

                        //this.$router.push("/about");
                        //console.log(this.user);
                        //this.$router.go()
                        
                    })
                    .catch((error)=>{
                        console.log("Error in form");
                       // console.error(error.response.data);
                      // console.log(error);
                       

                        if(error.response.status==400){
                            this.errorForm = true;

                            
                        }
                        
                    });

        }
    }
}


</script>