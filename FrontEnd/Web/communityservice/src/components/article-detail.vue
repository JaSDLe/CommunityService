<template>
  <div style="padding: 20px;">
    <van-row>
      <div class="title">{{ title }}</div>
    </van-row>
    <van-row type="flex" align="center" style="flex-wrap: wrap;">
      <van-col class="create-time">{{ createTime | getDate }}</van-col>
      <van-col class="author">{{ author }}</van-col>
    </van-row>
    <van-row class="content">{{ content }}</van-row>

    <div style="height: 40px;" />

    <answer-bar :replyNum="replyNum" @write-answer="openPopup" @to-answer="toAnswer" />

    <van-popup v-model="show" position="bottom" :style="{ height: '200px' }">
      <van-form ref="form" @submit="onSubmit">
        <van-field
          v-model.trim="answer"
          ref="answer"
          :error="isContentError"
          size="large"
          placeholder="请输入留言"
          type="textarea"
          maxlength="255"
          autosize
          rows="3"
          show-word-limit
          :rules="[{ validator: checkContent, trigger: 'onChange' }]"
        />
        <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit">发布</van-button>
        </div>
      </van-form>
    </van-popup>
  </div>
</template>

<script>
import AnswerBar from "@/components/answer-bar"
import { Row, Col, Popup, Form, Field, Button } from "vant"
import { createAnswer } from "@/api/news"

export default {
  components: {
    AnswerBar,
    [Row.name]: Row,
    [Col.name]: Col,
    [Popup.name]: Popup,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
  },

  props: {
    id: {
      type: String
    },
    title: {
      type: String,
      // default: "子节点浓氨水"
    },
    createTime: {
      type: String,
      // default: new Date().toString()
    },
    author: {
      type: String,
      // default: "猎云网"
    },
    content: {
      type: String,
      // default: "根据消息，is爱大家啊，大飒飒的我，123"
    },
    replyNum: {
      type: Number,
      default: 0
    }
  },

  data() {
    return {
      show: false,
      isContentError: false,
      answer: '',
    }
  },

  created() { },

  filters: {
    getDate(timeStamp) {
      const now = new Date(timeStamp)
      const y = now.getFullYear()
      const m = ("0" + (now.getMonth() + 1)).slice(-2)
      const d = ("0" + now.getDate()).slice(-2)
      return y + "-" + m + "-" + d + " " + now.toTimeString().substr(0, 8)
    },

  },

  methods: {
    checkContent(val) {
      this.isContentError = val == null || val == ""
    },
    onSubmit() {
      if (this.isContentError) {
        return
      }
      let param = {
        content: this.answer,
        parentId: this.id,
        createUser: this.$store.getters.getAccountId,
      }
      createAnswer(param).then(res => {
        if (res.data) {
          this.show = false
        }
      })
    },
    openPopup() {
      this.show = true
      this.$refs.answer.focus()
    },
    toAnswer() {
      this.$router.push({
        path: "/news/list"
      })
    },
  }
};
</script>

<style scoped lang='postcss'>
.title {
  font-size: 25px;
  color: black;
  font-weight: bold;
  word-break: break-all;
  margin-bottom: 18px;
}
.create-time {
  font-size: 16px;
  color: #858585;
  margin-right: 15px;
}
.author {
  font-size: 16px;
  color: #858585;
}
.content {
  margin-top: 18px;
  font-size: 22px;
}
/* /deep/.van-popup {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
} */
</style>
