<template>
  <div>
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
          :title="item.sendId"
          :create-time="item.updateTime"
          @on-click="toMessageDetail(item.messageId)"
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
import { PullRefresh, List, Icon, Popup, Cell, Row } from "vant";
import { pageMessage } from "@/api/message";

export default {
  components: {
    TabBar,
    NewsItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Icon.name]: Icon,
    [Popup.name]: Popup,
    [Cell.name]: Cell,
    [Row.name]: Row
  },

  data() {
    return {
      isShowPopup: false,
      list: [],
      isRefreshing: false,
      isListLoading: false,
      isListFinished: false,
      isListError: false,
      query: {
        accountId: null,
        pageNum: 1,
        pageSize: 10
      }
    };
  },

  computed: {},

  watch: {},

  created() {},

  methods: {
    onLoad() {
      if (this.isRefreshing) {
        this.list = [];
        this.isRefreshing = false;
      }
      this.getData();
    },
    onRefresh() {
      this.query.pageNum = 1;
      // 清空列表数据
      this.isListFinished = false;
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.isListError = false;
      this.isListLoading = true;
      this.onLoad();
    },
    getData() {
      pageMessage(this.query).then(res => {
        if (res.data) {
          this.isListError = false;
          this.list = this.list.concat(res.data.list);
          if (res.data.isLastPage) {
            this.isListFinished = true;
          } else {
            this.query.pageNum = res.data.nextPage;
          }
        } else {
          this.isListError = true;
        }
        this.isListLoading = false;
      });
    },
    toMessageDetail(val) {
      this.$router.push({
        path: "/message/detail",
        query: {
          messageId: val
        }
      });
    }
  }
};
</script>

<style>
</style>
