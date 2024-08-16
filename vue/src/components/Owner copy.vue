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
    <button @click="addProp = true, realCase = false" class="color add-property-button">Add More Properties</button>
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