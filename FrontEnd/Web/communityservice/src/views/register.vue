<template>
  <div class="page">
    <van-form ref="form" autocomplete="off" @submit="onSubmit">
      <van-row>
        <van-icon name="manager" size="30" />
        <van-field
          v-model="username"
          name="u"
          placeholder="用户名"
          maxlength="32"
          clearable
          :formatter="formatter"
          @blur="blurUsername"
          :rules="[{ validator: checkUsername, message: usernameMsg, trigger: 'onChange' }]"
        />
      </van-row>
      <van-row style="margin-top: 20px">
        <van-icon name="lock" size="30" />
        <van-field
          v-model="password"
          :type="passwordShow ? 'text' : 'password'"
          placeholder="密码"
          maxlength="20"
          clearable
          :formatter="formatter"
          :right-icon="password.length > 0 ? passwordShow ? 'eye-o' : 'closed-eye' : ''"
          @click-right-icon="passwordShow = !passwordShow"
          :rules="[{ validator: checkPassword, message: passwordMsg, trigger: 'onChange' }]"
        />
      </van-row>
      <van-row style="margin-top: 20px">
        <van-icon name="lock" size="30" />
        <van-field
          v-model="confirmPassword"
          :type="confirmPasswordShow ? 'text' : 'password'"
          placeholder="确认密码"
          maxlength="20"
          clearable
          :formatter="formatter"
          :right-icon="confirmPassword.length > 0 ? confirmPasswordShow ? 'eye-o' : 'closed-eye' : ''"
          @click-right-icon="confirmPasswordShow = !confirmPasswordShow"
          :rules="[{ validator: checkConfirmPassword, message: confirmPasswordMsg, trigger: 'onChange' }]"
        />
      </van-row>
      <div style="margin-top: 40px;">
        <van-button round block type="info" native-type="submit">注册</van-button>
      </div>
      <van-divider style="margin-top: 30px;" />
      <div style="margin-top: 30px;">
        <van-button round block plain type="primary" native-type="button" @click="toLogin">已有账号? 去登录</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import { Form, Field, Button, Icon, Row, Col, Toast, Divider, Dialog } from "vant"
import { register } from "@/api/member"

export default {
  components: {
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
    [Icon.name]: Icon,
    [Row.name]: Row,
    [Col.name]: Col,
    [Toast.name]: Toast,
    [Divider.name]: Divider
  },

  data() {
    return {
      username: "",
      password: "",
      confirmPassword: "",
      usernameMsg: "请输入不超过32位的字母或数字",
      passwordMsg: "请输入6-20位的字母、数字或特殊符号",
      confirmPasswordMsg: "确认密码与密码不一致",
      passwordShow: false,
      confirmPasswordShow: false
    }
  },

  computed: {},

  methods: {
    formatter(val) {
      return val.replace(/\s*/g, "")
    },
    checkUsername(val) {
      return /^[0-9a-zA-Z]{1,}$/.test(val)
    },
    blurUsername() {
      this.$refs.form.validate("u")
    },
    checkPassword(val) {
      return /^[0-9a-zA-Z~!@#$%^&*()_+-=]{6,20}$/.test(val)
    },
    checkConfirmPassword(val) {
      return val == this.password
    },
    onSubmit(values) {
      register({ username: this.username, password: this.password }).then(res => {
        this.$toast({
          type: res.success && res.data ? 'success' : 'fail',
          message: res.description
        })
        if (res.data) {
          this.$router.push({
            path: "/login",
            query: { username: this.username }
          })
        }
      })
    },
    toLogin() {
      this.$router.push({
        path: "/login",
        query: { username: this.username }
      })
    }
  }
};
</script>

<style scoped>
.page {
  height: 100%;
  width: 100%;
  background-color: #fff;
  position: fixed;
}
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
  font-size: 22px;
}
.van-button {
  font-size: 20px;
}
</style>
