<template>
  <div>
    <form v-on:submit.prevent="addNewSpecial"> <!--implement this method-->
      <div>
        <label for="specialName">Special Name:</label>
        <input type="text" v-model="newSpecial.name" /> <!--implement this data-->
      </div>
      <div>
          <label for="specialDescription">Description:</label>
          <textarea cols="30" rows="10" v-model="newSpecial.description"></textarea>
      </div>
      <div>
        <!--add a loop to print all choices as checkboxes-->
      </div>
      <div>
        <button v-on:click.prevent="resetForm">Cancel</button>
        <button>Add New Specialty Pizza</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {

}
</script>

<style>
</style>