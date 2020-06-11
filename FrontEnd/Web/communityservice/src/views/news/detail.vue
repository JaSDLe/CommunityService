<template>
  <div>
    <nav-bar title="新闻详情" />

    <van-skeleton title :row="10" :loading="loading" style="margin-top: 20px;">
      <article-detail
        :id="data.newsId"
        :title="data.title"
        :createTime="data.createTime"
        :author="data.author"
        :replyNum="data.replyNum"
        :content="data.content"
      />
    </van-skeleton>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import ArticleDetail from "@/components/article-detail"
import { Skeleton } from "vant"
import { findByNewsId } from "@/api/news"

export default {
  components: {
    NavBar,
    ArticleDetail,
    [Skeleton.name]: Skeleton
  },

  props: {},

  data() {
    return {
      loading: true,
      newsId: null,
      data: {}
    }
  },

  computed: {},

  watch: {},

  created() {
    this.newsId = this.$route.query.newsId
    this.getData()
  },

  mounted() { },

  methods: {
    getData() {
      let param = {
        newsId: this.newsId,
        operator: this.$store.getters.getAccountId
      }
      findByNewsId(param).then(res => {
        if (res.data) {
          this.loading = false
          this.data = res.data
        }
      })
    },
  }
};
</script>

<style scoped lang='postcss'>
</style>
