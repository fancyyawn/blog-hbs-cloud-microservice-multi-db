package top.zhacker.blog.comment.service;

import top.zhacker.blog.comment.dto.CommentPagingCriteria;
import top.zhacker.blog.comment.model.Comment;
import top.zhacker.blog.common.Paging;

/**
 * DATE: 17/3/24 下午1:41 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 *
 * 评论服务
 */

public interface CommentService {

    String createComment(Comment comment);

    Boolean deleteCommentById(String commentId, String operatorId);

    Paging<Comment> findCommentsByBlogId(CommentPagingCriteria commentPagingCriteria);
}
