package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.OrderItemService;
import com.ego.mapper.TbOrderItemMapper;
import com.ego.mapper.TbOrderMapper;
import com.ego.mapper.TbOrderShippingMapper;
import com.ego.pojo.TbOrder;
import com.ego.pojo.TbOrderItem;
import com.ego.pojo.TbOrderShipping;

public class OrderItemServiceImpl implements OrderItemService{
	/**
	 * 提交订单
	 * 同时插入TbOrderShipping,TbOrderItem,TbOrder
	 */
	@Resource
	private TbOrderShippingMapper tbOrderShippingMapper;
	@Resource
	private TbOrderMapper tbOrderMapper;
	@Resource
	private TbOrderItemMapper tbOrderItemMapper;
	@Override
	public int SubmitOrderItem(TbOrderShipping ship, List<TbOrderItem> orderItem, TbOrder order) throws Exception {
		// TODO Auto-generated method stub
		int index=tbOrderShippingMapper.insertSelective(ship);
		index+=tbOrderMapper.insertSelective(order);
		for (TbOrderItem tb : orderItem) {
			index+=tbOrderItemMapper.insertSelective(tb);
		}
		if(index==2+orderItem.size()){
			return 1;
		}else{
			throw new Exception("提单提交失败，事物回滚");
		}
	
	}

}
