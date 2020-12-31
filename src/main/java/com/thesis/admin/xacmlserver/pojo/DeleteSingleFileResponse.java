package com.thesis.admin.xacmlserver.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class DeleteSingleFileResponse {

    @JsonProperty("data")
    private Boolean data;

    @JsonProperty("message")
    private String message;

    public DeleteSingleFileResponse(Boolean isSuccess) {
        if(isSuccess) {
            this.data = true;
            this.message = "OK";
        } else  {
            this.data = false;
            this.message= "ERROR";
        }
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
