const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm1llwymes/",
            name: "ssm1llwymes",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm1llwymes/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于ssm的宠物店管理系统"
        } 
    }
}
export default base
