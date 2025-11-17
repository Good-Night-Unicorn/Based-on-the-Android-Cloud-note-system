
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#F4F4F4","height":"auto"}'>
			<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper" @tap="imgView(swiper)"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper" @tap="imgView(baseUrl+swiper)"></image>
				</swiper-item>
			</swiper>
			<view :style='{"width":"100%","padding":"24rpx","background":"none","height":"auto"}' class="detail-content">
				<view :style='{"margin":"0","borderColor":"#ccc","flexWrap":"wrap","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}' class="detail-list-item price">
					<view :style='{"display":"flex"}' v-if="storeupFlag==1" @click="shoucang">
						<text class="icon iconfont icon-shoucang11" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}'></text>
						<text :style='{"color":"#666","lineHeight":"80rpx","fontSize":"28rpx"}'>已收藏</text>
					</view>
					<view :style='{"padding":"0 12rpx","background":"linear-gradient( 180deg, #459FEF 0%, #2BC8BA 100%)","display":"flex"}' v-if="storeupFlag==0" @click="shoucang">
						<text class="icon iconfont icon-shoucang11" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff"}'></text>
						<text :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏</text>
					</view>
				</view>

				<view :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}' class="lable">笔记名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.bijimingcheng}}</view>
				</view>
				<view :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}' class="lable">标签：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.biaoqian}}</view>
				</view>

				<view :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item" @tap="download(detail.fujian )" >
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>附件：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' v-if="detail.fujian">下载文件</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' v-else>暂无文件</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>链接：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' style="text-decoration: underline" @tap="linkOthers(detail.lianjie)" >{{detail.lianjie}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>用户名：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.yonghuming}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>姓名：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.xingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>发布时间：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.fabushijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>点击次数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.clicknum}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>评论数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.discussnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>收藏数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.storeupnum}}</view>
				</view>

				<view :style='{"width":"100%","background":"#fff","display":"flex"}'>
					<view :style='{"width":"100%","margin":"0 0 24rpx 0","background":"linear-gradient( 133deg, #459FEF 0%, #2BC8BA 96%)","justifyContent":"center","display":"flex","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="zan">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">赞</view>
						<view :style='{"color":"#333","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"color":"#333","lineHeight":"80rpx","fontSize":"28rpx"}' class="icon iconfont icon-zan10"></view>
					</view>
					<view :style='{"width":"100%","margin":"0 0 24rpx 0","background":"linear-gradient( 133deg, #459FEF 0%, #2BC8BA 96%)","justifyContent":"center","display":"flex","height":"auto"}' class="detail-list-item" v-if="thumbsupFlag" @tap="zan">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","textAlign":"right"}' class="lable">取消赞</view>
						<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}' class="icon iconfont icon-zan10"></view>
					</view>
					<view :style='{"width":"100%","margin":"0 0 24rpx 0","background":"#D7F0EE","justifyContent":"center","display":"flex","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="cai">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#6683A2","textAlign":"right"}' class="lable">踩</view>
						<view :style='{"color":"#6683A2","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.crazilynum}}</view>
						<view :style='{"color":"#6683A2","lineHeight":"80rpx","fontSize":"28rpx"}' class="icon iconfont icon-cai11"></view>
					</view>
					<view :style='{"width":"100%","margin":"0 0 24rpx 0","background":"#D7F0EE","justifyContent":"center","display":"flex","height":"auto"}' class="detail-list-item" v-if="crazilyFlag" @tap="cai">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#6683A2","textAlign":"right"}' class="lable">取消踩</view>
						<view :style='{"color":"#6683A2","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.crazilynum}}</view>
						<view :style='{"color":"#6683A2","lineHeight":"80rpx","fontSize":"28rpx"}' class="icon iconfont icon-cai11"></view>
					</view>
				</view>

				<view v-if="detail.shipin " class="detail-list-item video" :style='{"margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' @tap="videoClick()">
					<video :style='{"border":"0","width":"100%","margin":"0","outline":"none","borderRadius":"8rpx","display":"block"}' id="myVideo" :src="baseUrl+detail.shipin" controls></video>
				</view>

				<view class="detail-list-item" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#FFFFFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>笔记摘要：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.bijizhaiyao}}</view>
				</view>


				<view class="detail-list-item rich" :style='{"margin":"0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#929292","textAlign":"right"}'>笔记内容：</view>
					<view class="rich-text" :style='{"padding":"24rpx 24rpx 24rpx 0","margin":"0"}'>
						<rich-text :nodes="detail.bijineirong"></rich-text>
					</view>
				</view>


				<view class="time-content" :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}'>
					<view class="comoment-header" :style='{"width":"100%","boxShadow":"rgb(0 0 0 / 30%) 0px 2rpx 12rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"padding":"0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}'>评论</view>
						<view :style='{"padding":"0 20rpx","background":"linear-gradient( 316deg, #2BC8BA 0%, #459FEF 99%)","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff"}' class="cuIcon-add"></view>
							<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"border":"none","boxShadow":"none","padding":"24rpx","margin":"24rpx 0 0 0","borderRadius":"10rpx","background":"#fff","width":"100%","position":"relative","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.1)","position":"absolute","right":"20rpx","top":"0","background":"#797979"}' v-if="item.istop">
							<span class="icon iconfont icon-jiantou24" :style='{"color":"#000"}'></span>
						</view>
						<view :style='{"width":"100%","display":"flex","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"0 8rpx 0 0","borderRadius":"100%","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#333","lineHeight":"60rpx","fontSize":"28rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							<rich-text :nodes="item.content"></rich-text>
						</view>
						<view :style='{"width":"100%","margin":"16rpx 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"60rpx"}'>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"alignItems":"center","display":"flex"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan07" :style='{"fontSize":"28rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>赞</span>
								<span :style='{"fontSize":"28rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="comzanChange(item)" :style='{"background":"none"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan11" :style='{"color":"#2BC8BA","fontSize":"28rpx"}'></span>
								<span :style='{"color":"#2BC8BA","fontSize":"28rpx","display":"none"}'>已赞</span>
								<span :style='{"color":"#2BC8BA","fontSize":"28rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"alignItems":"center","display":"flex"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai01" :style='{"fontSize":"28rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>踩</span>
								<span :style='{"fontSize":"28rpx"}'>({{item.crazilynum}})</span>
							</view>
							<view v-if="comcaiChange(item)" :style='{"background":"none"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai16" :style='{"color":"#2BC8BA","fontSize":"28rpx"}'></span>
								<span :style='{"color":"#2BC8BA","fontSize":"28rpx","display":"none"}'>已踩</span>
								<span :style='{"color":"#2BC8BA","fontSize":"28rpx"}'>({{item.crazilynum}})</span>
							</view>
						</view>
						<view :style='{"color":"#999","lineHeight":"24rpx","fontSize":"24rpx"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							回复:<rich-text :nodes="item.reply"></rich-text>
						</view>
						<view style="display: flex;display: flex;justify-content: flex-end;padding: 6rpx 0;" v-if="user&&user.id==item.userid">
							<view style="color: #999;font-size: 16rpx;" @click="delClick(item.id)">删除</view>
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"10rpx 24rpx","flexWrap":"wrap","background":"#FFFFFF","display":"flex","gap":"20rpx","width":"100%","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"linear-gradient( 90deg, #2BC8BA 0%, #459FEF 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('bijixinxi','私聊')" @tap="chatClick">联系TA</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"linear-gradient( 90deg, #2BC8BA 0%, #459FEF 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('bijixinxi','私聊')" @tap="chatClick">联系TA</button>
					
					<!-- #ifdef MP-WEIXIN -->
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"linear-gradient( 90deg, #2BC8BA 0%, #459FEF 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' open-type="share">分享</button>
					<!-- #endif -->
					<!-- #ifdef APP-PLUS -->
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"linear-gradient( 90deg, #2BC8BA 0%, #459FEF 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' @click="uniShare">分享</button>
					<!-- #endif -->
					<!-- #ifdef H5 -->
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"linear-gradient( 90deg, #2BC8BA 0%, #459FEF 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' @click="shareClick">分享</button>
					<!-- #endif -->
				</view>
			</view>
		</view>
	</view>
</mescroll-uni>
	<!-- #ifdef H5 -->
	<view class="shareBG" v-if="shareShow" @click="shareShow = false"></view>
	<view class="shareBox" :class="shareShow?'shareBoxActive':''">
		<view class="shareView" @click="shareToMicroblog">
			<img src="@/static/share/weibo.png" style="width: 80%;" alt="">
			<view class="shareText">微博</view>
		</view>
		<view class="shareView" @click="shareToQQRom">
			<img src="@/static/share/qqkongjian.png" style="width: 80%;" alt="">
			<view class="shareText">QQ空间</view>
		</view>
	</view>
	<!-- #endif -->
	<video v-if="showVideo"
		:style='{"border":"0","width":"0%","margin":"0","height":"0"}'
		id="myVideo" :src="baseUrl+detail.shipin" controls></video>
</view>
</template>

<script>
	// #ifdef APP-PLUS
	import UniShare from 'components/uni-share/js_sdk/uni-share.js';
	const uniShare = new UniShare();
	// #endif
	export default {
		// #ifdef APP-PLUS
		onBackPress({from}) {
			if(from=='backbutton'){
				this.$nextTick(function(){
					uniShare.hide()
				})
				return uniShare.isShow;
			}
		},
		// #endif
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
				userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				storeupFlag: 0,
				thumbsupFlag: 0,
				crazilyFlag: 0,
				count: 0,
				timer: null,
				title:'',
				// #ifdef APP-PLUS
				href: '',
				// #endif
				// #ifdef H5
				shareShow: false,
				shareUrl: location.href,
				// #endif
				showVideo: false,
			}
		},
		components: {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			// #ifdef APP-PLUS
			let page = getCurrentPages()
			this.href = this.baseUrl + 'front/h5/#/' + page[page.length - 1].route
			// #endif
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
			if(options.userid) {
				this.userid = options.userid;
			}
			// 渲染数据
			this.init();
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		// #ifdef MP-WEIXIN
		onShareAppMessage(){
			var obj = {
				title: this.title,
				imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
			}
			return obj
		},
		// #endif
		onUnload() {
			if(this.timer) {
				clearInterval(this.timer);
			}
		},
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			this.getThumbsup();
			let cleanType = uni.getStorageSync('discussbijixinxiCleanType')
			if(cleanType){
				uni.removeStorageSync('discussbijixinxiCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init(2);
			}
			let crossCleanType = uni.getStorageSync('crossCleanType')
			if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
				res = await this.$api.info('bijixinxi', this.id);
				let reg=new RegExp('http://localhost:8080/springbooty309825g/upload','g')//g代表全部
				if(res.data.bijineirong){
					res.data.bijineirong = res.data.bijineirong.replace(reg, this.$base.url + 'upload');
				}
				this.detail = res.data;
				this.title = this.detail.bijimingcheng
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			imgView(url){
				let arr = []
				for(let x in this.swiperList){
					arr.push(this.swiperList[x].substr(0,4)=='http'?this.swiperList[x]:this.baseUrl + this.swiperList[x])
				}
				uni.previewImage({
					current: url,
					urls: arr
				})
			},
			videoClick(){
				this.showVideo = true
				this.$forceUpdate()
			},
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// #ifdef H5
			// 分享微博
			shareToMicroblog() {
				//跳转地址
				window.open(
					"https://service.weibo.com/share/share.php?url=" +
					encodeURIComponent(this.shareUrl) +
					"&title=" + this.title
				);
			},
			// 分享qq空间
			shareToQQRom() {
				//跳转地址
				window.open(
					"https://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=" +
					encodeURIComponent(this.shareUrl) +
					"&title=" +
					this.title +
					"&summary=" +
					this.title
				);
			},
			shareClick(){
				this.shareShow = true
			},
			// #endif
			// #ifdef APP-PLUS
			uniShare() {
				uniShare.show({
					content: { //公共的分享参数配置  类型（type）、链接（herf）、标题（title）、summary（描述）、imageUrl（缩略图）
						type: 0,
						href: this.href,
						title: this.title,
						summary: this.title,
						imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
					},
					menus: [{
							"img": "/static/share/weixin.png",
							"text": "微信好友",
							"share": { //当前项的分享参数配置。可覆盖公共的配置如下：分享到微信小程序，配置了type=5
								"provider": "weixin",
								"scene": "WXSceneSession"
							}
						},
						{
							"img": "/static/share/pengyouquan.png",
							"text": "微信朋友圈",
							"share": {
								"provider": "weixin",
								"scene": "WXSceneTimeline"
							}
						},
						{
							"img": "/static/share/xiaochengxu.png",
							"text": "微信小程序",
							"share": {
								provider: "weixin",
								scene: "WXSceneSession",
								type: 5,
								miniProgram: {
									id: '123',
									path: '/pages/huodongxinxi/list',
									webUrl: '/#/pages/huodongxinxi/list',
									type: 0
								},
							}
						},
						{
							"img": "/static/share/weibo.png",
							"text": "微博",
							"share": {
								"provider": "sinaweibo"
							}
						},
						{
							"img": "/static/share/qq.png",
							"text": "QQ",
							"share": {
								"provider": "qq"
							}
						},
						{
							"img": "/static/share/fuzhi.png",
							"text": "复制",
							"share": "copyurl"
						},
						{
							"img": "/static/share/gengduo.png",
							"text": "更多",
							"share": "shareSystem"
						}
					],
					cancelText: "取消分享",
				}, e => { //callback
				})
			},
			// #endif
			linkOthers(url) {
				//#ifdef H5
				window.location.href = url;
				//#endif
				//#ifdef MP-WEIXIN
				uni.navigateTo({
					// 此处的链接为小程序上面新建的webview页面路径，参数url为要跳转外链的地址
					url:"/common/linkOthers/linkOthers?url=" + encodeURIComponent(url)
				});
				//#endif
				//#ifdef APP-PLUS
				plus.runtime.openURL(url)
				//#endif
			},
			// 支付
			onPayTap(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('paytable','bijixinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
			onDetailTap(item) {
				uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 收藏
			async getStoreup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'bijixinxi',
					userid: this.user.id,
					type: '1',
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'bijixinxi',
					userid: _this.user.id,
					type: '1',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								_this.detail.storeupnum--
								await _this.$api.update('bijixinxi',_this.detail)
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.bijimingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'bijixinxi',
								type: '1'
							});
							_this.detail.storeupnum++
							await _this.$api.update('bijixinxi',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			async onAcrossTap(tableName,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('crossTable','bijixinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(type=1){
				if(this.timer) {
					clearInterval(this.timer);
				}
				let res = await this.$api.info('bijixinxi', this.id);
				let reg=new RegExp('http://localhost:8080/springbooty309825g/upload','g')//g代表全部
				if(res.data.bijineirong){
					res.data.bijineirong = res.data.bijineirong.replace(reg, this.$base.url + 'upload').replace(/<img/g,'<img style="width: 100%;"');
				}
				this.detail = res.data;

				this.title = this.detail.bijimingcheng


				// 轮播图片
				this.swiperList = this.detail.tupian ? this.detail.tupian.split(",") : [];
				






				//修改富文本的图片样式
				if(this.detail.bijineirong) {
					this.detail.bijineirong = this.detail.bijineirong.replace(/img src/gi,"img style=\"width:100%;\" src");
				}
				









				if(type==2){
					this.detail.discussnum++
					await this.$api.update('bijixinxi',this.detail)
				}
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				if(uni.getStorageSync("appUserid")){
					let res = await this.$api.list('discussbijixinxi', {
						page: mescroll.num,
						limit: 10,
						refid: Number(this.id),
						sort: 'istop',
						order: 'desc'
					});
					// 如果是第一页数据置空
					if (mescroll.num == 1) this.commentList = [];
					for(let x in res.data.list){
						if(res.data.list[x].content){
							res.data.list[x].content = res.data.list[x].content.replace(/img src/gi,"img style=\"width:100%;\" src")
						}
					}
					this.commentList = this.commentList.concat(res.data.list);
					if (res.data.list.length == 0) this.hasNext = false;
				}
				mescroll.endSuccess(mescroll.size, this.hasNext);

			},
			comzanChange(row){
				if(row.tuserids){
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comzanClick(row){
				if(!this.user){
					return false
				}
				if(!this.comzanChange(row)){
					row.thumbsupnum++
					if(row.tuserids){
						row.tuserids = row.tuserids + ',' + this.user.id
					}else {
						row.tuserids = this.user.id
					}
					await this.$api.update('discussbijixinxi',row)
					this.$utils.msg('点赞成功');
				}else {
					row.thumbsupnum--
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.tuserids = arr.join(',')
					await this.$api.update('discussbijixinxi',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},
			comcaiChange(row){
				if(row.cuserids){
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comcaiClick(row){
				if(!this.user){
					return false
				}
				if(!this.comcaiChange(row)){
					row.crazilynum++
					if(row.cuserids){
						row.cuserids = row.cuserids + ',' + this.user.id
					}else {
						row.cuserids = this.user.id
					}
					await this.$api.update('discussbijixinxi',row)
					this.$utils.msg('点踩成功');
				}else {
					row.crazilynum--
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.cuserids = arr.join(',')
					await this.$api.update('discussbijixinxi',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url ){
				if(!url){
					return false
				}
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							// #ifdef H5
							 window.open(url);
							// #endif
							// #ifndef H5
							uni.saveFile({
								tempFilePath: res.tempFilePath, //临时路径
								success: function(obj) {
									uni.showToast({
										icon: 'success',
										mask: true,
										title: '下载成功' , 
										duration: 2000,
									});
									setTimeout(() => {
										console.log('obj.savedFilePath',obj.savedFilePath);
										var filePath = obj.savedFilePath;
										uni.openDocument({ //新开页面打开文档，支持格式：doc, xls, ppt, pdf, docx, xlsx, pptx。
											filePath: filePath,
											showMenu: true,
											success: function(res) {
												console.log('打开文档成功');
											}
										});
									}, 2000)
								}
							});
							// #endif
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let res = {}
				this.$utils.jump(`../discussbijixinxi/add-or-update?refid=${this.id}` )
			},
			delClick(id){
				let that = this
				uni.showModal({
					title: '提示',
					content: '是否删除此评论？',
					async success(res) {
						if(res.confirm){
							await that.$api.del('discussbijixinxi',JSON.stringify([id]))
							that.$utils.msg('删除成功')
							that.detail.discussnum--
							await that.$api.update('bijixinxi',that.detail)
							setTimeout(()=>{
								that.upCallback(that.mescroll)
							},1500)
						}
					}
				})
			},
			// 获取赞踩
			async getThumbsup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid: this.id,
					tablename: 'bijixinxi',
					userid: this.user.id,
					type: '%2%',
				}
				let res = await this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					if(res.data.list[0].type=='21') {
						this.thumbsupFlag = 1;
					} else {
						this.crazilyFlag = 1;
					}
				}

			},
			// 点赞
			async zan() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename : 'bijixinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点赞',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) - 1;
								await _this.$api.update('bijixinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.thumbsupFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点赞',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.bijimingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'bijixinxi',
								type: '21'
							});
							_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) + 1;
							await _this.$api.update('bijixinxi', _this.detail);
							_this.$utils.msg('点赞成功');
							_this.thumbsupFlag=1;
						}
					}
				});
			},
			// 踩
			async cai() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename: 'bijixinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点踩',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.crazilynum = parseInt(_this.detail.crazilynum) - 1;
								await _this.$api.update('bijixinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.crazilyFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点踩',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.bijimingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'bijixinxi',
								type: '22'
							});
							_this.detail.crazilynum = parseInt(_this.detail.crazilynum) + 1;
							await _this.$api.update('bijixinxi', _this.detail);
							_this.$utils.msg('点踩成功');
							_this.crazilyFlag=1;
						}
					}
				});
			},
		}
	}
</script>

<style lang="scss">
	page {
	  --animate-duration: 1s;
	  --animate-delay: 1s;
	  --animate-repeat: 1;
	}
	
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio .uni-audio-default {
		width: inherit !important;
	}
	// #ifdef H5
	.shareBG{
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0,0,0,.3);
		z-index: 665;
	}
	.shareBox {
		width: 100%;
		position: fixed;
		height: 20%;
		right: 0;
		bottom: 0;
		z-index: 666;
		-webkit-transform: translate3d(0, 100%, 0);
		transform: translate3d(0, 100%, 0);
		transition: transform .3s;
		overflow-y: scroll;
		background: #fff;
		display: flex;
		align-items: center;
		justify-content: space-around;
	}
	.shareBoxActive {
		-webkit-transform: translate3d(0%, 0, 0);
		transform: translate3d(0%, 0, 0);
	}
	.shareView {
		width: 20%;
		display: flex;
		flex-direction: column;
		align-items: center;
		.shareText {
			font-size: 24rpx;
			padding: 10rpx 0 0 ;
		}
	}
	// #endif
	

</style>
