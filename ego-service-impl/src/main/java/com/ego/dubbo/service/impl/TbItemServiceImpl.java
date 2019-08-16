package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.mapper.TbItemMapper;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemDescExample;
import com.ego.pojo.TbItemExample;
import com.ego.pojo.TbItemParamItem;
import com.ego.pojo.TbItemParamItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemServiceImpl implements TbItemService {
	@Resource
	private TbItemMapper tbItemMapper;
	@Resource
	private TbItemDescMapper tbItemDescMapper;
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;

	@Override
	public EasyUIDataGrid showTbItem(int page, int rows) {
		// 注意要写在查询全部的上面否则不生效
		PageHelper.startPage(page, rows);
		// 查询所有的TbItem
		TbItemExample example= new TbItemExample();
		example.createCriteria().andStatusBetween((byte)1,(byte)2);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		// 分页代码
		// 设置分页条件
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGrid grid = new EasyUIDataGrid();
		grid.setRows(pageInfo.getList());
		grid.setTotal(pageInfo.getTotal());
		return grid;
	}

	@Override
	public int updateTbItem(TbItem tbItem) {
		int index = tbItemMapper.updateByPrimaryKeySelective(tbItem);
		return index;
	}

	/**
	 * 新增商品
	 */
	@Override
	public int insertTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem) throws Exception {
		int index = 0;
		try {
			index += tbItemMapper.insertSelective(tbItem);
			index += tbItemDescMapper.insertSelective(tbItemDesc);
			index += tbItemParamItemMapper.insertSelective(tbItemParamItem);
		} catch (Exception e) {
			System.out.println("插入商品发生错误");
		}
		if (index == 3) {
			return 1;
		} else {
			throw new Exception("商品插入失败，操作还原");
		}
	}

	@Override
	public int updTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem) throws Exception {
		// TODO Auto-generated method stub
		int index = 0;
		try {
			index += tbItemMapper.updateByPrimaryKeySelective(tbItem);
			// 设置修改描述表where条件
			TbItemDescExample exampleDesc = new TbItemDescExample();
			exampleDesc.createCriteria().andItemIdEqualTo(tbItemDesc.getItemId());
			//index += tbItemDescMapper.updateByExampleWithBLOBs(tbItemDesc, exampleDesc);
			index += tbItemDescMapper.updateByExampleSelective(tbItemDesc, exampleDesc);
			// 设置修改商品规格参数表的条件
			TbItemParamItemExample exampleParam = new TbItemParamItemExample();
			exampleParam.createCriteria().andItemIdEqualTo(tbItemParamItem.getItemId());
			//index += tbItemParamItemMapper.updateByExampleWithBLOBs(tbItemParamItem, exampleParam);
			index += tbItemParamItemMapper.updateByExampleSelective(tbItemParamItem, exampleParam);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("商品修改失败");
		}
		if (index == 3) {
			return 1;
		} else {
			throw new Exception("商品修改出错");
		}

	}
  /**
   * 查询所有商品
   */
	@Override
	public List<TbItem> selAllItem() {
		// TODO Auto-generated method stub
		TbItemExample example=new TbItemExample();
		example.createCriteria().andStatusEqualTo((byte)1);
		List<TbItem> list= tbItemMapper.selectByExample(example);
		return list;
	}
/**
 * 通过商品的id查找商品
 */
@Override
public TbItem selItemById(long id) {
	// TODO Auto-generated method stub
	return tbItemMapper.selectByPrimaryKey(id);
}

}
