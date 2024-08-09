<template>
    <div  :class="{not: OneIndividual.vacancy , card: !OneIndividual.vacancy }">
        <a href="#" target="_blank" style="max-height: 221px; height: 100%;"> <!-- i added a max height and height 100% for card size continuity -->
    <img :src="OneIndividual.imgString[0]" alt="Apartment image">
        </a>
        <h6 style="font-size: 14px; text-align: center; margin-top: 2%;">{{OneIndividual.address}}</h6>
        <h6 style="font-size: 12px; text-align: center;">{{OneIndividual.city }}, {{ OneIndividual.state }}  {{ OneIndividual.zipCode }}</h6>
        <h6 style="text-align: center;">${{ OneIndividual.rent }}</h6>
        <p v-if="OneIndividual.vacancy" style="text-align: center; font-weight: bold;">Available</p>
        <p v-else style="text-align: center; font-weight: bold;">Not Available</p>
       
    </div>
    </template>
    
    <script>
    import PropertyService from '../services/PropertyService';
    export default {
        
        props:{
            OneIndividual: Object
        },
    
        
        data(){
            return{
                property: [],
                change: this.OneIndividual.vacant,
                status:String
            }
        },
        methods:{
            propertyCreate(){
                PropertyService.getProperty().then((e)=>{
                    this.property = e.data
                })
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
        border: 1px solid rgba(206, 42, 56, 0.493);
    
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
            color: rgba(187, 58, 58, 0.897);
            padding-top: 10px;
            transition: transform 0.4s;
            font-family: 'Roboto', sans-serif;
            font-size: small;
    
        }
    
        &:hover {
            box-shadow: 0 8px 16px rgba(236, 24, 52, 0.2);
            
            img {
                transform: scale(1.05);
            }
            
            h3 {
                color: rgb(177, 40, 52);
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

    .not {
        width: 100%;
        max-width: 350px;
        padding: 8px 8px;
        margin-bottom: 16px;
        height: 100%;
        transition: transform 0.4s, box-shadow 0.4s;
        border: 1px solid rgba(60, 161, 46, 0.493);
    
        img {
            max-height: 230px;
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
            color:  rgb(45, 131, 28);
            padding-top: 10px;
            transition: transform 0.4s;
            font-family: 'Roboto', sans-serif;
            font-size: small;
    
        }
    
        &:hover {
            box-shadow: 0 8px 16px rgba(26, 179, 26, 0.2);
            
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
            .not{
                transform: scale(1.05);
            }
        }
        
    }
    
    
    </style>