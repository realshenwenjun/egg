package com.dskj.util;


import com.dskj.base.Base;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * <b>function:</b> 缩放图片工具类，创建缩略图、伸缩图片比例
 *
 * @author hoojo
 * @version 1.0
 * @createDate 2012-2-3 上午10:08:47
 * @file ScaleImageUtils.java
 * @package com.hoo.util
 */
public class ImageUtil extends Base {
    public static String TMP = "/usr/local/tomcat/temp/";
    private static final String DOT = ".";
    public static final int W = 640;
    public static final int H = 640;

    private String fileName;
    private String parentPath;
    private Image img;
    private int width;
    private int height;
    private String name;
    private String fileType;

    public ImageUtil(String fileName) throws Exception {
        this.fileName = fileName;
        String osName = System.getProperties().getProperty("os.name");
        if (osName.toLowerCase().contains("window")) {
            TMP = System.getProperties().getProperty(
                    "java.io.tmpdir");
            if (!TMP.endsWith("/"))
                TMP = TMP + "/";
        }
        fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        name = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf("."));
        String[] fileds = fileName.split("/");
        parentPath = fileds[fileds.length - 2];
        download(fileName, name + DOT + fileType);

        File file = new File(new StringBuffer(TMP).append(name).append(DOT).append(fileType).toString());// 读入文件
        img = ImageIO.read(file);      // 构造Image对象
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }

    /**
     * java 下载网络上的图片并保存到本地目录
     *
     * @param urlString 网路图片地址
     * @param filename  如：test.png
     * @throws Exception
     */
    public static void download(String urlString, String filename) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        String savePath = TMP + filename;
        File sf = new File(savePath);
        if (!sf.exists()) {
            sf.createNewFile();
        }
        OutputStream os = new FileOutputStream(sf.getAbsolutePath());
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    /**
     * 按照宽度还是高度进行压缩
     *
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public String resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return resizeByWidth(w);
        } else {
            return resizeByHeight(h);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     *
     * @param w int 新宽度
     */
    public String resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return resize(w, h);
    }

    /**
     * 以高度为基准，等比例缩放图片
     *
     * @param h int 新高度
     */
    public String resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     *
     * @param w int 新宽度
     * @param h int 新高度
     */
    public String resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        File desFile = new File(new StringBuffer(TMP).append(name).append("-small").append(DOT).append(fileType).toString());
        if (!desFile.exists())
            desFile.createNewFile();
        FileOutputStream out = new FileOutputStream(desFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();
        File sourceFile = new File(new StringBuffer(TMP).append(name).append(DOT).append(fileType).toString());
        if (sourceFile.exists())
            sourceFile.delete();
        return desFile.getAbsolutePath();
    }

    public String getParentPath() {
        return parentPath;
    }

}