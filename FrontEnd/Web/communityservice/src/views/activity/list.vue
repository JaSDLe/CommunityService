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
      <van-cell center clickable @click="toCreateActivity">
        <template #title>
          <van-row type="flex" align="center">
            <van-icon name="smile-comment-o" size="27" />
            <div class="my-cell-title">发布动态</div>
          </van-row>
        </template>
      </van-cell>
    </van-popup>

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
          @on-click="onClick(item.activityId)"
        />
      </van-list>
    </van-pull-refresh>

    <van-dialog
      v-model="isShowBaseDialog"
      show-cancel-button
      close-on-click-overlay
      @confirm="onConfirm"
    >
      <van-field
        v-model="comment"
        placeholder="请输入评论"
        size="large"
        type="textarea"
        maxlength="255"
        autosize
        rows="2"
        show-word-limit
        clearable
        style="padding: 0 20px 20px;"
      />
    </van-dialog>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import ActivityItem from "@/components/activity-item"
import { PullRefresh, List, Search, Popup, Cell, Row, Icon, Dialog, Field } from "vant"
import { pageActivity, createComment } from "@/api/activity"

export default {
  components: {
    TabBar,
    ActivityItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Search.name]: Search,
    [Popup.name]: Popup,
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Icon.name]: Icon,
    [Field.name]: Field,
    [Dialog.Component.name]: Dialog.Component,
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
        content: null,
        pageNum: 1,
        pageSize: 10
      },
      search: '',
      isShowPopup: false,
      isShowBaseDialog: false,
      comment: '',
      activityId: null,
    }
  },

  computed: {
    isShowAdd() {
      return this.$store.getters.isResident
    }
  },

  mounted() {
    this.query.communityId = this.$store.getters.getCommunityId
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
      pageActivity(this.query).then(res => {
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
      this.query.content = val
      this.isRefreshing = true
      this.onRefresh()
    },
    onClear() {
      this.query.content = null
    },
    toCreateActivity() {
      this.$router.push({
        path: "/activity/create"
      })
    },
    toActivityDetail(val) {
      this.$router.push({
        path: "/activity/detail",
        query: {
          activityId: val
        }
      })
    },
    onClick(val) {
      this.isShowBaseDialog = true
      this.activityId = val
    },
    onConfirm() {
      createComment({ content: this.comment, parentId: this.activityId, createUser: this.$store.getters.getAccountId }).then(res => {
        if (res.data) {
          this.isShowBaseDialog = false
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
