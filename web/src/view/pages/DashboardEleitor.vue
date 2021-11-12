<template>
  <div class="eleitor">
    <v-btn class="mx-4 mb-4 mt-2 green white--text" elevation="2" small
      >Adicionar Eleitor +</v-btn
    >

    <v-container fluid class="mx-1 mt-2" v-for="data in datas" :key="data.id">
      <v-btn class="mb-2 mr-2" elevation="0" small>
        <v-icon>mdi-account-edit-outline</v-icon>
      </v-btn>

      <v-btn class="mb-2 mr-2 red white--text" elevation="0" small>
        <v-icon>mdi-account-multiple-remove</v-icon>
      </v-btn>

      <v-card flat class="pa-3">
        <v-layout row wrap class="pa-3 data">
          <v-flex xs6 sm3 md1>
            <div class="caption grey--text">ID</div>
            <div>{{ data.id }}</div>
          </v-flex>

          <v-flex xs6 sm4 md3>
            <div class="caption grey--text">NOME</div>
            <div>{{ data.nome }}</div>
          </v-flex>

          <v-flex xs6 sm4 md2>
            <div class="caption grey--text">EMAIL</div>
            <div>{{ data.email }}</div>
          </v-flex>

          <v-flex xs6 sm4 md2>
            <div class="caption grey--text">CPF</div>
            <div>{{ data.cpf }}</div>
          </v-flex>

          <v-flex xs4 sm4 md1>
            <div class="caption grey--text">TITULO</div>
            <div>{{ data.titulo }}</div>
          </v-flex>

          <v-flex xs4 sm4 md1>
            <div class="caption grey--text">CIDADE</div>
            <div>{{ data.cidade }}</div>
          </v-flex>

          <v-flex xs4 sm4 md2>
            <div class="caption grey--text">TELEFONE</div>
            <div>{{ data.telefone }}</div>
          </v-flex>
        </v-layout>
      </v-card>
    </v-container>
  </div>
</template>


<script>

import { getEleitorAll } from "./../../controller/dashboardController";

export default {
  name: "DashboardEleitor",
  data() {
    return {
      datas: [
      
      ],
    };
  },
  async created() {
    let eleitores = await getEleitorAll();

    eleitores.forEach((element) => {
      const data = {
        id: element.id,
        nome: element.nome,
        email: element.email,
        cpf: element.cpf,
        titulo: element.titulo,
        cidade: element.cidade.nome,
        telefone: element.telefone,
        
      };

      this.datas.push(data);
    });
  }
};
</script>


<style scoped>
.data {
  border-left: 4px solid orange;
}
.candidato {
  margin-top: 10px;
}
</style>
