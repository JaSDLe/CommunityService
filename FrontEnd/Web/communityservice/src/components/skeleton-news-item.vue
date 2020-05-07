<template>
  <van-skeleton
    title
    title-width="100%"
    avatar
    avatar-shape="square"
    :row="2"
    :row-width="['30%', '20%']"
    :loading="loading"
  >
    <news-item
      title="titleeee"
      cover="item.cover"
      reply-num="item.replyNum"
      create-time="item.createTime"
    />
  </van-skeleton>
</template>

<script>
import NewsItem from "@/components/news-item";
import { Skeleton } from "vant";

export default {
  components: {
    NewsItem,
    [Skeleton.name]: Skeleton
  },

  data() {
    return {
      loading: true
    };
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-skeleton {
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
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
/deep/.van-skeleton__content div:first-child {
  margin-top: 0;
  background-color: green;
}
/deep/.van-skeleton__content div:last-child {
  margin-top: 0;
  background-color: red;
}
</style>
