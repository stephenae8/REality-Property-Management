<template>
    <div class="manager-dashboard">
      <header class="welcome-message">
        <h1>Welcome, {{ this.$store.state.user.fName }}</h1>
      </header>
      <div class="dashboard-container">
        <section class="service-requests">
          <h2>Service Requests</h2>
          <div class="scroll">
            <div v-for="(service, index) in services" :key="index" class="request-card">
              <h3>Property ID: {{ service.propId }}</h3>
              <p><strong>Issue:</strong> {{ service.reqDetails }}</p>
              <p><strong>Status:</strong> {{ service.reqStatus }}</p>
              <div class="button-group">
                <button @click.prevent="setInProgress(service.reqId)" class="btn btn-primary">In Progress</button>
                <button @click.prevent="setComplete(service.reqId)" class="btn btn-success">Complete</button>
              </div>
            </div>
          </div>
        </section>
        
        <section class="message-form">
          <h2>Send A Message</h2>
          <form @submit.prevent="submitMessage">
            <input v-model="message.userTo" type="number" placeholder="Enter User ID" required />
            <textarea v-model="message.msgBody" class="messageBox" placeholder="Enter Your Message" required></textarea>
            <button type="submit" class="btn btn-primary">Send Message</button>
          </form>
        </section>
        
        <section class="applications">
          <h2>Applications</h2>
          <div class="accordion">
            <div class="accordion-item" v-for="status in ['Pending', 'Approved', 'Denied', 'All']" :key="status">
              <h3 @click="toggleAccordion(status)" class="accordion-header">
                {{ status }} Applications
                <span class="accordion-icon">{{ accordionState[status] ? '▼' : '▶' }}</span>
              </h3>
              <div v-if="accordionState[status]" class="accordion-content">
                <div v-for="(application, index) in filteredApplications(status)" :key="index" class="application-card">
                  <p><strong>User ID:</strong> {{ application.userId }}</p>
                  <p><strong>Move In Date:</strong> {{ application.moveInDate }}</p>
                  <p><strong>Status:</strong> {{ application.appStatus }}</p>
                  <div class="button-group" v-if="status === 'Pending'">
                    <button @click.prevent="setApprovedUser(application.userId)" class="btn btn-success">Approve</button>
                    <button @click.prevent="setDeniedUser(application.userId)" class="btn btn-danger">Deny</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </template>
  
  <script>
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
          msgDate: new Date().toISOString()
        },
        services: [],
        applications: [],
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
          "lastUpdated": new Date().toISOString(),
        },
        serviceComplete: {
          "reqId": '',
          "reqStatus": "complete",
          "lastUpdated": new Date().toISOString(),
        },
        accordionState: {
          Pending: false,
          Approved: false,
          Denied: false,
          All: false
        }
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
        setApprovedUser(userId) {
            this.approved.userId = userId;
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
  
      toggleAccordion(status) {
        this.accordionState[status] = !this.accordionState[status];
      },
  
      filteredApplications(status) {
        if (status === 'All') return this.applications;
        return this.applications.filter(app => app.appStatus.toLowerCase() === status.toLowerCase());
      }
    }
  }
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');
  
  .manager-dashboard {
    font-family: 'Roboto', sans-serif;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .welcome-message {
    text-align: center;
    margin-bottom: 30px;
    border-bottom: 2px solid #e0e0e0;
    padding-bottom: 15px;
  }
  
  .dashboard-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
    gap: 20px;
  }
  
  .service-requests, .message-form, .applications {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    padding: 20px;
  }
  
  h2 {
    margin-bottom: 20px;
    color: #333;
  }
  
  .scroll {
    max-height: 400px;
    overflow-y: auto;
  }
  
  .request-card, .application-card {
    background-color: #f9f9f9;
    border: 1px solid #e0e0e0;
    border-radius: 4px;
    padding: 15px;
    margin-bottom: 15px;
  }
  
  .button-group {
    display: flex;
    gap: 10px;
    margin-top: 10px;
  }
  
  .btn {
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .btn-primary {
    background-color: #007bff;
    color: white;
  }
  
  .btn-success {
    background-color: #28a745;
    color: white;
  }
  
  .btn-danger {
    background-color: #dc3545;
    color: white;
  }
  
  .btn:hover {
    opacity: 0.9;
  }
  
  input, textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .messageBox {
    min-height: 100px;
  }
  
  .accordion-item {
    border: 1px solid #e0e0e0;
    border-radius: 4px;
    margin-bottom: 10px;
  }
  
  .accordion-header {
    background-color: #f5f5f5;
    padding: 10px 15px;
    cursor: pointer;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .accordion-content {
    padding: 15px;
  }
  
  @media (max-width: 768px) {
    .dashboard-container {
      grid-template-columns: 1fr;
    }
  }
  </style>  