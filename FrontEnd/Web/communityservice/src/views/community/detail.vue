<template>
  <div>
    <nav-bar title="社区详情" />

    <van-field size="large" label="名称" v-model="name" readonly />
    <van-field size="large" label="简介" v-model="info" readonly type="textarea" autosize />
  </div>
</template>

<script>
import NavBar from "@/components/nav-bar";
import { Field } from "vant";

export default {
  components: {
    NavBar,
    [Field.name]: Field
  },

  props: {},

  data() {
    return {
      name: "卓越美丽山水",
      info: "社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介社区详情-简介"
    };
  },

  computed: {},

  watch: {},

  created() {},

  mounted() {},

  methods: {}
};
</script>

<style>
</style>
