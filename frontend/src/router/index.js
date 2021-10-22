import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
];

const router = VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
