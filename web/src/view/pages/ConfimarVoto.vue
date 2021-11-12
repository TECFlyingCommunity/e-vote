<template>
  <div align="center">
    <div class="profile-card">
      <div class="card-header">
        <div class="pic">
          <img src="./../../assets/images/pic.png" alt="" />
        </div>
        <div class="nome">{{nome}}</div>
        <div class="cargo">{{categoria}}</div>
        <div class="bt">
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
        </div>
        <a  @click="confirmarVota()" class="contact-btn"
          >Confirmar
          </a>
          <a @click="voltar()"  class="contact-btn"
          >Cancelar
          </a>
      </div>
      <div class="card-footer">
        <div class="numbers">
          <div class="item">
            <span>{{numero}}</span>
            Numero
          </div>
          <div class="border"></div>
          <div class="item">
            <span>{{estado}}</span>
            Nacionalidade
          </div>
         
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "./../../assets/css/styleVotar.css";
import {candidato,votar} from './../../controller/votaController'
export default {

  name: "ConfirmarVoto",

  data() {
    return {
      nome:'',
      numero:'',
      estado:'',
      categoria:''
    }
  },

  methods: {
    async confirmarVota() {
      try {
        await votar(candidato.id);
        this.$router.push({ name: "Graphs" });  
      } catch (error) {
        alert(error.data.message)
      }
      
    },

    voltar() {
      this.$router.push({ name: "Home" });
    },
  },

  created() {
    this.nome = candidato.eleitor.nome;
    this.numero = candidato.numero;
    this.estado = candidato.eleitor.cidade.estado.name;
    this.categoria = candidato.categoria.nome;
  },
};
</script>
