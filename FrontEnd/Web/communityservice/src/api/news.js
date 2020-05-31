import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

// 分页查询新闻列表
export function pageNews(data) {
  return user({
    url: '/userApi/news/pageNews',
    method: 'get',
    params: {
      communityId: data.communityId,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  })
}

// 根据新闻id查询新闻详情
export function findByNewsId(data) {
  return user({
    url: '/userApi/news/findByNewsId',
    method: 'get',
    params: {
      newsId: data.newsId,
      operator: data.operator
    }
  })
}

// 分页查询公告列表
export function pageNotice(data) {
  return user({
    url: '/userApi/notice/pageNotice',
    method: 'get',
    params: {
      communityId: data.communityId,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  })
}

// 根据公告id查询公告详情
export function findByNoticeId(data) {
  return user({
    url: '/userApi/notice/findByNoticeId',
    method: 'get',
    params: {
      noticeId: data.noticeId,
      operator: data.operator
    }
  })
}

// 创建留言
export function createAnswer(data) {
  return user({
    url: '/userApi/answer/createAnswer',
    method: 'post',
    data
  })
}

// 删除留言
export function deleteAnswer(data) {
  return user({
    url: '/userApi/answer/deleteAnswer',
    method: 'delete',
    params: {
      answerId: data.answerId,
      operator: data.operator
    }
  })
}

// 分页查询根留言
export function pageBaseAnswer(data) {
  return user({
    url: '/userApi/answer/pageBaseAnswer',
    method: 'get',
    params: {
      id: data.id,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  })
}
