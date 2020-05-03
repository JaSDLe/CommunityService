<template></template>

<script>
export default {
  created() {
    console.log(this.$store.getters.isLogin)
    if (this.$store.getters.isLogin) {
      this.$router.push({
        path: "/member/user-center"
      })
    } else {
      this.$router.push({
        path: "/login"
      })
    }
  }
}
</script>

<style>
</style>
