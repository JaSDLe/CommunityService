import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

// 查询社区列表
export function findAll() {
  return user({
    url: '/userApi/community/findAll',
    method: 'get'
  })
}

// 根据社区id查询社区详情
export function findDetailByCommunityId(data) {
  return user({
    url: '/userApi/community/findDetailByCommunityId',
    method: 'get',
    params: {
      communityId: data
    }
  })
}
