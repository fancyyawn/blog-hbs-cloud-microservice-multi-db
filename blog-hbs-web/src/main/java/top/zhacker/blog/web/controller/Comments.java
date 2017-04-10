package top.zhacker.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.zhacker.blog.web.model.Comment;
import top.zhacker.blog.web.service.CommentServiceClient;

/**
 * DATE: 17/1/11 上午10:28 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 *
 * 评论视图
 */
@Controller
@RequestMapping("/posts/{postId}/comments")
public class Comments extends ViewBase {

    private final CommentServiceClient commentService;

    @Autowired
    public Comments(CommentServiceClient commentService) {
        this.commentService = commentService;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String comment(@PathVariable String postId, String content, RedirectAttributes attributes){

        Comment comment = new Comment()
                .setPostId(postId)
                .setContent(content)
                .setAuthor(getCurrentUser())
                .setAuthorId(getCurrentUserId());
        commentService.createComment(comment);

        attributes.addFlashAttribute("success", "comment.create.success");
        return "redirect:/posts/"+postId;
    }

    @RequestMapping(value = "/{commentId}/remove", method = RequestMethod.POST)
    public String removeComment(@PathVariable String commentId,
                                @PathVariable String postId,
                                RedirectAttributes attributes){

        commentService.deleteComment(commentId, getCurrentUserId());
        attributes.addFlashAttribute("success", "comment.remove.success");
        return "redirect:/posts/"+postId;
    }
}
