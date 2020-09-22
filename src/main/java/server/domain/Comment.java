package server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    private User user;

    @Column(name = "commentText")
    private String commentText;

    @Column(name = "recipeName")
    private String recipeName;

    public Comment(User user, String commentText, String recipeName){
        this.user = user;
        this.commentText = commentText;
        this.recipeName = recipeName;
    }

    protected Comment(){}
    
    public void setId(int id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

	public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setCommentText(String commentText){
        this.commentText = commentText;
    }

    public String getCommentText(){
        return this.commentText;
    }
    
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public String getRecipeName(){
        return this.recipeName;
    }
}