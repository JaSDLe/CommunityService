<template>
  <van-form @submit="onSubmit">
    <van-field
      v-model="username"
      name="用户名"
      placeholder="请输入用户名"
      left-icon="manager"
      clearable
      :rules="[{ required: true, message: '请填写用户名' }]"
    />
    <van-field
      v-model="password"
      type="password"
      name="密码"
      label="密码"
      placeholder="密码"
      left-icon="lock"
      :rules="[{ required: true, message: '请填写密码' }]"
    />
    <div style="margin: 16px;">
      <van-button round block type="info" native-type="submit">提交</van-button>
    </div>
  </van-form>
</template>

<script>
import { Form, Field, Button } from "vant";

export default {
  components: {
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button
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
    }
  }
};
</script>

<style>
</style>
