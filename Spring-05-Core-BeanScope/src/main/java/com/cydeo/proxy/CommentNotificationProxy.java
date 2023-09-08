package com.cydeo.proxy;

import com.cydeo.model.Comment;

// No @Component since can't create an instance from an interface.
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
