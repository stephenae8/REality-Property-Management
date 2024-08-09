<template>
    <div id="main">
        <span style="display: flex; height: 60px;align-items: center;">
            <div id="opt" >
                <div id="searchbox" >
                    <span id="checkBox" style="display: inline-flex;">
                        <input v-model="this.searchTerm" type="text" no-focus placeholder="Columbus, OH" style="width: 250px; border-radius:13px; border: none;margin-left: 10%;margin-top: .1%; " >
                        <img src="../img/socialMediaHandle/search.png" alt="">
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <select v-model="this.priceup" style="margin-left: 12px; margin-top: %; width: 100%;padding: 2px;" id="avabig"  name=""  >
                            <option value="" >Price</option>
                            <option >$950</option>
                            <option >$1100</option>
                            <option >$1300</option>
                            <option >$1300+</option>
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <select v-model="this.available" style="margin-left: 3px; margin-top: 1.5%; width: 90%;" id="avabig"  >
                            <option value="" >Choose One</option>

                            <option>Available</option>
                            <option >Not Available</option>
                          
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <select v-model="this.bedroom" style="margin-left: 3px; margin-top: 1.5%; width: 90%;" id="avabig"  name=""  >
                            <option >Bedroom</option>
                            <option >2 Bedroom</option>
                            <option >3 Bedroom</option>
                            <option >4 Bedroom</option>
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <select v-model="this.amenities" style="margin-left: 1px; margin-top: 1.5%; width: 95%;" id="avabig"  name=""  >
                            <option value="">Amenities</option>
                            <option>Pets Allowed</option>
                            <option>In-Unit Washer & Dryer</option>
                            <option>Bathroom</option>
                        </select>
                        
                    </span>
                </div>
            </div>
        </span>
        <div id="secondMain" style="border: 1px solid black;">
            <div style="margin-bottom: 2%;"  v-for="one in filterBaseOn" :key="one.propId">
       <router-link style="text-decoration: none; color: rgba(0, 0, 0, 0.841);" :to="{name: 'property', params: {id: one.propId}}">    <DifferentCard  :-one-individual="one" ></DifferentCard></router-link> 
            </div>

    </div>
      
    </div>

  
</template>

<script>
import PropertyService from '../services/PropertyService.js';
import PropertyCard from './PropertyCard.vue';
import DifferentCard from './DifferentCard.vue';

export default {
  

    data(){
        return{
            allProperty: [],
            searchTerm: this.$route.query.search,
            available: '',
            willNumber: '',
            priceup: '',
            bedroom: '',
            amenities: '',
            
        }
    },
    
    components: {
        DifferentCard
    },

    methods:{
        getproperty(){
            PropertyService.getProperty().then((e)=>{
                this.allProperty = e.data
            })
        }
    },
    created(){
        this.getproperty()
    },

    computed: {
       
        filterBaseOn(){
            let newList = this.allProperty

            if(this.searchTerm == ''){
             newList = this.allProperty
            }
            
            if(this.searchTerm != ''){
                newList = newList.filter((e)=>{
                    if(e.city.toLowerCase().match(this.searchTerm.toLowerCase())){
                        return e
                    }
                })
            }
            if(this.available == "Available"){
                newList = newList.filter((e)=>{
                    if(e.vacancy == true){
                        return e
                    }
                })
            }

            if(this.available == "Not Available"){
                newList = newList.filter((e)=>{
                    if(e.vacancy == false){
                        return e
                    }
                })
            }

            if(this.willNumber == "1 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 1){
                        return e
                    }
                })
            }

            if(this.willNumber == "2 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 2){
                        return e
                    }
                })
            }

            if(this.willNumber == "3 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 3){
                        return e
                    }
                })
            }

            if(this.willNumber == "4 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 4){
                        return e
                    }
                })
            }
            
            
            if(this.priceup == "$950"){
                newList = newList.filter((e)=>{
                    if(e.rent>900 && e.rent<1000){
                        return e
                    }
                })
            }

            if(this.priceup == "$1100"){
                newList = newList.filter((e)=>{
                    if(e.rent>1000 && e.rent<1200){
                        return e
                    }
                })
            }

            if(this.priceup == "$1300"){
                newList = newList.filter((e)=>{
                    if(e.rent>1200 && e.rent<1300){
                        return e
                    }
                })
            }

            if(this.priceup == "$1300+"){
                newList = newList.filter((e)=>{
                    if(e.rent>1300){
                        return e
                    }
                })
            }

            if(this.priceup == "$1300+"){
                newList = newList.filter((e)=>{
                    if(e.rent>1300){
                        return e
                    }
                })
            }
            
            if(this.bedroom == "2 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 2){
                        return e
                    }
                })
            }

            if(this.bedroom == "3 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 3){
                        return e
                    }
                })
            }

            if(this.bedroom == "4 Bedroom"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 4){
                        return e
                    }
                })
            }

            if(this.amenities == "Pets Allowed"){
                newList = newList.filter((e)=>{
                    if(e.bedrooms == 4){
                        return e
                    }
                })
            }
            


            return newList;
        }
    }

}
</script>

<style scoped>

#avabig{
    
    /* height: 17px; */
    border: none;
 
}

#secondMain{
    margin-top: 1%;
    width: 95%;
    margin-left: 3%;
    padding: 10px;
    display: flex;
    flex-wrap: wrap;
    height: auto;
    justify-content:space-evenly;

}


#opt{
    border: 1px solid black; 
    height: 50px; 
    width: 100%;
     display: flex;
     justify-content: center;
}


#main{
    height: auto;
}

#secondbox{
    border: 1px solid black;
    height: 30px;
    margin-left: 1%;
    margin-top: .5%;
    width: 100px;
    border-radius: 7px;
    
}

#searchbox{
    
    border: 1px solid black;
    border-radius: 10px; 
    width: 15%;
    margin-top: .5%;
    height: 30px;
    
}

img{
    margin-top: 2%;
    height: 3%;
    width: 17px;
    margin-left: 5%;
}

#select{
    height: 8px;
    border: none;
    margin-top: 12.5%;
}

#ava{
    margin-bottom:3px ;
    width: 80px;
    /* margin-top: 3%; */
    
    /* border: 1px solid black; */
    text-align: center;
    /* width: 65px; */
}

#label{
    margin-bottom:3px ;
    width: 50px;
    margin-top: 3%;
    
    /* border: 1px solid black; */
    text-align: center;
    width: 65px;
}

input:focus{
    outline: none;
}

</style>