<template>
    <div class="all"
        style="width: 100%; border: 1px solid black; height: 100%; max-width: 2300px; display: flex; flex-direction: column; margin: auto; background-color: rgba(158,158,158,.137);">
        <span style="display: block;  height: 6%; width: 80%; margin-top: 2%; margin-left: 10%; border-bottom: 1px solid black;">
            <h1 style="font-size: 60px" >Welcome {{ this.$store.state.user.fName }}</h1>
        </span>
        <div class="container">
            <div class="top-section" style=" margin-top: 10%; margin-bottom: 10%; ">

                <div class="service-box" style="border: 1px solid black;">
                    <div class="scroll">
                        <h1 style="border-bottom: 1px solid black;">Service Requests</h1>
                        <li v-for="(services, index) in services" :key="index" class="property-card">
                            <p><strong>Property Id:</strong> {{ services.propId }} </p>
                            <p><strong>Service Issue:</strong>  {{ services.reqDetails }} </p>
                            <p><strong>Service Status:</strong> {{ services.reqStatus }}
                                <div class="allButtons" style="display: flex;">
                                    <div class="submit-button">
                                        <button type="submit"
                                            style="border-radius: 10px; background-color: #fcc82cea; border-color: white; color: white;"
                                            @click.prevent="setInProgress(services.reqId)">In Progress</button>
                                    </div>
                                    <div class="submit-button">
                                        <button type="submit"
                                            style="border-radius: 10px; background-color: #6ab46aea; rgba(15, 179, 102, 0.776): white; color: white;"
                                            @click.prevent="setComplete(services.reqId)">Complete</button>
                                    </div>
                                </div>
                            </p>
                        </li>
                    </div>
                </div>



                <form @submit.prevent="submitMessage" class="message-form" >
                    <h1 style="font-size: 30px; margin-bottom: auto; border-bottom: 1px solid black;"  >Send a Message to a Tenant</h1>

                    <input v-model="message.userTo" type="number" placeholder="Enter Tenant's User ID" required
                        style="font-size: large; margin-bottom: 15px;" />

                    <textarea v-model="message.msgBody" class="messageBox" name="text" cols="25" rows="5"
                        style="font-size: large;" placeholder="Enter your message" required></textarea>
                    <div class="submit-button">
                        <button type="submit"
                            style="border-radius: 10px; background-color: #058805ea; border-color: white; color: white;"
                            @click.prevent="submitMessage">Submit</button>
                    </div>
                </form>

            </div>
            <div class="bottom-section">
                <div class="applications-box" style="border: 1px solid black;">
                    <h1 style="border-bottom: 1px solid black;">All Applications</h1>
                    <ul>
                        <div class="scroll">
                            <li v-for="(applications, index) in applications" :key="index" class="property-card">
                                <p><strong>UserId:</strong> {{ applications.userId }}</p>
                                <p><strong>Move In Date:</strong> {{ applications.movieInDate }}</p>
                                <p><strong>Application Status:</strong> {{ applications.appStatus }}
                                <div class="allButtons" style="display: flex;">
                                    <div class="submit-button">
                                        <button type="submit"
                                            
                                            @click.prevent="setApprovedUser(applications.userId)">Approve</button>
                                    </div>
                                    <div class="submit-button">
                                        <button type="submit"
                                            style="border-radius: 10px; background-color: #a53d3dc6; border-color: white; color: white;"
                                            @click.prevent="setDeniedUser(applications.userId)">Deny</button>
                                    </div>
                                </div>
                                </p>
                            </li>
                        </div>
                    </ul>

                </div>
            </div>
        </div>
    </div>
</template>
    
<script>
import MessageService from '../services/MessageService.js';
import ApplicationService from '../services/ApplicationService.js';
import ServiceRequestService from '../services/ServiceRequestService.js';
import LeaseService from '../services/LeaseService.js';

export default {
    data() {
        return {
            message: {

                contactType: 'email',
                userTo: "",
                userFrom: this.$store.state.user.id,
                subject: 'Message from Manager',
                msgBody: "",
                msgDate: "2020-11-10T10:00:00"
            },
            services: [],
            applications: [],
            newLease: {
                userId: this.$store.state.user.id,
                propId: this.$store.state.propId,
                startDate: '2020-11-10',
                endDate: '2020-11-10',
                rent: this.$store.state.property.rent,
                termLength: '12',
            },
            approved: {
                "userId": '',
                "appStatus": "approved"
            },
            denied: {
                "userId": '',
                "appStatus": "denied"
            },
            inProgress: {
                "reqId": '',
                "reqStatus": "in_progress",
                "lastUpdated": "2024-03-16T10:30:00",
            },
            serviceComplete: {
                "reqId": '',
                "reqStatus": "complete",
                "lastUpdated": "2024-03-16T10:30:00",
            },

        };
    },

    created() {
        this.loadApplications();
        this.loadServiceRequests();
    },

    methods: {
        submitMessage() {
            MessageService.createMessage(this.message)
                .then(response => {
                    alert('Message sent successfully!');
                    this.resetMessageForm();
                })
                .catch(error => {
                    console.error('Error sending message:', error);
                    alert('Failed to send message.');
                    this.resetMessageForm();
                });
        },

        resetMessageForm() {
            this.message.userTo = '';
            this.message.msgBody = '';
        },
        loadServiceRequests() {
            ServiceRequestService.getServiceRequest().then((e) => {
                this.services = e.data;
            });
        },

        loadApplications() {
            ApplicationService.getApplication().then((e) => {
                this.applications = e.data;
            });
        },
        setApprovedUser(userId) {
            this.approved.userId = userId;
            this.approveApplication();
            // this.createLease();
        },
        approveApplication() {
            ApplicationService.updateApplication(this.approved)
                .then(response => {
                    alert('Application Approved Successfully');
                })
                .catch(error => {
                    console.error('Error Updating Application:', error);
                    alert('Failed to approve application.');
                });
        },

        createLease(newLease) {
            LeaseService.createLease(newLease)
            .then(response => {
                alert('New lease created', newLease);
            })
            .catch(error => {
                console.error('Error Updating Application:', error);
                alert('Failed to approve application.');                
            });
        },

        setDeniedUser(userId) {
            this.denied.userId = userId;
            this.deniedApplication();
        },
        deniedApplication() {
            ApplicationService.updateApplication(this.denied)
                .then(response => {
                    alert('Application Denied Successfully');
                })
                .catch(error => {
                    console.error('Error Updating Application:', error);
                    alert('Failed to approve application.');
                });
        },
        setInProgress(reqId) {
            this.inProgress.reqId = reqId;
            this.inProgressServiceRequest();
        },
        inProgressServiceRequest() {
            ServiceRequestService.updateServiceRequest(this.inProgress)
                .then(response => {
                    alert('Service Request Set To "In Progress"');
                })
                .catch(error => {
                    console.error('Error Updating Service Request:', error);
                    alert('Error changing status');
                });
        },
        setComplete(reqId) {
            this.serviceComplete.reqId = reqId;
            this.completeServiceRequest();
        },
        completeServiceRequest() {
            ServiceRequestService.updateServiceRequest(this.serviceComplete)
                .then(response => {
                    alert('Service Request Set To "Complete"');
                })
                .catch(error => {
                    console.error('Error Updating Service Request:', error);
                    alert('Error changing status');
                });
        },
        

    }
}
</script>
    
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    padding: 0 20%;
}

.top-section {
    width: 2000px;
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: center;
    gap: 10%;
    padding-bottom: 10%;
}

.bottom-section {
    display: flex;
    justify-content: center;
    width: 2000px;
    margin-bottom: 25%;
}

.service-box{
    place-content: center;
    width: 30%;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
}

.applications-box {
    place-content: center;
    width: 30%;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
}

.message-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 30%;
    min-height: 400px;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 35px;

    .messageBox {
        border-radius: 8px;
        margin: auto;
        height: 50%;
        width: 80%;
    }
}

.form-fields {
    display: flex;
    flex-direction: column;
    gap: 10px;
    width: 100%;
}

.upload-box {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 10px;
    width: 100%;
}

.submit-button {
    margin-top: 10px;
}

.property-card {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    background-color: #f9f9f9;
    display: flex;
    flex-direction: column;
    align-items: flex-start;

}

.property-card p {
    margin: 5px 0;
}

.property-image {
    max-width: 100%;
    height: auto;
    margin-top: 10px;
}

h3 {
    text-align: center;
}


div.scroll {
    margin: 4px, 4px;
    padding: 4px;
    height: 500px;
    overflow-x: hidden;
    overflow-y: auto;
    text-align: justify;
}
button{
    border-radius: 10px;
    display: block;
     width: 100%;
     padding: 10px;
     background: #73b680;
     color: white;
     gap: 10px;
}
</style>
    