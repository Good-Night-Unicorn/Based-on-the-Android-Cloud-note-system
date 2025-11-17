package com.dao;

import com.entity.DiscussbijixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbijixinxiVO;
import com.entity.view.DiscussbijixinxiView;


/**
 * 笔记信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-25 13:40:35
 */
public interface DiscussbijixinxiDao extends BaseMapper<DiscussbijixinxiEntity> {
	
	List<DiscussbijixinxiVO> selectListVO(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
	
	DiscussbijixinxiVO selectVO(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
	
	List<DiscussbijixinxiView> selectListView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);

	List<DiscussbijixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);

	
	DiscussbijixinxiView selectView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
	

}
