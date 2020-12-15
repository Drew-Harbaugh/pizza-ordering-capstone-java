<template>
  <div>
    <div v-for="order in orders" v-bind:key="order.orderId">
      <h2>{{ order.orderId }}</h2>
      <div class="customer">
        <h3>{{ order.customer.name }}</h3>
        <p>{{ order.customer.phoneNumber }}</p>
        <p>{{ order.customer.address }}</p>
      </div>
      <div class="status">
        <h3>{{ order.status }}</h3>
      </div>
      <div class="pizzas" v-for="pizzaObject in order.cart" v-bind:key="pizzaObject">
        <div class="pizza">
          <h2 class="name">{{ pizzaObject.pizza.name }}</h2>
          <h3>{{pizzaObject.size.name}}</h3>
          <h3>{{pizzaObject.pizza.crust.name}}</h3>
          <h3>{{pizzaObject.pizza.sauce.name}}</h3>
          <div class="toppingsLists">
            <h4>Regular Toppings</h4>
            <div v-for="regularTopping in pizzaObject.pizza.regularToppings" v-bind:key="regularTopping.name">
              <p>{{ regularTopping.name }}</p>
            </div>
            <h4>Premium Toppings</h4>
            <div v-for="premiumTopping in pizzaObject.pizza.premiumToppings" v-bind:key="premiumTopping.name">
              <p>{{ premiumTopping.name }}</p>
            </div>
          </div>
        </div>
        <!-- <button v-on:click="deleteSpecial(special)">Delete</button>
        <button v-on:click="makeAvailable(special)">Make Available</button>
        <button v-on:click="makeUnavailable(special)">Make Unavailable</button> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["orders"],
};
</script>

<style>
</style>