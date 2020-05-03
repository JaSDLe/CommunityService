<template>
  <div>
    <van-index-anchor :index="index" />
    <van-cell v-for="(item, i) in list" :key="i" :title="item.communityName" @click="onClick(item.communityId)" />
  </div>
</template>

<script>
import { IndexAnchor, Cell } from "vant"

export default {
  components: {
    [IndexAnchor.name]: IndexAnchor,
    [Cell.name]: Cell,
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
    return {}
  },
  computed: {},

  watch: {},

  created() { },

  mounted() { },

  methods: {
    onClick(val) {
      this.$emit('onClick', val)
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
