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
 * 图片组文件
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-29
 */
@Data
@TableName("image_group_file")
@ApiModel(value = "ImageGroupFile对象", description = "图片组文件")
public class ImageGroupFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("图片组id")
    private Long groupId;

    @ApiModelProperty("图片名称")
    private String name;

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ImageGroupFile{" +
            "id = " + id +
            ", groupId = " + groupId +
            ", name = " + name +
            ", sourceUrl = " + sourceUrl +
            ", previewUrl = " + previewUrl +
            ", downloadUrl = " + downloadUrl +
        "}";
    }
}
