<template>
  <div class="user" id="login">
    <div class="wrapC table">
      <div class="middle">
        <div class="input-wrap">
          <input v-model="email" id="email" placeholder="이메일을 입력해주세요" type="text" />
        </div>
        <div class="input-wrap">
          <input v-model="password" type="password" id="password" placeholder="영문, 숫자 혼용 8자 이상" />
        </div>
        <button class="btn btn--back btn--login" @click="login">로그인 하기</button>
        <div class="add-option">
          <div class="wrap">
            <p>아직 회원이 아니신가요?</p>
            <router-link v-bind:to="{ name: constants.URL_TYPE.USER.JOIN }" class="btn--text">회원가입</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "../../assets/css/user.scss";
import constants from "../../lib/constants";
import axios from "axios";

export default {
  components: {},
  created() {},
  watch: {},
  methods: {
    login() {
      axios
        .get(constants.URL_TYPE.SERVER + "/blog/account/login", {
          params: { email: this.email, password: this.password }
        })

        .then(response => {
          console.log(response.data);
          document.getElementById("closeBtn").click();
          this.$emit("on-login", response.data);
        })
        .catch(error => {
          console.log(error.response);
        });
    }
  },
  data: () => {
    return {
      constants,
      email: "",
      password: ""
    };
  }
};
</script>
