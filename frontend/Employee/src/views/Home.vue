<template>
  <div>
    <Header></Header>
    <div class="home">
      <p>You must be authenticated to see this</p>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
export default {
  components: {
    Header,
  },
  created() {
    this.$router.push('/orders');
  }
};
</script>

<style scoped>
.home {
  height: 100vh;
}
</style>
