package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Example)实体类
 *
 * @author code generation
 * @date 2019-11-22 20:33:06
 * @since JDK1.8
 */

@Getter
@Setter
@ToString
@TableName("example")
public class ExampleEntity implements Serializable {
    private static final long serialVersionUID = -81708271980793927L;

    @TableId
    private String id;

    @ApiModelProperty(name = "phone", value = "电话号码")
    private String phone;

    @ApiModelProperty(name = "userName", value = "用户名")
    private String userName;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}