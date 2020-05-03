import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

export function findAll() {
  return user({
    url: '/userApi/community/findAll',
    method: 'get'
  })
}

export function findDetailByCommunityId(data) {
  return user({
    url: '/userApi/community/findDetailByCommunityId',
    method: 'get',
    params: {
      communityId: data
    }
  })
}

export function login(data) {
  return user({
    url: '/userApi/account/login',
    method: 'post',
    data
  })
}

// export function findAll() {
//   return user({
//     url: '/userApi/accountDetail/findAll',
//     method: 'get',
//   })
// }