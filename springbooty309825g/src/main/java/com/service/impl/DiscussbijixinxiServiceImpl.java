package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussbijixinxiDao;
import com.entity.DiscussbijixinxiEntity;
import com.service.DiscussbijixinxiService;
import com.entity.vo.DiscussbijixinxiVO;
import com.entity.view.DiscussbijixinxiView;

@Service("discussbijixinxiService")
public class DiscussbijixinxiServiceImpl extends ServiceImpl<DiscussbijixinxiDao, DiscussbijixinxiEntity> implements DiscussbijixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbijixinxiEntity> page = this.selectPage(
                new Query<DiscussbijixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussbijixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbijixinxiEntity> wrapper) {
		  Page<DiscussbijixinxiView> page =new Query<DiscussbijixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussbijixinxiVO> selectListVO(Wrapper<DiscussbijixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbijixinxiVO selectVO(Wrapper<DiscussbijixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbijixinxiView> selectListView(Wrapper<DiscussbijixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbijixinxiView selectView(Wrapper<DiscussbijixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
