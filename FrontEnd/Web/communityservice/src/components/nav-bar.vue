<template>
  <div>
    <van-nav-bar style="font-size: 18px;" :title="title" left-arrow @click-left="onClickLeft" />
  </div>
</template>

<script>
import { NavBar } from "vant";

export default {
  name: "nav-bar",

  components: {
    [NavBar.name]: NavBar
  },

  props: {
    title: String
  },

  data() {
    return {};
  },

  created() {},

  methods: {
    onClickLeft() {
      this.$router.go(-1);
    }
  }
};
</script>

<style>
/* .van-nav-bar {
  /deep/ */
.van-nav-bar {
  height: 55px;
  line-height: 55px;
}
.van-nav-bar__title, .van-nav-bar__arrow {
  font-size: 20px;
}
/* } */
</style>
