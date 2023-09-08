package com.cydeo.repository;

import com.cydeo.model.Comment;

// No @Component since can't create an instance from an interface.
public interface CommentRepository {
    void storeComment(Comment comment);
}
