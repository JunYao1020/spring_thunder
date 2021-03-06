package icu.junyao.acl.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.junyao.acl.entity.AclPermission;
import icu.junyao.acl.req.AclPermissionReq;
import icu.junyao.acl.req.AclPermissionEditReq;
import icu.junyao.acl.res.AclPermissionRes;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author johnson
 * @since 2021-10-04
 */
public interface AclPermissionService extends IService<AclPermission> {

    /**
     * 通过用户获取该用户权限值集合
     *
     * @param aclUserId 用户id
     * @return 该用户权限值集合
     */
    List<String> gainPermissionValueListByAclUser(String aclUserId);

    /**
     * 获取树形菜单列表
     *
     * @return {@link AclPermissionRes}
     */
    List<AclPermissionRes> gainTreePermissionList();

    /**
     * 递归删除权限
     *
     * @param id 权限id
     */
    void deletePermission(String id);

    /**
     * 新增权限
     *
     * @param aclPermissionAddReq {@link AclPermissionReq}
     */
    void savePermission(AclPermissionReq aclPermissionAddReq);

    /**
     * 修改权限
     *
     * @param aclPermissionUpdateReq {@link AclPermissionReq}
     */
    void updatePermission(AclPermissionEditReq aclPermissionUpdateReq);

    /**
     * 获取当前用户菜单列表
     *
     * @return 菜单列表
     */
    List<JSONObject> gainMenuList();

    /**
     * 获取所有的权限
     *
     * @return 所有权限的树形列表
     */
    List<AclPermissionRes> gainAllPermission();
}
