<template>
  <div>
    <nav-bar title="个人信息" />

    <van-cell-group title="基本资料">
      <van-cell title="头像" is-link center>
        <template #default>
          <div style="display: flex;align-items: center;float: right;">
            <van-image round width="70" height="70"></van-image>
          </div>
          <!-- <van-image round width="80" height="80"></van-image> -->
        </template>
      </van-cell>
      <van-cell title="用户名" is-link value />
      <van-cell title="昵称" is-link value />
      <van-cell title="类型" is-link value />
      <van-cell title="手机号" is-link value />
      <van-cell title="邮箱" is-link value />
      <van-cell title="社区" is-link value />
    </van-cell-group>

    <van-cell-group title="详细资料">
      <van-cell title="性别" is-link value />
      <van-cell title="出生年月" is-link value />
      <van-cell title="星座" is-link value />
      <van-cell title="地址" is-link value />
    </van-cell-group>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import { CellGroup, Cell, Image } from "vant";

export default {
  components: {
    NavBar,
    [CellGroup.name]: CellGroup,
    [Cell.name]: Cell,
    [Image.name]: Image
  },

  props: {},

  data() {
    return {};
  },

  computed: {},

  watch: {},

  created() {},

  mounted() {},

  methods: {}
};
</script>

<style>
.van-cell {
  font-size: 16px;
}
</style>
