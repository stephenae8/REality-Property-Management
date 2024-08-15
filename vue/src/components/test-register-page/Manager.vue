<template>
    <div class="all">
      <h1 class="welcome-message">Service Request Management</h1>
      <div class="container">
        <div class="top-section">
          <!-- Service Requests -->
          <div class="service-box scroll" style="height:500px;overflow-x:hidden;">
            <p>Service Requests:</p>
            <button @click="setInProgress(reqId)" v-for="(req, reqId) in services" :key="reqId">{{ req }}</button>
            <br><hr>
          </div>
  
          <!-- Approve/Deny Applications -->
          <div class="applications-box scroll">
            <Accordion title="Pending Approvals" icon="fas fa-briefcase">
              <ul v-for="(application, appId) in applications" :key="appId">
                <li @click="setApprovedUser(appId)">{{ application }}</li>
              </ul>
            </Accordion>
  
            <Accordion title="Approved Applications" icon="fas fa-check-circle">
              <ul v-for="(application, appId) in applications.filter(app => app.status === 'approved')" :key="appId">
                <li @click="setDeniedUser(appId)">{{ application.name }}</li>
              </ul>
            </Accordion>
  
            <Accordion title="Denied Applications" icon="fas fa-times-circle">
              <ul v-for="(application, appId) in applications.filter(app => app.status === 'denied')" :key="appId">
                <li @click="setApprovedUser(appId)">{{ application.name }}</li>
              </ul>
            </Accordion>
  
          </div>
  
          <!-- Message Form -->
          <div class="message-form scroll" style="height:500px;overflow-x:hidden;">
            <input type="text" v-model="message.userTo">
            <textarea v-model="message.msgBody"></textarea>
            <button @click="submitMessage">Send Message</button>
            <p>{{ message.userTo }}</p>
          </div>
  
        </div>
  
        <!-- Bottom Section -->
        <div class="bottom-section">
          <!-- Service Request Statuses -->
          <div class="service-box scroll" style="height:500px;overflow-x:hidden;">
            <Accordion title="In Progress" icon="fas fa-spinner">
              <ul v-for="(req, reqId) in services.filter(req => req.status === 'in_progress')" :key="reqId">
                <li @click="setComplete(reqId)">{{ req.service }}</li>
              </ul>
            </Accordion>
  
            <Accordion title="Complete" icon="fas fa-check-circle">
              <ul v-for="(req, reqId) in services.filter(req => req.status === 'complete')" :key="reqId">
                <li @click="setApprovedUser(appId)">{{ req.service }}</li>
              </ul>
            </Accordion>
  
          </div>
  
        </div>
  
      </div>
    </div>
  </template>
  
  <script>
  import Accordion from './Accordion.vue'
  import MessageService from '../services/MessageService.js';
import ApplicationService from '../services/ApplicationService.js';
import ServiceRequestService from '../services/ServiceRequestService.js';
import LeaseService from '../services/LeaseService.js';
  
  export default {
    components: { Accordion },
    data() {
      return {
        message: {},
        services: [],
        applications: [],
        approved: { appId: '' },
        denied: { appId: '' },
        inProgress: { reqId: '' },
        serviceComplete: { reqId: '' }
      }
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
        ServiceRequestService.getServiceRequest()
          .then(response => {
            this.services = response.data;
            console.log(this.services)
          })
          .catch(error => {
            console.error('Error fetching services:', error);
          });
      },
      loadApplications() {
        ApplicationService.getApplication()
          .then(response => {
            this.applications = response.data;
            console.log(this.applications)
          })
          .catch(error => {
            console.error('Error fetching applications:', error);
          });
      }
    }
  }
  </script>