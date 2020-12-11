<template>
  <div>
    <Header></Header>
    <div id="body">
      <specials-list
        id="list"
        v-bind:specials="$store.state.specials"
      ></specials-list>
      <new-special id="new"></new-special>
    </div>
  </div>
</template>

<script>
import specialsService from "@/services/SpecialsService.js";
import specialsList from "@/components/SpecialsList.vue";
import newSpecial from "@/components/NewSpecial.vue";
import choiceService from "@/services/ChoiceService.js";
import Header from "@/components/Header.vue";

export default {
  components: {
    specialsList,
    newSpecial,
    Header,
  },
  created() {
    specialsService.getAllSpecials().then((response) => {
      this.$store.commit("SET_SPECIALS", response.data);
    });
    choiceService.getAllChoices().then((response) => {
      this.$store.commit("SET_CHOICES", response.data);
    });
  },
};
</script>

<style scope>
#body {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "list new";
}
#list {
  grid-area: "list";
}
#new {
  grid-area: "new";
}
</style>