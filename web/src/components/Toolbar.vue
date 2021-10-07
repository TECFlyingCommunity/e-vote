<template>
    <div>
    <v-app-bar
      color="white accent-4"
      elevation = "1"
      height="70"
      light
    >


      <v-toolbar-title>E-vote</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn text href='/' >
        Inicio
      </v-btn>

      <v-btn text href='/graphs' >
       Estatistica
      </v-btn>

       <v-btn text href='/home#sobre'>
       Sobre
      </v-btn>

       <v-btn text href='/home#contato' >
       Contato
      </v-btn>
    </v-app-bar>

    
  </div>
</template>

<script>
export default {
    name:  'Toolbar'
}
</script>