package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BijixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BijixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BijixinxiView;


/**
 * 笔记信息
 *
 * @author 
 * @email 
 * @date 2025-04-25 13:40:33
 */
public interface BijixinxiService extends IService<BijixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BijixinxiVO> selectListVO(Wrapper<BijixinxiEntity> wrapper);
   	
   	BijixinxiVO selectVO(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
   	
   	List<BijixinxiView> selectListView(Wrapper<BijixinxiEntity> wrapper);
   	
   	BijixinxiView selectView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BijixinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BijixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BijixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BijixinxiEntity> wrapper);



}

