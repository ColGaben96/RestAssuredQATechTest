package com.visa.qa.restassuredswaggersb.data.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.visa.qa.restassuredswaggersb.data.common.Category;
import com.visa.qa.restassuredswaggersb.data.common.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pet {
    private Long id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String stats;
}
