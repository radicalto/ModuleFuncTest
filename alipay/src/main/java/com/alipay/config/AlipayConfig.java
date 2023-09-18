package com.alipay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
//@PropertySource(value = "classpath:application.yml")
//@Component
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//    @Value("${alipay.user.app_id}")
    public static String app_id = "9021000128625868";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCnpCvcgehw5NmIpYu5g8NBy2W/qhW/NhKfZH/DngjG00UfduY8V52ZM8gvdJAIB0LC2aK0IAU8hlLrx6d1ZYSQGPY9xakNNgDlr6Nxzns3d8vs3tXGlSaABrIgI00t4kGabqxXKYmC8sdeVEZTSnl11JDrT+5WYzZljJHD0wPeo91NYPhxCyklDar2vKTAW6L6RqyDvCDMPmU/yRhxApz5msJVmISkBnschFNwf+j9RtxcTz/D3XLVan/QAclYW7RvJAnRgwe3J2HER1RQTdE737lDyQlV17VSs20uipvRPJQKLmtvXrEQTORkkyB5aIWBAGQRg1m46hG2QyXZAUaFAgMBAAECggEAUgAq+ESPJ1G52m5np0n9Y5yTW6pd0tcnStJE8LHHx0GmiRqGyjNtQngizpusrFCo5ljAjm0vQojN3Mkfb3xF2JptMJAT/gNRcwhz4YJHoT03AdmKJgXk/DDKRpAd+3i18E18fXIy8lvBC7IbaDiAqxNcA85oXddPz2JwFqKMPQWK7URYiTQyy5n6AD8GGLXRSF2ziaDGfu+8/l1AcaEZtwpX8UDqBuDqQaJkRoiBSvDVhDICGWEUbf40Uhy2E2JPcX856UD6yFJKKDvn2JLP1SW69HMdL/22rDN2hgzlXThw5o10ZNU4x/EBv/lq/hCM2dMaT9IF5Tn34ZTBZ8p5bQKBgQD1fjvnD5TY1+Tkb8S+xxIRZDgzQYIMRfMxkVfXeFcWGCg+Ary6l1nvzvz1O8MF/7MENZwVNUm1Qu6cVOhypnqDRJMrMDHFQZCHqmN79j8mRMTzD9imZgRBuXkAqGltfZWZrpRuvEvhQftgp5zuvPuwE48t8yQS3ggCQvbatLhvrwKBgQCu0PKJFUWh5MdunCuelUQnho5oFCNyjzQ6NHlD2u05HTJJlWGWs99lgHT2JNsbMufPpWXisqW98muD55HLagdPPgOO31PtM2cPrncBoF3mQoy48e+fa5UTzUdGdarmfF2EDnzvbs5gcWfWWeOKLsDOB5maNHlgZkadyt1tVyemCwKBgFMdBdLYp6Ayl7/vR0D/zNIuiAhyaUEWfZuOhZrhlzpXu2gjLRpPG5fhECtGrGRfiZAnRky32diQbJBo/rmyO1At61V336HU7MXBniTd3ctrBPL1rnfHmjFWRe0/F1KGbhu1y3MiNN5ypFS46py5Rsz6EkOQSepJWZTKbyDkhnzpAoGAJLAhVneqZ3GWETahSOTWqtzoYhtn3REEyvpcQMtfYc8o0JyTIIebaLfu1AGkIi8qyz9RBKSteBG6UrJ0vJYB9rVzFbb07CEPjhD1VNgNHNf2pJHR0klHviIkxTrIpRqQnbhUrAM7OK5UNn4i7MsnF5YsvFoq5vpP86mxktLptUUCgYEAkXWmCg11X0v7sjfSApQZHeFJfOH0dVJ2IxjCuSDED0PPBQpf3gKOTpfzpqbRJR9FlAtog6L/EeEEsXyL4Wiyg7q+NzQxQaBqbDFw9ErfxP1zqt9vNMtWVe005HkSYxZwI6ZaB4U83TipQDDRrp7ykkedc3lic/mimywjL06iD88=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5/85zxRDmja7zRRS6Bg4oeO1dRX0pqbQRQA5yFZTzCO2S6z4DFzUf2EsBR+DR3Jb7bPiKlp+QnDDFvwo4NLs7wYN0D44C6d/2Judxnys0rW2mHhO426Grz3T1dLwKWxCCpYRyUidhNC5EVZOJvgIsrWyaJmkOHDYGzdKrpTq4p2wRsHx+8XssjYIjs6xwyYzHNVoUoW8o5uWTJvEpc95iqpFFE0M55bE9WUF3zIs9sR9Q51bHF3M2NT2q3DrGjQjdFoHKTn32LSRo13z3rgk2PSyhU0hHrkFLhEPNdhDUDYNY25jBRhYOkcPbIlBOP2eTuQA1ufd0ajnKWxM6E9aHQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8080/callback/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8080/callback/return";
//    public static String return_url = "http://127.0.0.1:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 日志目录
    public static String log_path = "./";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



