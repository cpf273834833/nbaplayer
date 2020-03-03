package com.learn.nbaplayer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "nba",type = "_doc",shards = 1, replicas = 0)
public class NbaPlayer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String country;
    private String countryEn;
    @Field(type = FieldType.Keyword)
    private String code;
    private String displayAffiliation;
    private String displayName;
    private Integer draft;
    private String schoolType;
    private String weight;
    private Integer playYear;
    @Field(type = FieldType.Integer)
    private String jerseyNo;
    private Long birthDay;
    private String birthDayStr;
    private String displayNameEn;
    private String position;
    private Double heightValue;
    private String playerId;
    private String teamCity;
    private String teamCityEn;
    private String teamName;
    private String teamNameEn;
    private String teamConference;
    @Field(type = FieldType.Keyword)
    private String teamConferenceEn;
    @Field(type = FieldType.Keyword)
    private Integer age;
}
