<template>
  <div>
    <van-cell center is-link @click="toDetail" style="margin-bottom: 40px;">
      <template #title>
        <van-row class="my-row">
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
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">社区</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">我的动态</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">我的评论</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">我的留言</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell style center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">公告</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">我的足迹</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>
    <van-cell style center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>

    <van-cell center is-link>
      <template #title>
        <van-row class="my-row">
          <van-icon name="setting-o" size="22" />
          <div class="my-cell-title">设置</div>
        </van-row>
      </template>
    </van-cell>

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import { Form, Field, Button, Icon, Row, Col, Cell, Image } from "vant"

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
    [Image.name]: Image
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
    }
  }
};
</script>

<style scoped>
.my-row {
  display: flex;
  align-items: center;
}
.my-cell-title {
  margin-left: 13px;
  font-size: 17px;
}
</style>
