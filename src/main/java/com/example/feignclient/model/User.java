package com.example.feignclient.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="personasdfbbbbbb")
public class User {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
}