<template>
<div>
  <div v-for="special in specials" v-bind:key="special.specialtyId">
	  <div>
		  <h2>{{special.name}}</h2>
		  <p>{{special.description}}</p>
          <h3>{{special.price}}</h3>
	  </div>
  </div>
  </div>
</template>

<script>
export default {
	props: ['specials'],
}
</script>

<style>

</style>