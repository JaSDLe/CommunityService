<template>
  <div>
    <van-search :show-action="true">
      <template #action>
        <van-icon name="add" size="25" color="#1989fa" @click="isShowBaseDialog = true" />
      </template>
    </van-search>

    <van-dialog
      v-model="isShowBaseDialog"
      show-cancel-button
      close-on-click-overlay
      @confirm="onConfirm"
    >
      <van-field
        v-model="username"
        label="用户名"
        label-width="auto"
        colon
        placeholder="请输入用户名"
        size="large"
        clearable
        style="padding: 40px 20px 20px;"
      />
      <van-field
        v-model="content"
        label="内容"
        label-width="auto"
        colon
        placeholder="请输入内容"
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

    <van-pull-refresh v-model="isRefreshing" @refresh="onRefresh" success-text="刷新成功">
      <van-list
        v-model="isListLoading"
        :finished="isListFinished"
        :error.sync="isListError"
        finished-text="没有更多了"
        error-text="请求失败，点击重新加载"
        @load="onLoad"
      >
        <message-item
          v-for="(item, index) in list"
          :key="index"
          :receiver="item.receiverId"
          :headPic="item.headPic"
          :lastContent="item.content"
          :updateTime="item.updateTime"
          :unreadCount="item.unreadCount"
          @on-click="toMessageDetail(item.id)"
        />
      </van-list>
    </van-pull-refresh>

    <div style="height: 50px;" />

    <tab-bar />
  </div>
</template>

<script>
import TabBar from "@/components/tab-bar"
import MessageItem from "@/components/message-item"
import { PullRefresh, List, Icon, Popup, Cell, Row, Search, Field, Dialog } from "vant"
import { pageMessage, createMessage } from "@/api/message"

export default {
  components: {
    TabBar,
    MessageItem,
    [PullRefresh.name]: PullRefresh,
    [List.name]: List,
    [Icon.name]: Icon,
    [Popup.name]: Popup,
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Search.name]: Search,
    [Field.name]: Field,
    [Dialog.Component.name]: Dialog.Component,
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
      },
      isShowBaseDialog: false,
      username: null,
      content: '',
    }
  },

  computed: {},

  watch: {},

  created() {
    this.query.accountId = this.$store.getters.getAccountId
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
      pageMessage(this.query).then(res => {
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
    toMessageDetail(val) {
      this.$router.push({
        path: "/message/detail",
        query: {
          messageId: val
        }
      })
    },
    onConfirm() {
      createMessage({ receiverId: this.username, content: this.content, senderId: this.$store.getters.getAccountId }).then(res => {
        if (res.data) {
          this.isShowBaseDialog = false
          this.getData()
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
</style>
