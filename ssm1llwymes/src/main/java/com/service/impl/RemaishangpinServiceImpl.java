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


import com.dao.RemaishangpinDao;
import com.entity.RemaishangpinEntity;
import com.service.RemaishangpinService;
import com.entity.vo.RemaishangpinVO;
import com.entity.view.RemaishangpinView;

@Service("remaishangpinService")
public class RemaishangpinServiceImpl extends ServiceImpl<RemaishangpinDao, RemaishangpinEntity> implements RemaishangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemaishangpinEntity> page = this.selectPage(
                new Query<RemaishangpinEntity>(params).getPage(),
                new EntityWrapper<RemaishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RemaishangpinEntity> wrapper) {
		  Page<RemaishangpinView> page =new Query<RemaishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<RemaishangpinVO> selectListVO(Wrapper<RemaishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RemaishangpinVO selectVO(Wrapper<RemaishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RemaishangpinView> selectListView(Wrapper<RemaishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RemaishangpinView selectView(Wrapper<RemaishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
