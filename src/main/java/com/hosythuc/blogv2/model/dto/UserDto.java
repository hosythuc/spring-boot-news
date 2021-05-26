package com.hosythuc.blogv2.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Builder
@Getter
@Setter
public class UserDto {
    private Integer id;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("password")
    @NotBlank(message = "It is not null")
    private String password;

    @JsonProperty("full_name")
    @NotBlank(message = "It is not null")
    private String fullName;

    @JsonIgnore
    private Integer status;

    private Date createdAt;

    private Date updatedAt;

}
