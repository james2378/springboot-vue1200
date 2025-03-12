package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.RemaishangpinEntity;
import com.entity.view.RemaishangpinView;

import com.service.RemaishangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 宠物商品 
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 18:14:02
 */
@RestController
@RequestMapping("/remaishangpin")
public class RemaishangpinController {
    @Autowired
    private RemaishangpinService remaishangpinService;


    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;


    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RemaishangpinEntity remaishangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			remaishangpin.setShangjiamingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RemaishangpinEntity> ew = new EntityWrapper<RemaishangpinEntity>();

                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = remaishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaishangpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RemaishangpinEntity remaishangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<RemaishangpinEntity> ew = new EntityWrapper<RemaishangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = remaishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaishangpin), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RemaishangpinEntity remaishangpin){
       	EntityWrapper<RemaishangpinEntity> ew = new EntityWrapper<RemaishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( remaishangpin, "remaishangpin")); 
        return R.ok().put("data", remaishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RemaishangpinEntity remaishangpin){
        EntityWrapper< RemaishangpinEntity> ew = new EntityWrapper< RemaishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( remaishangpin, "remaishangpin")); 
		RemaishangpinView remaishangpinView =  remaishangpinService.selectView(ew);
		return R.ok("查询宠物商品成功").put("data", remaishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RemaishangpinEntity remaishangpin = remaishangpinService.selectById(id);
		remaishangpin.setClicknum(remaishangpin.getClicknum()+1);
		remaishangpin.setClicktime(new Date());
		remaishangpinService.updateById(remaishangpin);
        remaishangpin = remaishangpinService.selectView(new EntityWrapper<RemaishangpinEntity>().eq("id", id));
        return R.ok().put("data", remaishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RemaishangpinEntity remaishangpin = remaishangpinService.selectById(id);
		remaishangpin.setClicknum(remaishangpin.getClicknum()+1);
		remaishangpin.setClicktime(new Date());
		remaishangpinService.updateById(remaishangpin);
        remaishangpin = remaishangpinService.selectView(new EntityWrapper<RemaishangpinEntity>().eq("id", id));
        return R.ok().put("data", remaishangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RemaishangpinEntity remaishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(remaishangpin);

        remaishangpinService.insert(remaishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RemaishangpinEntity remaishangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(remaishangpin);

        remaishangpinService.insert(remaishangpin);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RemaishangpinEntity remaishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(remaishangpin);
        remaishangpinService.updateById(remaishangpin);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        remaishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RemaishangpinEntity remaishangpin, HttpServletRequest request,String pre){
        EntityWrapper<RemaishangpinEntity> ew = new EntityWrapper<RemaishangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = remaishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaishangpin), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RemaishangpinEntity remaishangpin, HttpServletRequest request){
    	String userId = request.getSession().getAttribute("userId").toString();
    	String goodtypeColumn = "shangpinleibie";
    	List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "remaishangpin").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
    	Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
    	List<RemaishangpinEntity> remaishangpinList = new ArrayList<RemaishangpinEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
        	for(OrdersEntity o : ordersDist) {
        		remaishangpinList.addAll(remaishangpinService.selectList(new EntityWrapper<RemaishangpinEntity>().eq(goodtypeColumn, o.getGoodtype())));
        	}
        }
    	EntityWrapper<RemaishangpinEntity> ew = new EntityWrapper<RemaishangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = remaishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaishangpin), params), params));
        List<RemaishangpinEntity> pageList = (List<RemaishangpinEntity>)page.getList();
        if(remaishangpinList.size()<limit) {
        	int toAddNum = (limit-remaishangpinList.size())<=pageList.size()?(limit-remaishangpinList.size()):pageList.size();
            for(RemaishangpinEntity o1 : pageList) {
                boolean addFlag = true;
                for(RemaishangpinEntity o2 : remaishangpinList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    remaishangpinList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(remaishangpinList.size()>limit) {
            remaishangpinList = remaishangpinList.subList(0, limit);
        }
        page.setList(remaishangpinList);
	return R.ok().put("data", page);
    }








}
