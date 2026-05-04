import request from '@/utils/request'

// 查询宿舍楼管理列表
export function listBuilding(query) {
  return request({
    url: '/susheguanli/building/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍楼管理详细
export function getBuilding(buildingId) {
  return request({
    url: '/susheguanli/building/' + buildingId,
    method: 'get'
  })
}

// 新增宿舍楼管理
export function addBuilding(data) {
  return request({
    url: '/susheguanli/building',
    method: 'post',
    data: data
  })
}

// 修改宿舍楼管理
export function updateBuilding(data) {
  return request({
    url: '/susheguanli/building',
    method: 'put',
    data: data
  })
}

// 删除宿舍楼管理
export function delBuilding(buildingId) {
  return request({
    url: '/susheguanli/building/' + buildingId,
    method: 'delete'
  })
}
