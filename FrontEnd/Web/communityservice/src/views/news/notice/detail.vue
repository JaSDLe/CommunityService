<template>
  <div>
    <nav-bar title="公告详情" />

    <van-skeleton title :row="10" :loading="loading" style="margin-top: 20px;">
      <article-detail
        :id="data.noticeId"
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
import { findByNoticeId } from "@/api/news"

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
      noticeId: null,
      data: {}
    }
  },

  computed: {},

  watch: {},

  created() {
    this.noticeId = this.$route.query.noticeId
    this.getData()
  },

  mounted() { },

  methods: {
    getData() {
      let param = {
        noticeId: this.noticeId,
        operator: this.$store.getters.getAccountId
      }
      findByNoticeId(param).then(res => {
        if (res.data) {
          this.loading = false
          this.data = res.data
        }
      })
    }
  }
};
</script>

<style scoped lang='postcss'>
</style>
