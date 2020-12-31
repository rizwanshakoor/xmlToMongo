package com.thesis.admin.xacmlserver.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class DataObject {

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("fileName")
    private String fileName;

    @Lob
    @JsonProperty("xmlContent")
    private String xmlContent;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
