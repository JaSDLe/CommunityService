<template>
  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item icon="wap-home-o">首页</van-tabbar-item>
    <van-tabbar-item icon="smile-comment-o">动态</van-tabbar-item>
    <van-tabbar-item icon="envelop-o">消息</van-tabbar-item>
    <van-tabbar-item icon="user-o">我的</van-tabbar-item>
  </van-tabbar>
</template>

<script>
import { Tabbar, TabbarItem } from "vant";

export default {
  name: "tab-bar",

  components: {
    [Tabbar.name]: Tabbar,
    [TabbarItem.name]: TabbarItem
  },

  data() {
    return {
      active: 0,
      routerArray: [
        "/news/list",
        "/activity/list",
        "/message/list",
        "/member/user-center"
      ]
    };
  },

  created() {
    this.active = this.routerArray.indexOf(this.$route.path);
  },

  methods: {
    onChange(index) {
      this.$router.push(this.routerArray[index]);
    }
  }
};
</script>

<style>
</style>
