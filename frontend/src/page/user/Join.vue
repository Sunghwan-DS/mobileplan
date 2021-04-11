<template>
  <div class="user" id="join">
    <div class="wrapC table">
      <div class="middle">
        <h1>회원가입</h1>
        <div class="form-wrap">
          <div class="input-wrap">
            <input v-model="nickName" id="nickname" placeholder="닉네임을 입력해주세요" type="text" />
          </div>

          <div class="input-wrap">
            <input v-model="email" id="email" placeholder="이메일을 입력해주세요" type="text" />
          </div>

          <div class="input-wrap password-wrap">
            <input v-model="password" id="password" :type="passwordType" placeholder="비밀번호를 입력해주세요" />
            <span :class="{active : passwordType==='text'}">
              <i class="fas fa-eye"></i>
            </span>
          </div>

          <div class="input-wrap password-wrap">
            <input
              v-model="passwordConfirm"
              id="password-confirm"
              :type="passwordConfirmType"
              placeholder="비밀번호를 한번 더 입력해주세요"
            />
            <span :class="{active : passwordConfirmType==='text'}">
              <i class="fas fa-eye"></i>
            </span>
          </div>
        </div>

        <label>
          <input v-model="isTerm" type="checkbox" id="term" />
          <span>약관에 동의합니다</span>
        </label>

        <span class="go-term">약관 보기</span>

        <button class="btn" @click="onJoin">
          <span>작성완료</span>
        </button>
        <div>
          <router-link v-bind:to="{ name: constants.URL_TYPE.POST.MAIN }" class="main">SS_log</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import constants from "../../lib/constants";
import "../../assets/css/user.scss";
import axios from "axios";

export default {
  components: {},
  created() {},
  methods: {
    onJoin() {
      if (!this.email.includes("@")) {
        alert("이메일 형식이 옳지 않습니다.");
      } else if (!this.email.includes(".")) {
        alert("이메일 형식이 옳지 않습니다.");
      } else if (this.password != this.passwordConfirm) {
        alert("비밀번호가 일치하지 않습니다.");
      } else if (!document.getElementById("term").checked) {
        alert("약관에 동의해주십시오.");
      } else {
        axios
          .post(constants.URL_TYPE.SERVER + "/blog/account/signup", {
            uid: this.nickName,
            email: this.email,
            password: this.password
          })
          .then(res => {
            this.$router.push({ name: constants.URL_TYPE.USER.JOINSUCCESS });
            console.log(res);
          })
          .catch(err => console.log(err));
      }
    }
  },
  watch: {},
  data: () => {
    return {
      email: "",
      nickName: "",
      password: "",
      passwordConfirm: "",
      isTerm: false,
      passwordType: "password",
      passwordConfirmType: "password",
      constants
    };
  }
};
</script>

<style>
.main {
  margin-top: 100px;
}
</style>
