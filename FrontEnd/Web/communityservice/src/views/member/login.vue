<template>
  <div class="page">
    <van-form autocomplete="off" @submit="onSubmit">
      <van-row>
        <van-icon name="manager" size="30" />
        <van-field
          v-model="username"
          placeholder="用户名"
          maxlength="32"
          clearable
          :formatter="formatter"
          :rules="[{ required: true, message: '请填写用户名' }]"
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
          :rules="[{ required: true, message: '请填写密码' }]"
        />
      </van-row>
      <div style="margin-top: 40px;">
        <van-button round block type="info" native-type="submit">登录</van-button>
      </div>
      <van-divider style="margin-top: 30px;" />
      <div style="margin-top: 30px;">
        <van-button
          round
          block
          plain
          type="primary"
          native-type="button"
          @click="toRegister"
        >没有账号? 去注册</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import { Form, Field, Button, Icon, Row, Col, Toast, Divider } from "vant"
import { login } from "@/api/member"
import { md5 } from 'js-md5'

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
      passwordShow: false,
      data: []
    }
  },

  created() {
    console.log(this.$route.query)
    if (this.$route.query.username) {
      this.username = this.$route.query.username
      console.log(this.username)
    }
  },

  methods: {
    formatter(val) {
      return val.replace(/\s*/g, "")
    },
    onSubmit(values) {
      login({ username: this.username, password: md5(this.password) }).then(res => {
        this.$toast({
          type: res.success && res.data ? 'success' : 'fail',
          message: res.description
        })
        if (res.data) {
          this.$store.dispatch('login', res.data).then(() => {
            this.$router.push({
              path: "/member/user-center"
            })
          })
        }
      })
    },
    toRegister() {
      this.$router.push({
        path: "/register"
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
