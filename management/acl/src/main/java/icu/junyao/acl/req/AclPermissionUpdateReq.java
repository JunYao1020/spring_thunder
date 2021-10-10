package icu.junyao.acl.req;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author johnson
 * @date 2021-10-03
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class AclPermissionUpdateReq extends AclPermissionAddReq {
    @NotEmpty(message = "id不能为空!")
    private String id;
}
