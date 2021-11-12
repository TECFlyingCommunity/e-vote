<template>
    <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
      <div class="container">
        <div class="card login-card">
          <div class="row no-gutters">
            <div class="col-md-5">
              <img
                src="./../../assets/images/2.png"
                alt="login"
                class="login-card-img"
              />
              <p
                class="
                  text-white
                  font-weight-medium
                  text-center
                  flex-grow
                  align-self-end
                  footer-link
                  text-small
                "
              >
                
              </p>
            </div>
            <div id="vtb" class="col-md-7">
              <div class="card-body">
                <div class="brand-wrapper">
                  <img src="./../../assets/logo.png" alt="logo" class="logo" />
                </div>
                <p id="roboto" class="login-card-description">FAÇA SEU LOGIN</p>
                <form @submit.prevent="submit()">
                  <div id="vvb" class="form-group">
                    <label for="email" class="sr-only">Email</label>
                    <input
                      type="email"
                      name="email"
                      id="email"
                      v-model="form.email"
                      class="form-control"
                      placeholder="Email"
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="password" class="sr-only">Senha</label>
                    <input
                      type="password"
                      name="senha"
                      id="password"
                      v-model="form.senha"
                      class="form-control"
                      placeholder="***********"
                    />
                  </div>
                  <input
                    name="login"
                    id="login"
                    class="btn btn-block login-btn mb-4"
                    type="submit"
                    value="Login"
                  />
                </form>
                <a href="#!" class="forgot-password-link"
                  >Esqueceu Sua Senha?</a
                >
                <p class="login-card-footer-text">
                  Não tem uma conta ?
                  <a href="/cadastro" class="text-reset">Registre-se aqui</a>
                </p>
                <nav class="login-card-footer-nav">
                  <a href="#!">Termos de uso.</a>
                  <a href="#!">Politica de Privacidade</a>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
</template>

<script>
import "bootstrap/dist/css/bootstrap.min.css";
import "@mdi/font/css/materialdesignicons.min.css";
import "./../../assets/css/estiloLogin.css";
import { mapActions } from 'vuex'
import * as actionsTypes from '../../controller/store/actions-types';  
export default {
  
    name: 'Login',
    data: () => ({
    form: {
      email: '',
      senha: ''
    }
  }),
  methods: {
    ...mapActions([actionsTypes.ActionDoLogin]),
    async submit () {
      try {
        console.log(this.form)
        await this.ActionDoLogin(this.form)
        this.$router.push({ name: 'Home' })
      } catch (err) {
        alert(err.data ? err.data.message : 'Não foi possível fazer login')
      }
    }
  }
}
</script>
