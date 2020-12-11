<template>
  <div>
      <h1>Hello</h1>
    
    <div class="cart" v-for="orderItem in $store.state.cart" v-bind:key="orderItem.timeStamp">
        
        <!-- <h2 v-bind:name="$store.name"></h2> -->
    </div>
  </div>
</template>


<script >
export default {
  props: ["orderItem"],
};
</script>

<style scoped>
</style>