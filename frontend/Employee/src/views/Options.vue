<template>
  <div>
    <options-list v-bind:options="allOptions"></options-list>
    <new-option v-bind:options="allOptions"></new-option>
  </div>
</template>

<script>
import OptionsList from "@/components/OptionsList.vue";
import NewOption from "@/components/NewOption.vue";
import OptionService from "@/services/OptionService.js";

export default {
  components: {
    OptionsList,
    NewOption,
  },
  data() {
    return {
      options: []
    }
  },
  computed: {
    allOptions() {
      return this.$store.state.options; // currently pulling dummy data from the datastore, will change to pull from API
    },
  },
  create() {
    OptionService.getChoicesByCategory(this.$route.params.categoryID).then(response => {
      this.options = response.data;
    });
  }
};
</script>

<style>
</style>