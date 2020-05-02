<template>
  <div>
    <van-skeleton title avatar :row="3" :loading="loading">
      <div>实际内容</div>
    </van-skeleton>

    <activity-item />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import ActivityItem from "@/components/activity-item"
import { Skeleton } from "vant"

export default {
  components: {
    TabBar,
    ActivityItem,
    [Skeleton.name]: Skeleton
  },

  data() {
    return {
      loading: true
    }
  },

  mounted() {
    setTimeout(() => {
      // this.loading = false;
    }, 1000)
  }
};
</script>

<style>
</style>
