import request from '@/utils/request'

// 查询住宿记录列表
export function listAccommodation(query) {
  return request({
    url: '/susheguanli/accommodation/list',
    method: 'get',
    params: query
  })
}

// 查询住宿记录详细
export function getAccommodation(accommodationId) {
  return request({
    url: '/susheguanli/accommodation/' + accommodationId,
    method: 'get'
  })
}

// 新增住宿记录
export function addAccommodation(data) {
  return request({
    url: '/susheguanli/accommodation',
    method: 'post',
    data: data
  })
}

// 修改住宿记录
export function updateAccommodation(data) {
  return request({
    url: '/susheguanli/accommodation',
    method: 'put',
    data: data
  })
}

// 删除住宿记录
export function delAccommodation(accommodationId) {
  return request({
    url: '/susheguanli/accommodation/' + accommodationId,
    method: 'delete'
  })
}
