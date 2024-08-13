<template>
  <div id="mainBox">
    <span id="welcome">
        <h6 style="margin-left: 5%;font-size: 20px; height: 30px;">Dashboard</h6>
       <h6 style="font-size: 20px;margin-right: 3%;">Welcome {{ user.lName }}</h6> 
    </span>
    <div id="secondBox" >
    <div id="funcontent">
      <span id="smalltext">
        <h6 style="font-size: 20px; display: inline-block; margin-top: 1%;margin-left: 3%;">Agreement</h6>
      </span>
      <div id="firstHalf" >
        <span style="border: 1px solid black; width: 45%; display:block; height: 400px;">
          <span id="justText" >
          <h6 style="display: inline-block; font-size: 20px;">Property</h6>
          </span>
          <hr>
          <span>
          <h6 style="text-align: center; font-size: 18px; font-weight: bold;">Vacancy</h6>
          <p style="margin-top: 2%;border: 1px solid black;">HERE ARE ALL YOUR AVAILABLE PROPERTY</p>
          <hr style="width: 50%; margin-left: 25%;">
          <h6 style="font-weight: bold; font-size: 18px; text-align: center;">Property Owned</h6>
          <p style="border: 1px solid black;">HERE IS ALL YOUR OWN PROPERTY</p>
          <hr style="width: 50%; margin-left: 25%;">
          <h6></h6>

        </span>
        </span>
        <span style="border: 1px solid black; width:45%; display: block; height: 400px;"></span>
      </div>

    </div>
    <div style="border: 1px solid black; height: 650px; margin-top:2%; width:20%; ">
      <span style="border-bottom: 1px solid black; display: flex; height: 50px;">
        <h6 style="font-size: 20px; display: block; margin-top: 2.3%;margin-left: 34%;">New Feed</h6>
      </span>

    </div>
  </div>

  </div>
  
</template>

<script>

export default {
  data(){
    return{
      user: this.$store.state.user,
      
    }
    
  },


  
  
}
</script>

<style scoped>
canvas{
  width: 600px;
  height: 600px;
}


#mainBox{
  border: 1px solid black; height: 800px;
}

#welcome{
  display: flex; 
  border: 1px solid black;
   justify-content: space-between; 
   background-color: rgba(211, 211, 211, 0.849);
   align-items: center;height: 50px;
}

#secondBox{
  display: flex;
   justify-content: space-evenly;

}

#funcontent{
  border: 1px solid black; 
  height: 650px;
  margin-top:2%; 
  width:75%;

}

#smalltext{
  border-bottom:1px solid black ;
  display: flex; 
  height: 50px;

}

#firstHalf{
   height: 400px; 
   margin-top: 4%; 
   display: flex; 
   justify-content: space-evenly; 
   align-items: center;

}

#justText{
  width: 100%; 
  display: flex;
  justify-content: 
  center;height: 10%;
  align-items: center;
  margin-top: 2%;
}



</style>