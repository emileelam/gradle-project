package com.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
    private long id;
    @Length(max = 3)
    private String content;
    private boolean result;

    public Saying() {

    }

    public Saying(long id, String content, boolean result) {
        this.id = id;
        this.content = content;
        this.result = result;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public boolean getResult() {
        if(id == 2 || id == 3 || id == 5 || id == 7 || id == 23 || id == 29 || id == 31 || id == 37) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
