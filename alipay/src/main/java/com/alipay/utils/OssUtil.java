package com.alipay.utils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OssUtil {
        // Endpoint以北京为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        // 这个是设置了用户
        String accessKeyId = "<your:accessKeyId>";
        String accessKeySecret = "<your:accessKeySecret>";

        String bucketName = "<your:bucketName>";



        public void create() {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            boolean exists = ossClient.doesBucketExist(bucketName);
            System.out.println("exists = " + exists);
            if (exists == false) { //判定是否存在此存储空间
                // 创建存储空间。
                ossClient.createBucket(bucketName);
            }
            ossClient.shutdown();
        }

        public void upload(String filePath){
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件流。
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            ossClient.putObject(bucketName, "upload/1.png", inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();
        }

    }
