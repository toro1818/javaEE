<template>
<div>
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <div style="background: #b2c2e0;text-align: center;font-family: 微软雅黑;font-size: 50px">购物车</div>
  <el-table
    ref="multipleTable"
    :data="BookData"
    border
    style="min-width:800px ;margin-top: 15px;padding-left:40px;width: 95%;text-align: center;font-size: larger"
    :header-cell-style="{background: '#b2c2e0',height:'60px',color:'black'}"
    :row-style="{height: '50px',borderStyle:'solid',borderWidth:'1px'}"
    :cell-style="{borderStyle:'solid',borderWidth:'1px'}"
    @selection-change="handleSelectionChange">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      prop="id"
      label="ID"
      width="50">
    </el-table-column>
    <el-table-column
      prop="bookname"
      label="书名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="author"
      label="作者"
      width="120">
    </el-table-column>
      <el-table-column
        prop="intro"
        label="简介">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格"
        width="100">
      </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button size="mini" type="primary" icon="el-icon-check" @click="buyOne(scope.$index, scope.row)" round>购买</el-button>
        <el-button size="mini" type="primary" icon="el-icon-delete" @click="deleteOne(scope.$index, scope.row)" round>删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-button style="display: inline-block;margin-left: 40px;margin-top: 10px" type="primary" @click="buyAll">付款</el-button>
</div>
</template>

<script>
export default {
  name: 'Cart',
  data () {
    return {
      BookData: [
        {
          id: 1,
          bookname: '西游记',
          author: '吴承恩',
          intro: '12',
          price: 1
        },
        {
          id: 2,
          bookname: '西游记',
          author: '吴承恩',
          intro: '12',
          price: 1
        }
      ],
      multipleSelection: []
    }
  },
  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    async buyOne (index, row) {
      this.$message.success('购买成功')
      const result = await this.$http.post('/orders/buy', row)
      console.log(result)
    },
    deleteOne (index, row) {
      this.$message.success('购买成功')
      this.BookData = this.BookData.filter(e => { return e !== row })
      const result = this.$http.delete('/orders/' + row.id, row)
      console.log(result)
    },
    buyAll () {
      if (Object.keys(this.multipleSelection).length === 0) {
        this.$message.error('请选择订单')
      } else {
        const result = this.$http.post('/orders/buy', this.multipleSelection)
        console.log(result)
      }
    }
  }
}
</script>

<style scoped>

</style>
