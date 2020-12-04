<template>
  <div>
    <form v-on:submit.prevent="addNewOption">
      <div>
        <label for="optionName">New Option:</label>
        <input type="text" v-model="newOption.optionName"/>
      </div>
      <div>
          <label for="categoryName">Category:</label>
            <select v-model="newOption.categoryName">
                <option value="Size">Size</option>
                <option value="Crust">Crust</option>
                <option value="Sauce">Sauce</option>
                <option value="Regular Toppings">Regular Toppings</option>
                <option value="Premium Toppings">Premium Toppings</option>
            </select>
      </div>
      <div>
          <button v-on:click.prevent="resetForm">Cancel</button>
          <button>Add New Option</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newOption: {
        categoryName: "",
        optionName: ""
      },
    };
  },
  props: ["options"],
  methods: {
      addNewOption() {
        //   this.options.forEach(element => {
        //       if (element.name === this.newOption.categoryName) {
        //           element.choices.push(this.newOption.optionName);
        //       }
        //   });
        this.$store.commit('ADD_OPTION', this.newOption);
        this.$router.push('/options');
          
      },
      resetForm() {
          this.newOption = {};
          this.$router.push('/options');
      }
  }
};
</script>

<style>

    

</style>