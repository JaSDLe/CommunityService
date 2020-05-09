import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

export function register(data) {
  return user({
    url: '/userApi/account/register',
    method: 'post',
    data
  })
}

export function login(data) {
  return user({
    url: '/userApi/account/login',
    method: 'post',
    data
  })
}

export function getUserInfoByAccountId(data) {
  return user({
    url: '/userApi/accountDetail/getUserInfoByAccountId',
    method: 'get',
    params: {
      accountId: data
    }
  })
}

export function updateAccountBaseInfo(data) {
  return user({
    url: '/userApi/account/updateAccountBaseInfo',
    method: 'put',
    data
  })
}

export function updateAccountDetail(data) {
  return user({
    url: '/userApi/accountDetail/updateAccountDetail',
    method: 'put',
    data
  })
}
