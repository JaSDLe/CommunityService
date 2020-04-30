<template>
  <div>
    <!-- <van-cell :title="title" value="内容" /> -->

    <van-cell center @click="toDetail">
      <template #title>
        <van-row class="my-row">
          <van-col style="margin-left: 13px;">
            <van-row>
              <div style="font-size: 19px;">昵称</div>
            </van-row>
            <van-row>
              <div style="font-size: 13px;">用户名</div>
            </van-row>
          </van-col>
        </van-row>
      </template>
      <template #default>
        <div style="display: flex;align-items: center;float: right;">
          <van-image radius="5" width="85px" height="65px"></van-image>
        </div>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { Cell, Row, Col, Image } from "vant";

export default {
  components: {
    [Cell.name]: Cell,
    [Row.name]: Row,
    [Col.name]: Col,
    [Image.name]: Image
  },

  props: {
    title: String,
    cover: String,
    replyNum: Number,
    createTime: Date
  },

  data() {
    return {};
  },

  computed: {},

  watch: {},

  created() {},

  mounted() {},

  destroyed() {},

  methods: {}
};
</script>

<style scoped>
.van-cell {
  border-top: 0.5px solid #ebedf0;
  /* border-bottom: 1px solid #ebedf0; */
}
</style>
