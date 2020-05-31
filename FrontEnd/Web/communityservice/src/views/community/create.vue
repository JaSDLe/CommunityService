<template>
  <div>
    <nav-bar :title="type + '社区'" />

    <van-form @submit="onSubmit">
      <van-field
        v-model.trim="communityName"
        :error="isNameError"
        clearable
        size="large"
        label="社区名称"
        placeholder="请输入名称"
        maxlength="255"
        :rules="[{ validator: checkName }]"
      />

      <van-field
        v-model.trim="communityInfo"
        :error="isInfoError"
        clearable
        size="large"
        label="社区简介"
        placeholder="请输入简介"
        type="textarea"
        maxlength="255"
        autosize
        rows="3"
        show-word-limit
        :rules="[{ validator: checkInfo }]"
      />

      <van-field
        v-model="index"
        :error="isIndexError"
        readonly
        clickable
        size="large"
        label="名称首字母"
        placeholder="点击选择首字母"
        input-align="right"
        @click="showPicker = true"
      />
      <van-popup v-model="showPicker" position="bottom">
        <van-picker
          show-toolbar
          :columns="columns"
          @confirm="onConfirm"
          @cancel="showPicker = false"
        />
      </van-popup>

      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">{{ type }}</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Form, Field, Button, Popup, Picker } from "vant"
import { createCommunity, updateCommunity } from "@/api/admin"

export default {
  components: {
    NavBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Popup.name]: Popup,
    [Button.name]: Button,
    [Picker.name]: Picker
  },

  data() {
    return {
      isNameError: false,
      isInfoError: false,
      isIndexError: false,
      communityName: "",
      communityInfo: "",
      showPicker: false,
      columns: [],
      index: "",
      type: '',
      item: {}
    }
  },

  created() {
    this.type = this.$route.query.type
    this.item = this.$route.query.item
    if (this.item != undefined) {
      this.communityName = this.item.communityName
      this.communityInfo = this.item.communityInfo
      this.index = this.item.index
    }
    for (let i = 0; i < 26; i++) {
      this.columns.push(String.fromCharCode(65 + i))
    }
  },

  methods: {
    checkName(val) {
      this.isNameError = val == null || val == ""
    },
    checkInfo(val) {
      this.isInfoError = val == null || val == ""
    },
    onConfirm(value, index) {
      this.index = value
      this.isIndexError = false
      this.showPicker = false
    },
    onSubmit() {
      if (this.index == null || this.index == "") {
        this.isIndexError = true
        return
      }
      if (this.isNameError || this.isInfoError) {
        return
      }
      if (this.type == '创建') {
        let param = {
          communityName: this.communityName,
          communityInfo: this.communityInfo,
          index: this.index,
          createUser: this.$store.getters.getAccountId
        }
        createCommunity(param).then(res => {
          if (res.data) {
            this.$router.push({
              path: "/community/list"
            })
          }
        })
      } else {
        let param = {
          communityId: this.item.communityId,
          communityName: this.communityName,
          communityInfo: this.communityInfo,
          index: this.index,
          updateUser: this.$store.getters.getAccountId
        }
        updateCommunity(param).then(res => {
          if (res.data) {
            this.$router.push({
              path: "/community/list"
            })
          }
        })
      }
    }
  }
};
</script>

<style scoped>
</style>
