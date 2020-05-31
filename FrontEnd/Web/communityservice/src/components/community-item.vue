<template>
  <div>
    <van-index-anchor :index="index" />
    <van-swipe-cell v-for="(item, i) in list" :key="i">
      <van-cell :title="item.communityName" @click="onClick(item.communityId)">
        <template v-if="isJoined(item.communityId)" #default>已加入</template>
      </van-cell>
      <template #right>
        <van-button v-if="canUpdate(item.communityId)" square type="info" text="修改" @click="toUpdate(item)" />
        <van-button v-if="canDelete" square type="danger" text="删除" @click="onDelete(item)" />
      </template>
    </van-swipe-cell>

    <van-dialog
      v-model="showDeleteDialog"
      title="提示"
      :message="message"
      show-cancel-button
      confirm-button-color="red"
      close-on-click-overlay
      @confirm="doDelete"
    ></van-dialog>
  </div>
</template>

<script>
import { IndexAnchor, Cell, SwipeCell, Button, Dialog } from "vant"
import { deleteCommunity } from "@/api/admin"

export default {
  components: {
    [IndexAnchor.name]: IndexAnchor,
    [Cell.name]: Cell,
    [SwipeCell.name]: SwipeCell,
    [Button.name]: Button,
    [Dialog.Component.name]: Dialog.Component,
  },

  props: {
    index: {
      type: String,
      default: ''
    },
    list: {
      type: Array,
      default: []
    }
  },

  data() {
    return {
      showDeleteDialog: false,
      message: '',
      communityId: null
    }
  },

  computed: {
    canDelete() {
      return this.$store.getters.isSuperAdmin
    }
  },

  watch: {},

  created() { },

  mounted() { },

  methods: {
    onClick(val) {
      this.$emit('on-click', val)
    },
    toUpdate(val) {
      this.$router.push({
        path: "/community/create",
        query: {
          type: '修改',
          item: val
        }
      })
    },
    onDelete(val) {
      this.message = '确认要删除 ' + val.communityName + ' ？'
      this.communityId = val.communityId
      this.showDeleteDialog = true
    },
    doDelete() {
      deleteCommunity({ communityId: this.communityId, operator: this.$store.getters.getAccountId }).then(res => {
        this.$emit('refresh')
      })
    },
    isJoined(val) {
      return this.$store.getters.getCommunityId == val
    },
    canUpdate(val) {
      return this.$store.getters.isSuperAdmin || (this.$store.getters.isAdmin && this.$store.getters.getCommunityId == val)
    }
  }
};
</script>

<style scoped>
.button-row {
  margin-top: 10px;
  border-top: 0.5px solid #ebedf0;
}
.nickname {
  font-size: 16px;
  color: black;
  word-break: break-all;
}
.create-time {
  font-size: 12px;
  color: #858585;
}
.activity-content {
  font-size: 16px;
  color: black;
  word-break: break-all;
}
.btn {
  background-color: rgba(255, 255, 255, 0);
  border: none;
  font-size: 15px;
}
</style>
