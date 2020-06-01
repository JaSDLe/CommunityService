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
      messsageId: null,
      data: {}
    }
  },

  computed: {},

  watch: {},

  created() {
    this.messsageId = this.$route.query.messsageId
    this.getData()
  },

  mounted() { },

  methods: {
    getData() {
      let param = {
        messsageId: this.messsageId,
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
