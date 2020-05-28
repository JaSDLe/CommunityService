<template>
  <div>
    <nav-bar title="创建社区" />

    <van-form @submit="onSubmit">
      <van-field
        v-model.trim="communityName"
        :error="isNameError"
        clearable
        size="large"
        label="社区名称"
        placeholder="请输入名称"
        maxlength="255"
        :rules="[{ validator: checkName }]"
      />

      <van-field
        v-model.trim="communityInfo"
        :error="isInfoError"
        clearable
        size="large"
        label="社区简介"
        placeholder="请输入简介"
        type="textarea"
        maxlength="255"
        autosize
        rows="3"
        show-word-limit
        :rules="[{ validator: checkInfo }]"
      />

      <van-field
        v-model="index"
        :error="isIndexError"
        readonly
        clickable
        size="large"
        label="名称首字母"
        placeholder="点击选择首字母"
        input-align="right"
        @click="showPicker = true"
      />
      <van-popup v-model="showPicker" position="bottom">
        <van-picker
          show-toolbar
          :columns="columns"
          @confirm="onConfirm"
          @cancel="showPicker = false"
        />
      </van-popup>

      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">创建</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import { Form, Field, Button, Popup, Picker } from "vant";
import { createCommunity } from "@/api/admin";

export default {
  components: {
    NavBar,
    [Form.name]: Form,
    [Field.name]: Field,
    [Popup.name]: Popup,
    [Button.name]: Button,
    [Picker.name]: Picker
  },

  data() {
    return {
      isNameError: false,
      isInfoError: false,
      isIndexError: false,
      communityName: "",
      communityInfo: "",
      showPicker: false,
      columns: [],
      index: ""
    };
  },

  created() {
    for (let i = 0; i < 25; i++) {
      this.columns.push(String.fromCharCode(65 + i));
    }
  },

  methods: {
    checkName(val) {
      this.isNameError = val == null || val == "";
    },
    checkInfo(val) {
      this.isInfoError = val == null || val == "";
    },
    onConfirm(value, index) {
      this.index = value;
      this.showPicker = false;
    },
    onSubmit() {
      if (this.index == null || this.index == "") {
        this.isIndexError = true;
        return;
      }
    }
  }
};
</script>

<style scoped>
</style>
