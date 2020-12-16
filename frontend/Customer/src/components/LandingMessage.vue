<template>
  <div>
      <p>Thanks for ordering, {{$store.state.customerName}}</p>
      <p>Your order will be ready soon!</p>
  </div>
</template>

<script>
export default {
    destroyed() {
        this.$store.commit("RESET_DATA_STORE");
    },

}
</script>

<style>

</style>