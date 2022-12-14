package cn.wwwwy.photo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-17
 */
@Data
@ApiModel(value = "Image对象", description = "图片表")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("图片名称")
    private String name;

    @ApiModelProperty("标签")
    private String tag;

    @ApiModelProperty("源文件地址")
    private String sourceUrl;

    @ApiModelProperty("预览地址")
    private String previewUrl;

    @ApiModelProperty("下载地址")
    private String downloadUrl;

}
