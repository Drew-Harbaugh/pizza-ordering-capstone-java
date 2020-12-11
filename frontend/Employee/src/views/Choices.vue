<template>
  <div>
    <Header></Header>
    <choices-list v-bind:choices="$store.state.choices"></choices-list>
    <new-choice></new-choice>
  </div>
</template>

<script>
import choicesList from "@/components/ChoicesList.vue";
import choiceService from "@/services/ChoiceService.js";
import newChoice from "@/components/NewChoice.vue";
import Header from "@/components/Header.vue";

export default {
  components: {
    choicesList,
    newChoice,
    Header,
  },
  created() {
    choiceService.getAllChoices().then((response) => {
      this.$store.commit("SET_CHOICES", response.data);
    });
  },
};
</script>

<style scope>
</style>