package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamService;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemParamServiceImpl implements TbItemParamService {
	@Resource
	private TbItemParamMapper tbItemParamMapper;

	/**
	 * 分页查询商品规格参数
	 */
	@Override
	public EasyUIDataGrid selParam(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParam> tbItemParam = tbItemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
		PageInfo<TbItemParam> info = new PageInfo<>(tbItemParam);
		EasyUIDataGrid grid = new EasyUIDataGrid();
		grid.setTotal(info.getTotal());
		grid.setRows(info.getList());
		return grid;
	}

	/**
	 * 通过商品类目的id查询商品规格参数
	 */

	@Override
	public TbItemParam selByCatId(Long catId) {
		// TODO Auto-generated method stu
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(catId);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		if (list != null && list.size() > 0) {
			TbItemParam param = list.get(0);
			return param;
		}
		return null;
	}

	/**
	 * 新增商品规格
	 * 
	 * @throws Exception
	 */
	@Override
	public int insTbItemParam(TbItemParam tbItemParam) throws Exception {
		// TODO Auto-generated method stub
		int index = 0;
		try {
			index = tbItemParamMapper.insertSelective(tbItemParam);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("插入失败");
		}
		if (index == 1) {
			return 1;
		} else {
			throw new Exception("新增失败");
		}
	}

	@Override
	public int delTbItemParam(Long ids) {
		// TODO Auto-generated method stub
		return tbItemParamMapper.deleteByPrimaryKey(ids);
	}

}
