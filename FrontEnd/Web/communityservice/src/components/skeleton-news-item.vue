<template>
  <van-skeleton
    title
    title-width="100%"
    avatar
    avatar-shape="square"
    :row="1"
    :row-width="'45%'"
    :loading="loading"
  >
    <news-item
      :title="title"
      :cover="cover"
      :reply-num="replyNum"
      :create-time="createTime"
    />
  </van-skeleton>
</template>

<script>
import NewsItem from "@/components/news-item"
import { Skeleton } from "vant"

export default {
  components: {
    NewsItem,
    [Skeleton.name]: Skeleton
  },

  props: {
    loading: {
      type: Boolean
    },
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
  }
};
</script>

<style scoped lang='postcss'>
.van-skeleton {
  padding: 10px 16px !important;
  min-height: 65px;
}
/deep/.van-skeleton__avatar {
  width: 85px !important;
  height: 65px !important;
  border-radius: 5px;
  order: 1;
  margin-right: 0;
}
/deep/.van-skeleton__content {
  padding-right: 16px;
  padding-top: 0;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
/deep/.van-skeleton__title {
  height: 22px;
  margin-top: 3px;
}
/* /deep/.van-skeleton__content :nth-child(2) {
  margin-top: 0;
} */
/deep/.van-skeleton__content :last-child {
  height: 18px;
  margin-top: 0;
  margin-bottom: 3px;
}
</style>
