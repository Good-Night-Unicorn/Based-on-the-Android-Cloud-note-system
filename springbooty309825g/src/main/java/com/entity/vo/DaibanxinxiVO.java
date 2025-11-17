package com.entity.vo;

import com.entity.DaibanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 待办信息
 * @author 
 * @email 
 * @date 2025-04-25 13:40:34
 */
public class DaibanxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 待办时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date daibanshijian;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 待办内容
	 */
	
	private String daibanneirong;
		
	/**
	 * 是否完成
	 */
	
	private String shifouwancheng;
		
	/**
	 * 创建时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chuangjianshijian;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
				
	
	/**
	 * 设置：待办时间
	 */
	 
	public void setDaibanshijian(Date daibanshijian) {
		this.daibanshijian = daibanshijian;
	}
	
	/**
	 * 获取：待办时间
	 */
	public Date getDaibanshijian() {
		return daibanshijian;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：待办内容
	 */
	 
	public void setDaibanneirong(String daibanneirong) {
		this.daibanneirong = daibanneirong;
	}
	
	/**
	 * 获取：待办内容
	 */
	public String getDaibanneirong() {
		return daibanneirong;
	}
				
	
	/**
	 * 设置：是否完成
	 */
	 
	public void setShifouwancheng(String shifouwancheng) {
		this.shifouwancheng = shifouwancheng;
	}
	
	/**
	 * 获取：是否完成
	 */
	public String getShifouwancheng() {
		return shifouwancheng;
	}
				
	
	/**
	 * 设置：创建时间
	 */
	 
	public void setChuangjianshijian(Date chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getChuangjianshijian() {
		return chuangjianshijian;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
			
}
