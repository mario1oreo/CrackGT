package com.mario.projects.CrackGT;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;

import com.luciad.imageio.webp.WebPReadParam;

/**
 * 
 * <p>
 * description: geeTest 滑块验证码处理
 * </p>
 * 
 * @author MaXin
 * @since 2017-2-19 12:53:10
 * @see
 */
public class GeeTestImageHandle {

    public static final int[] INDEX_ARR = { 39, 38, 48, 49, 41, 40, 46, 47, 35, 34, 50, 51, 33, 32, 28, 29, 27, 26, 36, 37, 31, 30, 44, 45, 43, 42, 12, 13, 23, 22, 14, 15, 21, 20, 8, 9, 25, 24, 6, 7,
            3, 2, 0, 1, 11, 10, 4, 5, 19, 18, 16, 17 };

    public static final int[] SORT_IMAGE = { 17, 16, 14, 15, 21, 20, 13, 12, 9, 8, 18, 19, 1, 0, 5, 4, 25, 24, 22, 23, 6, 7, 2, 3, 10, 11, 42, 43, 41, 40, 46, 47, 38, 39, 34, 35, 45, 44, 26, 27, 30,
            31, 50, 51, 49, 48, 33, 32, 29, 28, 37, 36 };

    public static List<int[]> topLeftPointList = new ArrayList<int[]>();

    static {
        topLeftPointList.add(new int[] { 157, 58 });
        topLeftPointList.add(new int[] { 145, 58 });
        topLeftPointList.add(new int[] { 265, 58 });
        topLeftPointList.add(new int[] { 277, 58 });
        topLeftPointList.add(new int[] { 181, 58 });
        topLeftPointList.add(new int[] { 169, 58 });
        topLeftPointList.add(new int[] { 241, 58 });
        topLeftPointList.add(new int[] { 253, 58 });
        topLeftPointList.add(new int[] { 109, 58 });
        topLeftPointList.add(new int[] { 97, 58 });
        topLeftPointList.add(new int[] { 289, 58 });
        topLeftPointList.add(new int[] { 301, 58 });
        topLeftPointList.add(new int[] { 85, 58 });
        topLeftPointList.add(new int[] { 73, 58 });
        topLeftPointList.add(new int[] { 25, 58 });
        topLeftPointList.add(new int[] { 37, 58 });
        topLeftPointList.add(new int[] { 13, 58 });
        topLeftPointList.add(new int[] { 1, 58 });
        topLeftPointList.add(new int[] { 121, 58 });
        topLeftPointList.add(new int[] { 133, 58 });
        topLeftPointList.add(new int[] { 61, 58 });
        topLeftPointList.add(new int[] { 49, 58 });
        topLeftPointList.add(new int[] { 217, 58 });
        topLeftPointList.add(new int[] { 229, 58 });
        topLeftPointList.add(new int[] { 205, 58 });
        topLeftPointList.add(new int[] { 193, 58 });
        topLeftPointList.add(new int[] { 145, 0 });
        topLeftPointList.add(new int[] { 157, 0 });
        topLeftPointList.add(new int[] { 277, 0 });
        topLeftPointList.add(new int[] { 265, 0 });
        topLeftPointList.add(new int[] { 169, 0 });
        topLeftPointList.add(new int[] { 181, 0 });
        topLeftPointList.add(new int[] { 253, 0 });
        topLeftPointList.add(new int[] { 241, 0 });
        topLeftPointList.add(new int[] { 97, 0 });
        topLeftPointList.add(new int[] { 109, 0 });
        topLeftPointList.add(new int[] { 301, 0 });
        topLeftPointList.add(new int[] { 289, 0 });
        topLeftPointList.add(new int[] { 73, 0 });
        topLeftPointList.add(new int[] { 85, 0 });
        topLeftPointList.add(new int[] { 37, 0 });
        topLeftPointList.add(new int[] { 25, 0 });
        topLeftPointList.add(new int[] { 1, 0 });
        topLeftPointList.add(new int[] { 13, 0 });
        topLeftPointList.add(new int[] { 133, 0 });
        topLeftPointList.add(new int[] { 121, 0 });
        topLeftPointList.add(new int[] { 49, 0 });
        topLeftPointList.add(new int[] { 61, 0 });
        topLeftPointList.add(new int[] { 229, 0 });
        topLeftPointList.add(new int[] { 217, 0 });
        topLeftPointList.add(new int[] { 193, 0 });
        topLeftPointList.add(new int[] { 205, 0 });
    }

    public static int findXDiffRectangeOfTwoImage(String imgSrc1, String imgSrc2) {
        try {
            BufferedImage image1 = ImageIO.read(new File(imgSrc1));
            BufferedImage image2 = ImageIO.read(new File(imgSrc2));
            int width1 = image1.getWidth();
            int height1 = image1.getHeight();
            int width2 = image2.getWidth();
            int height2 = image2.getHeight();

            if (width1 != width2)
                return -1;
            if (height1 != height2)
                return -1;

            int left = 0;
            /**
             * 从左至右扫描
             */
            boolean flag = false;
            for (int i = 0; i < width1; i++) {
                for (int j = 0; j < height1; j++)
                    if (isPixelNotEqual(image1, image2, i, j)) {
                        left = i;
                        flag = true;
                        break;
                    }
                if (flag)
                    break;
            }
            return left;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    private static boolean isPixelNotEqual(BufferedImage image1, BufferedImage image2, int i, int j) {
        int pixel1 = image1.getRGB(i, j);
        int pixel2 = image2.getRGB(i, j);

        int[] rgb1 = new int[3];
        rgb1[0] = (pixel1 & 0xff0000) >> 16;
        rgb1[1] = (pixel1 & 0xff00) >> 8;
        rgb1[2] = (pixel1 & 0xff);

        int[] rgb2 = new int[3];
        rgb2[0] = (pixel2 & 0xff0000) >> 16;
        rgb2[1] = (pixel2 & 0xff00) >> 8;
        rgb2[2] = (pixel2 & 0xff);

        for (int k = 0; k < 3; k++)
            if (Math.abs(rgb1[k] - rgb2[k]) > 50)                 // 因为背景图会有一些像素差异
                return true;

        return false;
    }

    @Deprecated
    public static List<String> imageCut(String imageFilePath, int rows, int cols) {
        List<String> imageFilePathList = new ArrayList<String>();
        BufferedImage image = null;
        if (imageFilePath.trim().toLowerCase().startsWith("http")) {
            try {
                image = ImageIO.read(new URL(imageFilePath));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (imageFilePath.trim().toLowerCase().endsWith("webp")) {
            try {
                ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

                // Configure decoding parameters
                WebPReadParam readParam = new WebPReadParam();
                readParam.setBypassFiltering(true);

                // Configure the input on the ImageReader
                reader.setInput(new FileImageInputStream(new File(imageFilePath)));

                // Decode the image
                image = reader.read(0, readParam);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                image = ImageIO.read(new File(imageFilePath));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (image == null) {
            return imageFilePathList;
        }

        int chunks = rows * cols;

        int chunkWidth = image.getWidth() / cols; // 计算每一块小图片的高度和宽度
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // 初始化BufferedImage
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // 画出每一小块图片
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        System.out.println("切分完成");

        // 保存小图片到文件中
        String preFilePath = "C:/tmp/testwebp-" + UUID.randomUUID() + "-";
        for (int i = 0; i < imgs.length; i++) {
            try {
                String filePath = preFilePath + i + ".bmp";
                ImageIO.write(imgs[i], "bmp", new File(filePath));
                imageFilePathList.add(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageFilePathList;
    }

    public static String getGeetestImg(String pathName, List<int[]> imgArray) throws IOException {
        BufferedImage image = null;
        if (pathName.trim().toLowerCase().startsWith("http")) {
            try {
                image = ImageIO.read(new URL(pathName));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (pathName.trim().toLowerCase().endsWith("webp")) {
            try {
                ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

                // Configure decoding parameters
                WebPReadParam readParam = new WebPReadParam();
                readParam.setBypassFiltering(true);

                // Configure the input on the ImageReader
                reader.setInput(new FileImageInputStream(new File(pathName)));

                // Decode the image
                image = reader.read(0, readParam);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                image = ImageIO.read(new File(pathName));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        List<BufferedImage> list = new ArrayList<BufferedImage>();
        for (int i = 0; i < imgArray.size(); i++) {
            BufferedImage subimage = image.getSubimage(imgArray.get(i)[0], imgArray.get(i)[1], 10, 58);
            list.add(subimage);
            // ImageIO.write(subimage, "jpg", new
            // File("d:\\image\\imgs"+i+".jpg"));
        }
        BufferedImage mergeImageUp = null;
        BufferedImage mergeImageDown = null;
        int mid = list.size() >>> 1;
        for (int i = 0; i < mid - 1; i++) {
            mergeImageUp = mergeImage(mergeImageUp == null ? list.get(i) : mergeImageUp, list.get(i + 1), true);
        }
        for (int i = mid; i < list.size() - 1; i++) {
            mergeImageDown = mergeImage(mergeImageDown == null ? list.get(i) : mergeImageDown, list.get(i + 1), true);
        }
        image = mergeImage(mergeImageUp, mergeImageDown, false);
        File file = new File("/image/fullImage-" + System.currentTimeMillis() + ".bmp");
        System.out.println("export image Path:" + file.getAbsolutePath());
        ImageIO.write(image, "bmp", file);
        return file.getAbsolutePath();
    }

    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, boolean isHorizontal) throws IOException {
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();
        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
        int[] ImageArrayTwo = new int[w2 * h2];
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1 + w2, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2);
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2,
                    BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }

        return DestImage;
    }

    public static int getOffSet(String bgImage, String frontImage) throws IOException {
        String bgImageFile = GeeTestImageHandle.getGeetestImg(bgImage, topLeftPointList);
        String frontImageFile = GeeTestImageHandle.getGeetestImg(frontImage, topLeftPointList);
        int offSet = GeeTestImageHandle.findXDiffRectangeOfTwoImage(bgImageFile, frontImageFile);
        return offSet;
    }

    public static void main(String[] args) throws IOException {
        // http://static.geetest.com/pictures/gt/1aa043de0/bg/8fc25406.webp
        String bgImageFile = GeeTestImageHandle.getGeetestImg("http://static.geetest.com/pictures/gt/5ff6ca480/bg/876354f1.jpg", topLeftPointList);
        String imageFile = GeeTestImageHandle.getGeetestImg("http://static.geetest.com/pictures/gt/5ff6ca480/5ff6ca480.jpg", topLeftPointList);
        // geeTesthandle.getGeetestImg("E:\\HFS\\pictures\\gt\\e6e7e0440\\e6e7e0440.webp",topLeftPointList);
        // geeTesthandle.getGeetestImg("E:\\HFS\\pictures\\gt\\e6e7e0440\\bg\\67e608856.webp",topLeftPointList);
        System.out.println(GeeTestImageHandle.findXDiffRectangeOfTwoImage(bgImageFile, imageFile));
    }
}
