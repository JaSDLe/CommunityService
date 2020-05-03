<template>
  <div>
    <nav-bar title="社区详情" />

    <van-field size="large" label="名称" v-model="name" readonly />
    <van-field size="large" label="简介" v-model="info" readonly type="textarea" autosize />
    <van-field size="large" label="创建时间" v-model="createTime" readonly />
    <van-field size="large" label="用户数" v-model="population" readonly />
    <van-field size="large" label="管理员列表" v-model="name" readonly />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Field } from "vant"
import { findDetailByCommunityId } from "@/api/community"

export default {
  components: {
    NavBar,
    [Field.name]: Field
  },

  props: {},

  data() {
    return {
      name: '',
      info: '',
      createTime: '',
      adminList: [],
      population: 0
    }
  },

  watch: {},

  created() {
    this.getData(this.$route.query.communityId)
  },

  mounted() { },

  methods: {
    getData(communityId) {
      findDetailByCommunityId(communityId).then(res => {
        if (res.data) {
          this.name = res.data.communityName
          this.info = res.data.communityInfo
          this.createTime = this.getDate(res.data.createTime)
          this.adminList = res.data.adminList
          this.population = res.data.population
          console.log(this.getDate(this.createTime))
        }
      })
    },
    getDate(timeStamp) {
      const now = new Date(timeStamp)
      const y = now.getFullYear()
      const m = ('0' + (now.getMonth() + 1)).slice(-2)
      const d = ('0' + (now.getDate())).slice(-2)
      return y + '-' + m + '-' + d
    }
  }
};
</script>

<style>
</style>
