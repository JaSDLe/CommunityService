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
      <van-cell
        title="用户名"
        is-link
        :value="account.username"
        @click="showBaseDialog(account.username, '用户名', 'username')"
      />
      <van-cell
        title="昵称"
        is-link
        :value="account.nickname"
        @click="showBaseDialog(account.nickname, '昵称', 'nickname')"
      />
      <van-cell title="类型" :value="account.typeText" />
      <van-cell
        title="手机号"
        is-link
        :value="account.phone"
        @click="showBaseDialog(account.phone, '手机号', 'phone')"
      />
      <van-cell
        title="邮箱"
        is-link
        :value="account.email"
        @click="showBaseDialog(account.email, '邮箱', 'email')"
      />
      <van-cell title="社区" is-link :value="account.communityName" @click="toCommunityList" />
    </van-cell-group>

    <van-cell-group title="详细资料">
      <van-cell
        title="性别"
        is-link
        :value="accountDetail.sex | getSex"
        @click="isShowSexPicker = true"
      />
      <van-popup v-model="isShowSexPicker" position="bottom">
        <van-picker
          show-toolbar
          :columns="sexColumns"
          @cancel="isShowSexPicker = false"
          @confirm="onConfirmSex"
        />
      </van-popup>

      <van-cell
        title="出生年月"
        is-link
        :value="accountDetail.birthday | getDate"
        @click="isShowBirthdayPicker = true"
      />
      <van-popup v-model="isShowBirthdayPicker" position="bottom">
        <van-datetime-picker
          v-model="date"
          type="date"
          title="选择年月日"
          :min-date="minDate"
          :max-date="maxDate"
          @cancel="isShowBirthdayPicker = false"
          @confirm="onConfirmBirthday"
        />
      </van-popup>

      <van-cell
        title="星座"
        is-link
        :value="accountDetail.constellation | getConstellation"
        @click="isShowConstellationPicker = true"
      />
      <van-popup v-model="isShowConstellationPicker" position="bottom">
        <van-picker
          show-toolbar
          :columns="constellationColumns"
          @cancel="isShowConstellationPicker = false"
          @confirm="onConfirmConstellation"
        />
      </van-popup>

      <van-cell
        title="地址"
        is-link
        :value="accountDetail.address"
        @click="showBaseDialog(accountDetail.address, '地址', 'address')"
      />
    </van-cell-group>

    <van-dialog
      v-model="isShowBaseDialog"
      show-cancel-button
      close-on-click-overlay
      @confirm="onConfirmBase"
    >
      <van-field
        v-model="value"
        :label="label"
        label-width="auto"
        colon
        :placeholder="'请输入' + label"
        size="large"
        clearable
        style="padding: 40px 20px 20px;"
      />
    </van-dialog>
  </div>
</template>

<script>
let that
import NavBar from "@/components/nav-bar"
import { CellGroup, Cell, Image, Dialog, Field, Popup, Picker, Notify, DatetimePicker } from "vant"
import {
  getUserInfoByAccountId,
  isUsernameOnly,
  updateAccountBaseInfo,
  updateAccountDetail
} from "@/api/member"

export default {
  components: {
    NavBar,
    [CellGroup.name]: CellGroup,
    [Cell.name]: Cell,
    [Image.name]: Image,
    [Dialog.Component.name]: Dialog.Component,
    [Field.name]: Field,
    [Popup.name]: Popup,
    [Picker.name]: Picker,
    [DatetimePicker.name]: DatetimePicker,
  },

  props: {},

  data() {
    return {
      isShowBaseDialog: false,
      isShowDetailDialog: false,
      value: null,
      label: null,
      type: null,
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
      },
      isShowSexPicker: false,
      sexColumns: ['男', '女'],
      sexValues: [true, false],
      isShowConstellationPicker: false,
      constellationColumns: ['白羊座', '金牛座', '双子座', '巨蟹座', '狮子座', '处女座', '天秤座', '天蝎座', '射手座', '魔羯座', '水瓶座', '双鱼座'],
      isShowBirthdayPicker: false,
      date: new Date(2000, 0, 1),
      minDate: new Date(1900, 0, 1),
      maxDate: new Date(),
    }
  },

  computed: {},

  watch: {},

  beforeCreate() {
    that = this
  },

  created() {
    this.accountId = this.$store.getters.getAccountId
    this.getUserInfo()
  },

  mounted() { },

  filters: {
    getDate(timeStamp) {
      if (timeStamp != null) {
        const now = new Date(timeStamp)
        const y = now.getFullYear()
        const m = ('0' + (now.getMonth() + 1)).slice(-2)
        const d = ('0' + (now.getDate())).slice(-2)
        return y + '-' + m + '-' + d
      }
    },
    getSex(sex) {
      if (sex != null) {
        return sex ? that.sexColumns[0] : that.sexColumns[1]
      }
    },
    getConstellation(index) {
      return that.constellationColumns[index]
    }
  },

  methods: {
    getUserInfo() {
      return new Promise(resolve => {
        getUserInfoByAccountId({ accountId: this.accountId, operator: this.accountId }).then(res => {
          if (res.data) {
            this.account = res.data.accountSimpleDTO
            this.accountDetail = res.data.accountDetailDTO
            resolve()
          }
        })
      })
    },
    resetParams() {
      this.newAccount = {
        accountId: null,
        username: null,
        nickname: null,
        phone: null,
        email: null
      }
      this.newAccountDetail = {
        accountId: null,
        sex: null,
        birthday: null,
        constellation: null,
        address: null
      }
    },
    updateStore() {
      this.$store.dispatch('updateBaseInfo', { username: this.account.username, nickname: this.account.nickname })
    },
    toCommunityList() {
      this.$router.push({
        path: "/community/list"
      })
    },
    showBaseDialog(val, label, type) {
      this.isShowBaseDialog = true
      this.value = val
      this.label = label
      this.type = type
    },
    onConfirmBase() {
      switch (this.type) {
        case 'username':
          this.newAccount.accountId = this.accountId
          this.newAccount.username = this.value
          isUsernameOnly(this.newAccount.username).then(res => {
            if (res.data) {
              updateAccountBaseInfo(this.newAccount).then(res => {
                if (res.data) {
                  Notify({
                    type: 'success',
                    message: res.description,
                    duration: 1500,
                  })
                  this.resetParams()
                  this.getUserInfo().then(() => {
                    this.updateStore()
                  })
                }
              })
            } else {
              Notify({
                type: 'danger',
                message: '用户名已存在',
                duration: 1500,
              })
            }
          })
          break
        case 'nickname':
          this.newAccount.accountId = this.accountId
          this.newAccount.nickname = this.value
          updateAccountBaseInfo(this.newAccount).then(res => {
            if (res.data) {
              Notify({
                type: 'success',
                message: res.description,
                duration: 1500,
              })
              this.resetParams()
              this.getUserInfo().then(() => {
                this.updateStore()
              })
            }
          })
          break
        case 'phone':
          this.newAccount.accountId = this.accountId
          this.newAccount.phone = this.value
          updateAccountBaseInfo(this.newAccount).then(res => {
            if (res.data) {
              Notify({
                type: 'success',
                message: res.description,
                duration: 1500,
              })
              this.resetParams()
              this.getUserInfo()
            }
          })
          break
        case 'email':
          this.newAccount.accountId = this.accountId
          this.newAccount.email = this.value
          updateAccountBaseInfo(this.newAccount).then(res => {
            if (res.data) {
              Notify({
                type: 'success',
                message: res.description,
                duration: 1500,
              })
              this.resetParams()
              this.getUserInfo()
            }
          })
          break
        case 'address':
          this.newAccountDetail.accountId = this.accountId
          this.newAccountDetail.address = this.value
          updateAccountDetail(this.newAccountDetail).then(res => {
            if (res.data) {
              Notify({
                type: 'success',
                message: res.description,
                duration: 1500,
              })
              this.resetParams()
              this.getUserInfo()
            }
          })
          break
        default:
          break
      }
    },
    onConfirmSex(value, index) {
      this.newAccountDetail.accountId = this.accountId
      this.newAccountDetail.sex = index == 0
      updateAccountDetail(this.newAccountDetail).then(res => {
        if (res.data) {
          this.isShowSexPicker = false
          Notify({
            type: 'success',
            message: res.description,
            duration: 1500,
          })
          this.resetParams()
          this.getUserInfo()
        }
      })
    },
    onConfirmConstellation(value, index) {
      this.newAccountDetail.accountId = this.accountId
      this.newAccountDetail.constellation = index
      updateAccountDetail(this.newAccountDetail).then(res => {
        if (res.data) {
          this.isShowConstellationPicker = false
          Notify({
            type: 'success',
            message: res.description,
            duration: 1500,
          })
          this.resetParams()
          this.getUserInfo()
        }
      })
    },
    onConfirmBirthday(value) {
      this.newAccountDetail.accountId = this.accountId
      this.newAccountDetail.birthday = value
      updateAccountDetail(this.newAccountDetail).then(res => {
        if (res.data) {
          this.isShowBirthdayPicker = false
          Notify({
            type: 'success',
            message: res.description,
            duration: 1500,
          })
          this.resetParams()
          this.getUserInfo()
        }
      })
    },
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-cell {
  font-size: 16px;
}
/deep/.van-cell__title {
  width: 100px;
}
/deep/.van-field__control {
  border: 1px solid #1989fa;
  border-radius: 5px;
  padding: 5px 10px;
}
/deep/.van-field__label {
  padding: 5px 10px 5px 0;
  font-weight: bold;
}
</style>
