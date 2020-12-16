<template>
  <div>
    <div>
      <header-bar id="navBar"></header-bar>
    </div>
    <div id="body">
    <specials-list v-bind:specials="$store.state.specials" v-bind:choices="$store.state.choices"></specials-list>
    </div>
  </div>
</template>

<script>
import SpecialsService from "@/services/SpecialsService.js";
import SpecialsList from "@/components/SpecialsList.vue";
import ChoiceService from "@/services/ChoiceService.js";
import HeaderBar from "@/components/HeaderBar.vue"

export default {
  components: {
    HeaderBar,
    SpecialsList,
  },
  created() {
    SpecialsService.getAllSpecials().then((response) => {
      this.$store.commit("SET_SPECIALS", response.data);
    });
    ChoiceService.getAllChoices().then((response) => {
      this.$store.commit("SET_CHOICES", response.data)
    });
  },
};
</script>

<style scope>
/* #body{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
} */
/* 
#list{
  grid-area: "list";
}
#new{
  grid-area: "new";
} */
</style>