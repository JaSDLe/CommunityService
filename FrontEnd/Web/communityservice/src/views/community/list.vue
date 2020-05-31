<template>
  <div>
    <nav-bar title="社区列表" @right-method="toCreate">
      <template v-if="canCreate" #my-right>
        <van-icon name="plus" size="20" />
      </template>
    </nav-bar>

    <van-index-bar :index-list="indexList" :sticky-offset-top="55" @select="onSelect">
      <community-item
        v-for="(item, index) in list"
        :key="index"
        :index="indexList[index]"
        :list="item.communityDTOList"
        @on-click="onClick"
        @refresh="getList"
      />
    </van-index-bar>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import CommunityItem from "@/components/community-item"
import { IndexBar, IndexAnchor, Cell, Icon } from "vant"
import { findAll } from "@/api/community"

export default {
  components: {
    NavBar,
    CommunityItem,
    [IndexBar.name]: IndexBar,
    [IndexAnchor.name]: IndexAnchor,
    [Cell.name]: Cell,
    [Icon.name]: Icon,
  },

  data() {
    return {
      list: [],
      indexList: []
    }
  },

  computed: {
    canCreate() {
      return this.$store.getters.isSuperAdmin
    }
  },

  watch: {},

  created() {
    console.log('created')
    this.getList()
  },

  mounted() { },

  methods: {
    getList() {
      findAll().then(res => {
        if (res.data) {
          this.list = res.data
          this.list.forEach(item => {
            this.indexList.push(item.communityDTOList[0].index)
          })
        }
      })
    },
    onSelect(val) {
      console.log(val)
    },
    onClick(val) {
      console.log(val)
      this.$router.push({
        path: "/community/detail",
        query: {
          communityId: val
        }
      })
    },
    toCreate() {
      if (this.canCreate) {
        this.$router.push({
          path: "/community/create",
          query: {
            type: '创建'
          }
        })
      }
    }
  }
};
</script>

<style>
</style>
