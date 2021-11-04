<template>
  <div align="center">
    <div class="profile-card">
      <div class="card-header">
        <div class="pic">
          <img src="./../../assets/images/pic.png" alt="" />
        </div>
        <div class="nome">nome</div>
        <div class="cargo">Presidente</div>
        <div class="bt">
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
          <a href="#" class="fab fa-twitter"></a>
        </div>
        <a  @click="confirmarVota()" class="contact-btn"
          >Votar
          </a>
      </div>
      <div class="card-footer">
        <div class="numbers">
          <div class="item">
            <span>numero</span>
            Numero
          </div>
          <div class="border"></div>
          <div class="item">
            <span>BAIA</span>
            Nacionalidade
          </div>
          <div class="border"></div>
          <div class="item">
            <span>Lula</span>
            Rival
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "./../../assets/css/styleVotar.css";
export default {
  name: "ConfirmarVoto",

  methods: {
    confirmarVota() {
      this.$router.push({ name: "Graphs" });
    },
  },
};
</script>
