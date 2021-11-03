import Vue from 'vue'
import App from './App.vue'
import vuetify from './controller/plugins/vuetify'
import router from './controller/routes';
import store from './controller/store';


Vue.config.productionTip = false

new Vue({
  vuetify,
  router,
  store,
  render: h => h(App),


}).$mount('#app')
