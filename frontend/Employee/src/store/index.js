import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    options: [
      {
        id: 1,
        name: 'Size',
        choices: ['small', 'medium', 'large']
      },
      {
        id: 2,
        name: 'Crust',
        choices: ['thin', 'regular', 'gluten-free']
      },
      {
        id: 3,
        name: 'Sauce',
        choices: ['tomato', 'alfredo', 'pesto', 'bbq']
      },
      {
        id: 4,
        name: 'Regular Toppings',
        choices: ['pepperoni', 'sausage', 'bacon', 'banana peppers', 'olives', 'mushrooms', 'green peppers']
      },
      {
        id: 5,
        name: 'Premium Toppings',
        choices: ['pineapple', 'fresh mozzarella', 'artichokes', 'steak']
      },
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
