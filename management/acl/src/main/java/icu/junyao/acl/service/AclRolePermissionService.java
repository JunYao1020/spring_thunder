package icu.junyao.acl.service;

import icu.junyao.acl.entity.AclPermission;
import icu.junyao.acl.entity.AclRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.junyao.acl.req.AclRolePermissionAddReq;

import java.util.List;

/**
 * <p>
 * 角色权限 服务类
 * </p>
 *
 * @author johnson
 * @since 2021-10-04
 */
public interface AclRolePermissionService extends IService<AclRolePermission> {

    /**
     * 为角色分配权限
     * @param aclRolePermissionAddReq {@link AclRolePermissionAddReq}
     */
    void saveRolePermissionRelationShip(AclRolePermissionAddReq aclRolePermissionAddReq);

    /**
     * 通过角色获取权限
     *
     * @param roleId 角色id
     * @retur 角色权限集合
     */
    List<AclPermission> selectRolePermissionRelationShip(String roleId);
}
