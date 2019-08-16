package com.alipay.config;

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

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092800616584";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1T5sWb66jvOFcygtI4y21Yx0tl35YwCsb32+Lv6wDhnk1+xPbs2AlsKrpmN6JS9WPomqdfQq96NyQd3EvroFtYIJThbSJvyXGBehfWKqyW4PMoB4KCP5J/OEg/H6CevNbz8r2L0TsyftxxaNYQjv66iAg763smaGLiqd28ntZcs1JkJt7tnYt4U5zOZ/doZg6iQpeLo3gqz70EhLHR6wC/hhrpIy9qdniAodc9/8ECP7t9fH4+03qA44749e1g3dMTTBaXXzFwJJoYDcxLJMn7Kg3YuW6H+JeBbGY3SEn/SR1YGpCXgVZ6yuiCJ9VdPc0SIIrZs76+9ueNaf8WxTpAgMBAAECggEAPNKMozUp77GwJDF/IZ9cOQobwqycbOdiTsJgqA/Pg4s75DjrC3ucGGiwnRZ0KLiw1rNUcqp8zQJt42S+KpGux2NltOEYlFD0Of7HWhzjflum1iEsko87xtQ3LZqmUd0vADCv1HA8/fYwDJWRW00009Jwnrvoq4NKJwaHcSac7H8+MzIxsssVLwv+ELJPPlC6IKDmqSiBptskeUlnn+6Xz1x6Q7Qv/0Bk1WQixTc5zvj8JRvKchC5L6qyHBWqTEAwsV1mNWwGQK+ZPDKNOpkqYHrfbsFESNeXevBrB4Exig+4x/yxMnM6QfbmHJ0qlOHEGfLzHGeiaS6eo3Gb4CuUkQKBgQDvna4uGIQwTW4eeE3hJKkh9QNzNJWml0k3bHYcZtD18K2jZgMNLY/L6uds5AWwfjf45MFHt2lw1ZLzL7SPuP43mdKJgB0FNQ4vtmjqD3Bzbu4y+dsqQte5MDskq8P6sGunZ9fcFJKv/GupRvpJX5EmZJ/kSsMiaBk3wu/qkYbgXQKBgQDBtVXG6LZmsFtfnuFEDd6YR8rKCSeAdpaoZwSrRGMDFmXpCDXriRBmgtODKYtHFGdExj12MjV/gG41o9HF4rYHB5Ad/8dYx/NlhvFblKLhHYcpwTIicmeD5LlyBF9jYB0YB8CY5tE6l722UXgxHgwMA51tA41LwOc64eUoiSst/QKBgEjVxElMuHm6P5vRc9LZAvRIdskBFfAyklXfiTNu6Vuo0g8WBh1uWQRiHgCSe0w/waHNXxb+oHVk5is3uAnr8JJUFpQnNisMCojkSJXFJahg8tTZ8A2zjcFD8OZfs82y7LZRMWM7ea826j7lTVUaUJO8CIIrW49M10WE4sqJe9cdAoGBALHOfs8Xe56lESqjj0lFpeaIN8feQUk1EbPA5FNFcdE6tQ8Dv2LVrJ08R2SlNLhpLSW/BlnBWsQPoppQJlULdmTbd1liGJ0Q5QVzqYaT2DLlRNV6BkgCVayGvga/psN0TSBqtUpkzPeIo9Z/z+DeINbCVrXjRcacamPtSMk9p8oNAoGBALWHUv/i3RUwMZZMUu6uqJkfQ+QliwZO2y+vDnY+kd6/2E3mxwuUDUQMTTsE/qE0g9teaFIzaFclB/awJqG0+MpdwSCavtIKA0lRY0H2fMvf9Q1jfcFJfZ06+DCqmzTfDZy+tdC5JulgacoCdfbsDmkewMc/0jg4JWJmf67pz9eY";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoIfwW5K6Xrz/W2/E7866kWiLTTg/MxvsqTk/LYahOh5QIwWAi+WHFtLWuQheWdph/fMXBKMmnNYk6ZQL/LIi+j6UFj2Xn6mKVgfZ5tyVXPKnT+UW7pRTkjyCcggUA3POz2YGQeaN+TOCOGWnC2Jjc5Zoe+0Xv6RgG7fq9XRWpqhO4FTjV3DEoJCG0wvxOIZoSgoUJAkBJ/gPmifAB7UIgjta5NZJa3Tq+pzRv0psKipWVAQeC49pgB+ab9sGCzBOtclNYsWPEjFkBJjHkpKQlzQxZFwii/f0ojPrMyb6BH6dAew39eH7PK+EB/80vYbZqMET6QBtBIJnKpneZEXY5QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8086/success";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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

