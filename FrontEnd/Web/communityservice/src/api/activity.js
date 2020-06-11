import createWebServiceHelper from '@/utils/request'
const user = createWebServiceHelper(process.env.VUE_APP_USER)

// 分页查询动态列表
export function pageActivity(data) {
  return user({
    url: '/userApi/activity/pageActivity',
    method: 'post',
    data
  })
}

// 根据动态id查询动态详情
export function findByActivityId(data) {
  return user({
    url: '/userApi/activity/findByActivityId',
    method: 'get',
    params: {
      activityId: data.activityId,
      operator: data.operator
    }
  })
}

// 创建动态
export function createActivity(data) {
  return user({
    url: '/userApi/activity/createActivity',
    method: 'post',
    data
  })
}

// 创建评论
export function createComment(data) {
  return user({
    url: '/userApi/comment/createComment',
    method: 'post',
    data
  })
}

// 删除评论
export function deleteComment(data) {
  return user({
    url: '/userApi/comment/deleteComment',
    method: 'delete',
    params: {
      commentId: data.commentId,
      operator: data.operator
    }
  })
}

// 分页查询根评论
export function pageBaseComment(data) {
  return user({
    url: '/userApi/comment/pageBaseComment',
    method: 'get',
    params: {
      activityId: data.activityId,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  })
}
