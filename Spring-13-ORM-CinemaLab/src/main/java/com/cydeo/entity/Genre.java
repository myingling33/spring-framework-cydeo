package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;

    @Override
    public String toString() {
        return "Genre{" +
                "movieList=" + movieList +
                '}';
    }
}
