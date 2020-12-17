import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */

export default new Vuex.Store({
  state: {
    choices: [],
    specials: [],
    cart: [],
    total: 0.00,
    customerName: '',
    delivery: false
  },
  mutations: {
    SET_SPECIALS(state, specials) {
      state.specials = specials;
    },
    SET_CHOICES(state, choices) {
      state.choices = choices;
    },
    ADD_TO_CART(state, pizza) {
      pizza.timeStamp = Date.now();
      state.cart.unshift(pizza);
    },
    REMOVE_FROM_CART(state, pizza) {
      pizza.timeStamp = Date.now();
      const index = state.cart.indexOf(pizza);
      state.cart.splice(index, 1);
    },
    ADD_TO_TOTAL(state, price) {
      state.total += price;
    },
    REMOVE_FROM_TOTAL(state, price) {
      state.total -= price;
    },
    ADD_CUSTOMER_INFO(state, info) {
      state.customerName = info.name;
      state.delivery = info.delivery;
    },
    RESET_DATA_STORE(state) {
      state.choices = [];
      state.specials = [];
      state.cart = [];
      state.total = 0.00;
    },
    REMOVE_CUSTOMER_INFO(state) {
      state.customerName = '';
      state.delivery = false;
    }
  }
})