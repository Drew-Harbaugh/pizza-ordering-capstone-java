<template>
  <div>
    <h1>Items in your cart:</h1>
    <div class="cart" v-for="orderItem in $store.state.cart" v-bind:key="orderItem.timeStamp">
      <h3>{{ orderItem.pizza.name }}</h3>      
      <p>{{ orderItem.size.name }}</p>
      <p>{{ orderItem.pizza.price }}</p>
      <div class="toppingsLists">
          <h4>Regular Toppings</h4>
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
        <br>
        <br>
    </div>
    <h3>Order Total: </h3>
  </div>
</template>


<script >
export default {
  props: ["orderItem"],
  methods: {
    removeFromCart(orderItem) {
      this.$store.commit('REMOVE_FROM_CART', orderItem);
    }
  }
};
</script>

<style scoped>
</style>