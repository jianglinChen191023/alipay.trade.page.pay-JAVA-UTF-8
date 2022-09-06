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
    // 使用沙箱环境的 APPID
    public static String app_id = "2016100100642012";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSW8OKd+By+Ea7UP9yCbWtlhvr7QvgAfiG9joMwbZ+Zma2/YMOWaAPD6NowrnaNaNd9gWZB/qJ1oe5QAXUi4bi/J1n+1+T1giRSaFtpkfDeRBvKmTiSyYCeGk7aeT0FWODWQB7ZnPD9R6KCeJCVhzN2YmurNFHftiM1fFcRHUNb5Daw0m7xKrOebQwMIk7K3at5a/Yd5nMUcOqoUOKTXMjxXSW6CnFXMCirPhg/e5aAMD+GiOUOIKx/DTtnZjVBv5UF0MJ7Xg1/wtrkHi4k3ZPLwJdMjv4UOH9377BbGFkyc0/0PJPhG69TqyyOInUCDNDyhzaYpH423GhlJy4uywrAgMBAAECggEAenw/jp+6gJ1VnKgxz/9eQ3Lv1SdiG8uqcVCZzllD4E7UwWoyhwzszg35ZNAqd/sRyK3/i03JGBgpKBjziCho74gYN5CBMZkbPHQRnFFfl7C210H0ggoAOmsJLob17GwGB0OyCpP4aFO4hi+1Ymzs2D2pYz0QPDRlCKB3yQ8louKjlykGSWwo58zwm935BHvv//JijHGbMbqDJGMfj/ogjhDP0txE7ZBiO9sEc1RjZ5Csg/81H8XSXCGyMowTX+I2M2ys59HMiuZFLM3pG5/UfOkqGKEJcv/ymsKILgL5h2XvLIFbgUqG4WMmHAX+moApnqmnkOtvSnE1u9hnBIkE+QKBgQDuerisalgfDlJ4wn3A7yQyX4cbT3ozLmqo/FZrlrd/ZJ/HgFrGBiEjaSxWRUxVUBGOgyQszOCzvhPySJjW6Y+xcai1MpC0z9fnvbpFM5GVVKUDIIA//O8+Ukd7wZyW20jebeFNk9I/kTAHs751wSJ8x60OET34r+ESk6aV+9xMDQKBgQCdHHK2XKgbUb+LtM0BUDq4KzPWW3/XYMrKpazDjwB+z2XWJSzch4nXyEa/8QAnUI3Atyn0fK1BmfyvFFtHpQtUpMUKtsswz9+RLwFrFrMspl3POlQEaU32fzl/RL7mybZyt71Mqcgq41DAtrVcyXWhgU1x6XrHcCxwZ0LROsDzFwKBgEolLbWteqhtM4cIMUEDGSXwPXloRH4VOGRB0DyzJ2ocRvEoHxDiZvszf+1yrkD4G/1LGLw1FsfLmTgDCkIHa/2ncOSlTAhrdp0+h+NsHR9oqcVHHZjHczrVKhR4Jc9hbk55q0sLYpsQ8PX0FItX+PkCu/NbuQDQ7hFwhqKrI9shAoGADU9LqIdQ9n+Gap92fpX9Y3zFd3No8SYSB/jhGfATaqrHRc0Ab+5Ljyw4UipoiOwaFiluNHgbdWNGNM7UrM0emJ0c1DuIGyqBFhuVUy0pIK83Y0bdt0H0iN1eUZnRUlvkSPOn5ca8XmXDgY/47VNj07rQhMXy0NJ/8UXOM0t27SECgYEAxERMjSKIjJ4VRcVcroBzdXZ2O3Pj9r1BLkyY8qKmptYvA+yinVWvvVzwjoHqLoqEkVZMq2ixrLYt7sl3esfGyUIdxjXUI1cbvCOpbDe7f0kJxvXyldC5Lrtama5gdJE36JFGbWrf2PRg4in1sizMjyY8G/SDMS0MNKpzos4pASQ=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoauF73gbBsJVQkFK/gmmVOWzYevEJZyPozl9L/49MvZKgo9oVOniBIJZq3+/ve6UZUKxLhKGFekP7mCsqMP3J+dr/a12gcVeBX8mu8J6ArwJnQ+pNsbZl9/dlpaob7qEGPd4gCZyr4J31ejpHrFJZBrUeHMtp3bo41YlMa7EKq4eoI8o8nm8yLFedtmtE5/LlY1uj3W0n6ZTGMjGfAOBQSICeoEJZPH+9u/NkLC/2FhRNNMwEAyp0xYQ3AjlX93GFL5F/1nc56oXDzpcIVzBXW+RP8Of1ISwFiXw6qF/P+zXLUNFmjDh03bJrdHoYuvS/Xygs53gwLYFIF+Qdo1KBwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 工程公网访问地址首页内网穿透客户端提供的域名
    public static String notify_url = "http://xsxpge.natappfree.cc/alipay_trade_page_pay_JAVA_UTF_8_Web_exploded//notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 工程公网访问地址首页内网穿透客户端提供的域名
    public static String return_url = "http://xsxpge.natappfree.cc/alipay_trade_page_pay_JAVA_UTF_8_Web_exploded//return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关（正式环境）
    /// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关（沙箱环境）
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径（win）
    // public static String log_path = "C:\\";

    // 日志路径（mac）
    public static String log_path = "/Users/chenjianglin/Desktop/";

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

