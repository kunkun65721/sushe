import request from '@/utils/request'

// 查询宿舍房间列表
export function listRoom(query) {
  return request({
    url: '/susheguanli/room/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍房间详细
export function getRoom(roomId) {
  return request({
    url: '/susheguanli/room/' + roomId,
    method: 'get'
  })
}

// 新增宿舍房间
export function addRoom(data) {
  return request({
    url: '/susheguanli/room',
    method: 'post',
    data: data
  })
}

// 修改宿舍房间
export function updateRoom(data) {
  return request({
    url: '/susheguanli/room',
    method: 'put',
    data: data
  })
}

// 删除宿舍房间
export function delRoom(roomId) {
  return request({
    url: '/susheguanli/room/' + roomId,
    method: 'delete'
  })
}
