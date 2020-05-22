<template>
  <div>
    <van-sticky>
      <van-row class="row">
        <van-col>
          <van-button icon="edit" class="btn1">写评论</van-button>
        </van-col>
        <van-col>
          <van-button icon="chat" class="btn2">{{ replyNum || '0' }}</van-button>
        </van-col>
      </van-row>
    </van-sticky>
  </div>
</template>

<script>
import { Sticky, Row, Col, Button } from "vant";

export default {
  components: {
    [Sticky.name]: Sticky,
    [Row.name]: Row,
    [Col.name]: Col,
    [Button.name]: Button
  },

  props: {
    replyNum: {
      type: Number,
      default: 18
    }
  },

  data() {
    return {};
  },

  created() {},

  methods: {
    // onClickLeft() {
    //   this.$router.go(-1)
    // }
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-sticky {
  background-color: #fff;
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
}
/deep/.van-sticky--fixed {
  top: calc(100% - 40px);
}
.row {
  height: 40px;
}
.row .btn2 {
  background-color: rgba(255, 255, 255, 0);
  border: none;
}
.row .btn1 {
  padding-right: 80px;
}
.van-button--default {
  color: #1989fa;
}
.btn1 .van-icon {
  font-size: 28px;
}
.btn1 .van-button__text {
  font-size: 18px;
  margin-top: 4px;
}
.btn2 .van-icon {
  transform: rotateY(180deg);
  font-size: 25px;

}
.btn2 .van-button__text {
  font-size: 23px;
}
</style>
