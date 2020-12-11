<template>
  <div>
    <Header></Header>
    <div class="home">
      <h1>Home</h1>
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
};
</script>

<style scoped>
.home {
  height: 100vh;
}
h1 {
  color: white;
  background-color: #dc3545;
  text-align: center;
  width: 100%;
}
</style>
