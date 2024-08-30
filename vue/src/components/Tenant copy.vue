<template>
    <div>
      <div v-if="completed && secondCheck && thirdCheck && fourCheck">
        <div :class="{background: go}" v-if="leases.leaseStatus == 'active'">
          <div id="main">
            <span id="greeting">
              <h3>Hello {{ username.fName.substring(0,1).toUpperCase()+username.fName.substring(1) }}!</h3>
              <p class="address">{{ justOne.address }}, {{ justOne.city }},{{justOne.state}} {{justOne.zipCode}}</p>
            </span>
            <div id="box">
              <div id="justcolor"></div>
              <div id="status">
                <span id="smallspan">
                  <h2 id="h2span">Your current Balance is <b>${{ displayRent }}</b></h2>
                  <span class="payment-info">
                    <img src="../img/socialMediaHandle/icons8-payment-24.png" alt="">
                    <p class="inline-text">1 schedule payment</p>
                  </span>
                </span>
              </div>
              <div class="button-container">
                <button @click="balanceGood" v-show="checkCase" class="button small">Make a Payment</button><br>
                <button v-show="checkCase" class="button grey small">Set Up AutoPay</button>
              </div>
            </div>
            <div v-if="addRe" class="request-form">
              <span class="request-form-content">
                <h4 class="request-form-title">Send A requests</h4>
                <p class="request-form-description">Please provide us with the details on your property and we will have our team check it out. Please provide us with all the request details!</p>
                <span class="request-form-inputs">
                  <label>Date:</label>
                  <input v-model="this.request.date" class="date-input" type="date" name="" id="">
                  <label>Service Type: </label>
                  <select v-model="this.request.service" class="service-select" name="">
                    <option>dishwasher</option>
                    <option>central_air</option>
                    <option>laundry</option>
                    <option>bathroom</option>
                    <option>other</option>    
                  </select>
                  <label>Description:</label>
                  <textarea v-model="this.request.description" name="" cols="50" rows="4" class="description-textarea" placeholder="Please Add Your Request!"></textarea>
                  <span class="form-buttons">
                    <button @click="formGood" class="button small submit-button">Submit</button>
                    <button @click="closeForm" class="button grey small close-button">Close</button>
                  </span>
                </span>
              </span>
            </div>
  
            <div id="secondbox">
              <span class="secondcase">
                <h6 id="h6first">Open requests</h6>
                <hr>
                <span v-for="king in requestLoop" :key="king.reqId" class="request-item">
                  <img id="tinylogo" src="../img/socialMediaHandle/icons8-repair-32.png" alt="">
                  <div id="divfortext">
                    <p id="firsttext">{{king.reqDetails}}</p>
                    <p id="secondtext">{{ king.reqStatus.substring(0,1).toUpperCase() }}{{king.reqStatus.substring(1) }}</p>
                  </div>
                </span>
                <hr>
                <span class="create-request-button">
                  <button v-show="checkCase" @click="displayform" class="button small">Create an Requests</button>
                </span>
              </span>
              <span class="secondcase">
                <h4 id="h4too">Message</h4>
                <hr>
                <div class="message-item" v-for="mess in openingMessage" :key="mess.msgId">
                  <span class="message-icon">
                    <img src="../img/socialMediaHandle/icons8-mail-50.png" class="mail-icon">
                  </span>
                  <span class="message-content">
                    <h3 class="message-subject">{{ mess.subject }}</h3>
                    <p class="message-body">{{ mess.msgBody }}</p>
                  </span>
                </div>
                <hr class="message-divider">
                <span class="message-buttons">
                  <button v-show="otherCase" @click="checkMessage" class="button small open-all-button">Open All</button>
                  <button v-show="secondCase" @click="openSendMessage" class="button grey small send-message-button">Send a Message</button>
                </span>
              </span>
            </div>
            <div v-if="createMessage" class="create-message-form">
              <span class="create-message-content">
                <h4 class="create-message-title">Send A Message</h4>
                <p class="create-message-description">Please fill out all the required section in order to send a message!</p>
                <span class="create-message-inputs">
                  <label>Contact</label>
                  <select class="contact-select" name="">
                    <option>a2ds2</option>
                  </select>
                  <label>Subject: </label>
                  <input v-model="this.oneMessage.subject" type="text" class="subject-input" required>
                  <label>Message:</label>
                  <textarea v-model="this.oneMessage.msgBody" name="" cols="50" rows="4" class="message-textarea" placeholder="Send your message!"></textarea>
                  <span class="message-form-buttons">
                    <button @click="goodMes" class="button small submit-message-button">Submit</button>
                    <button @click="closeMes" class="button grey small close-message-button">Close</button>
                  </span>
                </span>
              </span>
            </div>
  
            <div v-if="getMessage" class="messages-list">
              <div class="messages-container">
                <h4 class="messages-title">Messages</h4>
                <div v-for="one in messagestoReturn" :key="one.msgId" class="message-item">
                  <h4 class="message-subject">{{ one.subject }}</h4>
                  <hr class="message-divider">
                  <div class="message-body-container">
                    <h6 class="message-body">{{ one.msgBody }}</h6>
                  </div>
                  <p class="message-date">{{one.msgDate.split("-")[0]}}/{{ one.msgDate.split("-")[1]}}/{{ one.msgDate.split("-")[2].split("T")[0] }}</p>
                </div>
              </div>
              <button @click="closeMessage" class="button small grey close-messages-button">Close Message</button>
            </div>
  
            <div id="secondBigDiv">
              <span class="secondboxset lease-info">
                <h3 class="h3header">Leasing Information</h3>
                <h6 class="h6header">Account</h6>
                <p class="ptext">{{ leases.leaseId }}</p>
                <h6 class="h6header">Address</h6>
                <p class="ptext address-text">{{ justOne.address }}</p>
                <span class="date-info">
                  <div class="date-headers">
                    <h6 class="h6header">Start Date</h6>
                    <h6 class="h6header">End Date</h6>
                  </div>
                  <div class="date-values">
                    <p class="ptext">{{ leases.startDate }}</p>
                    <p class="ptext">{{ leases.endDate }}</p>
                  </div>
                </span>
                <span class="lease-status-info">
                  <div class="lease-status-headers">
                    <h6 class="h6header">Rent</h6>
                    <h6 class="h6header">Lease Status</h6>
                  </div>
                  <div class="lease-status-values">
                    <p class="ptext">${{ leases.rent }}</p>
                    <p class="ptext">{{ leases.leaseStatus.substring(0,1).toUpperCase()+leases.leaseStatus.substring(1) }}</p>
                  </div>
                </span>
              </span>
  
              <span class="secondboxset contact-info">
                <h3 class="h3header">Contact Us</h3>
                <span class="company-name">
                  <h6 class="h6header company-title">A2DS2,LLC</h6>
                </span>
                <span class="contact-item">
                  <img class="imglogo" src="../img/socialMediaHandle/icons8-phone-50.png" alt="">
                  <h6 class="h6header contact-text">(877) 606-3203</h6>
                </span>
                <span class="contact-item">
                  <img class="imglogo" src="../img/socialMediaHandle/icons8-mail-50.png" alt="">
                  <h6 class="h6header contact-text">it-services@techelevator.com</h6>
                </span>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>

<script>
import LeaseService from "../services/LeaseService";
import PropertyService from "../services/PropertyService";
import MessageService from "../services/MessageService";
import RequestService from "../services/RequestService";
import axios from "axios";
export default {
  data() {
    return {
      fourCheck: false,
      thirdCheck: false,
      secondCheck: false,
      completed: false,
      firstOne: false,
      otherCase: true,
      secondCase: true,
      checkCase: true,
      username: this.$store.state.user,
      leases: {},
      property: [],
      message: [],
      requests: [],
      go: false,
      addRe: false,
      request: {
        date: "",
        service: "",
        description: "",
      },
      posted: false,
      getMessage: false,
      createMessage: false,
      oneMessage: {
        userTo: "",
        subject: "",
        msgBody: "",
      },
    };
  },

  methods: {
    payRent() {
      // Start the countdown effect
      this.countDown(this.amount, 0, 1000);
    },
    countDown(start, end, duration) {
      let range = start - end;
      let stepTime = Math.abs(Math.floor(duration / range));
      let current = start;

      let interval = setInterval(() => {
        current -= 1;
        this.currentAmount = current;

        if (current <= end) {
          clearInterval(interval);
        }
      }, stepTime);
    },

    balanceGood() {
      alert("Payment Successful");
      this.leases.rent = 0;
    },

    formGood() {
      let objectToPost = {
        userId: this.username.id,
        propId: this.leases.propId,
        reqStatus: "pending",
        reqDate: new Date(this.request.date),
        lastUpdated: new Date(this.request.date),
        reqDetails: this.request.description,
        issueType: this.request.service,
      };
      axios.post("/service-request/create", objectToPost).then((e) => {
        this.posted = true;
      });

      this.go = false;
      this.addRe = false;
      this.otherCase = true;
      this.$router.go(0);
    },
    closeForm() {
      this.go = false;
      this.addRe = false;
      this.otherCase = true;
      this.secondCase = true;
    },

    returnLease() {
      LeaseService.leaseById(this.username.id).then((e) => {
        this.leases = e.data;
        this.completed = true;
      });
    },

    propertyOne() {
      PropertyService.getProperty().then((e) => {
        this.property = e.data;
        this.secondCheck = true;
      });
    },

    messagePort() {
      MessageService.getMessageByUser(this.username.id).then((e) => {
        this.message = e.data;
        this.thirdCheck = true;
      });
    },

    servicesForUser() {
      RequestService.getRequestbyId(this.username.id).then((e) => {
        this.requests = e.data;
        this.fourCheck = true;
      });
    },

    displayform() {
      this.go = true;
      this.addRe = true;
      this.otherCase = false;
      this.secondCase = false;
    },

    checkMessage() {
      this.go = true;
      this.getMessage = true;
      this.checkCase = false;
      this.secondCase = false;
    },
    closeMessage() {
      this.go = false;
      this.getMessage = false;
      this.checkCase = true;
      this.secondCase = true;
    },

    openSendMessage() {
      this.createMessage = true;
      this.checkCase = false;
      this.go = true;
    },

    closeMes() {
      this.createMessage = false;
      this.checkCase = true;
      this.go = false;
    },
    goodMes() {
      let messagetoGreat = {
        contactType: "email",
        userTo: 9002,
        userFrom: this.username.id,
        subject: this.oneMessage.subject,
        msgBody: this.oneMessage.msgBody,
        msgDate: new Date(Date.now()),
      };
      axios.post("/messages/create", messagetoGreat).then((e) => {});
      this.oneMessage.subject = "";
      this.oneMessage.msgBody = "";
      this.createMessage = false;
      this.checkCase = false;
      this.go = false;
      this.checkCase = true;
    },
  },

  created() {
    this.propertyOne();
    this.servicesForUser();
    this.returnLease();
    this.messagePort();
  },

  computed: {
    justOne() {
      let justForFun = {};
      justForFun = this.property.filter((e) => {
        if (e.propId == this.leases.propId) {
          return e;
        }
      })[0];

      return justForFun;
    },
    openingMessage() {
      let messagetodisplay = [];
      if (this.message.length >= 2) {
        return (messagetodisplay = [this.message[0], this.message[1]]);
      } else {
        return (messagetodisplay = this.message);
      }
    },

    requestLoop() {
      let hero = [];
      if (this.requests.length >= 2) {
        return (hero = [this.requests[0], this.requests[1]]);
      } else {
        return (hero = this.requests);
      }
    },

    messagestoReturn() {
      let newMessage = [];
      newMessage = this.message.filter((e) => {
        if (e.userTo == this.username.id) {
          return e;
        }
      });
      return newMessage;
    },

    displayRent() {
      let balance = 0;
      return (balance = this.leases.rent);
    },
  },
};
</script>
  
  <style scoped>
  .background {
    background: rgb(0, 0, 0);
  }
  
  .imglogo {
    width: 25px; 
    margin-left: 3%;
  }
  
  .h3header {
    font-size: 18px; 
    margin-top: 3%; 
    display: inline-block;
  }
  
  .ptext {
    font-size: 13px; 
    width: 95%;
    margin-left: 2%;
  }
  
  .h6header {
    width: 95%;
    margin-left: 2%;
    font-size: 15px;
  }
  
  #secondBigDiv {
    height: 500px; 
    margin-top: 3%;
    display: flex;
    justify-content: space-around;
    align-items: center;
  }
  
  .secondboxset {
    display: block; 
    border: 1px solid #312f2fb0;
    height: 300px;
    width: 35%;
    border-radius: 10px;
  }
  
  #secondP {
    height: 55%;
    border: 1px solid white;
    font-size: 13px; 
    padding: 2px;
    border-radius: 10px;
    background-color: green;
    color: white; 
    width: 13%;
    text-align: center;
    margin-left: 2%;
    margin-top: 5px;
  }
  
  #firstP {
    font-weight: bold;
    font-size: 16px;
    margin-left: 3%;
    margin-top: 2%;
  }
  
  #secondText {
    display: flex;
    width: 70%;
    margin-left: 5%;
  }
  
  #h4too {
    display: block;
    margin-top: 5%; 
    font-size: 18px; 
    width: 35%; 
    margin-left: 5%;
  }
  
  .small {
    border: 1px solid white;
  }
  
  #tinylogo {
    border: 3px solid #058805ea;
    padding: 5px; 
    border-radius: 6px; 
    background-color: #0588051a;
  }
  
  #secondtext {
    display: block;
    font-size: 14px;
    font-weight: bold;
    display: flex;
    align-items: center;
    height: 100%;
    margin-right: 1%;
  }
  
  #firsttext {
    padding: 4px;
    align-items: center;
    font-size: 14px; 
    height: 100%;
    display: flex;
    width: 75%;
    border: 1px solid black;
    margin-left: 5%;
    border-radius: 6px;
  }
  
  #divfortext {
    height: 50px;  
    width: 100%;
    display: flex; 
    justify-content: space-around;
  }
  
  #h6first {
    display: block;
    margin-top: 5%; 
    font-size: 18px; 
    width: 35%; 
    margin-left: 5%;
  }
  
  .secondcase {
    padding: 7px;
    width: 35%;
    border: 2px solid #312f2fb0;
    border-radius: 10px;
  }
  
  #secondbox {
    margin-top: 4%;
    height: 35%;
    display: flex;
    justify-content: space-around;
  }
  
  .button {
    border-radius: 10px;
    display: block;
    width: 100%;
    padding: 10px;
    background: #73b680;
    color: white;
  }
  
  .button:hover {
    background-color: gray;
  }
  
  .grey {
    background: white;
    color: gray;
  }
  
  .grey:hover {
    color: white;
  }
  
  #status {
    margin-left: 15%;
    margin-top: 1.5%;
  }
  
  #justcolor {
    border: 3px solid green;
  }
  
  #box {
    border: 2px solid rgba(49, 47, 47, 0.692); 
    border-radius: 10px;
    height: 17%; 
    width: 95%;
    margin-left: 3%;
    display: flex;
    margin-top: 3%;
  }
  
  #h2span {
    margin-left: 4%;
    margin-top: 1%;
    width: 95%; 
    font-size: 24px;
  }
  
  #smallspan {
    display: block;
    width: 90%;
    height: 120px;
  }
  
  #main {
    border: 1px solid black;
    background-color: rgba(158, 158, 158, 0.137);
    width: 90%;
    margin-left: 5%;
  }
  
  #greeting {
    margin-left: 3%;
    width: 95%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 50px;
    margin-top: 2%;
    margin-bottom: 2%;
    text-align: center;
  }
  
  h3 {
    margin-left: 2%;
  }
  
  .address {
    font-size: 12px;
  }
  
  .payment-info {
    margin-left: 4%;
  }
  
  .inline-text {
    display: inline; 
    font-size: 10px;
  }
  
  .button-container {
    height: 50%; 
    margin-top: 1%; 
    margin-left: 30%;
  }
  
  .request-form {
    border: 1px solid white; 
    height: 500px; 
    display: flex; 
    justify-content: center;
  }
  
  .request-form-content {
    display: block; 
    width: 70%;  
    height: 400px;
    margin-top: 1%;
  }
  
  .request-form-title {
    color: white;
    text-align: center; 
    margin-top: 2%;
  }
  
  .request-form-description {
    color: white; 
    width: 50%; 
    margin-left: 26%; 
    text-align: center;
  }
  
  .request-form-inputs {
    display: block; 
    width: 50%; 
    height: 350px; 
    margin-left: 26%;
  }
  
  .request-form-inputs label {
    color: white;
    display: block;
  }
  
  .date-input {
    color: black;
    display: inline-block;
  }
  
  .service-select {
    color: black;
    width: 20%; 
    margin-top: .3%;
  }
  
  .description-textarea {
    resize: none;
  }
  
  .form-buttons {
    display: flex;
    margin-top: 3%;
    justify-content: space-evenly;
  }
  
  .submit-button, .close-button {
    width: 33%;
  }
  
  .request-item {
    display: flex;
    margin-top: 2%;
  }
  
  .create-request-button {
    display: flex;
    margin-top: 3%;
    justify-content: center;
  }
  
  .message-item {
    height: 75px; 
    display: flex;
  }
  
  .message-icon {
    display: block; 
    margin-left: 4%; 
    height: 35px;
  }
  
  .mail-icon {
    width: 35px;
    margin-top: 2.5%;
  }
  
  .message-content {
    display: block; 
    margin-left: 5%;
    width: 100%;
  }
  
  .message-subject {
    border: 1px solid darkgray; 
    font-size: 20px; 
    width: 100%;
    margin-left: 0%;
    text-align: center; 
    border-radius: 5px;
  }
  
  .message-body {
    font-size: 12px;
  }
  
  .message-divider {
    margin-top: 2%;
    width: 50%;
    margin-left: 25%;
  }
  
  .message-buttons {
    display: flex; 
    justify-content: space-evenly;
  }
  
  .open-all-button, .send-message-button {
    width: 25%;
  }
  
  .create-message-form {
    border: 1px solid white; 
    height: 500px; 
    display: flex; 
    justify-content: center;
  }
  
  .create-message-content {
    display: block; 
    width: 70%;  
    height: 400px;
    margin-top: 1%;
  }
  
  .create-message-title {
    color: white;
    text-align: center; 
    margin-top: 2%;
  }
  
  .create-message-description {
    color: white; 
    width: 50%; 
    margin-left: 26%; 
    text-align: center;
  }
  
  .create-message-inputs {
    display: block; 
    width: 50%; 
    height: 350px; 
    margin-left: 26%;
  }
  
  .create-message-inputs label {
    color: white;
    display: block;
  }
  
  .contact-select {
    color: black;
    width: 20%; 
    margin-top: .3%;
  }
  
  .subject-input {
    width: 45%;
  }
  
  .message-textarea {
    resize: none;
  }
  
  .message-form-buttons {
    display: flex;
    margin-top: 3%;
    justify-content: space-evenly;
  }
  
  .submit-message-button, .close-message-button {
    width: 33%;
  }
  
  .messages-list {
    border: 1px solid white; 
    width: 100%;
  }
  
  .messages-container {
    width: 100%;
  }
  
  .messages-title {
    text-align: center;
    border: 1px solid white;
    margin-top: 3%; 
    color: white;
  }
  
  .message-item {
    margin-top: 3%;
  }
  
  .message-subject {
    text-align: center;
    margin-top: 3%; 
    color: white;
  }
  
  .message-divider {
    color: white;
    width: 50%; 
    margin-left: 22%;
    border: 1.5px solid white;
  }
  
  .message-body-container {
    height: 85px;
  }
  
  .message-body {
    height: 50px;
    width: 100%;
    text-align: center;
    color: white;
  }
  
  .message-date {
    width: 15%; 
    display: inline-block; 
    margin-left: 85%;
    margin-bottom: 0%; 
    color: white; 
    font-size: 12px;
  }
  
  .close-messages-button {
    width: 25%;
    margin-left: 37%;
    margin-top: 2%;
  }
  
  .lease-info, .contact-info {
    height: 300px;
  }
  
  .address-text {
    width: 35%;
  }
  
  .date-info, .lease-status-info {
    display: block; 
    height: 60px;
  }
  
  .date-headers, .lease-status-headers, 
  .date-values, .lease-status-values {
    display: flex;
  }
  
  .company-name {
    margin-bottom: 3%; 
    display: block;
  }
  
  .company-title {
    width: 70%;
    margin-left: 12.5%;
    font-size: 14px;
    font-style: italic;
  }
  
  .contact-item {
    display: flex;
    margin-bottom: 3%;
  }
  
  .contact-text {
    width: 90%; 
    margin-left: 5%;
    font-size: 14px;
  }
  </style>