<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="宿舍楼名称" prop="buildingName">
        <el-input
          v-model="queryParams.buildingName"
          placeholder="请输入宿舍楼名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼栋类型" prop="buildingType">
        <el-select v-model="queryParams.buildingType" placeholder="请选择楼栋类型" clearable>
          <el-option
            v-for="dict in dict.type.dormitory_building_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍楼状态" prop="buildingStatus">
        <el-select v-model="queryParams.buildingStatus" placeholder="请选择宿舍楼状态" clearable>
          <el-option
            v-for="dict in dict.type.dormitory_building_status"
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
          v-hasPermi="['susheguanli:building:add']"
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
          v-hasPermi="['susheguanli:building:edit']"
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
          v-hasPermi="['susheguanli:building:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['susheguanli:building:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="buildingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="宿舍楼ID" align="center" prop="buildingId" />
      <el-table-column label="宿舍楼名称" align="center" prop="buildingName" />
      <el-table-column label="楼栋类型" align="center" prop="buildingType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_building_type" :value="scope.row.buildingType"/>
        </template>
      </el-table-column>
      <el-table-column label="楼层数" align="center" prop="floorCount" />
      <el-table-column label="房间数" align="center" prop="roomCount" />
      <el-table-column label="宿舍楼状态" align="center" prop="buildingStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_building_status" :value="scope.row.buildingStatus"/>
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
            v-hasPermi="['susheguanli:building:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['susheguanli:building:remove']"
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

    <!-- 添加或修改宿舍楼管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="宿舍楼名称" prop="buildingName">
              <el-input v-model="form.buildingName" placeholder="请输入宿舍楼名称" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="楼栋类型" prop="buildingType">
              <el-select v-model="form.buildingType" placeholder="请选择楼栋类型">
                <el-option
                  v-for="dict in dict.type.dormitory_building_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="楼层数" prop="floorCount">
              <el-input v-model="form.floorCount" placeholder="请输入楼层数" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="房间数" prop="roomCount">
              <el-input v-model="form.roomCount" placeholder="请输入房间数" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="宿舍楼状态" prop="buildingStatus">
              <el-select v-model="form.buildingStatus" placeholder="请选择宿舍楼状态">
                <el-option
                  v-for="dict in dict.type.dormitory_building_status"
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
import { listBuilding, getBuilding, delBuilding, addBuilding, updateBuilding } from "@/api/susheguanli/building"

export default {
  name: "Building",
  dicts: ['dormitory_building_status', 'dormitory_building_type'],
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
      // 宿舍楼管理表格数据
      buildingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        buildingName: null,
        buildingType: null,
        buildingStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        buildingName: [
          { required: true, message: "宿舍楼名称不能为空", trigger: "blur" }
        ],
        buildingType: [
          { required: true, message: "楼栋类型不能为空", trigger: "change" }
        ],
        floorCount: [
          { required: true, message: "楼层数不能为空", trigger: "blur" }
        ],
        roomCount: [
          { required: true, message: "房间数不能为空", trigger: "blur" }
        ],
        buildingStatus: [
          { required: true, message: "宿舍楼状态不能为空", trigger: "change" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询宿舍楼管理列表 */
    getList() {
      this.loading = true
      listBuilding(this.queryParams).then(response => {
        this.buildingList = response.rows
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
        buildingId: null,
        buildingName: null,
        buildingType: null,
        floorCount: null,
        roomCount: null,
        buildingStatus: null,
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
      this.ids = selection.map(item => item.buildingId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加宿舍楼管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const buildingId = row.buildingId || this.ids
      getBuilding(buildingId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改宿舍楼管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.buildingId != null) {
            updateBuilding(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addBuilding(this.form).then(response => {
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
      const buildingIds = row.buildingId || this.ids
      this.$modal.confirm('是否确认删除宿舍楼管理编号为"' + buildingIds + '"的数据项？').then(function() {
        return delBuilding(buildingIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('susheguanli/building/export', {
        ...this.queryParams
      }, `building_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
