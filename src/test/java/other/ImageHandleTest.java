package other;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * 处理图片信息
 *
 * @author zetu
 * @date 2022/6/27
 */
public class ImageHandleTest {

    @Test
    public void handleImage() {
        String imgUrl = "https://img.alicdn.com/bao/uploaded/i2/118211378/O1CN01hfHNgZ1M3AXMBliHd_!!118211378.jpg_30x30.jpg";
        System.out.println(handleProp(imgUrl));
    }

    private String handleProp(String imgUrl) {
        if (StringUtils.isBlank(imgUrl)) {
            return "";
        }
        if (imgUrl.contains("ae01")) {
            return imgUrl;
        }
        if (imgUrl.toLowerCase().contains(".alicdn.") ||
                imgUrl.toLowerCase().contains(".taobaocdn.") ||
                imgUrl.toLowerCase().contains(".tbsandbox.")
        ) {
            int jpgIndex = imgUrl.toLowerCase().indexOf(".jpg_");
            if (jpgIndex == -1) {
                jpgIndex = imgUrl.toLowerCase().indexOf(".png_");
            }
            if (jpgIndex > 0) {
                return imgUrl.substring(0, jpgIndex + 4);
            }
            return imgUrl;
        }

        return imgUrl;
    }

    // try {
    //        if (
    //            srcImg.toLowerCase().indexOf('.alicdn.') !== -1 ||
    //            srcImg.toLowerCase().indexOf('.taobaocdn.') !== -1 ||
    //            srcImg.toLowerCase().indexOf('.tbsandbox.') !== -1
    //        ) {
    //            let jpgIndex = srcImg.toLowerCase().indexOf('.jpg_')
    //
    //            if (jpgIndex === -1) {
    //                jpgIndex = srcImg.toLowerCase().indexOf('.png_')
    //            }
    //
    //            if (jpgIndex > 0) {
    //                if (size > 0) {
    //                    return `${srcImg.substring(0, jpgIndex + 5) + size}x${size}.jpg`
    //                } else {
    //                    return srcImg.substring(0, jpgIndex + 4)
    //                }
    //            } else {
    //                if (srcImg.toLowerCase().endsWith('.310x310.jpg') || srcImg.toLowerCase().endsWith('.310x310.png')) {
    //                    return srcImg
    //                }
    //
    //                let index = srcImg.toLowerCase().indexOf('_M2.SS2_')
    //
    //                if (index > 0 && size > 0) {
    //                    return `${srcImg.substring(0, index + '_M2.SS2_'.length) + size}x${size}.jpg`
    //                } else if (index > 0) {
    //                    return srcImg
    //                }
    //
    //                let pointIndex = srcImg.lastIndexOf('.')
    //
    //                if (pointIndex > 0) {
    //                    let fileExt = srcImg.substring(pointIndex)
    //
    //                    if (fileExt !== null && (fileExt.toLowerCase() === '.jpg' || fileExt.toLowerCase() === '.png')) {
    //                        let srcImg2 = srcImg.substring(0, pointIndex)
    //                        let sizeIndex = srcImg2.lastIndexOf('_')
    //                        let pointIndex2 = srcImg2.lastIndexOf('.')
    //
    //                        if (pointIndex2 > sizeIndex) {
    //                            sizeIndex = pointIndex2
    //                        }
    //
    //                        if (sizeIndex > 0) {
    //                            let sizeTxt = srcImg2.substring(sizeIndex + 1)
    //                            let sizes = sizeTxt.toLowerCase().split('x')
    //                            let _size = 0
    //
    //                            if (sizes.length === 2) {
    //                                if (Number(sizes[0]) && Number(sizes[1])) {
    //                                    if (size) {
    //                                        return `${srcImg2.substring(0, sizeIndex + 1) + size}x${size}${fileExt}`
    //                                    } else {
    //                                        // 去掉参数
    //                                        return `${srcImg2.substring(0, sizeIndex)}${fileExt}`
    //                                    }
    //                                }
    //                            }
    //                        }
    //                    }
    //                }
    //
    //                // 阿里巴巴国际站 60规格的不存在 兼容为50
    //                if (
    //                    srcImg.toLowerCase().indexOf('.alicdn.com/kf/') != -1 &&
    //                    (size === 60 || size === 90 || size === 400)
    //                ) {
    //                    switch (size) {
    //                        case 60:
    //                            size = 50
    //                            if (srcImg.startsWith('//')) {
    //                                srcImg = `http:${srcImg}`
    //                            }
    //                            break
    //                        case 90:
    //                        case 400:
    //                            return srcImg
    //                        default:
    //                            break
    //                    }
    //                }
    //
    //                if (size) {
    //                    return `${srcImg}_${size}x${size}.jpg`
    //                }
    //            }
    //        }
    //
    //        return srcImg
    //    } catch (error) {
    //        Sentry.setExtra('extra', {
    //            data: {
    //                srcImg: JSON.stringify(srcImg)
    //            },
    //            error
    //        })
    //        Sentry.captureException(new Error('erp 图片转化方法错误'))
    //
    //        console.log('error', error, srcImg)
    //        return srcImg
    //    }
}
