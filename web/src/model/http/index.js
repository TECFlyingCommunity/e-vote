import Vue from "vue";
import VueResource from "vue-resource";

Vue.use(VueResource);

const http = Vue.http;

http.options.root = 'http://localhost:8080/';



http.interceptors.push(interceptors);

const setBearerToken = token => {
  http.headers.common['Authorization'] = `${token}`
}

const interceptors = ()=> {
  return ({ status }) => {
    if (status === 401) {
      this.$store.dispatch('auth/ActionSignOut')

      window._Vue.$router.push({ name: 'login' })
    }
  };
};

export { http, setBearerToken }