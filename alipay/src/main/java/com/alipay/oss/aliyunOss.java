package com.alipay.oss;


import com.alipay.utils.OssUtil;
import org.springframework.core.io.ClassPathResource;

public class aliyunOss {
    public static void main(String[] args) {
        OssUtil ossUtil = new OssUtil();
        String path = new ClassPathResource("/images/git.png").getPath();
        ossUtil.upload("src/main/resources/images/git.png");
    }

}
