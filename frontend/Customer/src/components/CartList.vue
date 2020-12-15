<template>
  <div>
    <h1>Items in your cart:</h1>
    <div
      class="cart"
      v-for="orderItem in $store.state.cart"
      v-bind:key="orderItem.timeStamp"
    >
      <h3>{{ orderItem.pizza.name }}</h3>
      <p>{{ orderItem.size.name }}</p>
      <!-- change to only print proper price -->
      <p>{{ orderItem.size.specialtyPrice }}</p>
      <p>{{ orderItem.size.customPrice }}</p>
      <p>{{ orderItem.pizza.price }}</p>
      <div class="toppingsLists">
        
          <h4> Regular Toppings</h4>
        <div
          v-for="regularTopping in orderItem.pizza.regularToppings"
          v-bind:key="regularTopping.name"
        >
          <p>{{ regularTopping.name }}</p>
        </div>
        
        <h4>Premium Toppings</h4>
        <div
          v-for="premiumTopping in orderItem.pizza.premiumToppings"
          v-bind:key="premiumTopping.name"
        >
          <p>{{ premiumTopping.name }}</p>
        </div>
      </div>
      <button v-on:click="removeFromCart(orderItem)">Remove from Cart</button>
      <br />
      <br />
    </div>
    <div></div>
    <div>
      <h3 v-bind="getTotal()">Order Total: {{ total }}</h3>
    </div>
    <div>
      <form v-on:submit.prevent>
        <div>
          <label for="delivery">Delivery</label>
          <input type="radio" v-bind:value="true" v-model="delivery" />
          <label for="pickup">Pick Up</label>
          <input type="radio" v-bind:value="false" v-model="delivery">
        </div>
        <div>
          <label for="name">Name: </label>
          <input type="text" value="name" v-model="customer.name" />
        </div>
        <div>
          <label for="phoneNumber">Phone Number: </label>
          <input type="text" value="phoneNumber" v-model="customer.phoneNumber" />
        </div>
        <div v-if="delivery === true">
          <label for="address">Address: </label>
          <input type="text" value="address" v-model="customer.address" />
        </div>
        <div>
          <label for="creditCard">Credit Card #: </label>
          <input type="text" value="creditCard" v-model="customer.creditCard" />
        </div>
        <button v-on:click="submitOrder()">Submit Order</button>
      </form>
    </div>
  </div>
</template>


<script >
import orderService from "@/services/OrderService.js";

export default {
  data() {
    return {
      delivery: false,
      total: 0.00,
      customer: {}
    }
  },
  computed: {
    
  },
  methods: {
    removeFromCart(orderItem) {
      this.$store.commit("REMOVE_FROM_CART", orderItem);
      this.$store.commit("REMOVE_FROM_TOTAL", orderItem.size.price);
      this.getTotal();
    },
    getTotal() {
      this.total = this.$store.state.total;
      return this.total;
    },
    submitOrder() {
      const order = this.makeOrderObject();
      orderService.addNewOrder(order).then(response => {
        if(response.status === 201) {
          alert("Thanks for your order!");
        }
      }).catch(error => {
        console.log(error);
      });
    },
    makeOrderObject() {
      let order = {
        status: 'Pending',
        timeStamp: Date.now(),
        delivery: this.delivery,
        total: this.getTotal(),
        customer: {
          name: this.customer.name,
          phoneNumber: this.customer.phoneNumber,
          address: this.customer.address,
          creditCard: this.customer.creditCard
        },
        cart: this.$store.state.cart
      }
      return order;
    }
  }
};
</script>

<style scoped>
</style>