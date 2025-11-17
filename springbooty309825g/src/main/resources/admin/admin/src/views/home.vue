<template>
	<div class="home-content">
		<!-- title -->
		<div id="home-title" class="home-title animate__animated">
			<div class="titles" >
				<span>欢迎使用</span>
				{{this.$project.projectName}}
			</div>
		</div>
		<!-- statis -->
		<div class="statis-box">
			<div id="statis1" class="statis1 animate__animated" v-if="isAuth('yonghu','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-zhangjie8"></span>
				</div>
				<div class="right">
					<div class="num">{{yonghuCount}}</div>
					<div class="name">用户总数</div>
				</div>
			</div>
		</div>
		<!-- statis -->
		<div id="news-box" class="news-box animate__animated">
			<div class="news-title">
				公告资讯
			</div>
			<div class="news-list">
				<div class="news-item" v-for="(item,index) in newsList" :index="index" @click="newsDetailClick(item)">
					<div class="news-text">
						{{item.title}}
					</div>
					<div class="news-time">
						{{item.addtime}}
					</div>
				</div>
			</div>
		</div>
		<el-dialog :visible.sync="newsVisible" title="公告资讯" :append-to-body="true" width="60%">
			<div style="width: 100%;text-align: center;font-size: 20px;color: #000;padding: 0 0 20px;font-weight: bold;">{{newsDetail.title}}</div>
			<div style="width: 100%;">
				<div class="ql-snow ql-editor" v-html="newsDetail.content"></div>
			</div>
		</el-dialog>
	
		<!-- echarts -->
	</div>
</template>
<script>
import 'animate.css'
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			yonghuCount: 0,
			newsList: [],
			newsDetail: {},
			newsVisible: false,
		};
	},
	mounted(){
		this.init();
		this.getyonghuCount();
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
	},
	computed: {
		avatar(){
			return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
		},
	},
	methods:{
		handleScroll() {
			let arr = [
				{id:'home-title',css:'animate__fadeInUp'},
				{id:'statis1',css:'animate__fadeInUp'},
				{id:'news-box',css:'animate__fadeInUp'},
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
		init(){
			if(this.$storage.get('Token')){
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code != 0) {
						router.push({ name: 'login' })
					}
				});
			}else{
				router.push({ name: 'login' })
			}
			this.getNewsList()
		},
		getNewsList(){
			let params = {
				page: 1,
				limit: 6,
				sort: 'addtime',
				order: 'desc',
			}
			this.$http({
				url: `news/list`,
				method: "get",
				params: params
			}).then(res => {
				if(res.data&&res.data.code==0){
					this.newsList = res.data.data.list
				}
			});
		},
		newsDetailClick(row){
			this.newsDetail = row
			this.newsVisible = true
		},
		getyonghuCount() {
			this.$http({
				url: `yonghu/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yonghuCount = data.data
				}
			})
		},
	}
};
</script>
<style lang="scss" scoped>
	.home-content {
		padding: 10px 15px 10px 18px;
		align-content: flex-start;
		background: url(http://codegen.caihongy.cn/20250401/ea296ff64d9f4894be204b25ca73dba6.png) no-repeat center top / cover;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-start;
		align-items: flex-start;
		position: relative;
		flex-wrap: wrap;
		.home-title {
			border-radius: 5px;
			padding: 10px 0;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			margin: 20px 0;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			transition: 0.3s;
			.titles {
				padding: 0;
				color: #333;
				font-weight: 600;
				font-size: 30px;
				line-height: 44px;
				span {
				}
			}
		}
		.home-title:hover {
			transform: translate3d(0, 0px, 0);
			z-index: 1;
		}
		.statis-box {
			padding: 0;
			margin: 10px 0;
			display: flex;
			width: calc(100% - 0px);
			justify-content: center;
			align-items: center;
			.statis1 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 10px;
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: 270px;
				transition: 0.3s;
				.left {
					border-radius: 15px;
					background: #6DB344;
					display: flex;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					order: 1;
					.iconfont {
						color: #FFFFFF;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #000000;
						font-weight: 500;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #8D8D8D;
						font-size: 14px;
						line-height: 12px;
						height: 12px;
						order: 1;
					}
				}
			}
			.statis1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis2 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 10px;
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: 270px;
				transition: 0.3s;
				.left {
					border-radius: 15px;
					background: #6DB344;
					display: flex;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					order: 1;
					.iconfont {
						color: #FFFFFF;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #000000;
						font-weight: 500;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #8D8D8D;
						font-size: 14px;
						line-height: 12px;
						height: 12px;
						order: 1;
					}
				}
			}
			.statis2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis3 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 10px;
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: 270px;
				transition: 0.3s;
				.left {
					border-radius: 15px;
					background: #6DB344;
					display: flex;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					order: 1;
					.iconfont {
						color: #FFFFFF;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #000000;
						font-weight: 500;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #8D8D8D;
						font-size: 14px;
						line-height: 12px;
						height: 12px;
						order: 1;
					}
				}
			}
			.statis3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis4 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 10px;
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: 270px;
				transition: 0.3s;
				.left {
					border-radius: 15px;
					background: #6DB344;
					display: flex;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					order: 1;
					.iconfont {
						color: #FFFFFF;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #000000;
						font-weight: 500;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #8D8D8D;
						font-size: 14px;
						line-height: 12px;
						height: 12px;
						order: 1;
					}
				}
			}
			.statis4:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis5 {
				border: 0px solid #ccc;
				border-radius: 10px;
				padding: 10px;
				margin: 0 10px 10px;
				background: #fff;
				display: none;
				width: 270px;
				transition: 0.3s;
				.left {
					border-radius: 15px;
					background: #6DB344;
					display: flex;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					order: 1;
					.iconfont {
						color: #FFFFFF;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #000000;
						font-weight: 500;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #8D8D8D;
						font-size: 14px;
						line-height: 12px;
						height: 12px;
						order: 1;
					}
				}
			}
			.statis5:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
		}
		.news-box {
			border: 0px solid #ccc;
			padding: 26px 30px;
			margin: 10px;
			display: flex;
			transition: 0.3s;
			border-radius: 10px;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			flex-direction: column;
			background: #fff;
			flex: 1;
			width: calc(30% - 20px);
			justify-content: center;
			align-items: center;
			.news-title {
				padding: 0 2px;
				margin: 0 0 20px;
				color: #000;
				font-weight: 600;
				width: 100%;
				font-size: 20px;
				border-color: #ddd;
				border-width: 0 0 2px;
				line-height: 44px;
				border-style: solid;
			}
			.news-list {
				flex-direction: column;
				display: flex;
				width: 100%;
				justify-content: space-between;
				align-items: center;
			}
			.news-item {
				border: 1px solid #eee;
				padding: 18px 0;
				display: flex;
				width: 100%;
				border-width: 0 0 1px;
				justify-content: space-between;
				align-items: center;
				.news-text {
					color: #000;
					font-weight: 500;
					font-size: 16px;
				}
				.news-time {
					color: #999;
					font-size: 14px;
				}
			}
		}
		.news-box:hover {
			transform: translate3d(0, 0px, 0);
		}
	}
	
	.echarts-flag-2 {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 10px 20px;
		background: rebeccapurple;
	
		&>div {
			width: 32%;
			height: 300px;
			margin: 10px 0;
			background: rgba(255,255,255,.1);
			border-radius: 8px;
			padding: 10px 20px;
		}
	}
	.animate__animated {
		animation-fill-mode: none;
	}
</style>
