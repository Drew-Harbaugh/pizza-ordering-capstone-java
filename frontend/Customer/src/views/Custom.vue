<template>
  <div>
    <custom-list v-bind:choices="availableChoices"> </custom-list>
  </div>
</template>

<script>
import CustomList from "../components/CustomList.vue";
import ChoiceService from "@/services/ChoiceService.js";

export default {
  components: {
    CustomList,
  },
  computed: {
      availableChoices() {
          return this.$store.state.choices.filter((choice) => choice.available === true);
      }
  },
  methods: {},
  created() {
    ChoiceService.getAllChoices().then((response) => {
      this.$store.commit("SET_CHOICES", response.data);
    });
  },
};
</script>

<style>
</style>