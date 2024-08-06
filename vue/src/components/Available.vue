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
        <div id="secondMain">
        <PropertyCard></PropertyCard>
    </div>
      
    </div>

  
</template>

<script>
import PropertyCard from './PropertyCard.vue';
export default {
    components: {
        PropertyCard
    }
}
</script>

<style scoped>

#secondMain{
    margin-left: 10%;
    border: 1px solid black;
    width: 80%;
    padding: 10px;
}


#opt{
    border: 1px solid black; 
    height: 50px; 
    width: 100%;
     display: flex;
     justify-content: center;
}


#main{
    height: 800px;
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


</style>