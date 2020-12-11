<template>
  <div>
      <h1>Hello</h1>
    
    <!-- <div class="cart" v-for="pizza in pizzas" v-bind:key="pizza.id"> -->
        <div>
        <h2 v-bind:name="$store.name"></h2>
    </div>
  </div>
</template>


<script >
export default {
  props: ["pizzas"],
};
</script>

<style scoped>
</style>