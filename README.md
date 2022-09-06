- [二十二 前台-支付案例](#二十二-前台-支付案例)
    - [1. 支付宝开放平台](#1-支付宝开放平台)
    - [2. 电脑网站支付](#2-电脑网站支付)
        - [2.1 总体步骤参考](#21-总体步骤参考)
        - [2.2 应用](#22-应用)
        - [2.3 加密](#23-加密)
            - [2.3.1 对称加密](#231-对称加密)
            - [2.3.2 非对称加密](#232-非对称加密)
            - [2.3.3 调用支付宝接口时使用的秘钥](#233-调用支付宝接口时使用的秘钥)
            - [2.3.4 生成秘钥工具](#234-生成秘钥工具)
                - [2.3.5 生成商户秘钥](#235-生成商户秘钥)
        - [2.4 支付流程](#24-支付流程)
    - [3. 内网穿透](#3-内网穿透)
        - [3.1 上网的常规方式](#31-上网的常规方式)
        - [3.2 项目发布的常规方式](#32-项目发布的常规方式)
        - [3.3 现在面临的特殊情况](#33-现在面临的特殊情况)
        - [3.4 内网穿透](#34-内网穿透)
        - [3.5 内网穿透工具 `natapp`](#35-内网穿透工具-natapp)
            - [3.5.1 下载客户端工具](#351-下载客户端工具)
            - [3.5.2 注册购买隧道](#352-注册购买隧道)
            - [3.5.3 `Mac` 用户使用 `natapp`](#353-mac-用户使用-natapp)
            - [3.5.4 测试](#354-测试)
    - [4. 沙箱环境](#4-沙箱环境)
        - [4.1 进入沙箱环境](#41-进入沙箱环境)
        - [4.2 沙箱应用](#42-沙箱应用)
        - [4.3 沙箱测试 APP](#43-沙箱测试-app)
    - [5. 电脑网站支付 Demo](#5-电脑网站支付-demo)
        - [5.1 下载 Demo](#51-下载-demo)
    - [6. 使用 `Eclipse` 导入 `Demo`](#6-使用-eclipse-导入-demo)
    - [7. 使用 `Idea` 打开支付案例 `Demo`](#7-使用-idea-打开支付案例-demo)
        - [7.1 配置依赖 `command + ;`](#71-配置依赖-command--)
        - [7.2 配置 `Web` 和 `Tamcat Server`](#72-配置-web-和-tamcat-server)
        - [7.3 修改配置文件](#73-修改配置文件)
        - [7.4 启动 `Tomcat`](#74-启动-tomcat)
        - [7.5 测试](#75-测试)


# 二十二 前台-支付案例

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449474458-a1c597b3-a9cd-4215-b264-5e89ebbfacc5.jpeg)

## 1. 支付宝开放平台

- 首页: https://open.alipay.com/
- 文档指引: https://opendocs.alipay.com/open/01bxlm



## 2. 电脑网站支付

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449638305-0ef9c0e4-1416-4358-886c-040c627dab29.jpeg)

### 2.1 总体步骤参考

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662442908428-8b1c84f5-0153-45a6-b66f-4e450a349321.png)



### 2.2 应用

- 开发工程中使用开发平台提供的沙箱环境进行调试, 沙箱环境中的应用已经创建好了, 不需要执行创建流程
- 功能开发完成, 项目上线时再创建应用

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662443523631-60789be5-53ec-4382-ac49-56f8f0c9c6e5.png)



### 2.3 加密

#### 2.3.1 对称加密

- 明文 -> 加密 -> 密文

    - 密文 -> 解密 -> 明文

- 如果知道密文可以反推明文



#### 2.3.2 非对称加密

密码学

- 公钥加密私钥解密/私钥加密公钥解密

    - 用公钥加密的不能用公钥在解密
    - 用私钥加密的也不能用私钥再解密

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662444328243-9d61a568-a1f8-49ea-9486-9face050f87e.png)

- 公钥生成的密文, 用私钥去解密



#### 2.3.3 调用支付宝接口时使用的秘钥

- 商户和支付宝都要提供公钥和私钥

    - 商户需要调用支付宝接口
    - 支付宝也需要调用商户接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662444764985-c75edd6c-739e-4749-a14d-82d0bcb6a535.png)

- 在支付宝开放平台的应用中设置商户公钥
- 在支付宝开放平台的应用中获取支付宝的公钥



- 在我们调用支付宝接口的程序中设置

    - 支付宝公钥
    - 商户的私钥



#### 2.3.4 生成秘钥工具

- https://opendocs.alipay.com/open/02nlga

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445179524-2175d7b3-e462-4095-9de4-c1f036f6a914.png)

- 开发者可通过如下工具生成 **公、私钥对** 或 **CSR 文件**（用于申请证书）。

    - WINDOWS: https://ideservice.alipay.com/ide/getPluginUrl.htm?clientType=assistant&platform=win&channelType=WEB
    - MAC: https://ideservice.alipay.com/ide/getPluginUrl.htm?clientType=assistant&platform=mac&channelType=WEB



##### 2.3.5 生成商户秘钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445501348-481d0e3a-8765-424c-bb26-97d4644ba15d.png)

- 私钥

```latex
MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFEqMLulY2vw9PZX3XCdleB6ri6I6+0eTBQM5gqLafaibUdEc7LwyPaFBQD5ScsRcgDP13g4h/LeUMMwtkb/0wmiKs75piCxELxiT1erGvFLm2wZK7GtXHizjDyUWxtLOVOCWj7ZvoJt/gCTmKeCSaaAVdxLuXsolZVZfml7OifwribATsvLKSGeMcSp4KX32bdQkPnpkR0J9RBAS6Yw1/mYmCiEeFgX7lMfeKhwiAEWrKup6cibJLwZ7GX1WyDfmrWQ0Z5SwSBvdo3VGAqNqoPUwggM7d0uOdYRN179jAMcQtGApg+xCQY7IaKSjLd307ZH/0ofja+1dpZhpgaKG/AgMBAAECggEAR1w3RADmRQ6sCZDzn1FGr4DRRTb2sWwpjDzePiv5bQIwK1ArluezgZ5BLqxloNOTTxzFD2jGnV7OCLvXDThsExRNKBfe7E+bjYrjSSxzeLVlhiLT8gKGlKn6FRMltHJ9cLQTFSfuA4NIH8TXXCejAXJXNxwM3aJdj8apqWsXNehs90HCP8urTkSeLsUMiU8Iee/OgwTL6xdwUEh7xFS+eWnIGxhJeJPScq+XTKKevcRPVmPJopTwjhTv61cp3i/IkaXBmRizbfI9tOO6R1EqBvWGj6b0b3+tog15Go0nCv/GRsAU1shTF23cGIRkB5O2fZsAvNcCXQ8GnoSnqBnbUQKBgQD9nqWZMTnpPgGJHGlSiM/dErjB0tb8serdl2wceXkLCf9PJAg15x5HdZL8T+AdED+fC5UH82AH9mFUqDitcyRBCl5WinC2Sr/IEFLl6e8fO1fSp50zG3bqkiLZIN1gqlEFkWwfDy7L7d4LKbtUer7iW9inOyMvCfGhEOLVsDAjaQKBgQDG7CEFLgWbNlgD1cCHnxSbnYUjXB1Dz07HvJVvtFMrRGA//aUpRDuM48U7+UT245dbw5nKwsQp3/Ky0aqLO/M9DW8kC4qMH5ExBDspgOtGmDac8Jqj66cjpZ955zryzaVxOR+Iu7rsTEwo0UpzdDnOm2VUy1Gu7CHTdJ9K5NN+5wKBgQDdsXrhsRUFHE1tU+eA3NSOU5oq2ylQFBnQf1digJBdJO0GeeGvdIqUPmMwqIWoAhcK6K3qGES+URD9VlrMy1RKgky6ayNhRW/k6tf734RFkbMQEbIpBX3qR7msgLzijZ5rNpYDhFsMqa2ppl34157Z8R0t+VSk/pU3jLIrxmod2QKBgHhBGXkrKEJ7qNuwpfKXDftBT9JfhmWO9r4y2FguODUo4dLtgKIg2KtEquClwbZLQh48ckWsVrBF7U+DBsmjVVmsPGsa+wfYsYpjV2ywvgrwS9u2bJX6CRG4t18XlYBhJ8n50YF0k/zz5vqqA4smUSgAs1J+k4Pexlgx4XaCPQUzAoGBAI/NuQpFHXueJucmSww83cEF6zf79ikFbIK5OfHVkxWaYB/EcNZNRi1MFSl+uHP3tPTT/520VMkPnO4EinviWA23roSKHQIB6XlUiOeHOkKqpnA49ivI/Gj5PqRRXSfDcqMc6HCrMVQFmV61l1gZ8jdOpp4R3GcojiE53X3P7+b0
```

- 公钥

```plain
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxRKjC7pWNr8PT2V91wnZXgeq4uiOvtHkwUDOYKi2n2om1HRHOy8Mj2hQUA+UnLEXIAz9d4OIfy3lDDMLZG/9MJoirO+aYgsRC8Yk9XqxrxS5tsGSuxrVx4s4w8lFsbSzlTglo+2b6Cbf4Ak5ingkmmgFXcS7l7KJWVWX5pezon8K4mwE7LyykhnjHEqeCl99m3UJD56ZEdCfUQQEumMNf5mJgohHhYF+5TH3iocIgBFqyrqenImyS8Gexl9Vsg35q1kNGeUsEgb3aN1RgKjaqD1MIIDO3dLjnWETde/YwDHELRgKYPsQkGOyGikoy3d9O2R/9KH42vtXaWYaYGihvwIDAQAB
```



### 2.4 支付流程

- https://opendocs.alipay.com/open/270/105899

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445860622-a16346bc-653a-4619-bd7f-9a366a50d180.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445878102-9a80ebfb-7453-407c-ba1e-87e201fc07f6.png)



## 3. 内网穿透

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449637333-6f471537-585f-46b9-90e3-4c43f7bf4fad.jpeg)

### 3.1 上网的常规方式

- 在内网中访问外网

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662446432888-24ee4252-07f6-482d-bb5d-5aefeb7f1c34.png)



### 3.2 项目发布的常规方式

- 先在内网环境中完成开发, 在部署到位于外网的生成服务器上

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662446785204-8c5ff3ac-2f63-41ab-89df-e8c5191c6d08.png)



### 3.3 现在面临的特殊情况

- 我们现在在内网开发环境下, 需要让支付宝来调用内网中的项目
- 如果不用特殊的处理这种情况是访问不到内网的



### 3.4 内网穿透

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447088258-42f22d42-4393-4d4d-9d65-24a1727cb981.png)



### 3.5 内网穿透工具 `natapp`

- https://natapp.cn/

#### 3.5.1 下载客户端工具

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447678360-d303a2eb-ce0b-44cc-bd4d-d09f0d6f0d53.png)

- mac 64: [📎natapp_darwin_amd64_2_3_9.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1662447992127-8d532e1a-a7ea-478a-82fe-875f7ed3e3bc.zip)
- mac 判断64还是32: 终端: `uname -a`显示 `X86_**64**` 就是64



#### 3.5.2 注册购买隧道

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447611040-8c7f48a1-3492-44ed-99f8-5ece5bf6607d.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450198769-b4d531f8-44e5-447f-bd2f-869033d6722e.png)



#### 3.5.3 `Mac` 用户使用 `natapp`

- 解压得到 `natapp` 文件
- 配置文件 `config.ini`, 配置 `authtoken` -> 在我的渠道中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450305789-444a1db8-61d6-4e05-a112-fb6164600c35.png)

```shell
#将本文件放置于natapp同级目录 程序将读取 [default] 段
#在命令行参数模式如 natapp -authtoken=xxx 等相同参数将会覆盖掉此配置
#命令行参数 -config= 可以指定任意config.ini文件
[default]
authtoken=                      #对应一条隧道的authtoken
clienttoken=                    #对应客户端的clienttoken,将会忽略authtoken,若无请留空,
log=none                        #log 日志文件,可指定本地文件, none=不做记录,stdout=直接屏幕输出 ,默认为none
loglevel=ERROR                  #日志等级 DEBUG, INFO, WARNING, ERROR 默认为 DEBUG
http_proxy=                     #代理设置 如 http://10.123.10.10:3128 非代理上网用户请务必留空
```

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/lt8vyw#Kaaa1

- 在`Linux/Mac` 下 需要先给执行权限

```bash
chmod a+x natapp
```

- 然后再运行

```bash
./natapp
```



#### 3.5.4 测试

1. 安装 `nginx`

```bash
brew install ngixn
```



1. 修改 `nginx.conf`, 将端口改为 `80`

```bash
vi /usr/local/etc/nginx/nginx.conf
```



1. 重启 nginx

```bash
brew services restart nginx
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450035067-01b88d46-7eb7-4cd8-8dcc-95388e877af6.png)



1. 启动 natapp

```bash
./natapp
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450058435-1dd4cb01-063b-4459-9877-44ce9a22cc5c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450072123-e30158f1-3388-4e3b-b24b-00e855cb43f4.png)





## 4. 沙箱环境

### 4.1 进入沙箱环境

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454969504-60be2a35-7b79-4a21-b373-fc579dd30835.png)



### 4.2 沙箱应用

- 启用公钥模式: 自动生成应用公钥/私钥和支付宝公钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662458519142-0840e618-bbf3-4a33-97e0-fc693f1299cb.png)

- 查看

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662467822180-3731f25a-5197-46a4-95eb-87ab6015515c.png)



### 4.3 沙箱测试 APP

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662471711403-aa5ab977-c315-4809-9fc9-1fa77c30b2ae.png)



## 5. 电脑网站支付 Demo

### 5.1 下载 Demo

- `Demo` 附件: [📎alipay.trade.page.pay-JAVA-UTF-8.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1662450537769-30d5c266-56ab-4ad9-aa85-90c9b5c9dd4d.zip)
- https://opendocs.alipay.com/open/270/106291

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450489249-93d9f947-10ba-48ec-b5b3-49fa1ff4d569.png)



## 6. 使用 `Eclipse` 导入 `Demo`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454632236-cdcfc73a-4f4d-4784-b442-11dc4cbfda8c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454610801-8b9e060a-013c-4139-a6e2-bc8cd9f35848.png)



## 7. 使用 `Idea` 打开支付案例 `Demo`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662474766428-4101e3ef-7176-4e2b-8dea-e50b01367037.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662474756975-144f7439-720f-4de4-bd14-3ef85576d887.png)

### 7.1 配置依赖 `command + ;`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453269136-19a0a4b6-b89b-4d32-9a06-cfda6f35799e.png)

1. 去掉红色依赖
2. 添加依赖包

- 点击 `+` 号, 选择

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453380538-812876f6-5ff2-4b03-a9e8-a015410315da.png)

- 加入依赖, 一个一个选择

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662469931753-3e02820b-e92b-4586-be5a-8313b8a107f9.png)\![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662469942955-2b647dfc-b65c-4176-9a00-f578990285f8.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475321209-76fd20e1-044c-427a-82ea-a5fd8ad2e7d9.png)



### 7.2 配置 `Web` 和 `Tamcat Server`

1. 添加 `Web`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470234078-d004f779-c85d-4b3f-886f-c78f3888d7b7.png)



1. 减去 Web.xml

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470301375-680b2b0c-374f-4222-8d5a-9bc9070dba57.png)



1. 修改 `web` 目录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470323751-ea3ed674-ecd3-4161-ad60-1405cf4efb80.png)



1. 点击 `Create Artifact`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470347334-3c685cd1-c9b8-4b84-892f-f1f5abf83da6.png)



1. 右键添加

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470399143-a35eb462-2811-4a46-adc2-eb7ca3774778.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470443570-c66a2994-6391-4c1a-ae66-81afd560e6ac.png)

- 记得点击 `Apply`

1. 打开运行配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470484680-0d2eaa47-7657-4d1a-bda2-637d8bd0ffbd.png)



1. 添加 `Tomcat Server`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470738432-319a8d4b-55e3-4be7-8b7c-f92bb8d506e6.png)



1. 将 `Artifact` 添加进入

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470609797-1e26eb7b-74e9-476b-840e-65e8b8c81043.png)



### 7.3 修改配置文件

- 将文件格式改为 `GBK` 再改为 `UTF-8`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453146503-32e333bc-c062-4533-a948-179021144b72.png)

```java
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
```



### 7.4 启动 `Tomcat`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470792565-1bcf0af3-aa68-4aaa-a3a8-91d06181a5f6.png)



### 7.5 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475072176-b48c558d-30de-4783-8624-6e1aa38a5135.png)

- 点击付款

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475191740-b3c1aafc-f482-4832-9f2e-1c889e776eeb.png)

- 扫码付款

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475244057-c8bedc91-7ad7-4531-986c-3f06c8b1ba7f.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475250302-1617b55a-5102-412d-a0b3-efd065ae10e0.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475256993-041d2b26-8f41-42e0-814f-763be06c3ea2.png)

