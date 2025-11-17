package com.dao;

import com.entity.BijixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BijixinxiVO;
import com.entity.view.BijixinxiView;


/**
 * 笔记信息
 * 
 * @author 
 * @email 
 * @date 2025-04-25 13:40:33
 */
public interface BijixinxiDao extends BaseMapper<BijixinxiEntity> {
	
	List<BijixinxiVO> selectListVO(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
	
	BijixinxiVO selectVO(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
	
	List<BijixinxiView> selectListView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);

	List<BijixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BijixinxiEntity> wrapper);

	
	BijixinxiView selectView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BijixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BijixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BijixinxiEntity> wrapper);



}
