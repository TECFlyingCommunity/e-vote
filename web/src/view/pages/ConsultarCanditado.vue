<template>
  <div align="center">
    <div class="profile-card">
      <div class="card-header">
        <div class="pic">
          <img src="./../../assets/images/politico.png" alt="" />
        </div>
        <div class="nome">- - - -</div>
        <div class="cargo">- - - -</div>
        <form  @submit.prevent="consultarVoto()">
          <div>
            <input
              class="candi"
              name="candidato"
              v-model="numero"
              type="text"
              placeholder="Numero do Candidato"
            />
          </div>
          <input type="submit" class="contact-btn" value="Consultar" />
        </form>
      </div>
      <div class="card-footer">
        <div class="numbers">
          <div class="item">
            <span>###</span>
            _ _ _ _ _
          </div>
          <div class="border"></div>
          <div class="item">
            <span>###</span>
            _ _ _ _ _
          </div>
          <div class="border"></div>
          <div class="item">
            <span>###</span>
            _ _ _ _ _
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "./../../assets/css/styleConsultar.css";

import {candidatoInfo} from './../../controller/votaController'


export default {
  name: "ConsultarCandiatato",

  data() {
    return {
      numero:0
    }
  },
  
  methods: {
    async consultarVoto(){
      try {
        await candidatoInfo(this.numero);
        this.$router.push({ name: 'ConfimarVoto' });
      } catch (error) {
        alert(error.data.message)
      }
        
    }

  },
};
</script>
