import request from '@/utils/request'

// 查询学生习惯档案列表
export function listHabit(query) {
  return request({
    url: '/susheguanli/habit/list',
    method: 'get',
    params: query
  })
}

// 查询学生习惯档案详细
export function getHabit(habitId) {
  return request({
    url: '/susheguanli/habit/' + habitId,
    method: 'get'
  })
}

// 新增学生习惯档案
export function addHabit(data) {
  return request({
    url: '/susheguanli/habit',
    method: 'post',
    data: data
  })
}

// 修改学生习惯档案
export function updateHabit(data) {
  return request({
    url: '/susheguanli/habit',
    method: 'put',
    data: data
  })
}

// 删除学生习惯档案
export function delHabit(habitId) {
  return request({
    url: '/susheguanli/habit/' + habitId,
    method: 'delete'
  })
}
