<template>
  <div>
    <h1>회원가입 인증 메일이 발송되었습니다. 이메일을 확인해주세요 : 미구현</h1>
    <h1>회원가입에 성공하였습니다!</h1>
    <router-link v-bind:to="{ name: constants.URL_TYPE.POST.MAIN }">SS_log</router-link>
  </div>
</template>

<script>
import constants from "../../lib/constants";

export default {
  data: () => {
    return {
      constants
    };
  }
};
</script>