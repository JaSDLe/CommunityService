<template>
  <div>
    <van-sticky>
      <van-nav-bar
        style="font-size: 18px;"
        :title="title"
        left-arrow
        @click-left="onClickLeft"
        @click-right="onClickRight"
      >
        <template #right>
          <slot name="my-right"></slot>
        </template>
      </van-nav-bar>
    </van-sticky>
  </div>
</template>

<script>
import { NavBar, Sticky } from "vant"

export default {
  name: "nav-bar",

  components: {
    [NavBar.name]: NavBar,
    [Sticky.name]: Sticky,
  },

  props: {
    title: String
  },

  data() {
    return {}
  },

  created() { },

  methods: {
    onClickLeft() {
      this.$router.go(-1)
    },
    onClickRight() {
      this.$emit('right-method')
    }
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-nav-bar {
  height: 55px;
  line-height: 55px;
}
/deep/.van-nav-bar__title,
/deep/.van-nav-bar__arrow {
  font-size: 20px;
}
</style>
