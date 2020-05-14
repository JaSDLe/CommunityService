<template>
  <div>
    <nav-bar title="公告详情" />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import {} from "vant";
import { findByNoticeId } from "@/api/news";

export default {
  components: {
    NavBar
  },

  props: {},

  data() {
    return {
      noticeId: null,
      data: {}
    };
  },

  computed: {},

  watch: {},

  created() {
    this.noticeId = this.$store.getters.getAccountId;
    this.getData(this.noticeId);
  },

  mounted() {},

  methods: {
    getData(param) {
      findByNoticeId(param).then(res => {
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
