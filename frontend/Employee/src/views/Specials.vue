<template>
  <div>
    <specials-list v-bind:specials="$store.state.specials"></specials-list>
    <new-special></new-special>
  </div>
</template>

<script>
import specialsService from "@/services/SpecialsService.js";
import specialsList from "@/components/SpecialsList.vue";
import newSpecial from "@/components/NewSpecial.vue";

export default {
  components: {
    specialsList,
    newSpecial
  },
  created() {
    specialsService.getAllSpecials().then((response) => {
      this.$store.commit("SET_SPECIALS", response.data);
    });
  },
};
</script>

<style>
</style>