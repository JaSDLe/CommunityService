<template>
  <div>
    <nav-bar title="动态详情" />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import {} from "vant";
import { findByActivityId } from "@/api/activity";

export default {
  components: {
    NavBar
  },

  props: {},

  data() {
    return {
      activityId: null,
      data: {}
    };
  },

  computed: {},

  watch: {},

  created() {
    this.activityId = this.$store.getters.getAccountId;
    this.getData(this.activityId);
  },

  mounted() {},

  methods: {
    getData(param) {
      findByActivityId(param).then(res => {
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
