// @ts-nocheck

import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Specials from '@/views/Specials.vue'
import Cart from '@/views/Cart.vue'
import Custom from '@/views/Custom.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/specials',
      name: 'specials',
      component: Specials,
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
    {
      path: '/custom',
      name: 'custom',
      component: Custom
    }
  ]
})

export default router;
