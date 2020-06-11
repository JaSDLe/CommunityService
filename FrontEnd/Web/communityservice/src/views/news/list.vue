<template>
  <div>
    <van-search
      v-model.trim="search"
      placeholder="请输入搜索关键词"
      :show-action="isShowAdd"
      @search="onSearch"
      @clear="onClear"
    >
      <template #action>
        <van-icon name="add" size="25" color="#1989fa" @click="isShowPopup = true" />
      </template>
    </van-search>

    <van-popup v-model="isShowPopup">
      <van-cell center clickable @click="toCreateNews">
        <template #title>
          <van-row type="flex" align="center">
            <van-icon name="newspaper-o" size="27" />
            <div class="my-cell-title">发布新闻</div>
          </van-row>
        </template>
      </van-cell>
      <van-cell center clickable @click="toCreateNotice">
        <template #title>
          <van-row type="flex" align="center">
            <van-icon name="bullhorn-o" size="27" />
            <div class="my-cell-title">发布公告</div>
          </van-row>
        </template>
      </van-cell>
    </van-popup>

    <van-notice-bar
      v-for="(item, index) in noticeList"
      :key="index"
      :text="item.title"
      left-icon="volume-o"
      mode="link"
      color="#1989fa"
      background="#ecf9ff"
      @click="toNoticeDetail(item.noticeId)"
    />

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
          @on-click="toNewsDetail(item.newsId)"
        />
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import NewsItem from "@/components/news-item"
import { PullRefresh, List, Search, Icon, Popup, Cell, Row, NoticeBar } from "vant"
import { pageNews, pageNotice } from "@/api/news"

export default {
  components: {
    TabBar,
    NewsItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Search.name]: Search,
    [Icon.name]: Icon,
    [Popup.name]: Popup,
    [Cell.name]: Cell,
    [Row.name]: Row,
    [NoticeBar.name]: NoticeBar,
  },

  data() {
    return {
      search: "",
      isShowPopup: false,
      list: [],
      isRefreshing: false,
      isListLoading: false,
      isListFinished: false,
      isListError: false,
      query: {
        communityId: null,
        title: null,
        pageNum: 1,
        pageSize: 10
      },
      noticeList: []
    }
  },

  computed: {
    isShowAdd() {
      return this.$store.getters.isAdmin
    }
  },

  watch: {},

  created() {
    this.query.communityId = this.$store.getters.getCommunityId
    pageNotice({
      communityId: this.query.communityId,
      pageNum: 1,
      pageSize: 3
    }).then(res => {
      if (res.data) {
        this.noticeList = res.data.list
      }
    })
  },

  methods: {
    onLoad() {
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
      this.query.title = val
      this.isRefreshing = true
      this.onRefresh()
    },
    onClear() {
      this.query.title = null
    },
    toCreateNews() {
      this.$router.push({
        path: "/news/create"
      })
    },
    toCreateNotice() {
      this.$router.push({
        path: "/notice/create"
      })
    },
    toNoticeDetail(val) {
      this.$router.push({
        path: "/notice/detail",
        query: {
          noticeId: val
        }
      })
    },
    toNewsDetail(val) {
      this.$router.push({
        path: "/news/detail",
        query: {
          newsId: val
        }
      })
    }
  }
};
</script>

<style lang="postcss" scoped>
/deep/.van-search__action {
  height: 34px;
  display: flex;
  align-items: center;
  padding: 0 10px;
}
/deep/.van-overlay {
  background-color: rgba(0, 0, 0, 0.3);
}
.my-cell-title {
  margin-left: 13px;
  margin-right: 13px;
  font-size: 17px;
}
/deep/.van-cell--center {
  padding: 13px;
  border-radius: 5px;
}
/deep/.van-popup--center {
  left: unset;
  transform: none;
}
/deep/.van-popup {
  border-radius: 5px;
  overflow-y: visible;
  position: absolute;
  width: fit-content;
  top: 58px;
  right: 5px;
}
/deep/.van-popup::before {
  content: "";
  width: 0;
  height: 0;
  position: absolute;
  top: -8px;
  right: 10px;
  border-left: solid 8px transparent;
  border-right: solid 8px transparent;
  border-bottom: solid 8px #fff;
}
</style>
