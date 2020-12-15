<template>
  <div>
    <Header></Header>
    <orders-list v-bind:orders="this.$store.state.orders"></orders-list>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import OrdersList from "@/components/OrdersList.vue";
import OrderService from "@/services/OrderService.js";

export default {
  components: {
    Header,
    OrdersList,
  },
  created() {
    OrderService.getAllOrders().then((response) => {
      this.$store.commit("SET_ORDERS", response.data);
    });
  },
};
</script>

<style>
</style>