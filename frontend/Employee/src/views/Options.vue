<template>
  <options-list v-bind:options="allOptions"></options-list>
</template>

<script>
import OptionsList from '@/components/OptionsList.vue';

export default {
    components: {
        OptionsList
    },
    computed: {
        allOptions() {
            return this.$store.state.options;
        }
    }

}
</script>

<style>

</style>