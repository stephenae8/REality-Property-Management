<template>
    <div id="footer" >
        <span class="mside" >
            <!-- <img style="margin-left: 35%; width: 110px; display: inline; margin-top: 4%;" src="../img/icons8-real-estate-100.png" alt=""> -->

            <h4 style=" text-align: center;font-size: 60px; font-family:'Times New Roman', Times, serif;margin-top: 6%;">A2DS2.com</h4>
            <p style=" display: flex;justify-content: flex-end;width: 50%;margin-left: 32%; font-weight: 700;">&copy;2024 DreamStar Group, Inc.</p>
            <span style="display: block; height: 50px;   width: 65%;margin-left: 23%; ">
             <a href="#"> <img style="width: 40px;" src="../img/socialMediaHandle/icons8-facebook-100.png" alt=""></a> 
             <a href="#"><img style="width: 40px;" src="../img/socialMediaHandle/icons8-instagram-100.png" alt=""></a>
             <a href="#"><img style="width: 40px;" src="../img/socialMediaHandle/icons8-linkedin-100.png" alt=""></a> 
             <a href="#"><img style="width: 40px;" src="../img/socialMediaHandle/icons8-tiktok-100.png" alt=""></a> 
              <a href="#"><img style="width: 40px;" src="../img/socialMediaHandle/icons8-twitterx-100.png" alt=""></a>
              <a href="#"><img style="width: 40px;" src="../img/socialMediaHandle/icons8-youtube-100.png" alt=""></a> 
              <a href="#"><img style="width: 37px;" src="../img/socialMediaHandle/icons8-about-us-100.png" alt=""></a>
            </span>
            <span style="display: flex; justify-content: flex-end; width: 81%;"><em>Equal Housing Opportunity </em></span>
        </span>
        <span class="rest" style="display:flex ;">
            <span class="oneside">
                <h4 style="margin-top: 15%;text-align: center;font-size: 17px;font-weight: bold;">Advertiser</h4>
                <span style="display: block; text-align: center; margin-top: 3%;">
                   <router-link to="" style="display: block;color: black;text-decoration: none;font-size: 15px;"> Advertise</router-link>
                  <router-link to="" style="display: block;color: black;text-decoration: none;"> Customer Portal</router-link> 
                 <router-link to="" style="color: black;text-decoration: none;">Community Voice</router-link>
                </span>
            </span>
        <span class="oneside">
            
                <h4 style="margin-top: 15%;text-align: center;font-size: 17px;font-weight: bold;">ABOUT US</h4>
                <span style="display: block; text-align: center; margin-top: 3%;">
                   <router-link to="" style="display: block;color: black;text-decoration: none;font-size: 15px;"> About Us</router-link>
                  <router-link to="" style="display: block;color: black;text-decoration: none;"> Contact Us</router-link> 
                 <router-link to="" style="display: block;color: black;text-decoration: none;">Legal Notices</router-link>
                 <router-link to="" style="display: block;color: black;text-decoration: none;">Private Notice</router-link>
                 <router-link to="" style="display: block; color: black;text-decoration: none;">Avoid Scams</router-link>


                
            </span>
        </span>
        <span class="oneside">
            
                <h4 style="margin-top: 15%;text-align: center;font-size: 17px;font-weight: bold;">CITY</h4>
                <span style="display: block; text-align: center; margin-top: 3%;">
                   <router-link to="#" style="display: block;color: black;text-decoration: none;font-size: 15px;">New York</router-link>
                  <router-link to="#" style="display: block;color: black;text-decoration: none;">Philadelphia</router-link> 
                 <router-link to="#" style="color: black;text-decoration: none;">Austin</router-link>
                 <router-link to="#" style="display: block;color: black;text-decoration: none;font-size: 15px;">Tulsa</router-link>
                  <router-link to="#" style="display: block;color: black;text-decoration: none;">Atlanta</router-link> 
                 <router-link to="#" style="color: black;text-decoration: none;">New Jersey</router-link>
             
            </span>

        </span>

    </span>
   </div>
  
</template>

<script>
export default {

}
</script>

<style scoped>
#footer{
    padding: 30px;
    display: flex;
    height: 400px;
    background-color: lightgray;
}

.mside{
    margin-left: 3px;
    width: 25%;
    display: block;
}

.rest{
    /* border: 1px solid black; */
    width: 75%;
}

.oneside{
    margin-left: 5px;
    width: 33%;
    /* border: 1px solid black; */

}

#whole{
    background-color: lightgray;

}


</style>