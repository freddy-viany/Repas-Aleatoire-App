<template>
    <div class="container">

     <form @submit.prevent="registerPlat()" method="post" enctype="multipart/form-data">

        
    <div class="row">
       <div class="col-lg-6 col-md-10 col-xs-12">

            <div class="form-floating mt-3 mb-3">
                <input v-model="plat.namePlat" type="text" class="form-control" id="platName" name="namePlat" placeholder="Nom Plat"  required>  
                <label for="platName" >Nom Plat :</label>
            </div>


            <div class="form-floating mb-3">
                <textarea v-model="plat.ingredients" class="form-control" id="platIngredient" placeholder="Ingredients" rows="3" name="ingredients" maxlength="300"
                    style="height: 150px; padding-top: 40px;" required  ></textarea>

                <label for="platIngredient" class="form-control">Entrez les ingredients :</label>
            </div>

            <div class="form-floating mb-3">
                <textarea v-model="plat.preparationPlat" class="form-control" id="preparationPlat" placeholder="preparation" rows="3" name="preparationPlat" maxlength="300"
                    style="height: 150px; padding-top: 40px;" required  ></textarea>

                <label for="preparationPlat" class="form-control">Entrez les étapes de preparation :</label>
            </div>

            <div class=" mb-3">
                <label for="file">Image:</label>
                <input type="file" name="file" id="file" @change="handleFileChange"><br>
            </div>


            <input type="submit" class="btn btn-primary" value="Envoyer"/>
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
    name:"AddPlatComp",
    
    data(){
        return{
            plat:{
                namePlat:"",
                ingredients:"",
                preparationPlat:"",
                image:""
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
        registerPlat(){

            let configHeader = { 
                     headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'multipart/form-data',
                                //"Access-Control-Allow-Origin": "*"
                                /*
                                "Access-Control-Allow-Origin": '*',
                                "Access-Control-Allow-Methods": 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
                                "Access-Control-Allow-Headers": 'Origin, Content-Type, X-Auth-Token, Accept',
                                */
                             }
                            };


                            //we send the form
                axios.post(URLAPI.URL+"/api/meal/addPlat",
                {
                    'namePlat':this.plat.namePlat,
                    'ingredients': this.plat.ingredients,
                    'preparationPlat':this.plat.preparationPlat,
                    'file':this.fileImage
                }
                , configHeader)
                    .then((response) =>{
                        console.log(this.plat);
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