import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import biaoqian from '@/views/modules/biaoqian/list'
	import discussbijixinxi from '@/views/modules/discussbijixinxi/list'
	import daibanxinxi from '@/views/modules/daibanxinxi/list'
	import sensitivewords from '@/views/modules/sensitivewords/list'
	import huodongxinxi from '@/views/modules/huodongxinxi/list'
	import storeup from '@/views/modules/storeup/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import bijixinxi from '@/views/modules/bijixinxi/list'
	import popupremind from '@/views/modules/popupremind/list'
	import yonghu from '@/views/modules/yonghu/list'
	import huodongbaoming from '@/views/modules/huodongbaoming/list'
	import forumreport from '@/views/modules/forumreport/list'
	import config from '@/views/modules/config/list'
	import huodongleixing from '@/views/modules/huodongleixing/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告资讯',
		component: news
	}
	,{
		path: '/biaoqian',
		name: '标签',
		component: biaoqian
	}
	,{
		path: '/discussbijixinxi',
		name: '笔记信息评论',
		component: discussbijixinxi
	}
	,{
		path: '/daibanxinxi',
		name: '待办信息',
		component: daibanxinxi
	}
	,{
		path: '/sensitivewords',
		name: '敏感词',
		component: sensitivewords
	}
	,{
		path: '/huodongxinxi',
		name: '活动信息',
		component: huodongxinxi
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/forum',
		name: '社区互动',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/bijixinxi',
		name: '笔记信息',
		component: bijixinxi
	}
	,{
		path: '/popupremind',
		name: '弹窗提醒',
		component: popupremind
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/huodongbaoming',
		name: '活动报名',
		component: huodongbaoming
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/huodongleixing',
		name: '活动类型',
		component: huodongleixing
	}
	,{
		path: '/newstype',
		name: '公告资讯分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
