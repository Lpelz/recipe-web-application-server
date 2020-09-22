package server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.domain.Comment;
import server.service.CommentService;

@CrossOrigin
@RestController
public class CommentController { 

    @Autowired
    private CommentService commentService;
    
    @PostMapping(value = "/comment", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
    }
    
    @GetMapping(value = "/comment")
    public List<Comment> getComments(@RequestParam String recipeName){
        return commentService.getComments(recipeName);
    }

    @DeleteMapping(value = "/comment")
    public void deleteComment(@RequestParam int id){
        commentService.deleteComment(id);
    }
}