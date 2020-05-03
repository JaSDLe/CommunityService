<template>
  <div>
    <nav-bar title="社区列表" />

    <van-index-bar :index-list="indexList" :sticky-offset-top="55" @select="onSelect">
      <community-item
        v-for="(item, index) in list"
        :key="index"
        :index="indexList[index]"
        :list="item.communityDTOList"
        @onClick="onClick"
      />
    </van-index-bar>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import CommunityItem from "@/components/community-item"
import { IndexBar, IndexAnchor, Cell, Toast } from "vant"
import { findAll } from "@/api/community"

export default {
  components: {
    NavBar,
    CommunityItem,
    [IndexBar.name]: IndexBar,
    [IndexAnchor.name]: IndexAnchor,
    [Cell.name]: Cell,
    [Toast.name]: Toast,
  },

  data() {
    return {
      list: [],
      indexList: []
    }
  },

  computed: {},

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
    }
  }
};
</script>

<style>
</style>
