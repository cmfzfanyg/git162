package com.baizhi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.baizhi.util.ImageCodeUtil.getSecurityCode;

public class testcode {
    //测试
    public static void main(String[] args) throws IOException {
        //获得随机字符
        String securityCode = getSecurityCode();
        //打印随机字符
        System.out.println("===="+securityCode);
        //生成图片
        //BufferedImage image = createImage(securityCode);
        //将生成的验证码图片以png(1.png)的格式输出到D盘        "D:\\1.png"   ==  "D:/1.png"
       // ImageIO.write(image, "png", new FileOutputStream(new File("D:\\4.png")));
    }

}
