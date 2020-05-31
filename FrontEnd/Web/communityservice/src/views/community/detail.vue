<template>
  <div>
    <nav-bar title="社区详情" />

    <van-field size="large" label="名称" v-model="name" readonly />
    <van-field size="large" label="简介" v-model="info" readonly type="textarea" autosize />
    <van-field size="large" label="创建时间" v-model="createTime" readonly />
    <van-field size="large" label="用户数" v-model="population" readonly />
    <van-field size="large" label="管理员列表">
      <template #input>
        <van-tag
          v-for="(item, index) in adminList"
          :key="index"
          style="margin-right: 10px;margin-bottom: 5px;margin-top: 5px;"
          type="success"
          size="large"
        >{{ item.nickname }}</van-tag>
      </template>
    </van-field>

    <div v-if="canJoin" style="margin: 16px;">
      <van-button v-if="!isJoined" round block type="info" @click="showJoinDialog = true">加入</van-button>
      <van-button v-else round block type="danger" @click="showLeaveDialog = true">退出</van-button>
    </div>

    <van-dialog
      v-model="showJoinDialog"
      title="提示"
      :message="'确认要加入 ' + name + ' ？'"
      show-cancel-button
      close-on-click-overlay
      @confirm="doJoin"
    ></van-dialog>

    <van-dialog
      v-model="showLeaveDialog"
      title="提示"
      :message="'确认要退出 ' + name + ' ？'"
      show-cancel-button
      confirm-button-color="red"
      close-on-click-overlay
      @confirm="doLeave"
    ></van-dialog>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Field, Tag, Button, Dialog } from "vant"
import { findDetailByCommunityId } from "@/api/community"
import { joinCommunity, leaveCommunity } from "@/api/member"

export default {
  components: {
    NavBar,
    [Field.name]: Field,
    [Tag.name]: Tag,
    [Button.name]: Button,
    [Dialog.Component.name]: Dialog.Component,
  },

  props: {},

  data() {
    return {
      name: '',
      info: '',
      createTime: '',
      adminList: [],
      population: 0,
      showJoinDialog: false,
      communityId: null,
      showLeaveDialog: false
    }
  },

  computed: {
    isJoined() {
      console.log(this.$store.getters.getCommunityId == this.communityId)
      return this.$store.getters.getCommunityId == this.communityId
    },
    canJoin() {
      return this.$store.getters.isResident || this.$store.getters.isAdmin
    }
  },

  watch: {},

  created() {
    this.communityId = this.$route.query.communityId
    this.getData(this.communityId)
  },

  mounted() { },

  methods: {
    getData(communityId) {
      findDetailByCommunityId({ communityId: communityId, operator: this.$store.getters.getAccountId }).then(res => {
        if (res.data) {
          this.name = res.data.communityName
          this.info = res.data.communityInfo
          this.createTime = this.getDate(res.data.createTime)
          this.adminList = res.data.adminList
          // this.adminList = [{ nickname: 'aaaa' }, { nickname: 'b' }, { nickname: 'bbbb' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }, { nickname: 'b' }]
          this.population = res.data.population
        }
      })
    },
    getDate(timeStamp) {
      const now = new Date(timeStamp)
      const y = now.getFullYear()
      const m = ('0' + (now.getMonth() + 1)).slice(-2)
      const d = ('0' + (now.getDate())).slice(-2)
      return y + '-' + m + '-' + d
    },
    doJoin() {
      joinCommunity({ accountId: this.$store.getters.getAccountId, communityId: this.communityId }).then(res => {
        if (res.data) {
          this.$store.dispatch('joinCommunity', { communityId: this.communityId, type: 3 })
          this.$router.push({
            path: "/community/list"
          })
        }
      })
    },
    doLeave() {
      leaveCommunity({ accountId: this.$store.getters.getAccountId }).then(res => {
        if (res.data) {
          this.$store.dispatch('joinCommunity', { communityId: null, type: 3 })
          this.$router.push({
            path: "/community/list"
          })
        }
      })
    },
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-field__control--custom {
  flex-wrap: wrap;
}
</style>
