import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

// 查询私信列表
export function pageMessage(data) {
  return user({
    url: '/userApi/message/pageMessage',
    method: 'get',
    params: {
      accountId: data.accountId,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  })
}

// 根据私信id查询私信详情
export function findByMessageId(data) {
  return user({
    url: '/userApi/message/findByMessageId',
    method: 'get',
    params: {
      newsId: data
    }
  })
}
