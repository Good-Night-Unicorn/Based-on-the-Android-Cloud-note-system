package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 待办信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-25 13:40:34
 */
@TableName("daibanxinxi")
public class DaibanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DaibanxinxiEntity() {
		
	}
	
	public DaibanxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 待办名称
	 */
					
	private String daibanmingcheng;
	
	/**
	 * 待办时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：待办名称
	 */
	public void setDaibanmingcheng(String daibanmingcheng) {
		this.daibanmingcheng = daibanmingcheng;
	}
	/**
	 * 获取：待办名称
	 */
	public String getDaibanmingcheng() {
		return daibanmingcheng;
	}
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
