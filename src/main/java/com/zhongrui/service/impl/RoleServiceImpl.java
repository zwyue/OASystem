package com.zhongrui.service.impl;

import com.zhongrui.dao.RoleMapper;
import com.zhongrui.entity.Role;
import com.zhongrui.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  Joanne
 * @date  2018/11/2 15:10
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleList(Integer id) {
        return roleMapper.selectByUserId(id);
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int insertUserRoleRe(Integer id, int insertRole) {
        Map map = new HashMap();
        map.put("userId",id);
        map.put("roleId",insertRole);
        return roleMapper.saveUserRoleRe(map);
    }
}
