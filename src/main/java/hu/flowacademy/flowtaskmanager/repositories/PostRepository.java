package hu.flowacademy.flowtaskmanager.repositories;

import hu.flowacademy.flowtaskmanager.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
