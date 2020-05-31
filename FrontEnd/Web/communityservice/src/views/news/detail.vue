<template>
  <div>
    <nav-bar title="新闻详情" />

    <article-detail
      :title="data.title"
      :createTime="data.createTime"
      :author="data.author"
      :replyNum="data.replyNum"
      :content="data.content"
    />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import ArticleDetail from "@/components/article-detail"
import { } from "vant"
import { findByNewsId } from "@/api/news"

export default {
  components: {
    NavBar,
    ArticleDetail
  },

  props: {},

  data() {
    return {
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
          this.data = res.data
        }
      })
    }
  }
};
</script>

<style scoped lang='postcss'>
</style>
