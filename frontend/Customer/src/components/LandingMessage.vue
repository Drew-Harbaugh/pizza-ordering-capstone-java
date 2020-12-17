<template>
  <div id="landing">
    <p id="thanks">Thanks for ordering, {{ $store.state.customerName }}!</p>
    <p id="dp" v-if="$store.state.delivery === true">Your order will be delivered in 35-40 minutes</p>
    <p id="dp" v-else>You order will be ready for pick up in 25-30 minutes</p>
    <div id="pizzaOven">
        <img src="@/Extras/pizza2.jpg" alt="Pizzas in a wood fired oven">
    </div>
  </div>
</template>

<script>
export default {
  destroyed() {
    this.$store.commit("REMOVE_CUSTOMER_INFO");
  },
};
</script>

<style>
#landing {
    padding-top: 10px;
    display: grid;
    grid-template: 
        "thanks"
        "dp"
        "img";
}
#thanks {
    grid-area: thanks;
    display: flex;
    justify-content: center;
    font-size: 25px;
}
#dp {
    grid-area: dp;
    display: flex;
    justify-content: center;
    font-size: 20px;
}
#pizzaOven {
    grid-area: img;
    display: flex;
    justify-content: center;
    padding-bottom: 10px;
    
}
#pizzaOven img {
    border: solid #dc3545 5px;
}
</style>