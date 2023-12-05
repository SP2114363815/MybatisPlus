package com.shaopeng.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
//@TableName//可以不加，默认使用实体类的名字作为表名！忽略大小写
          //BaseMapper ->User实体类 -》实体类的名 -》表名数据库操作
//数据库的表名和实体类命名不同（忽略大小写），使用@TableName("t_user")注解指定表名
//@TableName("t_user")
@Data
public class User {
    @TableId(type = IdType.AUTO)//主键自增长
    private Long id;
    @TableField(value ="name",exist = true)
    private String name;
    private Integer age;
    private String email;

   // @TableLogic //当前属性对应的列就是逻辑删除的状态字段
                //当你删除数据的时候，自动变成修改此列的值，默认0 未删除  1删除
                //当你查询数据的时候，默认只查询deleted=0
    private Integer deleted;
    @Version
    private Integer verson;
}

