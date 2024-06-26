package com.app.parkinglot.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Setter
@Getter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
