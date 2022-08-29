package cn.wwwwy.photo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 图片组
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-29
 */
@Data
@TableName("image_group")
@ApiModel(value = "ImageGroup对象", description = "图片组")
public class ImageGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("图片名称")
    private String name;

    @ApiModelProperty("预览地址")
    private String previewUrl;

}
