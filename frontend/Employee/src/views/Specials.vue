<template>
  <div>
	  <specials-list v-bind:specials="$store.state.specials"></specials-list>
  </div>
</template>

<script>
import specialsService from "@/services/SpecialsService.js";
import specialsList from "@/components/SpecialsList.vue";



export default {
	components: {
		specialsList,
	},
	created() {
		specialsService.getAllSpecials().then ((response) => {
			this.$store.commit('SET_SPECIALS', response.data);
		});
	}

}
</script>

<style>

</style>