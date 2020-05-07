<template>
  <div>
    <van-search
      v-model="search"
      :show-action="isShowCancel"
      placeholder="请输入搜索关键词"
      @search="onSearch"
      @cancel="onCancel"
    />

    <!-- <news-item
      title="titleeee"
      cover="item.cover"
      reply-num="item.replyNum"
      create-time="item.createTime"
    />-->

    <!-- <skeleton-news-item v-for="i in 3" :key="i" :loading="loading" /> -->

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
        <!-- <skeleton-news-item
          v-for="(item, index) in list"
          :key="index"
          :loading="loading"
          :title="item.title"
          :cover="item.cover"
          :reply-num="item.replyNum"
          :create-time="item.createTime"
        />-->
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import NewsItem from "@/components/news-item"
import SkeletonNewsItem from "@/components/skeleton-news-item"
import { PullRefresh, List, Search, Skeleton } from "vant"
import { pageNews } from "@/api/news"

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
    }
  },

  created() { },

  methods: {
    onLoad() {
      // setTimeout(() => {
      //   this.loading = false
      // }, 1500)
      if (this.isRefreshing) {
        this.list = []
        this.isRefreshing = false
      }
      this.getData()
    },
    onRefresh() {
      this.query.pageNum = 1
      // 清空列表数据
      this.isListFinished = false
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.isListError = false
      this.isListLoading = true
      this.onLoad()
    },
    getData() {
      pageNews(this.query).then(res => {
        if (res.data) {
          this.isListError = false
          this.list = this.list.concat(res.data.list)
          if (res.data.isLastPage) {
            this.isListFinished = true
          } else {
            this.query.pageNum = res.data.nextPage
          }
        } else {
          this.isListError = true
        }
        this.isListLoading = false
      })
    },
    onSearch(val) {
      console.log(val)
      this.isShowCancel = true
    },
    onCancel() {
      this.isShowCancel = false
    }
  }
};
</script>

<style>
</style>
