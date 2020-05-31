import createWebServiceHelper from '@/utils/request'
const admin = createWebServiceHelper(process.env.VUE_APP_ADMIN)

// 设置社区管理员
export function setAdmin(data) {
  return admin({
    url: '/adminApi/account/findAll',
    method: 'put',
    params: {
      accountId: data.accountId,
      communityId: data.communityId,
      operator: data.operator
    }
  })
}

// 取消社区管理员
export function unsetAdmin(data) {
  return admin({
    url: '/adminApi/account/unsetAdmin',
    method: 'put',
    params: {
      accountId: data.accountId,
      operator: data.operator
    }
  })
}

// 创建社区
export function createCommunity(data) {
  return admin({
    url: '/adminApi/community/createCommunity',
    method: 'post',
    data
  })
}

// 修改社区
export function updateCommunity(data) {
  return admin({
    url: '/adminApi/community/updateCommunity',
    method: 'put',
    data
  })
}

// 删除社区
export function deleteCommunity(data) {
  return admin({
    url: '/adminApi/community/deleteCommunity',
    method: 'delete',
    params: {
      communityId: data.communityId,
      operator: data.operator
    }
  })
}

// 创建新闻
export function createNews(data) {
  return admin({
    url: '/adminApi/news/createNews',
    method: 'post',
    data
  })
}

// 创建公告
export function createNotice(data) {
  return admin({
    url: '/adminApi/notice/createNotice',
    method: 'post',
    data
  })
}
