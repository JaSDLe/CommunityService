<template>
  <div>
    <nav-bar title="" />

  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { } from "vant"
import { findByMessageId } from "@/api/message"

export default {
  components: {
    NavBar,
  },

  props: {},

  data() {
    return {
      messageId: null,
      data: {}
    }
  },

  computed: {},

  watch: {},

  created() {
    this.messageId = this.$route.query.messageId
    this.getData()
  },

  mounted() { },

  methods: {
    getData() {
      let param = {
        messageId: this.messageId,
        operator: this.$store.getters.getAccountId
      }
      findByMessageId(param).then(res => {
        if (res.data) {
          this.data = res.data
        }
      })
    }
  }
};
</script>

<style scoped lang='postcss'>
</style>
