<template>
  <div>
    <van-pull-refresh v-model="isRefreshing" @refresh="onRefresh" success-text="刷新成功">
      <van-list
        v-model="isListLoading"
        :finished="isListFinished"
        :error.sync="isListError"
        @load="onLoad"
        finished-text="没有更多了"
        error-text="请求失败，点击重新加载"
      >
        <van-cell v-for="item in list" :key="item" :title="item" />
      </van-list>
    </van-pull-refresh>

    <tabbar />
  </div>
</template>

<script>
import tabbar from "@/components/tab-bar";
import { PullRefresh, List, Cell } from "vant";

export default {
  components: {
    tabbar,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Cell.name]: Cell
  },

  data() {
    return {
      list: [],
      isRefreshing: false,
      isListLoading: false,
      isListFinished: false,
      isListError: false
    };
  },

  methods: {
    onLoad() {
      setTimeout(() => {
        if (this.isRefreshing) {
          this.list = [];
          this.isRefreshing = false;
        }

        for (let i = 0; i < 10; i++) {
          this.list.push(this.list.length + 1);
        }
        this.isListLoading = false;

        if (this.list.length >= 40) {
          this.isListFinished = true;
        }
      }, 1000);
    },
    onRefresh() {
      // 清空列表数据
      this.isListFinished = false;

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.isListLoading = true;
      this.onLoad();
    }
  }
};
</script>

<style>
</style>
