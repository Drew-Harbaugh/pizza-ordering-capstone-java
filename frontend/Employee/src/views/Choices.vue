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
          <h1 class="h3 mb-3 font-weight-normal">Menu Choices</h1>
        </div>
      </b-navbar>
    </div>
    <choices-list v-bind:choices="$store.state.choices"></choices-list>
    <new-choice></new-choice>
  </div>
</template>

<script>
import choicesList from "@/components/ChoicesList.vue";
import choiceService from "@/services/ChoiceService.js";
import newChoice from "@/components/NewChoice.vue";

export default {
  components: {
    choicesList,
    newChoice
  },
  created() {
    choiceService
      .getAllChoices()
      .then((response) => {
        this.$store.commit('SET_CHOICES', response.data);
      });
  },
};
</script>

<style>
#navbar {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "navbarLogo title .";
}

#navbarLogo {
  grid-area: navbarLogo;
}

#title {
  grid-area: title;
  color: white;
  display: flex;
  justify-content: center;
  padding-left: 23%;
}

.navBarLogo{
  width: 20vw;
}
</style>