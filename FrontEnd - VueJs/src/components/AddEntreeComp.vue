<template>
    <div class="container">

     <form @submit.prevent="registerEntree()" method="post"  enctype="multipart/form-data">

        
    <div class="row">
       <div class="col-lg-6 col-md-10 col-xs-12">

            <div class="form-floating mt-3 mb-3">
                <input v-model="entree.nameEntree" type="text" class="form-control" id="entreeName" name="nameEntree" placeholder="Nom Entree"  required>  
                <label for="entreeName" >Nom Entree :</label>
            </div>


            <div class="form-floating mb-3">
                <textarea v-model="entree.ingredients" class="form-control" id="entreeIngredient" placeholder="ingredients" rows="3" name="Ingredients" maxlength="300"
                    style="height: 150px; padding-top: 40px;" required  ></textarea>

                <label for="entreeIngredient" class="form-control">Entrez les ingredients :</label>
            </div>

            <div class="mb-3">
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
    name:"AddEntreeComp",
    
    data(){
        return{
            entree:{
                nameEntree:"",
                ingredients:"",
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
        registerEntree(){

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

           /* const formData = new FormData();
            formData.append('nameEntree', this.entree.nameEntree);
            formData.append('ingredients', this.entree.ingredients);
            formData.append('file', this.image);*/

            


                            //we send the form
                axios.post(URLAPI.URL+"/api/meal/addEntree", 
                {
                    'nameEntree':this.entree.nameEntree,
                    'ingredients': this.entree.ingredients,
                    'file':this.fileImage
                }, 
                configHeader)
                    .then((response) =>{
                        console.log(this.entree);
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