<template>
  <div>
    <van-cell style="padding-bottom: 0;" center @click="toDetail">
      <template #default>
        <van-row>
          <van-col>
            <van-image :src="headPic" round fit="cover" width="45" height="45" lazy-load>
              <template #loading>
                <van-loading type="spinner" size="20" />
              </template>
              <template #error>
                <van-icon name="warning-o" size="20" />
              </template>
            </van-image>
          </van-col>
          <van-col style="margin-left: 10px;">
            <van-row>
              <div class="nickname">{{ nickname }}</div>
            </van-row>
            <van-row>
              <div class="create-time">{{ createTime | getDate }}</div>
            </van-row>
          </van-col>
        </van-row>
        <van-row>
          <div class="activity-content">{{ content }}</div>
        </van-row>
        <van-row class="button-row" type="flex" justify="space-around">
          <van-button icon="comment-o" class="btn">{{ replyNum || '评论' }}</van-button>
        </van-row>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { Cell, Row, Col, Image, Loading, Icon, Button } from "vant"

export default {
  components: {
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Col.name]: Col,
    [Image.name]: Image,
    [Loading.name]: Loading,
    [Icon.name]: Icon,
    [Button.name]: Button,
  },

  props: {
    nickname: {
      type: String,
      default: '新款小米'
    },
    content: {
      type: String,
      default: 'IT之家5月1日消息 根据NoteBookCheck的报道，大量小米的新型号笔记本电脑获得了蓝牙SIG的认证。外媒认为，小米打算扩大其移动个人电脑产品组合，最多推出6款新的笔记本电脑，其中至少有两款采用了AMD最新的Ryzen 4000 APU。'
    },
    headPic: {
      type: String,
      default: 'https://img.yzcdn.cn/vant/cat1.jpeg'
    },
    replyNum: {
      type: Number,
      default: 4
    },
    createTime: {
      type: String,
      default: Date.now()
    },
  },

  data() {
    return {}
  },
  computed: {},

  watch: {},

  created() { },

  mounted() { },

  filters: {
    getDate(timeStamp) {
      const now = new Date(timeStamp)
      const y = now.getFullYear()
      const m = ('0' + (now.getMonth() + 1)).slice(-2)
      const d = ('0' + (now.getDate())).slice(-2)
      return y + '-' + m + '-' + d + ' ' + now.toTimeString().substr(0, 8)
    }
  },

  methods: {
    toDetail(val) {
      console.log(val)
    }
  }
};
</script>

<style scoped>
.button-row {
  margin-top: 10px;
  border-top: 0.5px solid #ebedf0;
}
.nickname {
  font-size: 16px;
  color: black;
  word-break: break-all;
}
.create-time {
  font-size: 12px;
  color: #858585;
}
.activity-content {
  font-size: 16px;
  color: black;
  word-break: break-all;
}
.btn {
  background-color: rgba(255, 255, 255, 0);
  border: none;
  font-size: 15px;
}
</style>
