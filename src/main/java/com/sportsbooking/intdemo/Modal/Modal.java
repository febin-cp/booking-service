package com.sportsbooking.intdemo.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "HELLO")
public class Modal {
    @Id
    @GeneratedValue
    private Integer number;
    private String hello;
    private String how;
}
