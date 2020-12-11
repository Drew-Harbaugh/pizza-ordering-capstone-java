<template>
  <div class="list">
    <h2 class="title">{{ title }}</h2>
    <div
      class="name"
      v-for="choice in sortedChoices"
      v-bind:key="choice.choiceId"
    >
      <ul>
        <li v-bind:class="{ unavailable: !choice.available }">
          <input
            type="checkbox"
            v-bind:value="choice"
            v-bind:checked="$store.state.changeChoices.includes(choice)"
            v-on:change="toggleChoice(choice)"
          />
          {{ choice.name }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: ["sortedChoices"],
  data() {
    return {};
  },
  computed: {
    title() {
      if (this.sortedChoices.length === 0) {
        return "";
      }
      const oneChoice = this.sortedChoices[0];
      if (oneChoice.categoryId === 1) {
        return "Size";
      } else if (oneChoice.categoryId === 2) {
        return "Crust";
      } else if (oneChoice.categoryId === 3) {
        return "Sauce";
      } else if (oneChoice.categoryId === 4) {
        return "Regular Toppings";
      } else {
        return "Premium Toppings";
      }
    },
  },
  methods: {
    toggleChoice(choice) {
      this.$store.commit("TOGGLE_CHOICES", choice);
    },
  },
};
</script>

<style>
li {
  list-style: none;
  font-family: Pizzeria;
  font-size: 1.2rem;
}
h2 {
  font-family: Pizzeria;
}
.title {
  grid-area: title;
}
.name {
  grid-area: name;
}
.unavailable {
  text-decoration: line-through;
}
</style>