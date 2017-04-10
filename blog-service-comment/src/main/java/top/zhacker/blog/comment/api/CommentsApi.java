package top.zhacker.blog.comment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhacker.blog.comment.dto.CommentPagingCriteria;
import top.zhacker.blog.comment.model.Comment;
import top.zhacker.blog.comment.service.CommentService;
import top.zhacker.blog.common.Paging;

/**
 * DATE: 2017/4/10 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 */
@RestController
@RequestMapping("/v1/blog/comments")
public class CommentsApi {

    private final CommentService commentService;

    @Autowired
    public CommentsApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Paging<Comment> paging(CommentPagingCriteria criteria){
        return commentService.findCommentsByBlogId(criteria);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteComment(@PathVariable String id, @RequestParam String operatorId){
        return commentService.deleteCommentById(id, operatorId);
    }
}
