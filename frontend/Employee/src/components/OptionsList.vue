<template>
  <div class="option-columns">
    <div v-for="option in options" v-bind:key="option.id">
      <h2>{{ option.name }}</h2>
      <ul v-for="subOption in option.choices" v-bind:key="subOption">
        <li>{{ subOption }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: ["options"],
};
</script>

<style>

    .option-columns {
        display: flex;
        justify-content: space-around;
    }

</style>