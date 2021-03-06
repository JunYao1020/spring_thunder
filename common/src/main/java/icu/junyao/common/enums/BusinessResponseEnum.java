package icu.junyao.common.enums;

import icu.junyao.common.exception.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>通用返回结果</p>
 *
 * @author johnson
 * @date 2021-10-02
 */
@Getter
@AllArgsConstructor
public enum BusinessResponseEnum implements BusinessExceptionAssert {

    /**
     * 原始密码错误
     */
    OLD_PWD_ERROR("A0209", "原始密码错误!"),
    /**
     * 用户名或密码错误
     */
    PWD_ERROR("A0210", "用户名或密码错误!"),
    /**
     * 新密码不能和旧密码相同
     */
    NEW_PWD_EQUALS_OLD("A0212", "新密码不能与旧密码相同!"),
    /**
     * 用户名已存在
     */
    USER_NAME_REPEAT("A0211", "用户名已存在"),
    /**
     * 文件不存在!
     */
    FILE_IS_EMPTY("A0213", "文件不存在!"),
    /**
     * 用户不存在!
     */
    USER_NOT_FOUND("A0214", "用户不存在!"),
    /**
     * 角色名或角色编码已存在!
     */
    ROLE_INFO_EXIST("A0215", "角色名或角色编码已存在!"),
    /**
     * 权限名已存在
     */
    PERMISSION_NAME_ALREADY_EXISTS("A0216", "权限名已存在!"),
    /**
     * 该角色正在被使用
     */
    ROLE_BRING_USED("A0217", "该角色正在被使用!"),
    /**
     * banner标题已存在
     */
    BANNER_TITLE_USED("A0218", "banner标题已存在!"),
    /**
     * banner不存在
     */
    BANNER_NOT_EXIST("A0219", "banner不存在!"),
    /**
     * 登录信息过期
     */
    LOGIN_EXPIRED("A0220", "登录信息过期, 请重新登录!"),
    /**
     * 章节标题已存在
     */
    CHAPTER_EXIST("A0221", "章节标题已存在!"),
    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST("A0222", "账号不存在!"),
    /**
     * 用户被禁用, 请联系管理员
     */
    ACCOUNT_DISABLED("A0223", "用户被禁用, 请联系管理员!"),
    /**
     * 该手机号已注册, 忘记密码请联系管理员
     */
    MOBILE_EXIST("A0224", "该手机号已注册, 忘记密码请联系管理员"),
    /**
     * token解析错误
     */
    TOKEN_ERROR("A0225", "token解析错误"),
    /**
     * 文件数据为空!
     */
    FILE_CONTENT_EMPTY("A0226", "文件数据为空!"),
    /**
     * 视频删除失败
     */
    VOD_DELETE_ERROR("A0227", "视频删除失败!"),
    /**
     * 获取视频凭证失败
     */
    FETCH_PLAY_AUTH_ERROR("A0228", "获取视频凭证失败!"),
    /**
     * 该教师存在课程, 无法删除!
     */
    TEACHER_CANNOT_DELETE("A0229", "该教师存在课程, 无法删除!"),
    /**
     * 教师不存在!
     */
    TEACHER_NOT_EXISTS("A0230", "教师不存在"),
    /**
     * 管理员用户已绑定教师!
     */
    ACL_USER_ALREADY_BOUND("A0231", "管理员用户已绑定教师");

    private final String code;

    private final String message;

}
