package cn.wwwwy.photo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-17
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "Image{" +
            "id = " + id +
            ", name = " + name +
            ", tag = " + tag +
            ", sourceUrl = " + sourceUrl +
            ", previewUrl = " + previewUrl +
            ", downloadUrl = " + downloadUrl +
        "}";
    }
}
