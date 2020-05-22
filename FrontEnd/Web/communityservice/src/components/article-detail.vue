<template>
  <div style="padding: 20px;">
    <van-row>
      <div class="title">{{ title }}</div>
    </van-row>
    <van-row type="flex" align="center">
      <van-col class="create-time">{{ createTime | getDate }}</van-col>
      <van-col class="author">{{ author }}</van-col>
    </van-row>
    <van-row class="content">{{ content }}</van-row>

    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <van-row class="content">{{ content }}</van-row>
    <div style="height: 40px;" />
    <answer-bar />
  </div>
</template>

<script>
import AnswerBar from "@/components/answer-bar";
import { Row, Col } from "vant";

export default {
  components: {
    [Row.name]: Row,
    [Col.name]: Col,
    AnswerBar
  },

  props: {
    title: {
      type: String,
      default: "子节点浓氨水"
    },
    createTime: {
      type: String,
      default: new Date().toString()
    },
    author: {
      type: String,
      default: "猎云网"
    },
    content: {
      type: String,
      default: "根据消息，is爱大家啊，大飒飒的我，123"
    }
  },

  data() {
    return {};
  },

  created() {},

  filters: {
    getDate(timeStamp) {
      const now = new Date(timeStamp);
      const y = now.getFullYear();
      const m = ("0" + (now.getMonth() + 1)).slice(-2);
      const d = ("0" + now.getDate()).slice(-2);
      return y + "-" + m + "-" + d + " " + now.toTimeString().substr(0, 8);
    }
  },

  methods: {}
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
</style>
