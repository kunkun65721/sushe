<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="所属宿舍楼ID" prop="buildingId">
        <el-input
          v-model="queryParams.buildingId"
          placeholder="请输入所属宿舍楼ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房间号" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入房间号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在楼层" prop="floorNumber">
        <el-input
          v-model="queryParams.floorNumber"
          placeholder="请输入所在楼层"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房间类型" prop="roomType">
        <el-select v-model="queryParams.roomType" placeholder="请选择房间类型" clearable>
          <el-option
            v-for="dict in dict.type.dormitory_room_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="房间状态" prop="roomStatus">
        <el-select v-model="queryParams.roomStatus" placeholder="请选择房间状态" clearable>
          <el-option
            v-for="dict in dict.type.dormitory_room_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['susheguanli:room:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['susheguanli:room:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['susheguanli:room:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['susheguanli:room:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="房间ID" align="center" prop="roomId" />
      <el-table-column label="所属宿舍楼ID" align="center" prop="buildingId" />
      <el-table-column label="房间号" align="center" prop="roomNumber" />
      <el-table-column label="所在楼层" align="center" prop="floorNumber" />
      <el-table-column label="床位总数" align="center" prop="bedCount" />
      <el-table-column label="已占用床位" align="center" prop="bedOccupied" />
      <el-table-column label="房间类型" align="center" prop="roomType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_room_type" :value="scope.row.roomType"/>
        </template>
      </el-table-column>
      <el-table-column label="房间状态" align="center" prop="roomStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_room_status" :value="scope.row.roomStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['susheguanli:room:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['susheguanli:room:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改宿舍房间对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="所属宿舍楼ID" prop="buildingId">
              <el-input v-model="form.buildingId" placeholder="请输入所属宿舍楼ID" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="房间号" prop="roomNumber">
              <el-input v-model="form.roomNumber" placeholder="请输入房间号" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="所在楼层" prop="floorNumber">
              <el-input v-model="form.floorNumber" placeholder="请输入所在楼层" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="床位总数" prop="bedCount">
              <el-input v-model="form.bedCount" placeholder="请输入床位总数" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="已占用床位" prop="bedOccupied">
              <el-input v-model="form.bedOccupied" placeholder="请输入已占用床位" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="房间类型" prop="roomType">
              <el-select v-model="form.roomType" placeholder="请选择房间类型">
                <el-option
                  v-for="dict in dict.type.dormitory_room_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="房间状态" prop="roomStatus">
              <el-select v-model="form.roomStatus" placeholder="请选择房间状态">
                <el-option
                  v-for="dict in dict.type.dormitory_room_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRoom, getRoom, delRoom, addRoom, updateRoom } from "@/api/susheguanli/room"

export default {
  name: "Room",
  dicts: ['dormitory_room_type', 'dormitory_room_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 宿舍房间表格数据
      roomList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        buildingId: null,
        roomNumber: null,
        floorNumber: null,
        roomType: null,
        roomStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        buildingId: [
          { required: true, message: "所属宿舍楼ID不能为空", trigger: "blur" }
        ],
        roomNumber: [
          { required: true, message: "房间号不能为空", trigger: "blur" }
        ],
        floorNumber: [
          { required: true, message: "所在楼层不能为空", trigger: "blur" }
        ],
        bedCount: [
          { required: true, message: "床位总数不能为空", trigger: "blur" }
        ],
        bedOccupied: [
          { required: true, message: "已占用床位不能为空", trigger: "blur" }
        ],
        roomType: [
          { required: true, message: "房间类型不能为空", trigger: "change" }
        ],
        roomStatus: [
          { required: true, message: "房间状态不能为空", trigger: "change" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询宿舍房间列表 */
    getList() {
      this.loading = true
      listRoom(this.queryParams).then(response => {
        this.roomList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        roomId: null,
        buildingId: null,
        roomNumber: null,
        floorNumber: null,
        bedCount: null,
        bedOccupied: null,
        roomType: null,
        roomStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.roomId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加宿舍房间"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const roomId = row.roomId || this.ids
      getRoom(roomId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改宿舍房间"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.roomId != null) {
            updateRoom(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addRoom(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const roomIds = row.roomId || this.ids
      this.$modal.confirm('是否确认删除宿舍房间编号为"' + roomIds + '"的数据项？').then(function() {
        return delRoom(roomIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('susheguanli/room/export', {
        ...this.queryParams
      }, `room_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
