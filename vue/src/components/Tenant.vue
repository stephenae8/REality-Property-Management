<template>
    <h1>{{ message }}</h1>
<div v-if="this.leases.leaseStatus">
<div id="main">
        <span id="greeting">
            <h3>Hello {{ username.fName }}!</h3>
            <p style="font-size: 12px; ">{{ justOne.address }}, {{ justOne.city }},{{justOne.state}} {{justOne.zipCode}}</p>
        </span>
        <div id="box" >
            <div id="justcolor"></div>
            <div id="status" >
                <span id="smallspan">
                <h2 id="h2span" >Your current Balance is <b>$0.00</b></h2>
                <span style=" margin-left: 4%;">
                <img src="../img/socialMediaHandle/icons8-payment-24.png" alt="">
                <p style="display: inline; font-size: 10px;">1 schedule payment</p>
                </span>
            </span>
            </div>
            <div style="height: 50%; margin-top: 1%; margin-left: 30%;">
                <button class="button small">Make a Payment</button><br>
                <button class="button grey small">Set Up AutoPay</button>
            </div>
        </div>

        <div id="secondbox" >
            <span class="secondcase" >
                <h6 id="h6first" >Open requests</h6>
                <hr>
                <span style=" display: flex;">
                    <img id="tinylogo"  src="../img/socialMediaHandle/icons8-repair-32.png" alt="">
                   <div id="divfortext">
                    <p id="firsttext" style=" ">Visiting Boyfriend in Columbus until around August 17th</p>
                    <p id="secondtext">Completed</p>
                </div>
                </span>
                <hr>
                <span style=" display: flex;">
                    <img id="tinylogo"  src="../img/socialMediaHandle/icons8-repair-32.png" alt="">
                   <div id="divfortext">
                    <p id="firsttext" style=" ">Visiting Boyfriend in Columbus until around August 17th</p>
                    <p id="secondtext">Completed</p>
                </div>
                </span>
                <span style="display: flex;margin-top: 3%;justify-content: center; ">
                    <button class="button small">Create an Requests</button>
                </span>

            </span>
            <span class="secondcase" >
                <h4 id="h4too">Message</h4>
                <hr>
                <div style="border: 1px solid black; height: 55px; display: flex; ;">
                    <span style="display: block; margin-left: 2%;">
                        <img src="../img/socialMediaHandle/icons8-mail-50.png" style="width: 35px;margin-top: 4.5%;">
                    </span>
                    <span style="display: block; margin-left: 5%;">
                    <h3>hs</h3>
                     </span>
                </div>
                
            </span>
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
<div v-else>
    <h1>Application Still Pending</h1>
</div>
</template>

<script>
import LeaseService from '../services/LeaseService';
import PropertyService from '../services/PropertyService';
import MessageService from '../services/MessageService'
export default {
    data(){
        return{
            username: this.$store.state.user,
            leases: {},
            property: {},
            message: []
        }
    },

    methods: {
        returnLease(){
            
            LeaseService.leaseById(this.username.id).then((e)=>{
                this.leases = e.data
                
              
            })
          
        },

        propertyOne(){
            PropertyService.getProperty().then((e)=>{
                this.property = e.data
            })

        },

        messagePort(){
            MessageService.getMessageByUser(this.username.id).then((e)=>{
                this.message = e.data
            })
        }

    },


    created(){
        this.propertyOne();
        this.returnLease();
        this.messagePort();
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
        }
    }

}
</script>

<style scoped>

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
    padding: 2px;
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

.grey{
    background: white;
    color: gray;
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