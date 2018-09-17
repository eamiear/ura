/**
 * @author eamiear
 * @date 2018/9/14 11:31
 */

package com.ura.common.filter;

import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.RGBImageFilter;

public class ImageAlphaFilter extends RGBImageFilter {
    // 继承它实现图象ARGB的处理
    int alpha = 0;

    public ImageAlphaFilter(int alpha) {// 构造器，用来接收需要过滤图象的尺寸，以及透明度
        this.canFilterIndexColorModel = true;
        // TransparentImageFilter类继承自RGBImageFilter，它的构造函数要求传入原始图象的宽度和高度。
        // 该类实现了filterRGB抽象函数
        // ，缺省的方式下，该函数将x，y所标识的象素的ARGB值传入，程序员按照一定的程序逻辑处理后返回该象素新的ARGB值
        this.alpha = alpha;
    }

    public int filterRGB(int x, int y, int rgb) {
        DirectColorModel dcm = (DirectColorModel) ColorModel.getRGBdefault();
        // DirectColorModel类用来将ARGB值独立分解出来
        int red = dcm.getRed(rgb);
        int green = dcm.getGreen(rgb);
        int blue = dcm.getBlue(rgb);
        int alp = dcm.getAlpha(rgb);

        if (red == 255 && blue == 255 && green == 255) {// 如果像素为白色，则让它透明
            alpha = 0;
        } else {
            alpha = 255;
        }
        return alpha << 24 | red << 16 | green << 8 | blue;// 进行标准ARGB输出以实现图象过滤
    }
}
