<template>

    <div class="d-flex align-items-center min-vh-100 py-3 py-md-0">
      <div class="container">
        <div class="card login-card">
          <div class="row no-gutters">
            <div class="col-md-5">
              <img src="./../../assets/images/1.png" alt="login" class="login-card-img" />
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
              ></p>
            </div>
            <div id="vtb" class="col-md-7">
              <div class="card-body">
                <div class="brand-wrapper">
                  <img src="./../../assets/logo.png" alt="logo" class="logo" />
                </div>
                <p id="roboto" class="login-card-description">
                  Faça seu Cadastro
                </p>
                <form action="/cadastro" method="POST">
                  <div id="vvb" class="form-group">
                    <label for="nome_completo" class="sr-only"></label>
                    <input
                      type="text"
                      name="nome"
                      id="nome_completo"
                      class="form-control"
                      placeholder="Nome Completo"
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="cpf" class="sr-only"></label>
                    <input
                      type="text"
                      name="cpf"
                      id="cpf"
                      class="form-control"
                      placeholder="CPF "
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="titulo" class="sr-only"></label>
                    <input
                      type="text"
                      name="titulo"
                      id="titulo"
                      class="form-control"
                      placeholder="Titulo de Eleitor"
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="email" class="sr-only"></label>
                    <input
                      type="email"
                      name="email"
                      id="email"
                      class="form-control"
                      placeholder="email@email.com"
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="password" class="sr-only"></label>
                    <input
                      type="password"
                      name="senha"
                      id="password"
                      class="form-control"
                      placeholder="Senha"
                    />
                  </div>
                  <div class="form-group mb-4">
                    <label for="password2" class="sr-only"></label>
                    <input
                      type="password"
                      name="password"
                      id="password"
                      class="form-control"
                      placeholder="Repita sua senha"
                    />
                  </div>
                  <input
                    name="login"
                    id="login"
                    class="btn btn-block login-btn mb-4"
                    type="submit"
                    value="Cadastrar"
                  />
                </form>
                <p class="login-card-footer-text">
                  Ja possui uma conta ?
                  <a href="#!" class="text-reset">Cadastrar</a>
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
    
  </div>
</template>

<script>

import "@mdi/font/css/materialdesignicons.min.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "./../../assets/css/estiloCadastro.css";

export default {
  name: "Cadastro",
};
</script>

