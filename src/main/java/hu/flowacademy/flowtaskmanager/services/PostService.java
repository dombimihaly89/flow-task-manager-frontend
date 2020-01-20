package hu.flowacademy.flowtaskmanager.services;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.postDTO.PostDTO;
import hu.flowacademy.flowtaskmanager.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost(PostDTO postDTO) {
        Post post = new Post();
        post.postFromPostDTO(postDTO);
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(userService.findUserById(postDTO.getUserId()));
        post.setTask(taskService.findTaskById(postDTO.getTaskId()));
        postRepository.save(post);
        return post;
    }
}
