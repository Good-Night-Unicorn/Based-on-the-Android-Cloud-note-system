package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbijixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbijixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbijixinxiView;


/**
 * 笔记信息评论表
 *
 * @author 
 * @email 
 * @date 2025-04-25 13:40:35
 */
public interface DiscussbijixinxiService extends IService<DiscussbijixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbijixinxiVO> selectListVO(Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	DiscussbijixinxiVO selectVO(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	List<DiscussbijixinxiView> selectListView(Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	DiscussbijixinxiView selectView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbijixinxiEntity> wrapper);

   	

}

