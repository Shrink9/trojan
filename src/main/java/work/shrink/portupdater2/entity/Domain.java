package work.shrink.portupdater2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 域名表
 * @TableName domain
 */
@TableName(value ="domain")
@Data
public class Domain implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 域名
     */
    private String value;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}