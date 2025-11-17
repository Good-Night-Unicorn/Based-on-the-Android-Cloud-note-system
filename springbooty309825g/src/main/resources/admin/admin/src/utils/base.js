const base = {
    get() {
        return {
            url : "http://localhost:8080/springbooty309825g/",
            name: "springbooty309825g",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbooty309825g/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于安卓云笔记系统"
        } 
    }
}
export default base
