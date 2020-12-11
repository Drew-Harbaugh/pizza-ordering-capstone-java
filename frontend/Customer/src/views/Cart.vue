<template>
  <div>
      <header-bar id="navBar"></header-bar>
    <cart-list></cart-list>
  </div>
</template>


<script >
import CartList from "@/components/CartList.vue"
import HeaderBar from "@/components/HeaderBar.vue"

export default {
    components: {
        CartList,
        HeaderBar,
      
    },
  props: ["pizzas"],
};
</script>

<style scoped>
</style>