package top.zhacker.blog.post.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhacker.blog.common.Paging;
import top.zhacker.blog.post.dto.PostPagingCriteria;
import top.zhacker.blog.post.model.Post;
import top.zhacker.blog.post.service.PostService;

/**
 * DATE: 17/1/5 上午10:55 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 *
 * 博客视图
 */
@RestController
@RequestMapping("/v1/blog/posts")
public class PostApi{

    private final PostService postService;

    @Autowired
    public PostApi(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deletePost(@PathVariable String id,
                              @RequestParam String operatorId){
        return postService.deletePostById(id, operatorId);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Boolean updatePost(@PathVariable String id,
                              @RequestParam String title,
                              @RequestParam String content,
                              @RequestParam String operatorId){
        return postService.updatePostTitleAndContent(id, title, content, operatorId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post findPost(@PathVariable String id, @RequestParam(required = false) String operatorId){
        return postService.findPostById(id, operatorId);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Paging<Post> paging(PostPagingCriteria criteria){
        return postService.pagingPosts(criteria);
    }
}
