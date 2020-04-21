import axios from 'axios'

const __CACHE__ = {}

export default function createWebServiceHelper(baseUrl) {
  if (__CACHE__[baseUrl]) {
    return __CACHE__[baseUrl]
  }

  // 创建axios实例
  const service = axios.create({
    baseURL: baseUrl, // api的base_url
    timeout: 30000 // 请求超时时间
  })

  // // request拦截器
  // service.interceptors.request.use(config => {
  //   return config
  // }, error => {
  //   Promise.reject(error)
  // })

  // // respone拦截器
  // service.interceptors.response.use(
  //   response => {
  //     const res = response.data
  //     const handler = RETURN_CODE_HANDLER[response.data.code]
  //     if (handler) {
  //       return Promise.resolve(handler(response))
  //     }
  //     if (res.success !== true) {
  //       Message({
  //         message: res.description || '请求失败，请联系管理员',
  //         type: 'error',
  //         duration: 5 * 1000
  //       })
  //     }
  //     return res.success !== true ? Promise.reject(res) : Promise.resolve(res)
  //   },
  //   error => {
  //     console.log('拦截异常', error)
  //     Message({
  //       message: error || '请求失败，请联系管理员',
  //       type: 'error',
  //       duration: 5 * 1000
  //     })
  //     return Promise.reject(new Error(error))
  //   }
  // )

  __CACHE__[baseUrl] = service

  return service
}
