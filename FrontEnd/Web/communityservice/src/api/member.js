import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

export function findAll() {
  return user({
    url: '/userApi/account/findAll',
    method: 'get',
  })
}
