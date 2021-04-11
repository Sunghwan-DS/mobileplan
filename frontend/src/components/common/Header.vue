<template>
  <div id="header" v-if="isHeader">
    <h1>
      <router-link v-bind:to="{ name: constants.URL_TYPE.POST.MAIN }">SS_log</router-link>
    </h1>
    <div class="right">
      <!-- <div class="search-input">
        <i class="fas fa-search"></i>
        <input v-model="keyword" type="text" />
      </div>-->

      <!-- <router-link v-bind:to="{name:constants.URL_TYPE.USER.LOGIN}" class="login-btn">로그인</router-link> -->
      <div v-if="constants.LS_KEY.USER_TOKEN">
        <h5 style="display: inline-block; margin-right: 20px;">로그인이 됐어요!</h5>
        <b-button id="logoutBtn" @click="logout">로그아웃</b-button>
      </div>
      <div v-else>
        <b-button id="show-btn" @click="$bvModal.show('bv-modal-example')">로그인</b-button>

        <b-modal id="bv-modal-example" hide-footer>
          <template v-slot:modal-title>로그인</template>
          <div class="d-block text-center">
            <Login @on-login="login" />
          </div>
          <b-button
            id="closeBtn"
            class="mt-3"
            block
            @click="$bvModal.hide('bv-modal-example')"
          >Close Me</b-button>
        </b-modal>
      </div>
    </div>
  </div>
</template>

<script>
import constants from "../../lib/constants";
import Login from "../../page/user/Login.vue";
import axios from "axios";
const SERVER_URL = "http://localhost:8080";

export default {
  name: "Header",
  components: { Login },
  props: ["isHeader"],
  computed: {},
  watch: {},
  created() {},
  methods: {
    login() {
      constants.LS_KEY.USER_TOKEN = true;
    },
    logout() {
      constants.LS_KEY.USER_TOKEN = false;
    }
  },
  data: function() {
    return {
      constants,
      keyword: "",
      isLogedin: false
    };
  }
};
</script>

<style>
#login {
  height: 30vh;
}
</style>
