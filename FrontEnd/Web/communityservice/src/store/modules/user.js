
const user = {
  state: {
    accountId: '',
    communityId: '',
    type: '',
    username: '',
    nickname: '',
  },
  mutations: {
    SET_ACCOUNT_ID(state, accountId) {
      state.accountId = accountId
    },
    SET_COMMUNITY_ID(state, communityId) {
      state.communityId = communityId
    },
    SET_TYPE(state, type) {
      state.type = type
    },
    SET_USERNAME(state, username) {
      state.username = username
    },
    SET_NICKNAME(state, nickname) {
      state.nickname = nickname
    },
  },
  actions: {
    login({ commit }, data) {
      return new Promise(resolve => {
        commit('SET_ACCOUNT_ID', data.accountId)
        commit('SET_COMMUNITY_ID', data.communityId)
        commit('SET_TYPE', data.type)
        commit('SET_USERNAME', data.username)
        commit('SET_NICKNAME', data.nickname)
        resolve()
      })
    },
    logout({ commit }) {
      return new Promise(resolve => {
        commit('SET_ACCOUNT_ID', '')
        commit('SET_COMMUNITY_ID', '')
        commit('SET_TYPE', '')
        commit('SET_USERNAME', '')
        commit('SET_NICKNAME', '')
        resolve()
      })
    },
    joinCommunity({ commit }, data) {
      return new Promise(resolve => {
        commit('SET_COMMUNITY_ID', data.communityId)
        commit('SET_TYPE', data.type)
        resolve()
      })
    },
    updateBaseInfo({ commit }, data) {
      return new Promise(resolve => {
        commit('SET_USERNAME', data.username)
        commit('SET_NICKNAME', data.nickname)
        resolve()
      })
    },
  },
  getters: {
    isSuperAdmin: state => {
      return state.type == 1
    },
    isAdmin: state => {
      return state.type == 2
    },
    isResident: state => {
      return state.type == 3
    },
    isLogin: state => {
      console.log(state)
      return state.accountId != '' && state.accountId != null
    },
    getAccountId: state => {
      return state.accountId
    },
    getCommunityId: state => {
      return state.communityId
    },
    getType: state => {
      return state.type
    },
    getUsername: state => {
      return state.username
    },
    getNickname: state => {
      return state.nickname
    },
  }
}

export default user
