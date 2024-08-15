import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import PropertyService from '../services/PropertyService.js';
import LeaseService from '../services/LeaseService.js';
import MessageService from '../services/MessageService.js';
import RequestService from '../services/RequestService.js'

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {
        authorities: [
          {
            name: 'ROLE_ANON'
          }
        ]
      },
      property: [],
      lease: {},
      message: [],
      request: {},
      leases: []

    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {
          authorities: [
            {
              name: 'ROLE_ANON'
            }
          ]
        };
        axios.defaults.headers.common = {};
      },

      SET_LEASE(state){
        LeaseService.leaseById(state.user.id).then((e)=>{
          
          state.lease = e.data
        })
      },
      SET_LEASES(state) {
        LeaseService.getAllLeases().then((e)=>{
          state.leases = e.data
        })
      },
      
      SET_PROPERTY(state){
          PropertyService.getProperty().then((e)=>{
            state.property = e.data
          })
      },

      SET_MESSAGE(state){
        MessageService.getMessageByUser(state.user.id).then((e)=>{
          state.message = e.data
        })
      },

      SET_REQUEST(state){
        RequestService.getRequestbyId(state.user.id).then((e)=>{
          state.request = e.data
        })
      }


     
      // PROPERTY(state){
      //   PropertyService.getProperty().then((e)=>{
      //     state.property = e.data;
      //   })
      // }
  
    },
   
  });
  return store;
}
