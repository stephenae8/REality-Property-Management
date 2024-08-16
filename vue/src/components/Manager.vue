<template>
    <div class="all">
        <span class="greeting">
            <h1>Hello {{ this.$store.state.user.fName }}  {{ this.$store.state.user.lName }}</h1>
        </span>
        <div class="container">
            <div class="bottom-section">
                <div class="properties-box">
                    <h1>Application Status</h1>
                    
                    <!-- Pending Applications Accordion -->
                    <div class="accordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#pendingCollapse">
                                    Pending Applications
                                </button>
                            </h2>
                            <div id="pendingCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul>
                                        <div class="scroll">
                                            <li v-for="(application, index) in filterApplications('pending')" :key="index" class="property-card">
                                                <p><strong>Applicant:</strong> {{ application.applicantName }}</p>
                                                <p><strong>Requested Move In Date:</strong> {{ application.moveInDate }}</p>
                                                <p><strong>Property Address:</strong> {{ application.propertyAddress }}</p>
                                                <p><strong>Property Owner:</strong> {{ application.ownerName }}</p>
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

                    <!-- Approved/Denied Applications Accordion -->
                    <div class="accordion">
                        <div class="accordion-item" v-for="status in ['approved', 'denied']" :key="status">
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
                                                <p><strong>Applicant:</strong> {{ application.applicantName }}</p>
                                                <p><strong>Requested Move In Date:</strong> {{ application.moveInDate }}</p>
                                                <p><strong>Property Address:</strong> {{ application.propertyAddress }}</p>
                                                <p><strong>Property Owner:</strong> {{ application.ownerName }}</p>
                                                <p><strong>Application Status:</strong> {{ status.charAt(0).toUpperCase() + status.slice(1) }}</p>
                                            </li>
                                        </div>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="leases-box">
        <h1>Lease Management</h1>
        
        <!-- Active Leases Accordion -->
        <div class="accordion">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#activeLeaseCollapse">
                        Active Leases
                    </button>
                </h2>
                <div id="activeLeaseCollapse" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <ul class="scroll">
                            <li v-for="(lease, index) in filterLeases('active')" :key="index" class="property-card">    
                                <p><strong>Tenant:</strong> {{ lease.userId }}</p>
                                <p><strong>Property Address:</strong> {{ lease.propId }}</p>
                                <p><strong>Lease Start Date:</strong> {{ lease.startDate }}</p>
                                <p><strong>Lease End Date:</strong> {{ lease.endDate }}</p>
                                <div class="submit-button">
                                    <button type="submit" class="terminate-button" @click.prevent="setTerminatedLease(lease.leaseId)">Terminate Lease</button>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Expired Leases Accordion -->
        <div class="accordion">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#expiredLeaseCollapse">
                        Expired Leases
                    </button>
                </h2>
                <div id="expiredLeaseCollapse" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <ul class="scroll">
                            <li v-for="(lease, index) in filterLeases('expired')" :key="index" class="property-card">
                                <p><strong>Tenant:</strong> {{ lease.tenantName }}</p>
                                <p><strong>Property Address:</strong> {{ lease.propertyAddress }}</p>
                                <p><strong>Lease Start Date:</strong> {{ lease.startDate }}</p>
                                <p><strong>Lease End Date:</strong> {{ lease.endDate }}</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Terminated Leases Accordion -->
        <div class="accordion">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#terminatedLeaseCollapse">
                        Terminated Leases
                    </button>
                </h2>
                <div id="terminatedLeaseCollapse" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <ul class="scroll">
                            <li v-for="(lease, index) in filterLeases('terminated')" :key="index" class="property-card">
                                <p><strong>Tenant:</strong> {{ lease.tenantName }}</p>
                                <p><strong>Property Address:</strong> {{ lease.propertyAddress }}</p>
                                <p><strong>Lease Start Date:</strong> {{ lease.startDate }}</p>
                                <p><strong>Lease End Date:</strong> {{ lease.endDate }}</p>
                                <p><strong>Termination Date:</strong> {{ lease.terminationDate }}</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
            </div>
            <div class="top-section">
                <div class="revenue-box">
                    <!-- Pending Requests Accordion -->
                    <div class="accordion">
                        <h2>Service Requests</h2>
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#pendingRequestsCollapse">
                                    New Requests
                                </button>
                            </h2>
                            <div id="pendingRequestsCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul class="scroll">
                                        <li v-for="(service, index) in filterServices('pending')" :key="index" class="property-card">
                                            <p><strong>Property Id:</strong> {{ service.propId }}</p>
                                            <p><strong>Service Issue:</strong> {{ service.reqDetails }}</p>
                                            <p><strong>Service Status:</strong> Pending</p>
                                            <div class="submit-button">
                                                <button type="submit" class="in-progress-button" @click.prevent="setInProgress(service.reqId)">Set In Progress</button>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- In Progress Requests Accordion -->
                    <div class="accordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#inProgressRequestsCollapse">
                                    In-Progress Requests
                                </button>
                            </h2>
                            <div id="inProgressRequestsCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul class="scroll">
                                        <li v-for="(service, index) in filterServices('in_progress')" :key="index" class="property-card">
                                            <p><strong>Property Id:</strong> {{ service.propId }}</p>
                                            <p><strong>Service Issue:</strong> {{ service.reqDetails }}</p>
                                            <p><strong>Service Status:</strong> In Progress</p>
                                            <div class="submit-button">
                                                <button type="submit" class="complete-button" @click.prevent="setComplete(service.reqId)">Set Complete</button>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Completed Requests Accordion -->
                    <div class="accordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#completedRequestsCollapse">
                                    Completed Requests
                                </button>
                            </h2>
                            <div id="completedRequestsCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul class="scroll">
                                        <li v-for="(service, index) in filterServices('complete')" :key="index" class="property-card">
                                            <p><strong>Property Id:</strong> {{ service.propId }}</p>
                                            <p><strong>Service Issue:</strong> {{ service.reqDetails }}</p>
                                            <p><strong>Service Status:</strong> Completed</p>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="message-box">
                    <h1>Tenant Communication</h1>

                    <!-- Send Message Accordion -->
                    <div class="accordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#sendMessageCollapse">
                                    Contact Tenant
                                </button>
                            </h2>
                            <div id="sendMessageCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <form @submit.prevent="submitMessage" class="message-form">
                                        <input v-model="message.userTo" type="number" placeholder="Search tenant by ID" />
                                        <!-- <select v-model="selectedTenant" required>
                                            <option value="" disabled selected>Select a tenant</option>
                                            <option v-for="tenant in filteredTenants" :key="tenant.userId" :value="tenant.userId">
                                                {{ tenant.fName }}
                                            </option>
                                        </select> -->
                                        <textarea v-model="message.msgBody" class="messageBox" name="text" cols="25" rows="5"
                                            placeholder="Enter your message" required></textarea>
                                        <div class="submit-button">
                                            <button type="submit" class="submit-message-button">Send Message</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- View Messages Accordion -->
                    <div class="accordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#viewMessagesCollapse">
                                    Message History
                                </button>
                            </h2>
                            <div id="viewMessagesCollapse" class="accordion-collapse collapse">
                                <div class="accordion-body">
                                    <ul class="scroll">
                                        <li v-for="(msg, index) in messages" :key="index" class="message-card">
                                            <p><strong>To:</strong> {{ msg.userTo }}</p>
                                            <p><strong>Date:</strong> {{ msg.msgDate }}</p>
                                            <p><strong>Message:</strong> {{ msg.msgBody }}</p>
                                        </li>
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
import MessageService from '../services/MessageService.js';
import ApplicationService from '../services/ApplicationService.js';
import ServiceRequestService from '../services/ServiceRequestService.js';
import LeaseService from '../services/LeaseService.js';
import UserService from '../services/UserService.js'
export default {
    data() {
        return {
            wait: false,
            fakeUserTo: '',
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
            leases: [],
            searchedTenant: '',
            selectedTenant: '',
            filteredTenants: [],
            messages: [],
            tenants: [],
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
                "reqStatus": "in_progress"
            },
            serviceComplete: {
                "reqId": '',
                "reqStatus": "complete"
            },
            terminated: {
                "leaseId" : '',
                "leaseStatus" : "terminated"
            }
        };
    },

    created() {
        // if(this.wait){
        this.loadApplications();
        this.loadServiceRequests();
        this.loadLeases();
        this.loadMessages();
        this.loadTenants();
        console.log(this.tenants)
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
            this.fakeUserTo = '';
            this.message.msgBody = '';
        },

        loadServiceRequests() {
            ServiceRequestService.getServiceRequest().then((e) => {
                this.services = e.data;
            });
            this.wait = true
        },
        loadApplications() {
            ApplicationService.getApplication().then((e) => {
                this.applications = e.data;
            });
        },
        loadLeases() {
            LeaseService.getAllLeases().then((e) => {
                this.leases = e.data;
            })
        },
        loadMessages() {
        MessageService.getMessageByUser(this.$store.state.user.id)
            .then(response => {
                this.messages = response.data;
            })
            .catch(error => {
                console.error('Error loading messages:', error);
            });
        },
        loadTenants() {
            UserService.getUsers().then(e => {
                this.tenants = e.data;
            })
            .catch((error) => {
                alert('Error loading tenants ' + error)
            })
        },

        setApprovedUser(appId) {
            this.approved.appId = appId;
            this.approveApplication();
            this.$router.go(0)
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
            this.$router.go(0)
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
        setTerminatedLease(leaseId) {
            this.terminated.leaseId = leaseId;
            this.terminateLease();
            this.$router.go(0)
        },
        terminateLease() {
            console.log(this.terminated)
            LeaseService.updateLease(this.terminated)
            .then(response => {
                alert('Lease terminated!')
        })
        .catch(error => {
            alert('Error terminating lease', error)
        })
        },
        
        setInProgress(reqId) {
            this.inProgress.reqId = reqId;
            this.inProgressServiceRequest();
            this.$router.go(0)
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
        setComplete(reqId) {
            this.serviceComplete.reqId = reqId;
            this.completeServiceRequest();
            this.$router.go(0)
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
        },
        filterServices(status) {
            if (status === 'all') return this.services;
            return this.services.filter(serv => serv.reqStatus.toLowerCase() === status);
        },
        filterLeases(status) {
            if (status === 'all') return this.leases;
            return this.leases.filter(lease => lease.leaseStatus.toLowerCase() === status);
        },
        searchTenant() {
            this.filteredTenants = this.tenants.filter(name => name.fName.toLowerCase().includes(this.searchedTenant.toLowerCase()));
        },
    }

    
}
</script>


<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Roboto', sans-serif;
  background-color: #e8f5e9;
  color: #1a1a1a;
  line-height: 1.6;
}

.all {
  width: 100%;
  max-width: 1400px;
  margin: 0 auto;
  padding: 20px;
  background-color: rgba(158,158,158,.137);
}

.greeting {
  text-align: center;
  margin-bottom: 30px;
  font-size: 1.5rem;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 30px;
}

.bottom-section,
.top-section {
  display: flex;
  flex-direction: column;
  gap: 30px;
  width: 100%;
}

.revenue-box,
.properties-box,
.leases-box,
.message-box {
  background-color: #fff;
  border-radius: 16px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  padding: 20px;
  width: 100%;
}

.message-form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.message-form input,
.message-form select,
.message-form textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #a5d6a7;
  border-radius: 5px;
  font-size: 1rem;
}

.messageBox {
  min-height: 100px;
  resize: vertical;
}

.submit-button {
  text-align: right;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
}

.in-progress-button {
  background-color: #f39c12;
  color: white;
}

.complete-button,
.submit-message-button,
.approve-button {
  background-color: #058805ea;
  color: white;
}

.deny-button {
  background-color: #901818c6;
  color: white;
}

.scroll {
  max-height: 400px;
  overflow-y: auto;
  padding-right: 10px;
}

.property-card,
.message-card {
  background-color: #fff;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 15px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.accordion-item {
  margin-bottom: 10px;
}

.accordion-button {
  width: 100%;
  text-align: left;
  padding: 15px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
  font-weight: 500;
}

.accordion-button:not(.collapsed) {
  background-color: #4CAF50;
  color: #1a1a1a;
}

.accordion-body {
  padding: 15px;
  background-color: #fff;
  border: 1px solid #a5d6a7;
  border-radius: 0 0 5px 5px;
}

.allButtons {
  display: flex;
  gap: 10px;
  margin-top: 10px;
}

@media (min-width: 768px) {
  .bottom-section,
  .top-section {
    flex-direction: row;
  }

  .revenue-box,
  .properties-box,
  .leases-box,
  .message-box {
    flex: 1;
  }
}

@media (max-width: 767px) {
  .all {
    padding: 10px;
  }

  .greeting {
    font-size: 1.2rem;
  }

  .accordion-button {
    font-size: 0.9rem;
  }

  .property-card,
  .message-card {
    padding: 10px;
  }
}


</style>