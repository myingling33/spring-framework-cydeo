package com.cydeo.model;

import lombok.Data;

@Data
// Basic POJO so no @Component needed
public class Comment {
    private String author;
    private String text;
}
