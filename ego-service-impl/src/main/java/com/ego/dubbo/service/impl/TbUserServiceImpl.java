package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbUserService;
import com.ego.mapper.TbUserMapper;
import com.ego.pojo.TbUser;
import com.ego.pojo.TbUserExample;

public class TbUserServiceImpl implements TbUserService{
	@Resource
	private TbUserMapper tbUserMapper;
	/**
	 * 根据username和password查询user的信息
	 */
	@Override
	public TbUser selUser(TbUser user) {
		// TODO Auto-generated method stub
		TbUserExample example=new TbUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<TbUser> users=tbUserMapper.selectByExample(example);
		if(user!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

}
