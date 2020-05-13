import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

// 注册
export function register(data) {
  return user({
    url: '/userApi/account/register',
    method: 'post',
    data
  })
}

// 登录
export function login(data) {
  return user({
    url: '/userApi/account/login',
    method: 'post',
    data
  })
}

// 加入社区
export function joinCommunity(data) {
  return user({
    url: '/userApi/account/joinCommunity',
    method: 'put',
    params: {
      accountId: data.accountId,
      communityId: data.communityId
    }
  })
}

// 更新账户基本信息
export function updateAccountBaseInfo(data) {
  return user({
    url: '/userApi/account/updateAccountBaseInfo',
    method: 'put',
    data
  })
}

// 根据账号id获取账户信息
export function getUserInfoByAccountId(data) {
  return user({
    url: '/userApi/accountDetail/getUserInfoByAccountId',
    method: 'get',
    params: {
      accountId: data
    }
  })
}

// 更新账户详情信息
export function updateAccountDetail(data) {
  return user({
    url: '/userApi/accountDetail/updateAccountDetail',
    method: 'put',
    data
  })
}
