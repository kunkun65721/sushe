import request from '@/utils/request'

// 查询报修记录列表
export function listRepair(query) {
  return request({
    url: '/susheguanli/repair/list',
    method: 'get',
    params: query
  })
}

// 查询报修记录详细
export function getRepair(repairId) {
  return request({
    url: '/susheguanli/repair/' + repairId,
    method: 'get'
  })
}

// 新增报修记录
export function addRepair(data) {
  return request({
    url: '/susheguanli/repair',
    method: 'post',
    data: data
  })
}

// 修改报修记录
export function updateRepair(data) {
  return request({
    url: '/susheguanli/repair',
    method: 'put',
    data: data
  })
}

// 删除报修记录
export function delRepair(repairId) {
  return request({
    url: '/susheguanli/repair/' + repairId,
    method: 'delete'
  })
}
