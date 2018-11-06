package com.zhongrui.service;

import com.zhongrui.entity.Role;

import java.util.List;

/**
 * @Auther: Joanne
 * @Date: 2018/11/2 15:10
 * @Description:
 */
public interface RoleService {
    List<Role> selectRoleList(Integer id);

    int insertRole(Role role);

    int insertUserRoleRe(Integer id, int insertRole);
}
