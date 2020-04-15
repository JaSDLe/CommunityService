<template>
  <div>
    <van-form @submit="onSubmit">
      <van-row>
        <van-icon name="manager" size="30" />
        <van-field
          v-model="username"
          name="用户名"
          placeholder="请输入用户名"
          clearable
          class="login"
          :rules="[{ required: true, message: '请填写用户名' }]"
        />
      </van-row>
      <van-row style="margin-top: 20px">
        <van-icon name="lock" size="30" />
        <van-field
          v-model="password"
          type="password"
          name="密码"
          placeholder="请输入密码"
          class="login"
          :rules="[{ required: true, message: '请填写密码' }]"
        />
      </van-row>
      <div style="margin-top: 20px;">
        <van-button round block type="info" native-type="submit">登录</van-button>
      </div>
    </van-form>
    <tabbar />
  </div>
</template>

<script>
import tabbar from "@/components/tab-bar";
import { Form, Field, Button, Icon, Row, Col } from "vant";

export default {
  components: {
    tabbar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
    [Icon.name]: Icon,
    [Row.name]: Row,
    [Col.name]: Col
  },

  data() {
    return {
      username: "",
      password: ""
    };
  },

  methods: {
    onSubmit(values) {
      console.log("submit", values);
      this.$router.push({
        path: "/member/user-center",
        query: {}
      });
    }
  }
};
</script>

<style scoped>
.van-form {
  width: 80%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 50px;
}
.van-row {
  display: flex;
  align-items: center;
}
.van-field {
  font-size: 25px;
}
.van-button {
  font-size: 20px;
}
</style>
