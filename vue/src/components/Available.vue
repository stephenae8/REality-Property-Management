<template>
    <div id="main">
        <span style="display: flex; height: 60px;align-items: center;">
            <div id="opt" >
                <div id="searchbox" >
                    <span id="checkBox" style="display: inline-flex;">
                        <input type="text" no-focus placeholder="Columbus, OH" style="width: 250px; border-radius:13px; border: none;margin-left: 10%;margin-top: .1%; " >
                        <img  src="../img/socialMediaHandle/search.png" alt="">
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <label id="label" for="">Price</label>
                        <select id="select"  name="" style="position: relative;" >
                            
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <label id="label" for="">Price</label>
                        <select id="select"  name="" style="position: relative;" >
                            
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <label id="label" for="">Price</label>
                        <select id="select"  name="" style="position: relative;" >
                            
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                        
                    </span>
                </div>
                <div id="secondbox" >
                    <span style="display: inline-flex;">
                        <label id="label" for="">Price</label>
                        <select id="select"  name="" style="position: relative;" >
                            
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                        
                    </span>
                </div>
            </div>
        </span>
        <div id="secondMain" style="border: 1px solid black;">
            <div style="margin-bottom: 2%;"  v-for="one in getthemAll" :key="one.propId">
            <DifferentCard  :-one-individual="one" ></DifferentCard>
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
            allProperty: []
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
        getthemAll(){
            let newArray = [];
            return newArray = this.allProperty
        }
    }

}
</script>

<style scoped>

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
    margin-left: 2%;
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