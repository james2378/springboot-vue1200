package com.dao;

import com.entity.RemaishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RemaishangpinVO;
import com.entity.view.RemaishangpinView;


/**
 * 宠物商品
 * 
 * @author 
 * @email 
 * @date 2024-03-19 18:14:02
 */
public interface RemaishangpinDao extends BaseMapper<RemaishangpinEntity> {
	
	List<RemaishangpinVO> selectListVO(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);
	
	RemaishangpinVO selectVO(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);
	
	List<RemaishangpinView> selectListView(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);

	List<RemaishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<RemaishangpinEntity> wrapper);

	
	RemaishangpinView selectView(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);
	

}
