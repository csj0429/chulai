package com.chulai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dictionary")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Dictionary {
    @Version
    @JsonIgnore
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "DictionaryGenerator")
    @TableGenerator(name = "DictionaryGenerator", table = "pk_generator",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "dictionary_pk",
            initialValue = 0,
            allocationSize = 1)
    private Long id;

    //类型
    private String type;

    //代码
    private String code;
    //标题
    private String title;
    //值
    private Integer value;

    //创建者
    private Long creator;

    //是否固定，固定的表示初始化的，不可修改，不固定的表示自定义的，可以修改的
    private Boolean fixed;
}
