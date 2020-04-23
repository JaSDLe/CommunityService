import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

export function findAll() {
  return user({
    url: '/userApi/account/findAll',
    method: 'get',
  })
}

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
