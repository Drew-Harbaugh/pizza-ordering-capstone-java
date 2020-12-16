<template>
  <div>
    <header-bar />
    <landing-message />
  </div>
</template>

<script>
import LandingMessage from "@/components/LandingMessage.vue";
import HeaderBar from "@/components/HeaderBar.vue";

export default {
  components: {
    HeaderBar,
    LandingMessage,
  },
};
</script>

<style>
</style>