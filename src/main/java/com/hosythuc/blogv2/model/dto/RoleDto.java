package com.hosythuc.blogv2.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {
    private Integer id;
    private String name;
    private String description;
}
