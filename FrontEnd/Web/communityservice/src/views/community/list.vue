<template>
  <div>
    <nav-bar title="社区列表" />

    <van-index-bar @select="onSelect">
      <van-index-anchor index="A" />
      <van-cell title="文本" @click="onClick" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-index-anchor index="B" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-index-anchor index="E" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-index-anchor index="I" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-index-anchor index="L" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-index-anchor index="Z" />
      <van-cell title="文本" />
      <van-cell title="文本" />
      <van-cell title="文本" />
    </van-index-bar>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import { IndexBar, IndexAnchor, Cell } from "vant";

export default {
  components: {
    NavBar,
    [IndexBar.name]: IndexBar,
    [IndexAnchor.name]: IndexAnchor,
    [Cell.name]: Cell
  },

  props: {},

  data() {
    return {};
  },

  computed: {},

  watch: {},

  created() {},

  mounted() {},

  methods: {
    onSelect(val) {
      console.log(val);
    },
    onClick(val) {
      console.log(val);
      this.$router.push({
        path: "/community/detail"
      });
    }
  }
};
</script>

<style>
</style>
