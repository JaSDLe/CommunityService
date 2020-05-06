<template>
  <div>
    <van-search
      v-model="search"
      :show-action="isShowCancel"
      placeholder="请输入搜索关键词"
      @search="onSearch"
      @cancel="onCancel"
    />

    <news-item
      title="titleeee"
      cover="item.cover"
      reply-num="item.replyNum"
      create-time="item.createTime"
    />

    <!-- <van-skeleton title avatar avatar-shape="square" avatar-size="50" :row="2" :loading="loading">
      <news-item
        title="titleeee"
        cover="item.cover"
        reply-num="item.replyNum"
        create-time="item.createTime"
      />
    </van-skeleton> -->

    <skeleton-news-item />

    <van-pull-refresh v-model="isRefreshing" @refresh="onRefresh" success-text="刷新成功">
      <van-list
        v-model="isListLoading"
        :finished="isListFinished"
        :error.sync="isListError"
        finished-text="没有更多了"
        error-text="请求失败，点击重新加载"
        @load="onLoad"
      >
        <news-item
          v-for="(item, index) in list"
          :key="index"
          :title="item.title"
          :cover="item.cover"
          :reply-num="item.replyNum"
          :create-time="item.createTime"
        />
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar";
import NewsItem from "@/components/news-item";
import SkeletonNewsItem from "@/components/skeleton-news-item";
import { PullRefresh, List, Search, Skeleton } from "vant";
import { pageNews } from "@/api/news";

export default {
  components: {
    TabBar,
    NewsItem,
    SkeletonNewsItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Search.name]: Search,
    [Skeleton.name]: Skeleton
  },

  data() {
    return {
      search: "",
      isShowCancel: false,
      list: [],
      isRefreshing: false,
      isListLoading: false,
      isListFinished: false,
      isListError: false,
      query: {
        communityId: null,
        pageNum: 1,
        pageSize: 10
      },
      loading: true
    };
  },

  created() {},

  methods: {
    onLoad() {
      // setTimeout(() => {
      if (this.isRefreshing) {
        this.list = [];
        this.isRefreshing = false;
      }
      // this.getData()

      // for (let i = 0; i < 10; i++) {
      //   this.list.push(this.list.length + 1)
      // }
      // this.isListLoading = false

      // if (this.list.length >= 40) {
      //   this.isListFinished = true
      // }
      // }, 1000)
    },
    onRefresh() {
      // 清空列表数据
      this.isListFinished = false;
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.isListLoading = true;
      this.onLoad();
    },
    getData() {
      pageNews(this.query).then(res => {
        if (res.data) {
          this.list = this.list.concat(res.data.list);
          this.isListLoading = false;

          if (res.data.isLastPage) {
            this.isListFinished = true;
          }
        }
      });
    },
    onSearch(val) {
      console.log(val);
      this.isShowCancel = true;
    },
    onCancel() {
      this.isShowCancel = false;
    }
  }
};
</script>

<style>
</style>
