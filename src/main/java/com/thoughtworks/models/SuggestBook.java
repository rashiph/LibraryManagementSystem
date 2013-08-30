package com.thoughtworks.models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@Entity
@Table(name = "suggest")
public class SuggestBook extends BaseEntity {


    @NotNull
    @Column(name = "employeeId")
    private long employeeId;

    @NotEmpty
    @Column(name = "bookName")
    private String bookName;

    @NotEmpty
    @Column(name = "authorName")
    private String authorName;

    @NotNull
    @Column(name = "edition")
    private int edition;

}