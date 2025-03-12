package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemaishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemaishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemaishangpinView;


/**
 * 宠物商品
 *
 * @author 
 * @email 
 * @date 2024-03-19 18:14:02
 */
public interface RemaishangpinService extends IService<RemaishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemaishangpinVO> selectListVO(Wrapper<RemaishangpinEntity> wrapper);
   	
   	RemaishangpinVO selectVO(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);
   	
   	List<RemaishangpinView> selectListView(Wrapper<RemaishangpinEntity> wrapper);
   	
   	RemaishangpinView selectView(@Param("ew") Wrapper<RemaishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemaishangpinEntity> wrapper);

   	

}

