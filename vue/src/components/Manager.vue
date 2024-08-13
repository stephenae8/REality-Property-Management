<template>
    <div class="all">
        <span class="greeting">
            <h1>Hello {{ this.$store.state.user.fName }}</h1>
        </span>
        <div class="container">
            <div class="top-section">
                <div class="revenue-box">
                    <div class="scroll">
                        <h2>Service Requests</h2>
                        <li v-for="(services, index) in services" :key="index" class="property-card">
                            <p><strong>Property Id:</strong> {{ services.propId }} </p>
                            <p><strong>Service Issue:</strong>  {{ services.reqDetails }} </p>
                            <strong>Service Status:</strong> {{ services.reqStatus }}
                                <div class="allButtons">
                                    <div class="submit-button">
                                        <button type="submit" class="in-progress-button" @click.prevent="setInProgress(inProgress.reqId)">In Progress</button>
                                    </div>
                                    <div class="submit-button">
                                        <button type="submit" class="complete-button" @click.prevent="setComplete(serviceComplete.reqId)">Complete</button>
                                    </div>
                                </div>
                            
                        </li>
                    </div>
                </div>

                <form @submit.prevent="submitMessage" class="message-form">
                    <h1>Send a Message to a Tenant</h1>

                    <input v-model="message.userTo" type="number" placeholder="Enter Tenant's User ID" required />

                    <textarea v-model="message.msgBody" class="messageBox" name="text" cols="25" rows="5"
                        placeholder="Enter your message" required></textarea>
                    <div class="submit-button">
                        <button type="submit" class="submit-message-button" @click.prevent="submitMessage">Submit</button>
                    </div>
                </form>
            </div>
            
            <div class="bottom-section">
                <div class="properties-box">
                    <h1>Application Status</h1>
                    <div class="accordion">
                        <div class="accordion-item" v-for="status in ['pending', 'approved', 'denied', 'all']" :key="status">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" :data-bs-target="`#${status}Collapse`">
                                    {{ status.charAt(0).toUpperCase() + status.slice(1) }} Applications
                                </button>
                            </h2>
                            <div :id="`${status}Collapse`" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul>
                                        <div class="scroll">
                                            <li v-for="(application, index) in filterApplications(status)" :key="index" class="property-card">
                                                <p><strong>UserId:</strong> {{ application.userId }}</p>
                                                <p><strong>Move In Date:</strong> {{ application.moveInDate }}</p>
                                                <strong>Application Status:</strong> {{ application.appStatus }}
                                                <div class="allButtons">
                                                    <div class="submit-button">
                                                        <button type="submit" class="approve-button" @click.prevent="setApprovedUser(application.appId)">Approve</button>
                                                    </div>
                                                    <div class="submit-button">
                                                        <button type="submit" class="deny-button" @click.prevent="setDeniedUser(application.appId)">Deny</button>
                                                    </div>
                                                </div>
                                                
                                            </li>
                                        </div>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>



<script>
// ... (script section remains the same)
import MessageService from '../services/MessageService.js';
import ApplicationService from '../services/ApplicationService.js';
import ServiceRequestService from '../services/ServiceRequestService.js';
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
                "appId": '',
                "reqStatus": "in_progress"
            },
            serviceComplete: {
                "userId": '',
                "reqStatus": "complete"
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
        setInProgress(userId) {
            this.inProgress.userId = userId;
            this.inProgressServiceRequest();
        },
        inProgressServiceRequest() {
            ServiceRequestService.updateServiceRequest(this.inProgress)
                .then(response => {
                    alert('Service Request Set To "In Progress"');
                })
                .catch(error => {
                    console.error('Error Updating Service Request:', error);
                    alert('Failed to approve application.');
                });
        },
        setComplete(userId) {
            this.serviceComplete.userId = userId;
            this.completeServiceRequest();
        },
        completeServiceRequest() {
            ServiceRequestService.updateServiceRequest(this.serviceComplete)
                .then(response => {
                    alert('Service Request Set To "Complete"');
                })
                .catch(error => {
                    console.error('Error Updating Service Request:', error);
                    alert('Failed to approve application.');
                });
        },
        filterApplications(status) {
            if (status === 'all') return this.applications;
            return this.applications.filter(app => app.appStatus.toLowerCase() === status);
        }
    }

    
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

.all {
    width: 100%;
    border: 1px solid black;
    height: 100%;
    max-width: 2300px;
    display: flex;
    flex-direction: column;
    margin: auto;
    background-color: rgba(158,158,158,.137);
}

.greeting {
    display: block;
    height: 6%;
    width: 80%;
    margin-top: 2%;
    margin-left: 10%;
    font-size: larger;
}

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    padding: 0 20%;
}

.top-section {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 250px;
    margin-top: 10%;
    margin-bottom: 10%;
}

.bottom-section {
    max-width: 1560px;
    margin-bottom: 25%;
    width: 100%;
}

.revenue-box,
.properties-box,
.message-form {
    place-content: center;
    min-width: 650px;
    border-radius: 16px;
    border: 3px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
}

.message-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    min-height: 400px;
    padding: 35px;
}

.message-form h1 {
    font-size: 30px;
    margin-bottom: auto;
}

.message-form input,
.message-form textarea {
    font-size: large;
    margin-bottom: 15px;
}

.messageBox {
    border-radius: 8px;
    margin: auto;
    height: 50%;
    width: 80%;
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

.allButtons {
    display: flex;
}

.in-progress-button {
    border-radius: 10px;
    background-color: #fcc82cea;
    border-color: white;
    color: white;
}

.complete-button,
.submit-message-button,
.approve-button {
    border-radius: 10px;
    background-color: #058805ea;
    border-color: white;
    color: white;
}

.deny-button {
    border-radius: 10px;
    background-color: #901818c6;
    border-color: white;
    color: white;
}

.scroll {
    margin: 4px, 4px;
    padding: 4px;
    height: 500px;
    overflow-x: hidden;
    overflow-y: auto;
    text-align: justify;
}

.accordion-item {
    margin-bottom: 10px;
}

.accordion-button {
    width: 100%;
    text-align: left;
    padding: 10px;
    background-color: #f8f9fa;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.accordion-body {
    padding: 10px;
    background-color: #ffffff;
    border: 1px solid #dee2e6;
    border-radius: 0 0 5px 5px;
}
</style>