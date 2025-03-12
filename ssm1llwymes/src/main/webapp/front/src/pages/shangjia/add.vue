<template>
<div :style='{"width":"80%","padding":"20px","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="100px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="宠物店名称" prop="shangjiamingcheng">
            <el-input v-model="ruleForm.shangjiamingcheng" 
                placeholder="宠物店名称" clearable :disabled=" false  ||ro.shangjiamingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="密码" prop="mima">
            <el-input v-model="ruleForm.mima" 
                placeholder="密码" clearable :disabled=" false  ||ro.mima"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="宠物店图片" v-if="type!='cross' || (type=='cross' && !ro.shangjiatupian)" prop="shangjiatupian">
            <file-upload
            tip="点击上传宠物店图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.shangjiatupian?ruleForm.shangjiatupian:''"
            @change="shangjiatupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="宠物店图片" prop="shangjiatupian">
                <img v-if="ruleForm.shangjiatupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shangjiatupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shangjiatupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="联系人" prop="lianxiren">
            <el-input v-model="ruleForm.lianxiren" 
                placeholder="联系人" clearable :disabled=" false  ||ro.lianxiren"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable :disabled=" false  ||ro.lianxidianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="邮箱" prop="youxiang">
            <el-input v-model="ruleForm.youxiang" 
                placeholder="邮箱" clearable :disabled=" false  ||ro.youxiang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="营业执照" prop="yingyezhizhao">
            <file-upload
            tip="点击上传营业执照"
            action="file/upload"
            :limit="1"
			:type="3"
            :multiple="true"
            :fileUrls="ruleForm.yingyezhizhao?ruleForm.yingyezhizhao:''"
            @change="yingyezhizhaoUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="宠物店地址" prop="shangjiadizhi">
            <el-input v-model="ruleForm.shangjiadizhi" 
                placeholder="宠物店地址" clearable :disabled=" false  ||ro.shangjiadizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="详细介绍" prop="xiangxijieshao">
            <editor 
                :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.xiangxijieshao" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#57A7A5","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"none","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(64, 158, 255, 1)","borderRadius":"5px","background":"#9E9E9E","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				shangjiamingcheng : false,
				mima : false,
				shangjiatupian : false,
				lianxiren : false,
				lianxidianhua : false,
				youxiang : false,
				yingyezhizhao : false,
				shangjiadizhi : false,
				xiangxijieshao : false,
				thumbsupnum : false,
				crazilynum : false,
				storeupnum : false,
				money : false,
				status : false,
				passwordwrongnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          shangjiamingcheng: '',
          mima: '',
          shangjiatupian: '',
          lianxiren: '',
          lianxidianhua: '',
          youxiang: '',
          yingyezhizhao: '',
          shangjiadizhi: '',
          xiangxijieshao: '',
          thumbsupnum: '',
          crazilynum: '',
          storeupnum: '',
          money: '',
          status: '',
          passwordwrongnum: '',
        },


        rules: {
          shangjiamingcheng: [
            { required: true, message: '宠物店名称不能为空', trigger: 'blur' },
          ],
          mima: [
            { required: true, message: '密码不能为空', trigger: 'blur' },
          ],
          shangjiatupian: [
            { required: true, message: '宠物店图片不能为空', trigger: 'blur' },
          ],
          lianxiren: [
          ],
          lianxidianhua: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          youxiang: [
            { validator: this.$validate.isEmail, trigger: 'blur' },
          ],
          yingyezhizhao: [
          ],
          shangjiadizhi: [
          ],
          xiangxijieshao: [
          ],
          thumbsupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          crazilynum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          money: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          status: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          passwordwrongnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='shangjiamingcheng'){
              this.ruleForm.shangjiamingcheng = obj[o];
              this.ro.shangjiamingcheng = true;
              continue;
            }
            if(o=='mima'){
              this.ruleForm.mima = obj[o];
              this.ro.mima = true;
              continue;
            }
            if(o=='shangjiatupian'){
              this.ruleForm.shangjiatupian = obj[o].split(",")[0];
              this.ro.shangjiatupian = true;
              continue;
            }
            if(o=='lianxiren'){
              this.ruleForm.lianxiren = obj[o];
              this.ro.lianxiren = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='youxiang'){
              this.ruleForm.youxiang = obj[o];
              this.ro.youxiang = true;
              continue;
            }
            if(o=='yingyezhizhao'){
              this.ruleForm.yingyezhizhao = obj[o];
              this.ro.yingyezhizhao = true;
              continue;
            }
            if(o=='shangjiadizhi'){
              this.ruleForm.shangjiadizhi = obj[o];
              this.ro.shangjiadizhi = true;
              continue;
            }
            if(o=='xiangxijieshao'){
              this.ruleForm.xiangxijieshao = obj[o];
              this.ro.xiangxijieshao = true;
              continue;
            }
            if(o=='thumbsupnum'){
              this.ruleForm.thumbsupnum = obj[o];
              this.ro.thumbsupnum = true;
              continue;
            }
            if(o=='crazilynum'){
              this.ruleForm.crazilynum = obj[o];
              this.ro.crazilynum = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
            if(o=='money'){
              this.ruleForm.money = obj[o];
              this.ro.money = true;
              continue;
            }
            if(o=='status'){
              this.ruleForm.status = obj[o];
              this.ro.status = true;
              continue;
            }
            if(o=='passwordwrongnum'){
              this.ruleForm.passwordwrongnum = obj[o];
              this.ro.passwordwrongnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`shangjia/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			if((this.ruleForm.mima).toString().length<3){
                this.$message.error('密码长度不能小于3');
                return
			}
			if((this.ruleForm.mima).toString().length>13){
                this.$message.error('密码长度不能大于13');
                return
			}
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('shangjia/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`shangjia/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`shangjia/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      shangjiatupianUploadChange(fileUrls) {
          this.ruleForm.shangjiatupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      yingyezhizhaoUploadChange(fileUrls) {
          this.ruleForm.yingyezhizhao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 100px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
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
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: none;
	  width: 500px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
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
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
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
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
