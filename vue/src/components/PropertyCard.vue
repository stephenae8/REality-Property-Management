<template>

<div class="card" >
    <a href="#" target="_blank">
<img :src="justOne[0].imgString[4]" alt="Apartment image">
    </a>
    <h6 style="font-size: 14px; text-align: center; margin-top: 1%;">{{justOne[0].address}}</h6>
    <p style="font-size: 12px; text-align: center;">{{ justOne[0].city }}, {{ justOne[0].state }}  {{ justOne[0].zipCode }}</p>
   
</div>
</template>

<script>
import PropertyService from '../services/PropertyService';
export default {
    
   

    
    data(){
        return{
            property: []
        }
    },
    methods:{
        propertyCreate(){
            PropertyService.getProperty().then((e)=>{
                this.property = e.data
            })
        }
    },

    computed: {
        justOne(){
            let oneProperty = {}
        oneProperty = this.property.filter((e)=>{
                if( this.$route.params.id == e.propId){
                    return e
                }[0]                  
                 })  
                 
               return oneProperty
                }
              
            },

        created(){
        this.propertyCreate()
    }
    }



</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap'); 

.card {
    width: 100%;
    max-width: 350px;
    padding: 8px 8px;
    margin-bottom: 16px;
    height: 100%;
    transition: transform 0.4s, box-shadow 0.4s;
    border: 1px solid rgba(230, 221, 221, 0.555);

    img {
        max-height: 300px;
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-top-left-radius: 16px;
        border-top-right-radius: 16px;
        transition: transform 0.4s;
    }

    h3 {
        padding: 16px;
    }

    p {
        color: rgb(107, 105, 105);
        padding-top: 10px;
        transition: transform 0.4s;
        font-family: 'Roboto', sans-serif;
        font-size: small;

    }

    &:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        
        img {
            transform: scale(1.05);
        }
        
        h3 {
            color: rgb(163, 228, 159);
        }

        p {
            transform: scale(1.05);
            color: rgb(0, 0, 0);

        }
        .card{
            transform: scale(1.05);
        }
    }
    
}


</style>

