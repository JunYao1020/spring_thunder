package icu.junyao.classroom.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.junyao.classroom.entity.CourseComment;
import icu.junyao.classroom.entity.User;
import icu.junyao.classroom.mapper.CourseCommentMapper;
import icu.junyao.classroom.mapper.UserMapper;
import icu.junyao.classroom.req.CourseCommentReq;
import icu.junyao.classroom.req.PageCourseCommentReq;
import icu.junyao.classroom.res.CourseCommentRes;
import icu.junyao.classroom.service.CourseCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.junyao.common.entity.PageResult;
import icu.junyao.common.enums.BusinessResponseEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author johnson
 * @since 2021-10-23
 */
@Service
@RequiredArgsConstructor
public class CourseCommentServiceImpl extends ServiceImpl<CourseCommentMapper, CourseComment> implements CourseCommentService {

    private final UserMapper userMapper;

    @Override
    public PageResult<CourseCommentRes> pageComment(PageCourseCommentReq pageCourseCommentReq) {
        // 构建分页条件, 按时间降序查找当前课程的评论
        IPage<CourseComment> courseCommentPage = new Page<>(pageCourseCommentReq.getPage()
                , pageCourseCommentReq.getPageSize());
        LambdaQueryWrapper<CourseComment> courseCommentLambdaQueryWrapper = Wrappers.lambdaQuery();
        courseCommentLambdaQueryWrapper.eq(CourseComment::getCourseId, pageCourseCommentReq.getCourseId())
                .orderByDesc(CourseComment::getCreatedTime);

        super.page(courseCommentPage, courseCommentLambdaQueryWrapper);

        // 属性转移
        List<CourseCommentRes> courseCommentResList = BeanUtil
                .copyToList(courseCommentPage.getRecords(), CourseCommentRes.class, CopyOptions.create());

        // 没有评论直接返回空
        if (CollUtil.isEmpty(courseCommentResList)) {
            return new PageResult<>(0L, new ArrayList<>());
        }
        // 加入用户信息
        List<String> userIdList = courseCommentResList.stream().map(CourseCommentRes::getUserId)
                .collect(Collectors.toList());
        List<User> userList = userMapper.selectBatchIds(userIdList);
        Map<String, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, u -> u));
        courseCommentResList.forEach(c -> {
            User user = userMap.get(c.getUserId());
            c.setNickname(user.getNickname());
            c.setAvatar(user.getAvatar());
        });

        return new PageResult<>(courseCommentPage.getTotal(), courseCommentResList);
    }

    @Override
    public void saveComment(CourseCommentReq courseCommentReq, DecodedJWT decodedJwt) {
        // 校验解析jwt
        if (decodedJwt == null) {
            throw BusinessResponseEnum.TOKEN_ERROR.newException();
        }

        String id = decodedJwt.getClaim("id").asString();

        CourseComment courseComment = new CourseComment();
        BeanUtils.copyProperties(courseCommentReq, courseComment);
        courseComment.setUserId(id);

        super.save(courseComment);
    }
}
