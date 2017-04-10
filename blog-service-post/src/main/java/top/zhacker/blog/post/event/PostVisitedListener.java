package top.zhacker.blog.post.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zhacker.blog.post.model.Post;
import top.zhacker.blog.post.repo.PostRepo;

import javax.annotation.PostConstruct;

/**
 * DATE: 17/1/10 下午10:34 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 *
 * 计算博客的PV
 *
 */
@Component
@Slf4j
public class PostVisitedListener {

    @Autowired
    private EventBus eventBus;

    @PostConstruct
    private void init(){
        eventBus.register(this);
    }

    @Autowired
    private PostRepo postRepo;

    @Subscribe
    public void onPostVisited(PostVisitedEvent event){
        log.info("user({}) visit post({})", event.getVisitorId(), event.getPostId());

        Post post = postRepo.findOne(event.getPostId());
        post.setPv(post.getPv()+1);

        postRepo.save(post);
    }

}
