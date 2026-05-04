import request from '@/utils/request'

// 查询卫生检查记录列表
export function listInspection(query) {
  return request({
    url: '/susheguanli/inspection/list',
    method: 'get',
    params: query
  })
}

// 查询卫生检查记录详细
export function getInspection(inspectionId) {
  return request({
    url: '/susheguanli/inspection/' + inspectionId,
    method: 'get'
  })
}

// 新增卫生检查记录
export function addInspection(data) {
  return request({
    url: '/susheguanli/inspection',
    method: 'post',
    data: data
  })
}

// 修改卫生检查记录
export function updateInspection(data) {
  return request({
    url: '/susheguanli/inspection',
    method: 'put',
    data: data
  })
}

// 删除卫生检查记录
export function delInspection(inspectionId) {
  return request({
    url: '/susheguanli/inspection/' + inspectionId,
    method: 'delete'
  })
}
