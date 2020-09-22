package server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import server.domain.Comment;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    void deleteById(int id);
    List<Comment> findAllByRecipeName(String recipeName);    
}