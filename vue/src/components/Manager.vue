<template>
    <div class="all">
        <span class="welcome-message">
            <h1>Welcome {{ this.$store.state.user.fName }}</h1>
        </span>
        <div class="container">
            <div class="top-section">
                <div class="service-box">
                    <div class="scroll">
                        <h1>Service Requests</h1>
                        <li v-for="(services, index) in services" :key="index" class="property-card">
                            <p><strong>Property Id:</strong> {{ services.propId }} </p>
                            <p><strong>Service Issue:</strong> {{ services.reqDetails }} </p>
                            <p><strong>Service Status:</strong> {{ services.reqStatus }}</p>
                            <div class="allButtons">
                                <button @click.prevent="setInProgress(services.reqId)">In Progress</button>
                                <button @click.prevent="setComplete(services.reqId)">Complete</button>
                            </div>
                        </li>
                    </div>
                </div>
                <form @submit.prevent="submitMessage" class="message-form">
                    <h1>Send A Message To A User</h1>
                    <input v-model="message.userTo" type="number" placeholder="Enter User ID" required />
                    <textarea v-model="message.msgBody" class="messageBox" placeholder="Enter Your Message" required></textarea>
                    <button @click.prevent="submitMessage">Submit</button>
                </form>
            </div>
            <div class="bottom-section">
                <div class="applications-box">
                    <h1>All Applications</h1>
                    <div class="scroll">
                        <li v-for="(applications, index) in applications" :key="index" class="property-card">
                            <p><strong>UserId:</strong> {{ applications.userId }}</p>
                            <p><strong>Move In Date:</strong> {{ applications.moveInDate }}</p>
                            <p><strong>Application Status:</strong> {{ applications.appStatus }}</p>
                            <div class="allButtons">
                                <button @click.prevent="setApprovedUser(applications.appId)">Approve</button>
                                <button @click.prevent="setDeniedUser(applications.appId)">Deny</button>
                            </div>
                        </li>
                    </div>
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
            approved: {
                "appId": '',
                "appStatus": "approved"
            },
            denied: {
                "appId": '',
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
                    alert('Message Sent');
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
        setApprovedUser(appId) {
            this.approved.appId = appId;
            this.approveApplication();
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
        setDeniedUser(appId) {
            this.denied.appId = appId;
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
.all {
    width: 100%;
    border: 1px solid black;
    max-width: 2300px;
    margin: auto;
    background-color: rgba(158, 158, 158, 0.137);
    padding: 2%;
}
.welcome-message {
    height: 6%;
    width: 80%;
    margin: 2% auto;
    border-bottom: 1px solid black;
    font-size: 60px;
    text-align: center;
}
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    padding: 0 20%;
}
.top-section, .bottom-section {
    width: 2000px;
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: center;
    gap: 10%;
    margin-bottom: 5%;
}
.service-box, .applications-box, .message-form {
    place-content: center;
    width: 30%;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
}
.scroll {
    height: 500px;
    overflow-x: hidden;
    overflow-y: auto;
}
.property-card {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    background-color: #F9F9F9;
}
.allButtons {
    display: flex;
    gap: 10px;
    margin-top: 10px;
}
button {
    border-radius: 10px;
    padding: 10px;
    background: #73B680;
    color: white;
    width: 100%;
    max-width: 150px;
    border: none;
    cursor: pointer;
    transition: background 0.3s ease;
}
button:hover {
    background: #5A8F60;
}
input, textarea {
    width: 100%;
    padding: 10px;
    font-size: large;
    margin-bottom: 15px;
    border-radius: 8px;
    border: 1px solid #ccc;
}
.messageBox{
    min-height: 300px;
}
@media (max-width: 1024px) {
    .container {
        padding: 0 5%;
    }
    .top-section, .bottom-section {
        width: 100%;
        flex-direction: column;
        gap: 20px;
    }
    .service-box, .applications-box, .message-form {
        width: 100%;
        max-width: 600px;
        padding: 15px;
    }
    .scroll {
        height: 200px;
    }
    .welcome-message {
        font-size: 5vw;
    }
}
</style>