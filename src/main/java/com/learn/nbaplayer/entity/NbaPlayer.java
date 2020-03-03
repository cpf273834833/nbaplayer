package com.learn.nbaplayer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;

/**
 * @author chengpengfei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "nba",type = "_doc",shards = 1, replicas = 0)
public class NbaPlayer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 国家
     */
    @Field(type = FieldType.Text)
    private String country;

    /**
     * 国家英文
     */
    @Field(type = FieldType.Text)
    private String countryEn;

    /**
     * 代码
     */
    @Field(type = FieldType.Keyword)
    private String code;

    /**
     * 所属国家
     */
    @Field(type = FieldType.Text)
    private String displayAffiliation;

    /**
     * 姓名
     */
    @Field(type = FieldType.Text)
    private String displayName;

    /**
     * 入队时间
     */
    private Integer draft;

    /**
     * 学历
     */
    private String schoolType;

    /**
     * 体重
     */
    private String weight;

    /**
     * 打球时间
     */
    private Integer playYear;

    /**
     * 球号
     */
    @Field(type = FieldType.Integer)
    private String jerseyNo;

    /**
     * 生日毫秒
     */
    private Long birthDay;

    /**
     * 生日字符串
     */
    private String birthDayStr;

    @Field(type = FieldType.Text)
    private String displayNameEn;

    /**
     * 位置
     */
    private String position;

    /**
     * 身高
     */
    private Double heightValue;

    /**
     * 球员id
     */
    private String playerId;

    /**
     * 球队城市
     */
    private String teamCity;

    /**
     * 球队城市英文
     */
    private String teamCityEn;

    /**
     * 球队名称
     */
    private String teamName;

    /**
     * 球队名称英文
     */
    private String teamNameEn;

    /**
     * 所属区
     */
    private String teamConference;

    /**
     * 所属区英文
     */
    @Field(type = FieldType.Keyword)
    private String teamConferenceEn;

    /**
     * 年龄
     */
    @Field(type = FieldType.Keyword)
    private Integer age;
}
