<template>
  <div @touchmove.prevent>
    <nav-bar title="发表动态">
      <template #my-right>
        <van-button round block type="info" icon="success" @click="doCreate"></van-button>
      </template>
    </nav-bar>

    <van-form ref="form">
      <van-field
        v-model.trim="content"
        ref="field"
        :error="isContentError"
        size="large"
        placeholder="分享新鲜事..."
        type="textarea"
        maxlength="255"
        autosize
        rows="100"
        show-word-limit
        :rules="[{ validator: checkContent, trigger: 'onChange' }]"
      />
    </van-form>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar"
import { Form, Field, Button } from "vant"
import { createActivity } from "@/api/activity"

export default {
  components: {
    NavBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Button.name]: Button,
  },

  data() {
    return {
      isContentError: false,
      content: "",
    }
  },

  mounted() {
    this.$refs.field.focus()
  },

  methods: {
    checkContent(val) {
      this.isContentError = val == null || val == ""
    },
    doCreate() {
      this.$refs.form.validate()
      if (this.isContentError) {
        return
      }
      let param = {
        content: this.content,
        communityId: this.$store.getters.getCommunityId,
        createUser: this.$store.getters.getAccountId,
      }
      createActivity(param).then(res => {
        if (res.data) {
          this.$router.push({
            path: "/activity/list"
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
/deep/.van-button {
  height: 30px;
}
/deep/.van-button__icon {
  color: white;
}
/deep/.van-field__control {
  font-size: 17px;
}
/deep/.van-field__word-limit {
  font-size: 13px;
  position: fixed;
  bottom: 16px;
  right: 16px;
  margin: 0;
  padding: 4px 5px;
  border: 1px solid #1989fa;
  border-radius: 999px;
  color: #1989fa;
}
/deep/.van-field__word-num {
  font-size: 15px;
}
</style>
