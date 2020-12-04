<template>
  <div>
    <options-list v-bind:options="allOptions"></options-list>
    <new-option v-bind:options="allOptions"></new-option>
  </div>
</template>

<script>
import OptionsList from "@/components/OptionsList.vue";
import NewOption from "@/components/NewOption.vue";

export default {
  components: {
    OptionsList,
    NewOption,
  },
  computed: {
    allOptions() {
      return this.$store.state.options; // currently pulling dummy data from the datastore, will change to pull from API
    },
  },
};
</script>

<style>
</style>