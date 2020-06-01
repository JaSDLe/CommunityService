<template>
  <div>
    <nav-bar title="个人信息" />

    <van-cell-group title="基本资料">
      <van-cell title="头像" is-link center>
        <template #default>
          <div style="display: flex;align-items: center;float: right;">
            <van-image round width="70" height="70"></van-image>
          </div>
        </template>
      </van-cell>
      <van-cell title="用户名" is-link :value="account.username" />
      <van-cell title="昵称" is-link :value="account.nickname" />
      <van-cell title="类型" :value="account.typeText" />
      <van-cell title="手机号" is-link :value="account.phone" />
      <van-cell title="邮箱" is-link :value="account.email" />
      <van-cell title="社区" is-link :value="account.communityName" @click="toCommunityList" />
    </van-cell-group>

    <van-cell-group title="详细资料">
      <van-cell title="性别" is-link :value="accountDetail.sex ? '男' : '女'" />
      <van-cell title="出生年月" is-link :value="getDate(accountDetail.birthday)" />
      <van-cell title="星座" is-link :value="accountDetail.constellation" />
      <van-cell title="地址" is-link :value="accountDetail.address" />
    </van-cell-group>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { CellGroup, Cell, Image } from "vant"
import {
  getUserInfoByAccountId,
  updateAccountBaseInfo,
  updateAccountDetail
} from "@/api/member"

export default {
  components: {
    NavBar,
    [CellGroup.name]: CellGroup,
    [Cell.name]: Cell,
    [Image.name]: Image,
  },

  props: {},

  data() {
    return {
      accountId: null,
      account: {},
      accountDetail: {},
      newAccount: {
        accountId: null,
        username: null,
        nickname: null,
        phone: null,
        email: null
      },
      newAccountDetail: {
        accountId: null,
        sex: null,
        birthday: null,
        constellation: null,
        address: null
      }
    }
  },

  computed: {},

  watch: {},

  created() {
    this.accountId = this.$store.getters.getAccountId
    this.getUserInfo(this.accountId)
  },

  mounted() { },

  methods: {
    getUserInfo(accountId) {
      getUserInfoByAccountId({ accountId: accountId, operator: accountId }).then(res => {
        if (res.data) {
          this.account = res.data.accountSimpleDTO
          this.accountDetail = res.data.accountDetailDTO
        }
      })
    },
    updateAccountBaseInfo(data) {
      updateAccountBaseInfo(data).then(res => {
        if (res.data) {
          this.$router.push({
            path: "/member/account-detail"
          })
        }
      })
    },
    updateAccountDetail(data) {
      updateAccountDetail(data).then(res => {
        if (res.data) {
          this.$router.push({
            path: "/member/account-detail"
          })
        }
      })
    },
    toCommunityList() {
      this.$router.push({
        path: "/community/list"
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

<style scoped lang='postcss'>
/deep/.van-cell {
  font-size: 16px;
}
/deep/.van-cell__title{
  width: 100px;
}
</style>
