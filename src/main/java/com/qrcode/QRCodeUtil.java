package com.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.print.PngPrintable;
import com.print.PrintUtil;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

/**
 * Created by fz on 2016/3/31.
 */
public class QRCodeUtil {

    // 二维码属性
    private static Hashtable ht = new Hashtable(){{
        put(EncodeHintType.CHARACTER_SET, "utf-8");
        put(EncodeHintType.MARGIN, 1);
    }};

    // 黑白像素
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    // bit矩阵 转换为 缓存图片
    public static BufferedImage createQRCodePngImg(String url, int width, int height) throws Exception {

        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, ht);
        return toBufferedImage(bitMatrix);
    }

    // 将bit矩阵 转换为 黑白像素
    private static BufferedImage toBufferedImage(BitMatrix matrix) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void easyQRCodePrint(String url) throws Exception {

        int width = 65;
        int height = 65;
        int x = 0;
        int y = 0;
        BufferedImage image = createQRCodePngImg(url, width, height);
        PngPrintable pngPrintable = new PngPrintable(image, x, y, width, height);
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new MediaPrintableArea(0f, 0f, width, height, MediaPrintableArea.INCH));
        PrintUtil.printPrintable(pras, pngPrintable);
    }

    public static void main(String[] args) throws Exception {

        easyQRCodePrint("http://www.baidu.com/");
    }

}
