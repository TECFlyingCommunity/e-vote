import Vue from 'vue'
import App from './App.vue'
import vuetify from './controller/plugins/vuetify'
import router from './controller/routes';
import store from './controller/store';
import Chartkick from 'vue-chartkick'
import Chart from 'chart.js'


Vue.config.productionTip = false;


Vue.use(Chartkick.use(Chart));

new Vue({
  vuetify,
  router,
  store,
  render: h => h(App),


}).$mount('#app')
