package cn.wwwwy.photo.service.impl;

import cn.wwwwy.photo.entity.Image;
import cn.wwwwy.photo.mapper.ImageMapper;
import cn.wwwwy.photo.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author wwwwy
 * @since 2022-08-17
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}
