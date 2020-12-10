<template>
  <div>
    <div>
      <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
        <div class="navBarLogo" id="navbarLogo">
          <b-img
            src="./anotherOneBitesTheCrustLogo.png"
            fluid
            alt="Pizza image"
          ></b-img>
        </div>

        <div id="title">
          <h1 class="h3 mb-3 font-weight-normal">Specials</h1>
        </div>
      </b-navbar>
    </div>
    <div id="body">
    <specials-list id="list" v-bind:specials="$store.state.specials"></specials-list>
    <new-special id="new"></new-special>
    </div>
  </div>
</template>

<script>
import specialsService from "@/services/SpecialsService.js";
import specialsList from "@/components/SpecialsList.vue";
import newSpecial from "@/components/NewSpecial.vue";
import choiceService from "@/services/ChoiceService.js";

export default {
  components: {
    specialsList,
    newSpecial,
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
#body{
  display:grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
      "list new"
}

#list{
  grid-area: "list";
}
#new{
  grid-area: "new";
}
</style>