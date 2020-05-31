<template>
  <div>
    <van-cell center is-link @click="toDetail" style="margin-bottom: 40px;">
      <template #title>
        <van-row type="flex" align="center">
          <van-image round width="80" height="80"></van-image>
          <van-col style="margin-left: 13px;">
            <van-row>
              <div style="font-size: 19px;">{{ nickname }}</div>
            </van-row>
            <van-row>
              <div style="font-size: 13px;">{{ username }}</div>
            </van-row>
          </van-col>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link @click="toCommunity">
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="shop-o" size="22" />
          <div class="my-cell-title">社区</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="smile-comment-o" size="22" />
          <div class="my-cell-title">我的动态</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="comment-o" size="22" />
          <div class="my-cell-title">我的评论</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="notes-o" size="22" />
          <div class="my-cell-title">我的留言</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="bullhorn-o" size="22" />
          <div class="my-cell-title">公告</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="clock-o" size="22" />
          <div class="my-cell-title">我的足迹</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>
    <van-cell center is-link>
      <template #title>
        <van-row type="flex" align="center">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center clickable @click="logout" style="margin-top: 40px;">
      <template #title>
        <van-row type="flex" align="center" justify="center">
          <div style="color: red;font-size: 17px;">退出登录</div>
        </van-row>
      </template>
    </van-cell>

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import { Form, Field, Button, Icon, Row, Col, Cell, Image, Dialog } from "vant"

export default {
  components: {
    TabBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
    [Icon.name]: Icon,
    [Row.name]: Row,
    [Col.name]: Col,
    [Cell.name]: Cell,
    [Image.name]: Image,
    [Dialog.name]: Dialog,
  },

  data() {
    return {
      nickname: '',
      username: ''
    }
  },

  created() {
    this.nickname = this.$store.getters.getNickname || '未设置昵称'
    this.username = this.$store.getters.getUsername
  },

  methods: {
    toDetail() {
      this.$router.push({
        path: "/member/account-detail"
      })
    },
    toCommunity() {
      this.$router.push({
        path: "/community/list"
      })
    },
    logout() {
      this.$dialog({
        title: '提示',
        message: '确认要退出登录？',
        showCancelButton: true,
        closeOnClickOverlay: true,
        confirmButtonColor: 'red'
      }).then(() => {
        this.$router.push({
          path: "/login"
        })
        this.$store.dispatch('logout')
      })
    }
  }
};
</script>

<style scoped>
.my-cell-title {
  margin-left: 13px;
  font-size: 17px;
}
</style>
