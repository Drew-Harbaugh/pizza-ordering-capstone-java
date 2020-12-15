<template>
  <div>
    <h1>Pending Orders</h1>
    <div v-for="order in pendingOrders" v-bind:key="order.orderId">
      <h2>{{ order.orderId }}</h2>
      <div class="customer">
        <h3>{{ order.customer.name }}</h3>
        <p>{{ order.customer.phoneNumber }}</p>
        <p>{{ order.customer.address }}</p>
      </div>
      <div class="status">
        <h3>{{ order.status }}</h3>
      </div>
      <div
        class="pizzas"
        v-for="pizzaObject in order.cart"
        v-bind:key="pizzaObject.pizzaId"
      >
        <div class="pizza">
          <h2 class="name">{{ pizzaObject.pizza.name }}</h2>
          <h3>{{ pizzaObject.size.name }}</h3>
          <h3>{{ pizzaObject.pizza.crust.name }}</h3>
          <h3>{{ pizzaObject.pizza.sauce.name }}</h3>
          <div class="toppingsLists">
            <h4>Regular Toppings</h4>
            <div
              v-for="regularTopping in pizzaObject.pizza.regularToppings"
              v-bind:key="regularTopping.name"
            >
              <p>{{ regularTopping.name }}</p>
            </div>
            <h4>Premium Toppings</h4>
            <div
              v-for="premiumTopping in pizzaObject.pizza.premiumToppings"
              v-bind:key="premiumTopping.name"
            >
              <p>{{ premiumTopping.name }}</p>
            </div>
          </div>
        </div>
      </div>
      <button v-on:click="markCancelled(order.orderId)">Cancelled</button>
      <button v-on:click="markReady(order.orderId)">Ready</button>
      <button v-on:click="markComplete(order.orderId)">Complete</button>
    </div>
    <h1>Order History</h1>
    <div v-for="order in orderHistory" v-bind:key="order.orderId">
      <h2>{{ order.orderId }}</h2>
      <div class="customer">
        <h3>{{ order.customer.name }}</h3>
        <p>{{ order.customer.phoneNumber }}</p>
        <p>{{ order.customer.address }}</p>
      </div>
      <div class="status">
        <h3>{{ order.status }}</h3>
      </div>
      <div
        class="pizzas"
        v-for="pizzaObject in order.cart"
        v-bind:key="pizzaObject.pizzaId"
      >
        <div class="pizza">
          <h2 class="name">{{ pizzaObject.pizza.name }}</h2>
          <h3>{{ pizzaObject.size.name }}</h3>
          <h3>{{ pizzaObject.pizza.crust.name }}</h3>
          <h3>{{ pizzaObject.pizza.sauce.name }}</h3>
          <div class="toppingsLists">
            <h4>Regular Toppings</h4>
            <div
              v-for="regularTopping in pizzaObject.pizza.regularToppings"
              v-bind:key="regularTopping.name"
            >
              <p>{{ regularTopping.name }}</p>
            </div>
            <h4>Premium Toppings</h4>
            <div
              v-for="premiumTopping in pizzaObject.pizza.premiumToppings"
              v-bind:key="premiumTopping.name"
            >
              <p>{{ premiumTopping.name }}</p>
            </div>
          </div>
        </div>
        <button v-on:click="markPending(order.orderId)">Pending</button>
        <button v-on:click="markCancelled(order.orderId)">Cancelled</button>
        <button v-on:click="markReady(order.orderId)">Ready</button>
        <button v-on:click="markComplete(order.orderId)">Complete</button>
      </div>
    </div>
  </div>
</template>

<script>
import orderService from "@/services/OrderService.js";

export default {
  props: ["orders"],
  computed: {
    pendingOrders() {
      return this.orders.filter((order) => order.status === "Pending");
    },
    orderHistory() {
      return this.orders.filter((order) => order.status !== "Pending");
    },
  },
  methods: {
    markCancelled(orderId) {
      let order = {
        orderId: orderId,
        status: "Cancelled",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markComplete(orderId) {
      let order = {
        orderId: orderId,
        status: "Complete",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markReady(orderId) {
      let order = {
        orderId: orderId,
        status: "Ready",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markPending(orderId) {
      let order = {
        orderId: orderId,
        status: "Pending",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    refreshOrders() {
      orderService.getAllOrders().then((response) => {
        this.$store.commit("SET_ORDERS", response.data);
      });
    },
  },
};
</script>

<style>
</style>