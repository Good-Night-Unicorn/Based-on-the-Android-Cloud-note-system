package com.dao;

import com.entity.DaibanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaibanxinxiVO;
import com.entity.view.DaibanxinxiView;


/**
 * 待办信息
 * 
 * @author 
 * @email 
 * @date 2025-04-25 13:40:34
 */
public interface DaibanxinxiDao extends BaseMapper<DaibanxinxiEntity> {
	
	List<DaibanxinxiVO> selectListVO(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);
	
	DaibanxinxiVO selectVO(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);
	
	List<DaibanxinxiView> selectListView(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);

	List<DaibanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);

	
	DaibanxinxiView selectView(@Param("ew") Wrapper<DaibanxinxiEntity> wrapper);
	

}
