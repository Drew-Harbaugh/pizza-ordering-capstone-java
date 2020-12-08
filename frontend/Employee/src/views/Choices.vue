<template>
  <div>
    <choices-list v-bind:choices="allChoices"></choices-list>
  </div>
</template>

<script>
import choicesList from "@/components/ChoicesList.vue";
import choiceService from "@/services/ChoiceService.js";

export default {
  components: {
    choicesList,
  },
  data() {
    return {
      allChoices: [],
    };
  },
  created() {
    choiceService
      .getAllChoices() // where is this param coming from?
      .then((response) => {
        this.allChoices = response.data;
      });
  },
};
</script>

<style>
</style>