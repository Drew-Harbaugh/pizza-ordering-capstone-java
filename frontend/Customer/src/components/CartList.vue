<template>
  <div>
    <h1>Items in your cart:</h1>
    <div class="cart" v-for="orderItem in $store.state.cart" v-bind:key="orderItem.timeStamp">
      <h3>{{ orderItem.pizza.name }}</h3>      
      <p>{{ orderItem.size.name }}</p>
      <p>{{ orderItem.pizza.price }}</p>
    </div>
    <h3>Order Total: </h3>
  </div>
</template>


<script >
export default {
  props: ["orderItem"],
};
</script>

<style scoped>
</style>