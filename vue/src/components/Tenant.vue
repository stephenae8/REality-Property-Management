<template>
  <div>
<div v-if="completed && secondCheck && thirdCheck && fourCheck">
    <div :class="{background: go}" v-if="leases.leaseStatus == 'active'" >
     
     <div id="main">
            <span id="greeting">
                <h3>Hello {{ username.fName.substring(0,1).toUpperCase()+username.fName.substring(1) }}!</h3>
                <p style="font-size: 12px; ">{{ justOne.address }}, {{ justOne.city }},{{justOne.state}} {{justOne.zipCode}}</p>
            </span>
            <div id="box" >
                <div id="justcolor"></div>
                <div id="status" >
                    <span id="smallspan">
                    <h2 id="h2span" >Your current Balance is <b>${{ displayRent }}</b></h2>
                    <span style=" margin-left: 4%;">
                    <img src="../img/socialMediaHandle/icons8-payment-24.png" alt="">
                    <p style="display: inline; font-size: 10px;">1 schedule payment</p>
                    </span>
                </span>
                </div>
                <div style="height: 50%; margin-top: 1%; margin-left: 30%;">
                    <button @click="balanceGood" v-show="checkCase" class="button small">Make a Payment</button><br>
                    <button v-show="checkCase" class="button grey small">Set Up AutoPay</button>
                </div>
            </div>
            <div v-if="addRe" style="border: 1px solid white; height: 500px; display: flex; justify-content: center;" > 
            <span style="display: block; width: 70%;  height: 400px;margin-top: 1%;">
                <h4 style="color: white;text-align: center; margin-top: 2%;">Send A requests</h4>
                <p style="color: white; width: 50%; margin-left: 26%;">Please provide us with the details on your property and we will have our team check it out. Please provide us with all the request details! </p>
                <span style="display: block; width: 50%; height: 350px; margin-left:26%;">
                    <label style="color: white;display: block;">Date:</label>
                    <input v-model="this.request.date" style="color: white;display: inline-block; color: black;" type="date" name="" id="">
                    <label style="color: white;display: block;margin-top: 1%;">Service Type: </label>
                    <select v-model="this.request.service" style=" color: black;width: 20%; margin-top: .3%;" name="">
                        <option >dishwasher</option>
                         <option >central_air</option>
                        <option >laundry</option>
                        <option >bathroom</option>
                        <option >other</option>    
                    </select>
                    <label style="color: white;display: block;margin-top: 2%;">Description:</label>
                    <textarea v-model="this.request.description" name="" cols="50" rows="4" style="resize: none;" placeholder="Please Add Your Request!" ></textarea>
                   <span style="display: flex;margin-top: 3%;justify-content: space-evenly;">
                    <button @click="formGood"  class="button small" style= "width: 33%" >Submit</button>
                    <button @click="closeForm" class="button grey small" style=";width: 33% ;">Close</button>
                </span>
                </span>
            </span>
    
    
    </div>
    
            <div id="secondbox" >
                <span class="secondcase" >
                    <h6 id="h6first" >Open requests</h6>
                    <hr>
                    <span v-for="king in requestLoop" :key="king.reqId" style=" display: flex;margin-top: 2%;">
                        <img id="tinylogo"  src="../img/socialMediaHandle/icons8-repair-32.png" alt="">
                       <div id="divfortext">
                        <p id="firsttext" >{{king.reqDetails}}</p>
                        <p id="secondtext" >{{ king.reqStatus.substring(0,1).toUpperCase() }}{{king.reqStatus.substring(1)  }}</p>
                    </div>
                    </span>
                    <hr>
                   
                    <span style="display: flex;margin-top: 3%;justify-content: center; ">
                        <button v-show="checkCase" @click="displayform" class="button small">Create an Requests</button>
                    </span>
    
                </span>
                <span class="secondcase" >
                    <h4 id="h4too">Message</h4>
                    <hr>
                    <div style=" height: 75px; display: flex;" v-for="mess in openingMessage" :key="mess.msgId">
                        <span style="display: block; margin-left: 4%; height: 35px; ">
                            <img src="../img/socialMediaHandle/icons8-mail-50.png" style="width: 35px;margin-top: 2.5%;">
                        </span>
                        <span style="display: block; margin-left: 5%;width: 100%; ">
                        <h3 style="border: 1px solid darkgray; font-size: 20px; width: 100%;margin-left: 0%;text-align: center; border-radius: 5px;">{{ mess.subject }}</h3>
                        <p style="font-size: 12px;">{{ mess.msgBody }}</p>
                         </span>
                    </div>
                    <hr style="margin-top:2%;width: 50%;margin-left: 25%;">
                    <span style="display: flex; justify-content: space-evenly;">
                    <button v-show="otherCase" @click="checkMessage" style="width: 25%;" class="button small">Open All</button>
    
                    <button v-show="secondCase" @click="openSendMessage" style="width: 25%;" class="button grey small">Send a Message</button>
    
                </span>
                </span>
            </div>
            <div v-if="createMessage" style="border: 1px solid white; height: 500px; display: flex; justify-content: center;" > 
            <span style="display: block; width: 70%;  height: 400px;margin-top: 1%;">
                <h4 style="color: white;text-align: center; margin-top: 2%;">Send A Message</h4>
                <p style="color: white; width: 50%; margin-left: 26%; text-align: center;">Please fill out all the required section in order to send a message!</p>
                <span style="display: block; width: 50%; height: 350px; margin-left:26%;">
                    <label style="color: white;display: block;">Contact</label>
                    <select  style=" color: black;width: 20%; margin-top: .3%;" name="">
                        <option >a2ds2</option>
                    </select>
                    <label style="color: white;display: block;margin-top: 1%;">Subject: </label>
                   <input v-model="this.oneMessage.subject" type="text" style="width: 45%;" required>
                    <label style="color: white;display: block;margin-top: 2%;">Message:</label>
                    <textarea v-model="this.oneMessage.msgBody" name="" cols="50" rows="4" style="resize: none;" placeholder="Send your message!" ></textarea>
                   <span style="display: flex;margin-top: 3%;justify-content: space-evenly;">
                    <button @click="goodMes"  class="button small" style= "width: 33%" >Submit</button>
                    <button @click="closeMes" class="button grey small" style=";width: 33% ;">Close</button>
                </span>
                </span>
            </span>
    
    
    </div>
    
    
    
    
    
            <div v-if="getMessage" >
            <div style=" border: 1px solid white; width: 100%;">
        <h4 style="text-align: center;border: 1px solid white;margin-top: 3%; color: white">Messages</h4>
    
        <div v-for="one in messagestoReturn" :key="one.msgId">
        <h4 style="text-align: center;margin-top: 3%; color: white">{{ one.subject }}</h4>
        <hr style="color: white;width: 50%; margin-left: 22%;border:1.5px solid white ;">
        <div >
            <h6 style=" height: 50px;width:max-content; width: 100%;height: 85px; text-align: center;color: white;">{{ one.msgBody }}</h6>
        </div>
            <p style="width: 15%; display: inline-block; margin-left: 85%;margin-bottom: 0%; color: white; font-size: 12px;">{{one.msgDate.split("-")[0]}}/{{ one.msgDate.split("-")[1]}}/{{ one.msgDate.split("-")[2].split("T")[0] }}</p>
        </div>
        </div>
        <button @click="closeMessage" style="width: 25%;margin-left: 37%;margin-top: 2%;"  class="button small grey">Close Message</button>
    </div>
    
    
    
            <div id="secondBigDiv" >
                <span class="secondboxset" style="height: 350px; padding: 3px;">
                    <h3 class="h3header" >Leasing Information</h3>
                    <h6 class="h6header" >Account</h6>
                    <p class="ptext">{{ leases.leaseId }}</p>
                    <h6 class="h6header" >Address</h6>
                    <p class="ptext" style="width: 35%;">{{ justOne.address }}</p>
                    <span style="display: block; height: 60px;;">
                    <div style="display: flex;">
                    <h6 class="h6header" >Start Date</h6>
                    <h6 class="h6header">End Date</h6>
                    </div>
                    <div style=";display: flex;">
                        <p class="ptext">{{ leases.startDate }}</p>
                        <p class="ptext">{{ leases.endDate }}</p>
                    </div>
                    </span>
                    <span style="display: block; height: 100px;">
                    <div style="display: flex;">
                    <h6 class="h6header" >Rent </h6>
                    <h6 class="h6header">Lease Status</h6>
                    </div>
                    <div style=";display: flex;">
                        <p class="ptext">${{ leases.rent }}</p>
                        <p class="ptext">{{ leases.leaseStatus.substring(0,1).toUpperCase()+leases.leaseStatus.substring(1) }}</p>
                    </div>
    
                    </span>
                    
                </span>
                
                <span class="secondboxset" >
                    <h3 class="h3header" style="margin-bottom: 3%;">Contact Us</h3>
                    <span style="margin-bottom: 3%; display: block;">
                        <h6 class="h6header" style="width: 70%;margin-left: 12.5%;font-size: 14px;font-style: italic;">A2DS2,LLC</h6>
                    </span>
                    <span style=" display: flex;margin-bottom: 3%;">
                        <img class="imglogo" src="../img/socialMediaHandle/icons8-phone-50.png" alt="">
                        <h6 class="h6header" style="width: 90%; margin-left: 5%;font-size: 14px;">(877) 606-3203</h6>
                    </span>
                    <span style="display: flex;">
                        <img class="imglogo" src="../img/socialMediaHandle/icons8-mail-50.png" alt="">
                    <h6 class="h6header" style="width: 90%; margin-left: 5%;font-size: 14px;">it-services@techelevator.com</h6>
                    </span>
                </span>
            </div>
        </div>
</div>
    
</div> 
</div>
    </template>
    
    <script>
    import LeaseService from '../services/LeaseService';
    import PropertyService from '../services/PropertyService';
    import MessageService from '../services/MessageService';
    import RequestService from '../services/RequestService';
    import axios from 'axios';
    import ApplicationService from '../services/ApplicationService';
    export default {


        data(){
            return{
                fourCheck: false,
                thirdCheck: false,
                secondCheck : false,
                completed: false,
                firstOne: false,
                otherCase: true,
                secondCase: true,
                checkCase:true,
                username: this.$store.state.user,
                leases: {},
                property: [],
                message: [],
                requests: [],
                go: false,
                addRe: false,
                request: {
                    date: '',
                    service: '',
                    description: '',
                },
                posted: false,
                getMessage: false,
                createMessage: false,
                oneMessage: {
                    userTo: '',
                    subject: '',
                    msgBody: ''
                }
            }
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


            balanceGood(){
                alert('Payment Successful')
                this.leases.rent = 0

            },


    
            formGood(){
            let objectToPost = {
                    userId: this.username.id,
                    propId: this.leases.propId,
                    reqStatus: "pending",
                    reqDate: new Date(this.request.date),
                    lastUpdated: new Date(this.request.date),
                    reqDetails: this.request.description,
                    issueType: this.request.service
    
                }
                axios.post("/service-request/create", objectToPost).then((e)=>{
                    this.posted = true
                })
              
                this.go= false;
                this.addRe= false;
                this.otherCase = true;
                this.$router.go(0)
            },
            closeForm(){
                this.go= false;
                this.addRe = false;
                this.otherCase = true;
                this.secondCase = true;
            },
         

 
    
            returnLease(){
                
                LeaseService.leaseById(this.username.id).then((e)=>{
                    this.leases = e.data
                   this.completed = true
                })
              
            },
    
            propertyOne(){
                PropertyService.getProperty().then((e)=>{
                    this.property = e.data
                    this.secondCheck =true
                })
    
            },
    
            messagePort(){
                MessageService.getMessageByUser(this.username.id).then((e)=>{
            
                    this.message = e.data
                    this.thirdCheck = true
                })
            },
    
            servicesForUser(){
                RequestService.getRequestbyId(this.username.id).then((e)=>{
    
                    this.requests = e.data
                    this.fourCheck = true
                })
            },

    
            displayform(){
                this.go=true;
                this.addRe = true;
                this.otherCase =false;
                this.secondCase = false
            },
    
            checkMessage(){
                this.go =true;
                this.getMessage = true;
                this.checkCase =false;
                this.secondCase = false;
            },
            closeMessage(){
                this.go =false;
                this.getMessage = false;
                this.checkCase = true;
                this.secondCase = true
            },
            
            openSendMessage(){
                this.createMessage = true;
                this.checkCase =false;
                this.go = true;
            },
    
            closeMes(){
                this.createMessage = false;
                this.checkCase =  true;
                this.go = false;
            },
            goodMes(){
                let messagetoGreat = {
                    contactType: "email",
                    userTo: 9002,
                    userFrom: this.username.id,
                    subject: this.oneMessage.subject,
                    msgBody: this.oneMessage.msgBody,
                    msgDate: new Date(Date.now())
                }
                axios.post('/messages/create', messagetoGreat).then((e)=>{
    
                });
                this.oneMessage.subject = '';
                this.oneMessage.msgBody =  '';
                this.createMessage =false;
                this.checkCase =false;
                this.go =false;
                this.checkCase = true;
    
            }
    
    
          
    
    
        },
    
    
        created(){
            this.propertyOne();
            this.servicesForUser();
            this.returnLease();
            this.messagePort()

        
        },
    
        computed: {
            justOne(){
                let justForFun = {};
                justForFun = this.property.filter((e)=>{
                    if(e.propId==this.leases.propId){
                        return e
                    }
                })[0]
    
                return justForFun
            },
            openingMessage(){
                let messagetodisplay = []
                if(this.message.length>=2){
                    return messagetodisplay = [this.message[0], this.message[1]]
                }else{
                    return messagetodisplay = this.message
                }
        
            },

            requestLoop(){
                let hero = [];
                if(this.requests.length>=2){
                    return hero = [this.requests[0],this.requests[1]]
                }else{
                    return hero = this.requests
                }

            },

    
    
            messagestoReturn(){
                let newMessage = [];
                newMessage = this.message.filter((e)=>{
                    if(e.userTo == this.username.id){
                        return e
                    }
                })
                return newMessage;
            },

            displayRent(){
                let balance = 0;
                return balance = this.leases.rent
            }
            
    
        }
    
    }
    </script>
    
    <style scoped>
    
    .background{
        background: rgb(0, 0, 0);
    }
    
    .imglogo{
        width: 25px; 
        margin-left: 3%;
    }
    
    .h3header{
        font-size: 18px; 
        margin-top: 3%; 
        display: inline-block;
    }
    
    .ptext{
        font-size: 13px; 
        width: 95%;
        margin-left: 2%;
    
    }
    
    .h6header{
        width: 95%;
        margin-left: 2%;
         font-size: 15px;
    }
    
    #secondBigDiv{
        height: 500px; 
        margin-top: 3%;
        display: flex;
        justify-content: space-around;
        align-items: center;
    
    }
    
    .secondboxset{
        display: block; 
        border: 1px solid #312f2fb0;
        height: 300px;
        width: 35%;
         border-radius:10px
    }
    
    #secondP{
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
             margin-top: 5px
    }
    
    #firstP{
        font-weight: bold;
         font-size: 16px;
          margin-left: 3%;
          margin-top: 2%;
    }
    
    #secondText{
        display: flex;
        width: 70%;
        margin-left: 5%;
    }
    
    #h4too{
        display: block;
         margin-top: 5%; 
         font-size: 18px; 
         width: 35%; 
         margin-left: 5%;
    
    }
    
    .small{
        border: 1px solid white;
    }
    
    
    #tinylogo{
        border: 3px solid #058805ea;
        
         padding: 5px; 
         border-radius: 6px; 
         background-color:#0588051a ;
    }
    
    #secondtext{
         display: block;
         font-size: 14px;
         font-weight: bold;
         display: flex;
         align-items: center;
         height: 100%;
         margin-right: 1%;
    }
    
    #firsttext{
        padding: 4px;
        align-items: center;
        font-size: 14px; 
        height: 100%;
        display: flex;
         width: 75%;
        border: 1px solid black;
         margin-left: 5%;
         border-radius:6px ;
        
    }
    
    #divfortext{
        height: 50px;  width: 100%;display: flex; 
        justify-content: space-around
    
    }
    
    
    
    
    #h6first{
        display: block;
         margin-top: 5%; 
         font-size: 18px; 
         width: 35%; 
         margin-left: 5%;
    
    }
    
    .secondcase{
        padding: 7px;
        width: 35%;
        border: 2px solid #312f2fb0;
        border-radius: 10px;
        
    }
    
    
    #secondbox{
        margin-top:4% ;
        height: 35%;
        display: flex;
        justify-content: space-around;
    }
    
    .button{
        border-radius: 10px;
        display: block;
         width: 100%;
         padding: 10px;
         background: #73b680;
         color: white;
    }
    
    .button:hover{
        background-color:gray ;
    
    }
    
    .grey{
        background: white;
        color: gray;
    }
    
    .grey:hover{
        color: white;
    }
    
    
    #status{
        margin-left: 15%;
         margin-top: 1.5%;
    }
    
    #justcolor{
        border: 3px solid green;
    }
    
    #box{
        border: 2px solid rgba(49, 47, 47, 0.692); 
        border-radius: 10px;
        height: 17%; 
        width: 95%;
        margin-left: 3%;
        display: flex;
        margin-top: 3%;
    }
    
    #h2span{
        margin-left: 4%;
        margin-top: 1%;
        width: 95%; 
        font-size: 24px;
    }
    
    
    #smallspan{
        display: block;
        width: 90%;
        height: 120px;
    }
    
    #main{
        border: 1px solid black;
        background-color: rgba(158, 158, 158, 0.137);
        width: 90%;
        margin-left: 5%;
        
        }
    
    #greeting{
        margin-left: 3%;
        width: 95%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 50px;
        margin-top:2% ;
        margin-bottom: 2%;
        text-align: center;
    }
    
    h3{
        margin-left: 2%;
    }
    
    </style>