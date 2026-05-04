<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生ID" prop="studentId">
        <el-input
          v-model="queryParams.studentId"
          placeholder="请输入学生ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="填写状态" prop="fillStatus">
        <el-select v-model="queryParams.fillStatus" placeholder="请选择填写状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_fill_status"
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
          v-hasPermi="['susheguanli:habit:add']"
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
          v-hasPermi="['susheguanli:habit:edit']"
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
          v-hasPermi="['susheguanli:habit:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['susheguanli:habit:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="habitList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录ID" align="center" prop="habitId" />
      <el-table-column label="学生ID" align="center" prop="studentId" />
      <el-table-column label="作息习惯" align="center" prop="sleepHabit">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_sleep_habit" :value="scope.row.sleepHabit"/>
        </template>
      </el-table-column>
      <el-table-column label="睡觉时间" align="center" prop="sleepTime">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_sleep_time" :value="scope.row.sleepTime"/>
        </template>
      </el-table-column>
      <el-table-column label="起床时间" align="center" prop="wakeTime">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_wake_time" :value="scope.row.wakeTime"/>
        </template>
      </el-table-column>
      <el-table-column label="午休习惯" align="center" prop="napHabit">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_nap_habit" :value="scope.row.napHabit"/>
        </template>
      </el-table-column>
      <el-table-column label="洗澡频率" align="center" prop="bathFrequency">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_bath_frequency" :value="scope.row.bathFrequency"/>
        </template>
      </el-table-column>
      <el-table-column label="卫生重视程度" align="center" prop="cleanImportance">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_clean_importance" :value="scope.row.cleanImportance"/>
        </template>
      </el-table-column>
      <el-table-column label="能否接受室友不打扫" align="center" prop="tolerateDirty">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_tolerate_dirty" :value="scope.row.tolerateDirty"/>
        </template>
      </el-table-column>
      <el-table-column label="学习地点" align="center" prop="studyLocation">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_study_location" :value="scope.row.studyLocation"/>
        </template>
      </el-table-column>
      <el-table-column label="欢迎室友带朋友" align="center" prop="friendVisit">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_friend_visit" :value="scope.row.friendVisit"/>
        </template>
      </el-table-column>
      <el-table-column label="是否接受室友开麦游戏" align="center" prop="gamingMic">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_gaming_mic" :value="scope.row.gamingMic"/>
        </template>
      </el-table-column>
      <el-table-column label="是否打呼噜" align="center" prop="snoring">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dormitory_snoring" :value="scope.row.snoring"/>
        </template>
      </el-table-column>
      <el-table-column label="填写状态" align="center" prop="fillStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_fill_status" :value="scope.row.fillStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['susheguanli:habit:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['susheguanli:habit:remove']"
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

    <!-- 添加或修改学生习惯档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="学生ID" prop="studentId">
              <el-input v-model="form.studentId" placeholder="请输入学生ID" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="作息习惯" prop="sleepHabit">
              <el-select v-model="form.sleepHabit" placeholder="请选择作息习惯">
                <el-option
                  v-for="dict in dict.type.dormitory_sleep_habit"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="睡觉时间" prop="sleepTime">
              <el-select v-model="form.sleepTime" placeholder="请选择睡觉时间">
                <el-option
                  v-for="dict in dict.type.dormitory_sleep_time"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="起床时间" prop="wakeTime">
              <el-select v-model="form.wakeTime" placeholder="请选择起床时间">
                <el-option
                  v-for="dict in dict.type.dormitory_wake_time"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="午休习惯" prop="napHabit">
              <el-select v-model="form.napHabit" placeholder="请选择午休习惯">
                <el-option
                  v-for="dict in dict.type.dormitory_nap_habit"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="洗澡频率" prop="bathFrequency">
              <el-select v-model="form.bathFrequency" placeholder="请选择洗澡频率">
                <el-option
                  v-for="dict in dict.type.dormitory_bath_frequency"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="卫生重视程度" prop="cleanImportance">
              <el-select v-model="form.cleanImportance" placeholder="请选择卫生重视程度">
                <el-option
                  v-for="dict in dict.type.dormitory_clean_importance"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="能否接受室友不打扫" prop="tolerateDirty">
              <el-select v-model="form.tolerateDirty" placeholder="请选择能否接受室友不打扫">
                <el-option
                  v-for="dict in dict.type.dormitory_tolerate_dirty"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="学习地点" prop="studyLocation">
              <el-select v-model="form.studyLocation" placeholder="请选择学习地点">
                <el-option
                  v-for="dict in dict.type.dormitory_study_location"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="欢迎室友带朋友" prop="friendVisit">
              <el-select v-model="form.friendVisit" placeholder="请选择欢迎室友带朋友">
                <el-option
                  v-for="dict in dict.type.dormitory_friend_visit"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="是否接受室友开麦游戏" prop="gamingMic">
              <el-select v-model="form.gamingMic" placeholder="请选择是否接受室友开麦游戏">
                <el-option
                  v-for="dict in dict.type.dormitory_gaming_mic"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="是否打呼噜" prop="snoring">
              <el-select v-model="form.snoring" placeholder="请选择是否打呼噜">
                <el-option
                  v-for="dict in dict.type.dormitory_snoring"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="填写状态" prop="fillStatus">
              <el-select v-model="form.fillStatus" placeholder="请选择填写状态">
                <el-option
                  v-for="dict in dict.type.sys_fill_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
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
import { listHabit, getHabit, delHabit, addHabit, updateHabit } from "@/api/susheguanli/habit"

export default {
  name: "Habit",
  dicts: ['dormitory_nap_habit', 'dormitory_clean_importance', 'dormitory_tolerate_dirty', 'dormitory_snoring', 'dormitory_sleep_time', 'dormitory_sleep_habit', 'dormitory_bath_frequency', 'dormitory_friend_visit', 'sys_fill_status', 'dormitory_wake_time', 'dormitory_study_location', 'dormitory_gaming_mic'],
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
      // 学生习惯档案表格数据
      habitList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentId: null,
        fillStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentId: [
          { required: true, message: "学生ID不能为空", trigger: "blur" }
        ],
        sleepHabit: [
          { required: true, message: "作息习惯不能为空", trigger: "change" }
        ],
        sleepTime: [
          { required: true, message: "睡觉时间不能为空", trigger: "change" }
        ],
        wakeTime: [
          { required: true, message: "起床时间不能为空", trigger: "change" }
        ],
        napHabit: [
          { required: true, message: "午休习惯不能为空", trigger: "change" }
        ],
        bathFrequency: [
          { required: true, message: "洗澡频率不能为空", trigger: "change" }
        ],
        cleanImportance: [
          { required: true, message: "卫生重视程度不能为空", trigger: "change" }
        ],
        tolerateDirty: [
          { required: true, message: "能否接受室友不打扫不能为空", trigger: "change" }
        ],
        studyLocation: [
          { required: true, message: "学习地点不能为空", trigger: "change" }
        ],
        friendVisit: [
          { required: true, message: "欢迎室友带朋友不能为空", trigger: "change" }
        ],
        gamingMic: [
          { required: true, message: "是否接受室友开麦游戏不能为空", trigger: "change" }
        ],
        snoring: [
          { required: true, message: "是否打呼噜不能为空", trigger: "change" }
        ],
        fillStatus: [
          { required: true, message: "填写状态不能为空", trigger: "change" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询学生习惯档案列表 */
    getList() {
      this.loading = true
      listHabit(this.queryParams).then(response => {
        this.habitList = response.rows
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
        habitId: null,
        studentId: null,
        sleepHabit: null,
        sleepTime: null,
        wakeTime: null,
        napHabit: null,
        bathFrequency: null,
        cleanImportance: null,
        tolerateDirty: null,
        studyLocation: null,
        friendVisit: null,
        gamingMic: null,
        snoring: null,
        fillStatus: null,
        fillTime: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.ids = selection.map(item => item.habitId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加学生习惯档案"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const habitId = row.habitId || this.ids
      getHabit(habitId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改学生习惯档案"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.habitId != null) {
            updateHabit(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addHabit(this.form).then(response => {
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
      const habitIds = row.habitId || this.ids
      this.$modal.confirm('是否确认删除学生习惯档案编号为"' + habitIds + '"的数据项？').then(function() {
        return delHabit(habitIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('susheguanli/habit/export', {
        ...this.queryParams
      }, `habit_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
