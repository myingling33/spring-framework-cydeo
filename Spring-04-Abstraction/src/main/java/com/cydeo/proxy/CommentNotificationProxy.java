package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

// No @Component since can't create an instance from an interface.
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
