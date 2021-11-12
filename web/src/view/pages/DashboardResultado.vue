<template>
  <div align="center">
    
    <pie-chart :data="chartData"></pie-chart>
  </div>
</template>


<script>

import data from "./../../controller/graphController";


export default {
  name: "Graphs",
  data() {
    return {
      chartData: {},
    }
  },
  
  methods:{
    async init () {
    try {
      this.chartData= await data();
      console.log(this.chartData);
    } catch (error) {
       alert(error.data ? error.data.message : 'Não foi possível recuperar os dados');
    }
     
    }
  },
   beforeMount(){
    this.init()
 },
};
</script>
