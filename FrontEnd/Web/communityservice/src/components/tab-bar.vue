<template>
  <div>
    <van-tabbar v-model="active" @change="onChange">
      <van-tabbar-item v-if="isShowHome" :name="nameArray[0]" icon="wap-home-o">首页</van-tabbar-item>
      <van-tabbar-item v-if="isShowActivity" :name="nameArray[1]" icon="smile-comment-o">动态</van-tabbar-item>
      <van-tabbar-item :name="nameArray[2]" icon="envelop-o">消息</van-tabbar-item>
      <van-tabbar-item :name="nameArray[3]" icon="user-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
import { Tabbar, TabbarItem } from "vant"

export default {
  name: "tab-bar",

  components: {
    [Tabbar.name]: Tabbar,
    [TabbarItem.name]: TabbarItem
  },

  data() {
    return {
      active: 0,
      nameArray: [
        "home",
        "activity",
        "message",
        "me"
      ],
      routerArray: [
        "/news/list",
        "/activity/list",
        "/message/list",
        "/member/user-center"
      ]
    }
  },

  created() {
    console.log('created')
    this.active = this.nameArray[this.routerArray.indexOf(this.$route.path)]
  },

  computed: {
    isShowHome() {
      return !this.$store.getters.isSuperAdmin
    },
    isShowActivity() {
      return this.$store.getters.isResident
      this.$store.getters.getCommunityId != null && this.$store.getters.getCommunityId != '' && this.$store.getters.isResident
    },
  },

  activated() {
    console.log('activated')
    // this.active = this.routerArray.indexOf(this.$route.path)
  },

  methods: {
    onChange(name) {
      this.$router.push(this.routerArray[this.nameArray.indexOf(name)])
    }
  }
};
</script>

<style>
</style>
