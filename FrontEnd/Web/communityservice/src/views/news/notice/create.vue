<template>
  <div>
    <nav-bar title="发布公告" />

    <van-form @submit="onSubmit">
      <van-field
        v-model.trim="title"
        :error="isTitleError"
        clearable
        size="large"
        label="标题"
        placeholder="请输入标题"
        maxlength="255"
        :rules="[{ validator: checkTitle }]"
      />

      <van-field
        v-model.trim="content"
        :error="isContentError"
        clearable
        size="large"
        label="内容"
        placeholder="请输入内容"
        type="textarea"
        maxlength="30000"
        autosize
        rows="10"
        show-word-limit
        :rules="[{ validator: checkContent }]"
      />

      <van-field
        v-model="startTime"
        :error="isStartTimeError"
        readonly
        clickable
        size="large"
        label="开始时间"
        placeholder="点击选择开始时间"
        input-align="right"
        @click="showStartTimePicker = true"
      />
      <van-popup v-model="showStartTimePicker" position="bottom">
        <van-datetime-picker
          v-model="startTimePick"
          type="datetime"
          title="选择开始时间"
          @confirm="onStartTimeConfirm"
          @cancel="showStartTimePicker = false"
        />
      </van-popup>

      <van-field
        v-if="startTime != null && startTime != ''"
        v-model="endTime"
        :error="isEndTimeError"
        readonly
        clickable
        size="large"
        label="结束时间"
        placeholder="点击选择结束时间"
        input-align="right"
        @click="showEndTimePicker = true"
      />
      <van-popup v-model="showEndTimePicker" position="bottom">
        <van-datetime-picker
          v-model="endTimePick"
          type="datetime"
          title="选择结束时间"
          :min-date="getMinDate"
          @confirm="onEndTimeConfirm"
          @cancel="showEndTimePicker = false"
        />
      </van-popup>

      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">发布</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Form, Field, Button, DatetimePicker, Popup } from "vant"
import { createNotice } from "@/api/admin"

export default {
  components: {
    NavBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
    [DatetimePicker.name]: DatetimePicker,
    [Popup.name]: Popup,
  },

  data() {
    return {
      isTitleError: false,
      isContentError: false,
      isStartTimeError: false,
      isEndTimeError: false,
      title: "",
      content: "",
      showStartTimePicker: false,
      startTime: '',
      startTimePick: new Date(),
      showEndTimePicker: false,
      endTime: '',
      endTimePick: new Date(),
    }
  },

  computed: {
    getMinDate() {
      return new Date(this.startTime)
    }
  },

  created() {
  },

  methods: {
    checkTitle(val) {
      this.isTitleError = val == null || val == ""
    },
    checkContent(val) {
      this.isContentError = val == null || val == ""
    },
    onStartTimeConfirm(val) {
      this.startTime = this.getDate(val)
      this.isStartTimeError = false
      this.showStartTimePicker = false
    },
    onEndTimeConfirm(val) {
      this.endTime = this.getDate(val)
      this.isEndTimeError = false
      this.showEndTimePicker = false
    },
    onSubmit() {
      if (this.startTime == null || this.startTime == "") {
        this.isStartTimeError = true
        return
      }
      if (this.endTime == null || this.endTime == "") {
        this.isEndTimeError = true
        return
      }
      if (this.isTitleError || this.isContentError) {
        return
      }
      console.log(new Date(this.startTime))
      let param = {
        title: this.title,
        content: this.content,
        startTime: new Date(this.startTime),
        endTime: new Date(this.endTime),
        communityId: this.$store.getters.getCommunityId,
        createUser: this.$store.getters.getAccountId,
      }
      createNotice(param).then(res => {
        if (res.data) {
          this.$router.push({
            path: "/news/list"
          })
        }
      })
    },
    getDate(timeStamp) {
      const now = new Date(timeStamp)
      const y = now.getFullYear()
      const m = ('0' + (now.getMonth() + 1)).slice(-2)
      const d = ('0' + (now.getDate())).slice(-2)
      return y + '-' + m + '-' + d + ' ' + now.toTimeString().substr(0, 5)
    },
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-field__label {
  width: auto;
  margin-right: 16px;
}
</style>
