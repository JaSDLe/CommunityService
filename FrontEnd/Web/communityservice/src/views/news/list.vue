<template>
  <div>
    <van-search v-model="value" placeholder="请输入搜索关键词" />

    <van-pull-refresh v-model="isRefreshing" @refresh="onRefresh" success-text="刷新成功">
      <van-list
        v-model="isListLoading"
        :finished="isListFinished"
        :error.sync="isListError"
        finished-text="没有更多了"
        error-text="请求失败，点击重新加载"
        @load="onLoad"
      >
        <!-- <van-cell v-for="item in list" :key="item" :title="item" /> -->
        <news-item v-for="item in list" :key="item" :title="item" />
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar";
import NewsItem from "@/components/news-item";
import { PullRefresh, List, Cell, Search } from "vant";

export default {
  components: {
    TabBar,
    NewsItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Cell.name]: Cell,
    [Search.name]: Search
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
