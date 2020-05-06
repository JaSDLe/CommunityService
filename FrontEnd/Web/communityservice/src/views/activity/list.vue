<template>
  <div>
    <van-skeleton title avatar :row="3" :loading="loading">
      <div>实际内容</div>
    </van-skeleton>

    <van-pull-refresh v-model="isRefreshing" @refresh="onRefresh" success-text="刷新成功">
      <van-list
        v-model="isListLoading"
        :finished="isListFinished"
        :error.sync="isListError"
        finished-text="没有更多了"
        error-text="请求失败，点击重新加载"
        @load="onLoad"
      >
        <activity-item
          v-for="(item, index) in list"
          :key="index"
          :nickname="item.nickname"
          :content="item.content"
          :headPic="item.headPic"
          :replyNum="item.replyNum"
          :createTime="item.createTime"
        />
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar";
import ActivityItem from "@/components/activity-item";
import { PullRefresh, List, Skeleton } from "vant";
import { pageActivity } from "@/api/activity";

export default {
  components: {
    TabBar,
    ActivityItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Skeleton.name]: Skeleton
  },

  data() {
    return {
      loading: true,
      list: [],
      isRefreshing: false,
      isListLoading: false,
      isListFinished: false,
      isListError: false,
      query: {
        communityId: null,
        pageNum: 1,
        pageSize: 10
      }
    };
  },

  mounted() {
    // setTimeout(() => {
    // this.loading = false;
    // }, 1000);
  },

  methods: {
    onLoad() {
      if (this.isRefreshing) {
        this.list = [];
        this.isRefreshing = false;
      }
      this.getData();
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
      pageActivity(this.query).then(res => {
        if (res.data) {
          this.list = this.list.concat(res.data.list);
          this.isListLoading = false;
          if (res.data.isLastPage) {
            this.isListFinished = true;
          }
        }
      });
    }
  }
};
</script>

<style>
</style>
