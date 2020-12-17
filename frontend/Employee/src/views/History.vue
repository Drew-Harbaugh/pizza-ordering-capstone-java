<template>
  <div>
    <Header></Header>
    <history-list v-bind:orders="this.$store.state.orders"></history-list>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import HistoryList from "@/components/HistoryList.vue";
import HistoryService from "@/services/HistoryService.js";

export default {
  components: {
    Header,
    HistoryList
  },
  created() {
    HistoryService.getAllOrders().then((response) => {
      this.$store.commit("SET_ORDERS", response.data);
    });
  },
};
</script>

<style>
</style>