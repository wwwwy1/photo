package cn.wwwwy.photo.controller;

import cn.hutool.core.img.Img;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.wwwwy.photo.config.UploadConfig;
import cn.wwwwy.photo.entity.Image;
import cn.wwwwy.photo.handler.GlobalExceptionHandler;
import cn.wwwwy.photo.service.IImageService;
import cn.wwwwy.photo.util.ResultBody;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

import org.apache.commons.io.FileUtils;
/**
 * <p>
 * 图片表 前端控制器
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-17
 */
@RestController
@RequestMapping("/system/image")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    @Autowired
    private IImageService imageService;

    @Autowired
    private UploadConfig uploadConfig;

    @GetMapping("batchSave")
    public Object batchSave(@RequestBody List<Image> imageList){
        imageService.saveBatch(imageList);
        return imageList;
    }

    @GetMapping("getPage")
    public Object getPage(@RequestParam(value = "pageStart",required = false,defaultValue = "1") Integer pageStart,
                       @RequestParam(value = "pageLimit",required = false,defaultValue = "5") Integer pageLimit){
        Page<Image> pageParam = new Page<>(pageStart,pageLimit);
        return ResultBody.success(imageService.page(pageParam));
    }

    @GetMapping("getList")
    public Object getList(){
        return ResultBody.success(imageService.list());
    }

    @GetMapping("getPageParam")
    public Object getPageParam(@RequestParam(value = "pageStart",required = false,defaultValue = "1") Integer pageStart,
                       @RequestParam(value = "pageLimit",required = false,defaultValue = "5") Integer pageLimit){
        Page<Image> pageParam = new Page<>(pageStart,pageLimit);
        QueryWrapper<Image> wrapper = new QueryWrapper<>();
        return imageService.page(pageParam,wrapper.lambda().eq(Image::getName,"xx"));
    }

    @RequestMapping("/uploadImage")
    @ResponseBody
    public Object editormdPic(@RequestParam(value = "editormd-image-file", required = false) List<MultipartFile> fileList, HttpServletRequest request) throws Exception {
        if (CollectionUtils.isEmpty(fileList)){
            return ResultBody.error();
        }
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            Image image = new Image();
            // 源文件名
            String originalFilename = file.getOriginalFilename();
            // 获取文件名
            String filename = originalFilename.substring(0,originalFilename.lastIndexOf("."));
            // 获取文件的后缀
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.fastUUID() + suffixName;
            image.setName(filename);
            image.setSourceUrl(uploadConfig.getImgUploadUrl(newFileName));
            image.setDownloadUrl(uploadConfig.getImgDownloadUrl(newFileName));
            image.setPreviewUrl(uploadConfig.getImgPreviewUrl(newFileName));

            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(uploadConfig.getImgUploadUrl(newFileName)));
                // 文件压缩
                Img.from(FileUtil.file(image.getSourceUrl()))
                        //压缩比例
                        .setQuality(0.3)
                        .write(FileUtil.file(image.getPreviewUrl()));

                imageList.add(image);
            } catch (Exception e) {
                logger.error("图片上传失败：" + e.getMessage());
                return ResultBody.error();
            }
            imageService.saveBatch(imageList);
        }
        return ResultBody.success();
    }
}
