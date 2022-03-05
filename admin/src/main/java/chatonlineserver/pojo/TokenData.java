package chatonlineserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tokendata")
@ApiModel(value="tokendata对象", description="token表")
public class TokenData implements Serializable {
    @TableId(value = "token_id",type = IdType.ASSIGN_ID)
    @ApiModelProperty("token的id号")
    private Integer token_id;
    @TableField("access_token")
    private String access_token;
    @TableField("expire_token")
    private String expire_token;
    @TableField("create_time")
    private Date create_time;
}
