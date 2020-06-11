<template>
  <div>
    <van-cell style="padding: 13px;" center clickable @click="toDetail">
      <template #default>
        <van-row type="flex" justify="space-between" align="center">
          <van-col type="flex" align="center" style="height: 45px;">
            <van-image :src="headPic" round fit="cover" width="45" height="45" lazy-load>
              <template #loading>
                <van-loading type="spinner" size="20" />
              </template>
              <template #error>
                <van-icon name="warning-o" size="20" />
              </template>
            </van-image>
          </van-col>
          <van-col class="my-right-col">
            <van-row type="flex" justify="space-between">
              <div class="receiver">{{ receiver }}</div>
              <div class="update-time">{{ updateTime | getDate }}</div>
            </van-row>
            <van-row type="flex" justify="space-between" align="center">
              <div class="lastContent">{{ lastContent }}</div>
              <van-tag v-if="unreadCount > 0" round type="danger">{{ unreadCount }}</van-tag>
            </van-row>
          </van-col>
        </van-row>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { Cell, Row, Col, Image, Loading, Icon, Button, Tag } from "vant"

export default {
  components: {
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Col.name]: Col,
    [Image.name]: Image,
    [Loading.name]: Loading,
    [Icon.name]: Icon,
    [Button.name]: Button,
    [Tag.name]: Tag,
  },

  props: {
    receiver: {
      type: String,
      // default: '新款小米222222222222222222222222222222222222222222222'
    },
    headPic: {
      type: String,
      // default: 'IT之家5月1日消息 根据NoteBookCheck的报道，大量小米的新型号笔记本电脑获得了蓝牙SIG的认证。外媒认为，小米打算扩大其移动个人电脑产品组合，最多推出6款新的笔记本电脑，其中至少有两款采用了AMD最新的Ryzen 4000 APU。'
    },
    lastContent: {
      type: String,
      // default: 'https://img.yzcdn.cn/vant/cat1.jpeg1111111111111111111111111111111111111'
    },
    updateTime: {
      type: String,
      // default: 4
    },
    unreadCount: {
      type: Number,
      default: 0
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
      const now1 = new Date()
      const y1 = now1.getFullYear()
      const m1 = ('0' + (now1.getMonth() + 1)).slice(-2)
      const d1 = ('0' + (now1.getDate())).slice(-2)
      if (y == y1) {
        if (m == m1 && d == d1) {
          return now.toTimeString().substr(0, 5)
        } else {
          return m + '-' + d
        }
      } else {
        y.slice(-2) + '-' + m + '-' + d
      }
    }
  },

  methods: {
    toDetail(val) {
      this.$emit('on-click')
    }
  }
};
</script>

<style scoped>
.receiver {
  font-size: 16px;
  color: black;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  width: 200px;
}
.update-time {
  font-size: 12px;
  color: #858585;
}
.lastContent {
  font-size: 14px;
  color: #858585;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  width: 200px;
}
.my-right-col {
  width: 100%;
  min-height: 50px;
  padding-left: 16px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.van-tag--round {
  border-radius: 50%;
  height: 100%;
  font-size: 12px;
}
</style>
