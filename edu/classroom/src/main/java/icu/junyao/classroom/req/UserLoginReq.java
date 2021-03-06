package icu.junyao.classroom.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author johnson
 * @date 2021-11-01
 */
@Data
public class UserLoginReq {

    @NotBlank(message = "手机号不能为空!")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式错误!")
    private String mobile;

    @NotBlank(message = "密码不能为空!")
    @Pattern(regexp = "^[A-Za-z0-9._~!@#$^&*]{6,20}$", message = "密码格式错误!")
    private String password;
}
