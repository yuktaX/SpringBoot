package com.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
//import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID id;
    @NotBlank
    private final String Name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("Name") String Name)
    {
        this.id = id;
        this.Name = Name;
    }

    public UUID getid() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
