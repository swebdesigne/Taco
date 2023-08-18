package ru.taco.tacos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TacoTest {
    private int id;
    private Date createAt = new Date();
    private String name;
    private List<String> ingredients;
}
