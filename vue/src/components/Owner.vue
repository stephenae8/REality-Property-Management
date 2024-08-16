<template>
  <div v-if="this.$store.state.user.authorities[0].name == 'ROLE_OWNER'">
  <div id="mainBox" :class="{background: addProp }">
    <span id="welcome">
        <h6 id="dashboard-title">Dashboard</h6>
       <h6 id="welcome-message">Welcome {{ user.fName }} {{ user.lName }}</h6> 
    </span>
    <div id="secondBox" >
    <div id="funcontent">
      <span id="smalltext">
        <h6 id="agreement-title">Agreement</h6>
      </span>
      <div id="firstHalf" >
        <span class="property-box">
          <span id="justText" >
          <h6 class="section-title">Property</h6>
          </span>
          <hr>
          <span>
      <h6 class="subsection-title">Vacancy</h6>
      <span class="vacancy-info">
        <img src="../img/icons8-building-100 (1).png" alt="" class="icon">
      <p class="stats-box">Current Percentages of Properties Occupied: <b>{{ displayVacancy }}% </b></p>
      </span>
      <hr class="short-hr">
      <h6 class="subsection-title">Property Owned</h6>
      <span class="property-owned-info">
        <img src="../img/icons8-property-50.png" alt="" class="icon">
      <p class="stats-box">You Currently Have a Total of: <b>{{ displayAllProp }}</b> Properties </p>
    </span>
      <hr class="short-hr">
    </span>
    </span>
    <span class="report-box">
    <span class="report-title-container">
    <h6 class="section-title">Report Logs</h6>
    </span>
    <hr>
    <h6 class="subsection-title">Operating expenses</h6>
    <span class="expense-info">
      <img src="../img/socialMediaHandle/icons8-expenses-66.png" alt="" class="icon">
      <p class="stats-box">Your Current Net Profit Based On All Properties: <b>${{ displayNetProfit }}</b></p>
    </span>
    <hr class="short-hr">
    <h6 class="subsection-title">Maintenance expenses</h6>
    <span class="maintenance-info">
      <img src="../img/socialMediaHandle/icons8-general-ledger-50.png" class="icon" alt="">
      <p class="stats-box">Your Total Expenses of Based On All Properties: <b>${{ displayRevenue }}</b></p>
    </span>
    <hr class="short-hr">
    </span>
  </div>

  <div id="add-property-button-container">
    <button @click="addProp = true, realCase = false" class="color add-property-button">Add Property</button>
  </div>
  <div v-show="addProp" id="add-property-form">
    <span id="add-property-container">
            <h4 id="add-property-title">Add A Property</h4>
            <p id="add-property-instruction">Please fill out all sections to add a new property!</p>
            <div id="form-container">
            <span class="form-column">
              <span class="form-field">
                <label class="form-label">State</label>
                <select v-model="application.state" class="state-select" name="">
                  <option  value="">Select State</option>
                  <option v-for="state in states" :key="state" :value="state">{{ state }}</option>
                </select>
              </span>
                <label class="form-label">City: </label>
               <input v-model="application.city" type="text" class="form-input" required>
                <label class="form-label">Zip Code:</label>
                <input v-model="application.zipCode" type="text" class="form-input" required>
                <label class="form-label">Address: </label>
                <input v-model="application.address" type="text" class="form-input" required>
                <label class="form-label">Rent:</label>
                <input v-model="application.rent" type="text" class="form-input" required>
                <label class="form-label">Bed:</label>
                <input v-model="application.bedrooms" type="text" class="form-input" required>
                <label class="form-label">Bathroom:</label>
                <input v-model="application.bathrooms" type="text" class="form-input" required>
                <label class="form-label">Property Image URL:</label>
                <input v-model="images.imageURL" type="text" class="form-input" >
            </span>
            <span class="form-column">
              <h6 class="amenities-title">Add Amenities</h6>
            
              <div class="amenities-container">
                <label class="amenity-label" for="">Pets: </label><br>
                <select v-model="amenities.pets_allowed" class="amenity-select" name="" id="">
                  <option value="">Pets allowed?</option>
                  <option value="true">Yes</option>
                  <option value="false">No</option>
                </select>
                <label class="amenity-label" for="">Dishwasher</label>
                <select v-model="amenities.dishwasher" class="amenity-select" name="" id="">
                  <option value="">Dishwasher?</option>
                  <option value="true">Yes</option>
                  <option value="false">No</option>
                </select>
                <label class="amenity-label" for="">Air Conditioner</label>
                <select v-model="amenities.central_air" class="amenity-select" id="">
                  <option value="">Air Conditioning?</option>
                  <option value="true">Yes</option>
                  <option value="false">No</option>
                </select>
                <label class="amenity-label" for="">Laundry</label>
                <select v-model="amenities.laundry" class="amenity-select" id="">
                  <option value="">In-Unit Laundry?</option>
                  <option value="true">Yes</option>
                  <option value="false">No</option>
                </select>
              </div>
            </span>
          </div>
          <span id="form-buttons">
                <button @click="createdApplication" class="button small submit-button">Submit</button>
                <button @click="closeAdd" class="button grey small close-button">Close</button>
            </span>
        </span>
  </div>
</div>
<div id="news-feed">
  <span id="news-feed-header">
    <h6 id="news-feed-title">New Feed</h6>
  </span>

  <span id="repair-feed">
    <h6 class="feed-subtitle">Repair Feed</h6>
    <hr class="short-hr">
    <span v-for="oneGuy in displayfeed" :key="oneGuy.propId" class="feed-item">
      <span>
      <img src="../img/socialMediaHandle/icons8-repair-50.png" class="feed-icon" alt="">
     </span>
      <span class="feed-content">
      <p class="feed-text">Request on Property {{ oneGuy.propId }}, <b>{{ oneGuy.issueType.substring(0,1).toUpperCase()+oneGuy.issueType.substring(1) }}</b> </p>
      <p class="feed-text">Last Updated {{ oneGuy.lastUpdated.split("-")[0] }}/{{ oneGuy.lastUpdated.split("-")[1] }}/{{ oneGuy.lastUpdated.split("-")[2].split("T")[0] }}, Status {{ oneGuy.reqStatus.substring(0,1).toUpperCase()+oneGuy.reqStatus.substring(1).replace("_", " ") }}</p>
    </span>
    </span>
  </span>
  <span id="approved-feed">
    <h6 class="feed-subtitle">Aprroved</h6>
    <hr class="short-hr">
    <span v-for="here in getFeedApp" :key="here.propId" class="feed-item">
      <img src="../img/socialMediaHandle/icons8-approved-50.png" class="feed-icon-approved" alt="">
      <p class="feed-text">Building # <b>{{ here.propId }}</b> just got approved on: <p class="feed-date"> {{ here.appDate.split("-")[0] }}/{{ here.appDate.split("-")[1] }}/{{ here.appDate.split("-")[2].split("T")[0]}}</p></p>
    </span>
  </span>
</div>
  </div>
  <div v-show="realCase" id="properties-showcase">
    <h3 id="properties-title">Your Properties</h3>
    <span id="properties-container">
      <div v-for="oneOne in getFourProp" :key="oneOne.propId">
   <router-link class="property-link" :to="{name: 'property', params: {id: oneOne.propId}}"> <DifferentCardVue :OneIndividual="oneOne" ></DifferentCardVue> </router-link>
      </div>
    </span>
    <span id="view-all-container">
      <button class="button view-all-button" @click="pushToAvailable">Click To View All</button>
    </span>
  </div>
  </div>
</div>
<div v-else>
  <div id="unauthorized-container">
   <button @click="goback" class="button gray go-back-button">Go Back To Home Page</button>
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
        pets_allowed: '',
        dishwasher: '',
        central_air: '',
        laundry: ''
      },

      images: {
        imageURL: ''
      },
      states: [
      "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", 
      "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", 
      "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", 
      "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", 
      "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
      ],

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
      console.log(storethem)

      PropertyService.createProperty(storethem).then((e)=>{
      // this.application.address = '';
      // this.application.bathrooms = '';
      // this.application.bedrooms = '';
      // this.application.city = '';
      // this.application.rent = '';
      // this.application.state = '';
      // this.application.zipCode = '';
      // this.amenities.centralAir = '';
      // this.amenities.petsAllowed = '';
      // this.amenities.laundry = '';
      // this.amenities.dishwasher= '';
      alert('Property successfully added!')
      this.addProp = false;
      this.realCase = true;


      })
      .catch(error => {'Error creating property', error})

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
    pushToAvailable(){
      
      this.$router.push({name: 'Available', query: {secondsearch: this.ownerProp[0].ownerId}})
    }

  




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
/* Base styles (for mobile devices) */
.background {
  background: rgba(2, 2, 2, 0.681);
}

#mainBox {
  border: 1px solid black;
  padding: 10px;
}

#welcome {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgba(211, 211, 211, 0.849);
  padding: 10px;
  height: auto;
}

#dashboard-title, #welcome-message {
  font-size: 16px;
  margin: 5px 0;
}

#secondBox {
  display: flex;
  flex-direction: column;
}

#funcontent {
  border: 1px solid black;
  margin-top: 10px;
  width: 100%;
}

#smalltext {
  border-bottom: 1px solid black;
  display: flex;
  height: 50px;
}

#agreement-title {
  font-size: 18px;
  display: inline-block;
  margin: 10px 0;
}

#firstHalf {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.property-box, .report-box {
  border: 1px solid black;
  width: 100%;
  margin-bottom: 20px;
  padding: 10px;
}

#justText {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
}

.section-title {
  display: inline-block;
  font-size: 18px;
}

.subsection-title {
  text-align: center;
  font-size: 16px;
  font-weight: bold;
}

.vacancy-info, .property-owned-info, .expense-info, .maintenance-info {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.icon {
  width: 40px;
  margin-bottom: 10px;
}

.stats-box {
  margin-top: 10px;
  border: 1px solid black;
  width: 90%;
  text-align: center;
  border-radius: 5px;
  padding: 5px;
}

.short-hr {
  width: 80%;
  margin: 15px auto;
}

.report-title-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: auto;
  margin: 10px 0;
}

.button, .color {
  border-radius: 10px;
  display: block;
  width: 100%;
  padding: 10px;
  background: #73b680;
  color: white;
  border: 1px solid white;
  font-size: 14px;
  margin: 10px 0;
}

.button:hover, .color:hover {
  background: green;
}

.grey {
  background: darkgray;
}

.grey:hover {
  background: gray;
}

#add-property-button-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.add-property-button {
  height: 60px;
  width: 120px;
  /* border-radius: 50%; */
  font-size: 12px;
}

#add-property-form {
  width: 100%;
  margin-top: 20px;
}

#add-property-container {
  width: 100%;
  padding: 10px;
}

#add-property-title {
  color: white;
  text-align: center;
  margin-top: 10px;
}

#add-property-instruction {
  color: white;
  text-align: center;
  margin: 10px 0;
}

#form-container {
  display: flex;
  flex-direction: column;
}

.form-column {
  width: 100%;
  margin-bottom: 20px;
}

.form-label {
  color: white;
  display: block;
  margin-top: 10px;
}

.form-input, .state-select, .amenity-select {
  width: 100%;
  margin-bottom: 10px;
  padding: 5px;
}

.amenities-title {
  color: white;
  font-size: 16px;
  margin-top: 20px;
}

.amenities-container {
  margin-top: 10px;
}

.amenity-label {
  margin-top: 10px;
  display: block;
  color: white;
}

#form-buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.submit-button, .close-button {
  width: 48%;
}

#news-feed {
  border: 1px solid black;
  margin-top: 20px;
  width: 100%;
  padding: 10px;
}

#news-feed-header {
  border-bottom: 1px solid black;
  padding: 10px 0;
}

#news-feed-title {
  font-size: 18px;
  text-align: center;
}

#repair-feed, #approved-feed {
  margin-top: 20px;
}

.feed-subtitle {
  text-align: center;
  font-weight: bold;
}

.feed-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 15px 0;
}

.feed-icon, .feed-icon-approved {
  width: 30px;
  margin-bottom: 10px;
}

.feed-content {
  text-align: center;
}

.feed-text {
  margin: 5px 0;
}

.feed-date {
  font-weight: bold;
}

#properties-showcase {
  border: 1px solid black;
  width: 100%;
  margin-top: 20px;
  padding: 10px;
}

#properties-title {
  text-align: center;
  margin: 15px 0;
  font-weight: bold;
  font-style: italic;
}

#properties-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.property-link {
  text-decoration: none;
  color: black;
  margin: 10px 0;
}

#view-all-container {
  display: flex;
  justify-content: center;
  margin: 20px 0;
}

.view-all-button {
  width: 50%;
}

#unauthorized-container {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.go-back-button {
  width: 80%;
  max-width: 300px;
}

/* Tablet styles */
@media screen and (min-width: 768px) {
  #welcome {
    flex-direction: row;
    justify-content: space-between;
  }

  #secondBox {
    flex-direction: row;
  }

  #funcontent {
    width: 70%;
  }

  #firstHalf {
    flex-direction: row;
    justify-content: space-between;
  }

  .property-box, .report-box {
    width: 48%;
  }

  #news-feed {
    width: 28%;
  }

  #form-container {
    flex-direction: row;
    justify-content: space-between;
  }

  .form-column {
    width: 48%;
  }

  #properties-container {
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
  }

  .view-all-button {
    width: 30%;
  }
}

/* Desktop styles */
@media screen and (min-width: 1024px) {
  #mainBox {
    max-width: 1200px;
    margin: 0 auto;
  }

  #dashboard-title, #welcome-message {
    font-size: 20px;
  }

  #funcontent {
    width: 75%;
  }

  #news-feed {
    width: 23%;
  }

  .button, .color {
    font-size: 16px;
  }

  #add-property-form {
    width: 80%;
    margin: 0 auto;
  }

  #properties-showcase {
    width: 96.8%;
    margin-left: 1.6%;
  }

  .view-all-button {
    width: 20%;
  }
}

/* Large desktop styles */
@media screen and (min-width: 1440px) {
  #mainBox {
    max-width: 1400px;
  }

  #funcontent {
    width: 80%;
  }

  #news-feed {
    width: 18%;
  }

  #add-property-form {
    width: 70%;
  }

  .view-all-button {
    width: 15%;
  }
}
</style>

