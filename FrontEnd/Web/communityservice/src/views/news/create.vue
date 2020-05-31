<template>
  <div>
    <nav-bar title="发布新闻" />

    <van-form @submit="onSubmit">
      <van-field
        v-model.trim="title"
        :error="isTitleError"
        clearable
        size="large"
        label="标题"
        placeholder="请输入标题"
        maxlength="255"
        :rules="[{ validator: checkTitle }]"
      />

      <van-field
        v-model.trim="content"
        :error="isContentError"
        clearable
        size="large"
        label="内容"
        placeholder="请输入内容"
        type="textarea"
        maxlength="30000"
        autosize
        rows="10"
        show-word-limit
        :rules="[{ validator: checkContent }]"
      />

      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">发布</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Form, Field, Button } from "vant"
import { createNews } from "@/api/admin"

export default {
  components: {
    NavBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
  },

  data() {
    return {
      isTitleError: false,
      isContentError: false,
      title: "",
      content: "",
    }
  },

  created() {
  },

  methods: {
    checkTitle(val) {
      this.isTitleError = val == null || val == ""
    },
    checkContent(val) {
      this.isContentError = val == null || val == ""
    },
    onSubmit() {
      if (this.isTitleError || this.isContentError) {
        return
      }
      let param = {
        title: this.title,
        content: this.content,
        cover: null,
        communityId: this.$store.getters.getCommunityId,
        createUser: this.$store.getters.getAccountId,
      }
      createNews(param).then(res => {
        if (res.data) {
          this.$router.push({
            path: "/news/list"
          })
        }
      })
    }
  }
};
</script>

<style scoped lang='postcss'>
/deep/.van-field__label {
  width: auto;
  margin-right: 16px;
}
</style>
