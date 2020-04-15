<template>
  <div>
    <van-skeleton title avatar :row="3" :loading="loading">
      <div>实际内容</div>
    </van-skeleton>

    <tabbar />
  </div>
</template>

<script>
import tabbar from "@/components/tab-bar";
import { Skeleton } from "vant";

export default {
  components: {
    tabbar,
    [Skeleton.name]: Skeleton
  },

  data() {
    return {
      loading: true
    };
  },

  mounted() {
    setTimeout(() => {
      // this.loading = false;
    }, 1000);
  }
};
</script>

<style>
</style>
