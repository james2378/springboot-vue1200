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


import com.dao.DiscussremaishangpinDao;
import com.entity.DiscussremaishangpinEntity;
import com.service.DiscussremaishangpinService;
import com.entity.vo.DiscussremaishangpinVO;
import com.entity.view.DiscussremaishangpinView;

@Service("discussremaishangpinService")
public class DiscussremaishangpinServiceImpl extends ServiceImpl<DiscussremaishangpinDao, DiscussremaishangpinEntity> implements DiscussremaishangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussremaishangpinEntity> page = this.selectPage(
                new Query<DiscussremaishangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussremaishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussremaishangpinEntity> wrapper) {
		  Page<DiscussremaishangpinView> page =new Query<DiscussremaishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussremaishangpinVO> selectListVO(Wrapper<DiscussremaishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussremaishangpinVO selectVO(Wrapper<DiscussremaishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussremaishangpinView> selectListView(Wrapper<DiscussremaishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussremaishangpinView selectView(Wrapper<DiscussremaishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
