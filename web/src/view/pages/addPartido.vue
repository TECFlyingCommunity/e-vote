<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="4">
        <v-card>
          <v-card-text class="text-center pa-7">
            <v-file-input show-size label="Imagem do candidato"> </v-file-input>
            <p>Nome: {{ form.nome }}</p>
            <p>Numero: {{ form.numero }}</p>
            <p>Sigla: {{ form.sigla }}</p>
            <h6 class="subtitle-2 font-weight-light">
              Verifique os dados antes de enviar
            </h6>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="12" lg="8">
        <v-card>
          <v-card-text>
            <h3
              class="title blue-grey--text text--darken-2 font-weight-regular"
            >
              Cadastro de Partido
            </h3>
            <h6 class="subtitle-2 font-weight-light">
              Adicione os atributos de acordo co o campo
            </h6>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>
            <form @submit.prevent="submit()">
              <v-text-field
                v-model="form.nome"
                label="Nome do Partido"
                filled
                background-color="transparent"
              ></v-text-field>

              <v-text-field
                type="number"
                v-model="form.numero"
                label="Numero Oficial do Partido"
                filled
                background-color="transparent"
              ></v-text-field>
              <v-text-field
                type="text"
                v-model="form.sigla"
                label="Sigla"
                filled
                background-color="transparent"
              ></v-text-field>

              <v-btn
                type="submit"
                class="text-capitalize mt-5 element-0"
                color="success"
                >Cadastrar</v-btn
              >
            </form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import cadastrar from "./../../controller/partidoController";
export default {
  name: "Candidatos",

  data() {
    return {
      form: {
        nome: "",
        numero: "",
        sigla: "",
      },
      show1: false,
      rules: {
        required: (value) => !!value || "Obrigatorio.",
        min: (v) => v.length >= 8 || "Min 8 caracteres",
        emailMatch: () => "Dados incorretos",
      },
      items: ["NV", "NA", "NR", "NL"],
    };
  },

  components: {},
  methods: {
    async submit() {
      try {
        await cadastrar(this.form);
        this.$router.push({ name: "DashboardPartido" });
      } catch (error) {
        alert(
          error.data ? error.data.message : "Não foi possível fazer o cadastro"
        );
      }
    },
  },
};
</script>
