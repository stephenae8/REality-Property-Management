<template>
  <div v-if="this.$store.state.user.authorities[0].name == 'ROLE_OWNER'">
   
  <div id="mainBox" :class="{background: addProp }">
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
          <span style="display:flex; justify-content: space-evenly;">
            <img src="../img/icons8-building-100 (1).png" alt="" style="width: 50px;">
          <p style="margin-top: 2%;border: 1px solid black; width: 80%;text-align: center;border-radius: 5px;">Current Percentages of Properties Occupated: <b>{{ displayVacancy }}% </b></p>
          </span>
          <hr style="width: 50%; margin-left: 25%;">
          <h6 style="font-weight: bold; font-size: 18px; text-align: center;">Property Owned</h6>
          <span style="display: flex; justify-content: space-evenly;">
            <img src="../img/icons8-property-50.png" alt="" style="width: 50px;">
          <p style="border: 1px solid black;width: 80%;text-align: center;">You Currently Have an Total of: <b>{{ displayAllProp }}</b> Properties </p>
        </span>
          <hr style="width: 50%; margin-left: 25%;">
<span style="display: flex; justify-content: center;">
  <button style="width: 35%;" class="button">Click To View More </button>
</span>

        </span>
        </span>
        <span style="border: 1px solid black; width:45%; display: block; height: 400px;">
        <span style="display: flex; height: 12%;justify-content: center;align-items: center;">
        <h6 style="font-size: 20px;margin-top: 3%;">Report Logs</h6>
        </span>
        <hr>
        <h6 style="text-align: center;font-size: 18px; font-weight: bold;">Operating expenses</h6>
        <span style="display: flex;justify-content: center;justify-content: space-evenly; align-items: center;">
          <img src="../img/socialMediaHandle/icons8-expenses-66.png" alt="">
          <p style="border: 1px solid black;width: 80%;height: 25%;text-align: center;border-radius: 5px;">Your Current Net Profit Based On All Properties: <b>${{ displayNetProfit }}</b></p>
        </span>
        <hr style="width: 50%;margin-left: 25%;">
        <h6 style="text-align: center;font-size: 18px;font-weight: bold;">Maintenance expenses</h6>
        <span style="display: flex; height: 12%;justify-content: center;justify-content: space-evenly;align-items: center;">
          <img src="../img/socialMediaHandle/icons8-general-ledger-50.png" style="width: 50px;" alt="">
          <p style="width: 80%;border: 1px solid black;margin-top: 1%;border-radius: 3px; text-align: center;">Your Total Expenses of Based On All Propeties: <b>${{ displayRevenue }}</b></p>
        </span>
        <hr style="width: 50%;margin-left: 25%;">
        <span style="display: flex; justify-content: center;">
          <button style="width: 35%;" class=" grey">Show more Details </button>
        </span>
        </span>
      </div>

      <div style=" height: 100px; display: flex; justify-content: center; align-items: center;">
        <button @click="addProp = true, realCase = false" class="color" style="height: 80px; width: 80px; border-radius: 50%; font-size: 12px;margin-top: .9%;">Add More Properties</button>

      </div>
      <div v-show="addProp" style=" height: 47%;margin-top: 1.9%; display: flex;">
        <span style="display: block; width: 70%;  height: 650px; margin-left: 18%;">
                <h4 style="color: white;text-align: center; margin-top: 2%;">Add A Property</h4>
                <p style="color: white; width: 50%; margin-left: 26%; text-align: center;">Please fill out all the required section in order to add an new property!</p>
                <div style="display: flex;justify-content: flex-end;justify-content: space-evenly;">
                <span style="display: block; width: 40%; height: 74%;  ">
                  <span style=";display: block;width: 100%;">
                    <label style="color: white;display: block;">State</label>
                    <select v-model="this.application.state"  style=" color: black;width: 20%; margin-top: .3%;" name="">
                      <option  value="">Select State</option>
                        <option >PA</option>
                        <option >OH</option>
                        <option >NY</option>
                        <option >NJ</option>
                        <option >Other...</option>
                    </select>
                  </span>
                    <label style="color: white;display: block;margin-top: 1%;">City: </label>
                   <input v-model="this.application.city"  type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 1%;">Zip Code:</label>
                    <input v-model="this.application.zipCode"  type="text" style="width: 45%;" required>

                    <label style="color: white;display: block;margin-top: 1%;">Address: </label>
                    <input v-model="this.application.address"  type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 1%;">Rent:</label>
                    <input v-model="this.application.rent" type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 1%;">Bed:</label>
                    <input v-model="this.application.bedroom" type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 1%;">Bathroom:</label>
                    <input v-model="this.application.bathroom" type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 1%;">Please include an URL to your property:</label>
                    <input v-model="this.images.imgURL" type="text" style="width: 45%;" >
                 
                </span>
                <span style="display: block; width: 40%;">
                  <h6 style="color: white;font-size: 18px;">Add Amenities</h6>
                
                  <div style="height: 50%;margin-top: 2.5%;">
                    <label style="margin-top: 3%;" for="">Pets: </label><br>
                    <select v-model="this.amenities.petsAllowed" style="display: block;" name="" id="">
                      <option value="">Pets allowed</option>
                      <option >true</option>
                      <option >false</option>
                    </select>
                    <label style="margin-top: 3%;display: block;color: white;" for="">Dishwasher</label>
                    <select v-model="this.amenities.dishwasher" style="display: block;" name="" id="">
                      <option value=""></option>
                      <option>true</option>
                      <option>false</option>
                    </select>
                    <label style="display: block;margin-top: 3%;color: white;" for="">Air Conditioner</label>
                    <select v-model="this.amenities.centralAir" id="">
                      <option value=""></option>
                      <option>true</option>
                      <option>false</option>
                    </select>
                    <label style="display: block;margin-top: 3%;color: white;" for="">Laundry</label>
                    <select v-model="this.amenities.laundry" id="">
                      <option value=""></option>
                      <option>true</option>
                      <option>false</option>
                    </select>

                  </div>
             
                </span>
                
              </div>
              <span style="display: flex;margin-top: 3%;justify-content: space-evenly;">
                    <button @click="createdApplication"  class="button small" style= "width: 33%" >Submit</button>
                    <button @click="closeAdd" class="button grey small" style=";width: 33% ;">Close</button>
                </span>
            </span>

      </div>

    </div>
    <div style="border: 1px solid black; height: 650px; margin-top:2%; width:20%; ">
      <span style="border-bottom: 1px solid black; display: flex; height: 50px;">
        <h6 style="font-size: 20px; display: block; margin-top: 2.3%;margin-left: 39%;">New Feed</h6>
      </span>

      <span style=" height: 250px; display: block;margin-top: 2.5%;">
        <h6 style="text-align: center;font-weight: bold;">Repair Feed</h6>
        <hr style="width: 50%; margin-left: 25%;">
        <span v-for="oneGuy in displayfeed"  :key="oneGuy.propId" style="display: flex;  height: 35%; justify-content: center;justify-content: space-evenly;align-items: center;">
          <span >
          <img src="../img/socialMediaHandle/icons8-repair-50.png" style="width: 30px;" alt="">
         </span>
          <span style="display: block;">
          <p style="text-align: center;">Request on Property {{ oneGuy.propId }}, <b>{{ oneGuy.issueType.substring(0,1).toUpperCase()+oneGuy.issueType.substring(1) }}</b> </p>
          <p style=";text-align: center;">Last Updated {{ oneGuy.lastUpdated.split("-")[0] }}/{{ oneGuy.lastUpdated.split("-")[1] }}/{{ oneGuy.lastUpdated.split("-")[2].split("T")[0] }}, Status {{ oneGuy.reqStatus.substring(0,1).toUpperCase()+oneGuy.reqStatus.substring(1).replace("_", " ") }}</p>
        </span>
        </span>

      </span>
      <span style="display: block; height: 200px; ">
        <h6 style="text-align: center;font-weight: bold;">Aprroved</h6>
        <hr style="width: 50%;margin-left: 25%;">
        <span v-for="here in getFeedApp" :key="here.propId"  style="display: flex;height: 35%;justify-content: center;justify-content: space-evenly;align-items: center;">
          <img src="../img/socialMediaHandle/icons8-approved-50.png" style="width: 40px;height: 40px;margin-left: 8%" alt="">
          <p style="margin-top: 2%;width: 70%;">Building # <b>{{ here.propId }}</b> just got approved on: <p style="display: inline;margin-left: 30%;"> {{ here.appDate.split("-")[0] }}/{{ here.appDate.split("-")[1] }}/{{ here.appDate.split("-")[2].split("T")[0]}}</p></p>
          
        </span>
        
      </span>
      

    </div>
  </div>
  <div v-show="realCase" style="display: block;border: 1px solid black; width: 96.8%;margin-left: 1.6%;height: 550px;margin-top: 3%;">
    <h3 style="text-align: center;margin-top: 1.5%;font-weight: bold;font-style: italic;">Your Properties</h3>
    <span style="; display: flex;height: 65%;width: 95%;margin-left: 2%; margin-top: .5%;justify-content: center;justify-content: space-evenly;align-items: center;">
      <div v-for="oneOne in getFourProp" :key="oneOne.propId">
   <router-link style="text-decoration: none; color: black;" :to="{name: 'property', params: {id: oneOne.propId}}"> <DifferentCardVue :OneIndividual="oneOne" ></DifferentCardVue> </router-link>
      </div>
    </span>
    <span style="display: flex; height: 100px;justify-content: center;align-items: center;">
      <button style="width: 10%;height: 65%;" class="button">Click To View All</button>

    </span>

  </div>


  </div>

</div>
<div v-else>
  <div style="height: 700px; width: 100%; display: flex;justify-content: center;align-items: center;">
   
   <button style="width: 25%;" @click="goback" class="button gray">Go Back To Home Page</button>
  </div>
</div>
  
</template>

<script>
import LeaseService from '../services/LeaseService';
import PropertyService from '../services/PropertyService';
import ServiceRequest from '../services/RequestService';
import ApplicationService from '../services/ApplicationService';
import DifferentCardVue from './DifferentCard.vue';
export default {
  data(){
    return{
      user: this.$store.state.user,
      netProfit: '',
      totalAmount: '',
      totalRenevue: '',
      vacancyNumber: '',
      ownerProp: [],
      requestFeed: [],
      applicationfeed: [],
      green: false,
      application: {
        ownerId: this.$store.state.user.id,
        state: '',
        address: '',
        city: '',
        zipCode: '',
        vacancy: "true",
        pending: "true",
        rent: '',
        bedrooms: '',
        bathrooms: '',
      },

      amenities: {
        petsAllowed: '',
        dishwasher: '',
        centralAir: '',
        laundry: ''
      },

      images: {
        imageURL: ''
      },

      addProp: false,
      realCase: true
      
    }
  
  },

  components: {
    DifferentCardVue,
  },

  methods: {
    closeAdd(){
      this.addProp = false;
      this.realCase = true;
      

    },

    createdApplication(){
      
      let firstApp = this.application;
      let secondAm = this.amenities;
      let thirdImg = this.images;

      let storethem = {
        property: firstApp,
        amenities: secondAm,
        images: thirdImg
      }

      PropertyService.createProperty(storethem).then((e)=>{
      this.application.address = '';
      this.application.bathrooms = '';
      this.application.bedrooms = '';
      this.application.city = '';
      this.application.rent = '';
      this.application.state = '';
      this.application.zipCode = '';
      this.amenities.centralAir = '';
      this.amenities.petsAllowed = '';
      this.amenities.laundry = '';
      this.amenities.dishwasher= '';
      this.addProp = false;
      this.realCase = true;

      })

    },

    goback(){
      this.$router.push('/')
    },




    getNetProfit(){
       LeaseService.leaseNetProfit(this.user.id).then((e)=>{
        this.netProfit = e.data
      })
    },

    getTotal(){
      LeaseService.leaseTotal(this.user.id).then((e)=>{
        this.totalAmount = e.data
      })
    },

    getVacancy(){
      LeaseService.leaseVacancy(this.user.id).then((e)=>{
        this.vacancyNumber = e.data
      })
    },

    getTotalRevenue(){
      LeaseService.leaseByRevenue(this.user.id).then((e)=>{
        this.totalRenevue = e.data
      })
    },
    getProperty(){
      PropertyService.getPropertyByOwnerId(this.user.id).then((e)=>{
        this.ownerProp = e.data
      })
    },
    getService(){
      ServiceRequest.getRequestByOwnerId(this.user.id).then((e)=>{
        this.requestFeed = e.data
      })
    },
    getApplicationForNew(){
      ApplicationService.getAppNew(this.user.id).then((e)=>{
        this.applicationfeed = e.data

      })
    },




  },

  created() {
    if(this.$store.state.user.authorities[0].name == 'ROLE_OWNER'){
    this.getNetProfit();
    this.getTotal();
    this.getVacancy();
    this.getTotalRevenue();
    this.getProperty();
    this.getService();
    this.getApplicationForNew();
    }else{
      console.log("Worked")
    }
  },

  computed: {
    displayTotal(){
      let newTotal = 0;
      return newTotal = this.totalAmount
    },

    displayRevenue(){
      let change = 0;
      return change = this.totalRenevue
    },

    displayNetProfit(){
      let hereOne = 0;
      return hereOne = this.netProfit
    },

    displayVacancy(){
      let one = 0;
      return one = this.vacancyNumber
    },

    displayAllProp(){
      let allProp = 0;
      return allProp = this.ownerProp.length
    },

    displayfeed(){
      let newArrayOne = [];
      if(this.requestFeed.length>=2){
        return newArrayOne = [this.requestFeed[0], this.requestFeed[1]]
      }else{
        return newArrayOne = this.requestFeed
      }
    },

    getFeedApp(){
      let newArray = [];
      if(this.applicationfeed.length>=2){
        return newArray = [this.applicationfeed[0],this.applicationfeed[1], this.applicationfeed[2]]
      }else{
        return newArray = this.applicationfeed[0]
      }

    },

    getFourProp(){
      let fourArray = [];
      if(this.ownerProp.length>=6){
        return fourArray = [this.ownerProp[0], this.ownerProp[1], this.ownerProp[2], this.ownerProp[3], this.ownerProp[4], this.ownerProp[5]]
      }else{
        return fourArray = [this.ownerProp[0]]
      }
    }
  }


  
  
}
</script>

<style scoped>

.background{
  background: rgba(2, 2, 2, 0.681);
}
.grey{
  border-radius: 10px;
  display: block;
  width: 100%;
  padding: 10px;
  background: darkgray;
  color: white;
  border: 1px solid white;
}

.grey:hover{
  background: gray;
}


#mainBox{
  border: 1px solid black; 
}

#welcome{
  display: flex; 
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

.button {
  border-radius: 10px;
  display: block;
  width: 100%;
  padding: 10px;
  background: #73b680;
  color: white;
  border: 1px solid white;
}

.button:hover{
  background: green;
}

.color{
  padding: 10px;
  background: #73b680;
  color: white;
  border: 1px solid white;
}

.color:hover{
  background: gray;
  color: white;
}



</style>