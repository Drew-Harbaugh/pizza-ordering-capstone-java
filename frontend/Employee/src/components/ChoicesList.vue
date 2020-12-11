<template>
  <div>
    <div class="category-columns">
      <category-column v-bind:sortedChoices="size" id="size"></category-column>
      <category-column
        v-bind:sortedChoices="crust"
        id="crust"
      ></category-column>
      <category-column
        v-bind:sortedChoices="sauce"
        id="sauce"
      ></category-column>
      <category-column
        v-bind:sortedChoices="regularToppings"
        id="regularToppings"
      ></category-column>
      <category-column
        v-bind:sortedChoices="premiumToppings"
        id="premiumToppings"
      ></category-column>
    </div>
    <button v-on:click="deleteChoices()">Delete</button>
    <button v-on:click="makeAvailable()">Make Available</button>
    <button v-on:click="makeUnavailable()">Make Unavailable</button>
  </div>
</template>

<script>
import categoryColumn from "@/components/CategoryColumn.vue";
import choiceService from "@/services/ChoiceService.js";

export default {
  components: {
    categoryColumn,
  },
  props: ["choices"],
  computed: {
    size() {
      return this.choices.filter((choice) => choice.categoryId === 1);
    },
    crust() {
      return this.choices.filter((choice) => choice.categoryId === 2);
    },
    sauce() {
      return this.choices.filter((choice) => choice.categoryId === 3);
    },
    regularToppings() {
      return this.choices.filter((choice) => choice.categoryId === 4);
    },
    premiumToppings() {
      return this.choices.filter((choice) => choice.categoryId === 5);
    },
  },
  methods: {
    deleteChoices() {
      const choicesToChange = this.$store.state.changeChoices;
      choicesToChange.forEach((choice) => {
        choiceService
          .deleteChoice(choice.choiceId)
          .then((response) => {
            if (response.status === 200) {
              this.updateChoices();
            } else if (response.status === 500) {
              alert("Could not delete one or more choices");
              this.updateChoices();
            }
          })
          .catch((error) => {
            console.log(error.message);
          });
      });
      this.emptyChangeChoiceArray();
    },
    emptyChangeChoiceArray() {
      this.$store.commit("EMPTY_CHOICES");
    },
    updateChoices() {
      choiceService.getAllChoices().then((response) => {
        this.$store.commit("SET_CHOICES", response.data);
      });
    },
    makeUnavailable() {
      const choicesToChange = this.$store.state.changeChoices;
      choicesToChange.forEach((choice) => {
        if (choice.available === true) {
          choice.available = false;
        }
        this.updateChoice(choice);
      });
      this.emptyChangeChoiceArray();
    },
    makeAvailable() {
      const choicesToChange = this.$store.state.changeChoices;
      choicesToChange.forEach((choice) => {
        if (choice.available === false) {
          choice.available = true;
        }
        this.updateChoice(choice);
      });
      this.emptyChangeChoiceArray();
    },
    updateChoice(choice) {
      choiceService
        .updateChoice(choice)
        .then((response) => {
          if (response.status === 200) {
            this.updateChoices();
          } else if (response.status === 500) {
            alert("Could not update one or more choices");
            this.updateChoices();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
  },
};
</script>

<style>
.category-columns {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "size reg"
    "crust reg"
    "sauce prem";
  text-align: center;
}

#size {
  grid-area: size;
}

#crust {
  grid-area: crust;
}

#sauce {
  grid-area: sauce;
}

#regularToppings {
  grid-area: reg;
}

#premiumToppings {
  grid-area: prem;
}
</style>