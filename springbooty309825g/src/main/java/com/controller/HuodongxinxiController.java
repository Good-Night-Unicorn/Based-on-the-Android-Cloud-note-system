package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HuodongxinxiEntity;
import com.entity.view.HuodongxinxiView;

import com.service.HuodongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 活动信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-25 13:40:34
 */
@RestController
@RequestMapping("/huodongxinxi")
public class HuodongxinxiController {
    @Autowired
    private HuodongxinxiService huodongxinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongxinxiEntity huodongxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huodongxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();


        //查询结果
		PageUtils page = huodongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongxinxiEntity huodongxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();

        //查询结果
		PageUtils page = huodongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongxinxiEntity huodongxinxi){
       	EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongxinxi, "huodongxinxi")); 
        return R.ok().put("data", huodongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongxinxiEntity huodongxinxi){
        EntityWrapper< HuodongxinxiEntity> ew = new EntityWrapper< HuodongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongxinxi, "huodongxinxi")); 
		HuodongxinxiView huodongxinxiView =  huodongxinxiService.selectView(ew);
		return R.ok("查询活动信息成功").put("data", huodongxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongxinxiEntity huodongxinxi = huodongxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huodongxinxi,deSens);
        return R.ok().put("data", huodongxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongxinxiEntity huodongxinxi = huodongxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(huodongxinxi,deSens);
        return R.ok().put("data", huodongxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongxinxi);
        huodongxinxiService.insert(huodongxinxi);
        return R.ok().put("data",huodongxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongxinxi);
        huodongxinxiService.insert(huodongxinxi);
        return R.ok().put("data",huodongxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongxinxi);
        //全部更新
        huodongxinxiService.updateById(huodongxinxi);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<HuodongxinxiEntity> list = new ArrayList<HuodongxinxiEntity>();
        for(Long id : ids) {
            HuodongxinxiEntity huodongxinxi = huodongxinxiService.selectById(id);
            huodongxinxi.setSfsh(sfsh);
            huodongxinxi.setShhf(shhf);
            list.add(huodongxinxi);
        }
        huodongxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
