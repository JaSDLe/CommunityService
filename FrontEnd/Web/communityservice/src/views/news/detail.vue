<template>
  <div>
    <nav-bar title="新闻详情" />

    <article-detail />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import ArticleDetail from "@/components/article-detail";
import {} from "vant";
import { findByNewsId } from "@/api/news";

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
    };
  },

  computed: {},

  watch: {},

  created() {
    this.newsId = this.$store.getters.getAccountId;
    // this.getData(this.newsId);
  },

  mounted() {},

  methods: {
    getData(param) {
      findByNewsId(param).then(res => {
        if (res.data) {
          this.data = res.data;
        }
      });
    }
  }
};
</script>

<style scoped lang='postcss'>
</style>
