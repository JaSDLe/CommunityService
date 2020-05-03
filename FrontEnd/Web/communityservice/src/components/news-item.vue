<template>
  <div>
    <van-cell center clickable @click="toDetail">
      <template #default>
        <van-row type="flex" justify="space-between" align="center">
          <van-col class="my-left-col">
            <van-row>
              <div class="news-title">{{ title }}</div>
            </van-row>
            <van-row type="flex" justify="space-between">
              <div class="create-time">{{ createTime | getDate }}</div>
              <div class="reply-num">{{ replyNum }}评</div>
            </van-row>
          </van-col>
          <van-col class="my-right-col">
            <van-image
              :src="cover"
              fit="scale-down"
              width="85"
              height="65"
              radius="5"
              lazy-load
            >
              <template #loading>
                <van-loading type="spinner" size="20" />
              </template>
              <template #error>
                <van-icon name="warning-o" size="20" style="margin-top: 10px;" />
                <span style="font-size: 10px;">加载失败</span>
              </template>
            </van-image>
          </van-col>
        </van-row>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { Cell, Row, Col, Image, Loading, Icon } from "vant"

export default {
  components: {
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Col.name]: Col,
    [Image.name]: Image,
    [Loading.name]: Loading,
    [Icon.name]: Icon,
  },

  props: {
    title: {
      type: String,
      // default: '新款小米笔记本获蓝牙认证：13.3/14/16.1英寸全覆盖'
    },
    cover: {
      type: String,
      // default: 'https://img.yzcdn.cn/vant/cat1.jpeg'
    },
    replyNum: {
      type: Number,
      // default: 0
    },
    createTime: {
      type: String,
      // default: Date.now()
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
.van-cell {
  border-top: 0.5px solid #ebedf0;
}
.news-title {
  font-size: 16px;
  color: black;
  word-break: break-all;
}
.create-time {
  font-size: 12px;
  color: #858585;
}
.reply-num {
  font-size: 12px;
  color: #858585;
}
.my-left-col {
  width: 100%;
  min-height: 65px;
  padding-right: 16px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.my-right-col {
  display: flex;
  align-items: center;
}
</style>
