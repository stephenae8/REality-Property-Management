import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import PropertyService from '../services/PropertyService.js';

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
      property: []
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
     
      // PROPERTY(state){
      //   PropertyService.getProperty().then((e)=>{
      //     state.property = e.data;
      //   })
      // }
  
    },
   
  });
  return store;
}
