package com.cydeo.repository;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component  // DBCommentRepository is going to be injected in the CommentService.
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
