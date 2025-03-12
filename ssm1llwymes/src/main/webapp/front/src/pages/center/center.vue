<template>
<div class="center-preview" :style='{"width":"80%","margin":"10px auto","position":"relative","background":"none"}'>
	<div class="title" :style='{"border":"2px solid #57A7A5","margin":"0","color":"#57A7A5","textAlign":"center","background":"#fff","fontSize":"20px","lineHeight":"44px"}'>{{ title }}</div>
	
	<div class="info" :style='{"padding":"50px 50px 50px 280px","boxShadow":"none","margin":"0 auto 20px","borderRadius":"0","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","position":"relative","height":"260px"}'>
		<div :style='{"borderColor":"#efefef","color":"#333","borderWidth":"0 0 1px 0","display":"none","width":"100%","lineHeight":"44px","fontSize":"15px","borderStyle":"solid","height":"44px"}'>个人信息</div>
		<div :style='{"borderColor":"#efefef","top":"45px","left":"100px","borderWidth":"0","width":"150px","fontSize":"0","position":"absolute","borderStyle":"solid","height":"150px"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"10px","borderWidth":"0 0 1px 0","display":"block","width":"100%","borderStyle":"solid","height":"100%"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"borderColor":"#efefef","top":"45px","left":"100px","borderWidth":"0","width":"150px","fontSize":"0","position":"absolute","borderStyle":"solid","height":"150px"}' v-if="userTableName=='shangjia'">
			<el-image :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"10px","borderWidth":"0 0 1px 0","display":"block","width":"100%","borderStyle":"solid","height":"100%"}' :src="sessionForm.shangjiatupian?baseUrl + sessionForm.shangjiatupian:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","display":"none","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>用户账号</div>
			<div :style='{"fontSize":"24px","color":"#000","textAlign":"left","flex":1}'>{{sessionForm.yonghuzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-qita1" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>用户姓名</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.yonghuxingming}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-baohuhaoma" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>性别</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"75px"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>联系方式</div>
			<div :style='{"fontSize":"16px","color":"#000","textAlign":"left","flex":1}'>{{sessionForm.lianxifangshi}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-kuaijiezhifu" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>余额</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"14px","color":"#333","textAlign":"left","height":"50%"}'>{{sessionForm.money}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-tongji2" :style='{"padding":"0 5px","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>状态</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.status}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","display":"none","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>宠物店名称</div>
			<div :style='{"fontSize":"24px","color":"#000","textAlign":"left","flex":1}'>{{sessionForm.shangjiamingcheng}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-qita1" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>联系人</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.lianxiren}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-baohuhaoma" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>联系电话</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.lianxidianhua}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"75px"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>邮箱</div>
			<div :style='{"fontSize":"16px","color":"#000","textAlign":"left","flex":1}'>{{sessionForm.youxiang}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-kuaijiezhifu" :style='{"padding":"0 0","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>宠物店地址</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"14px","color":"#333","textAlign":"left","height":"50%"}'>{{sessionForm.shangjiadizhi}}</div>
		</div>
		<div :style='{"padding":"0 0","borderColor":"#efefef","flexWrap":"wrap","borderWidth":"0","flexDirection":"column","display":"flex","width":"calc(100% / 3)","lineHeight":"40px","borderStyle":"solid","height":"50%"}' v-if="userTableName=='shangjia'">
			<span class="icon iconfont icon-tongji2" :style='{"padding":"0 5px","margin":"10px","color":"#fff","borderRadius":"50%","textAlign":"center","background":"#57A7A5","width":"55px","fontSize":"24px","lineHeight":"55px","height":"55px"}'></span>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"16px","color":"#000","height":"50%"}'>赞</div>
			<div :style='{"width":"calc(100% - 75px)","fontSize":"15px","color":"#333","textAlign":"left","flex":1,"height":"50%"}'>{{sessionForm.thumbsupnum}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"width":"100%","flexWrap":"wrap","background":"#fff","justifyContent":"center","display":"flex"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="200px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='yonghu'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#57A7A5","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'>点我充值</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="宠物店名称" prop="shangjiamingcheng">
            <el-input v-model="sessionForm.shangjiamingcheng" placeholder="宠物店名称" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="宠物店图片" prop="shangjiatupian">
			<file-upload
			tip="点击上传宠物店图片"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.shangjiatupian?sessionForm.shangjiatupian:''"
			@change="shangjiashangjiatupianHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="联系人" prop="lianxiren">
            <el-input v-model="sessionForm.lianxiren" placeholder="联系人" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="邮箱" prop="youxiang">
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="营业执照" prop="yingyezhizhao">
			<file-upload
			tip="点击上传营业执照"
			action="file/upload"
			:limit="1"
			:type="3"
			:multiple="true"
			:fileUrls="sessionForm.yingyezhizhao?sessionForm.yingyezhizhao:''"
			@change="shangjiayingyezhizhaoHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="宠物店地址" prop="shangjiadizhi">
            <el-input v-model="sessionForm.shangjiadizhi" placeholder="宠物店地址" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#57A7A5","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'>点我充值</div>
			</div>
		  </el-form-item>
		  <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='shangjia'" label="详细介绍">
		    <editor
		        :style='{"border":"1px solid #E2E3E5","boxShadow":"none","outline":"none","color":"#333","borderRadius":"0","width":"100%","lineHeight":"32px","fontSize":"14px"}'
		        v-model="sessionForm.xiangxijieshao" 
		        class="editor" 
		        action="file/upload">
		    </editor>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0","background":"#57A7A5","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"none","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"0","background":"#9E9E9E","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
	  <el-tab-pane label="修改密码">
		<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="200px">
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="原密码" prop="password">
			  <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="新密码" prop="newpassword">
			  <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="确认密码" prop="repassword">
			  <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}'>
			  <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0","background":"#57A7A5","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="updatePassword">修改密码</el-button>
			</el-form-item>
		</el-form>
	  </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的订单"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

	<el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
	  <el-form :model="chongzhiForm">
		<el-form-item label="充值金额" label-width="120px">
		  <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
		</el-form-item>
		<el-form-item label-width="120px">
		  <el-radio-group v-model="chongzhiForm.radio">
			<el-radio style="margin-bottom: 30px" label="微信支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/weixin.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">微信支付</span>
			</el-radio>
			<el-radio label="支付宝支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhifubao.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">支付宝支付</span>
			</el-radio>
			<el-radio label="中国建设银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jianshe.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国农业银行支付">
			  <el-image
				style="width: 126px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/nongye.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国银行支付">
			  <el-image
				style="width: 140px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhongguo.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="交通银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jiaotong.png')"
				fit="fill"></el-image>
			</el-radio>
		  </el-radio-group>
		</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer">
		<el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
		<el-button type="primary" @click="chongzhi">确认充值</el-button>
	  </div>
	</el-dialog>
</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
		passwordForm: {},
		passwordRules: {
			password: [
				{
					required: true,
					message: "密码不能为空",
					trigger: "blur"
				}
			],
			newpassword: [
				{
					required: true,
					message: "新密码不能为空",
					trigger: "blur"
				}
			],
			repassword: [
				{
					required: true,
					message: "确认密码不能为空",
					trigger: "blur"
				}
			]
		},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
		menuList: [],
        disabled: false,
        dialogFormVisibleMoney: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('frontToken')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuzhanghao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuxingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxifangshi', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'money', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'status', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'passwordwrongnum', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'shangjiamingcheng', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'shangjiatupian', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxiren', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxidianhua', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'youxiang', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'yingyezhizhao', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'shangjiadizhi', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'xiangxijieshao', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'thumbsupnum', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'crazilynum', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'storeupnum', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'money', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'status', null);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.sessionForm, 'passwordwrongnum', null);
		}

		if ('yonghu' == this.userTableName&&this.rules['yonghuzhanghao']){
			this.rules['yonghuzhanghao'].push({ required: true, message: '请输入用户账号', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuzhanghao']) {
			this.$set(this.rules, 'yonghuzhanghao', [{ required: true, message: '请输入用户账号', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['yonghuxingming']){
			this.rules['yonghuxingming'].push({ required: true, message: '请输入用户姓名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuxingming']) {
			this.$set(this.rules, 'yonghuxingming', [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'status', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'passwordwrongnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName&&this.rules['shangjiamingcheng']){
			this.rules['shangjiamingcheng'].push({ required: true, message: '请输入宠物店名称', trigger: 'blur' })
		}else if('shangjia' == this.userTableName&&!this.rules['shangjiamingcheng']) {
			this.$set(this.rules, 'shangjiamingcheng', [{ required: true, message: '请输入宠物店名称', trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('shangjia' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName&&this.rules['shangjiatupian']){
			this.rules['shangjiatupian'].push({ required: true, message: '请输入宠物店图片', trigger: 'blur' })
		}else if('shangjia' == this.userTableName&&!this.rules['shangjiatupian']) {
			this.$set(this.rules, 'shangjiatupian', [{ required: true, message: '请输入宠物店图片', trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'youxiang', [{ required: false, validator: this.$validate.isEmail, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'thumbsupnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'crazilynum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'storeupnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'status', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('shangjia' == this.userTableName) {
			this.$set(this.rules, 'passwordwrongnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`yonghu` == this.userTableName && (this.sessionForm.yonghuzhanghao).toString().length<3){
			this.$message.error('用户账号长度不能小于3');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.yonghuzhanghao).toString().length>13){
			this.$message.error('用户账号长度不能大于13');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.mima).toString().length<3){
			this.$message.error('密码长度不能小于3');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.mima).toString().length>13){
			this.$message.error('密码长度不能大于13');
			return
		}
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`shangjia` == this.userTableName && (this.sessionForm.mima).toString().length<3){
			this.$message.error('密码长度不能小于3');
			return
		}
		if(`shangjia` == this.userTableName && (this.sessionForm.mima).toString().length>13){
			this.$message.error('密码长度不能大于13');
			return
		}
		if(`shangjia` == this.userTableName && this.sessionForm.shangjiatupian!=null){
			this.sessionForm.shangjiatupian = this.sessionForm.shangjiatupian.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`shangjia` == this.userTableName && this.sessionForm.yingyezhizhao!=null){
			this.sessionForm.yingyezhizhao = this.sessionForm.yingyezhizhao.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      shangjiashangjiatupianHandleAvatarSuccess(fileUrls) {
        this.sessionForm.shangjiatupian = fileUrls;
      },
      shangjiayingyezhizhaoHandleAvatarSuccess(fileUrls) {
        this.sessionForm.yingyezhizhao = fileUrls;
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
		if(!this.sessionForm.money) {
			this.sessionForm.money = parseFloat(this.chongzhiForm.money)
		}else{
			this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
		}
        
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
			  this.setSession()
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '修改密码':
            this.passwordForm = {
				password: '',
				newpassword: '',
				repassword: '',
			}
			this.$forceUpdate()
            break;
          case '我的发布':
            tab.$router.push('/index/myForumList');
            break;
          case '我的订单':
            tab.$router.push('/index/shop-order/order');
            break;
          case '我的地址':
            tab.$router.push('/index/shop-address/list');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
	  async updatePassword(){
			this.$refs["passwordForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.sessionForm.mima) {
						password = this.sessionForm.mima;
					} else if (this.sessionForm.password) {
						password = this.sessionForm.password;
					}
					if (this.passwordForm.password != password) {
						this.$message.error("原密码错误");
						return;
					}
					if (this.passwordForm.newpassword != this.passwordForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.passwordForm.newpassword == this.passwordForm.password) {
						this.$message.error("新密码与原密码相同！");
						return;
					}
					if (this.userTableName == 'yonghu') {
						if(this.passwordForm.newpassword && (this.passwordForm.newpassword.length<3)){
							this.$message.error(`新密码长度不能小于3`);
							return
						}
						if(this.passwordForm.newpassword && (this.passwordForm.newpassword.length>13)){
							this.$message.error(`新密码长度不能大于13`);
							return
						}
					}
					this.sessionForm.password = this.passwordForm.newpassword;
					this.sessionForm.mima = this.passwordForm.newpassword;
					this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
							this.setSession()
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			})
	  },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  hasBack(name){
		  switch(name){
			case '订单管理':
				return false
				break;
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 0;
	margin: 0 auto;
	background: #57A7A5;
	width: 100%;
	border-color: #eee;
	border-width: 0;
	position: relative;
	float: left;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 30px;
  	color: #000;
  	background: #57A7A5;
  	font-weight: 500;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 30px;
  	color: #fff;
  	background: #57A7A5;
  	font-weight: 500;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 30px;
  	color: #fff;
  	background: #57A7A5;
  	font-weight: 500;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content {
  	padding: 10px;
  	background: #fff;
  	width: 100%;
  }
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #000;
  	font-weight: 500;
  	width: 200px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 200px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #E2E3E5;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	width: 500px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #E2E3E5;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	width: 500px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #E2E3E5;
  	border-radius: 0;
  	padding: 0 10px 0 30px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	width: 500px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px solid #E2E3E5;
  	cursor: pointer;
  	border-radius: 0;
  	color: #000;
  	width: 200px;
  	font-size: 32px;
  	line-height: 60px;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #E2E3E5;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	display: inline-block;
  	width: 390px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
