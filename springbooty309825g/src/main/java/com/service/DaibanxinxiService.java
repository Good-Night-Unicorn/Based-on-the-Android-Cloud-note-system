package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaibanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaibanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaibanxinxiView;


/**
 * 待办信息
 *
 * @author 
 * @email 
 * @date 2025-04-25 13:40:34
 */
public interface DaibanxinxiService extends IService<DaibanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaibanxinxiVO> selectListVO(Wrapper<DaibanxinxiEntity> wrapper);
   	
   	DaibanxinxiVO selectVO(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);
   	
   	List<DaibanxinxiView> selectListView(Wrapper<DaibanxinxiEntity> wrapper);
   	
   	DaibanxinxiView selectView(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaibanxinxiEntity> wrapper);

   	

}

