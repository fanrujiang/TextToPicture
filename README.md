
# 阿里文生图 Java Demo

## 简介

TextToPicture 是一个基于 Spring Boot 的应用程序，它使用外部 API 将文本描述转换为图像。用户可以通过 Web 界面输入关键词、选择图像数量、大小和风格，然后生成对应的图像。

## 功能

- 输入关键词生成图像
- 可配置图像数量
- 可选择图像尺寸
- 可选择图像风格

## 环境要求

- Java 1.8+
- Maven 3.6.0+

## 安装与运行
你需要在 application.properties 配置 阿里云 DashScope灵积模型API 访问密钥

获取key的方式请参考 [如何获取通义千问API的KEY_模型服务灵积(DashScope)-阿里云帮助中心 (aliyun.com)](https://help.aliyun.com/zh/dashscope/developer-reference/acquisition-and-configuration-of-api-key?spm=a2c4g.11186623.0.0.3a513116Bwc33B)

```
ali.apiKey= 
```

### 克隆项目

```bash
git clone https://github.com/fanrujiang/TextToPicture
cd TextToPicture

# 构建项目
# 使用 Maven 构建项目并生成JAR文件：
mvn clean package
```

### 运行项目

```bash
java -jar target/TextToPicture.jar
```

## 使用说明

### 访问 Web 界面

打开浏览器，访问 `http://localhost`。你将看到一个表单，可以输入关键词并选择图像数量、大小和风格。

### 表单字段

- **关键词**: 输入你希望生成图像的关键词
- **图像数量**: 输入要生成的图像数量
- **大小**: 从下拉菜单中选择图像尺寸
- **风格**: 从下拉菜单中选择图像风格

### 示例

1. 输入关键词，例如 "雄鹰自由自在的在蓝天白云下飞翔"
2. 选择图像数量，例如 4
3. 从下拉菜单中选择图像尺寸，例如 1024x1024
4. 从下拉菜单中选择图像风格，例如 3D卡通
5. 点击“生成图片”按钮

## 依赖项

- Spring Boot
- Thymeleaf
- 外部 API 客户端库

## 贡献

欢迎贡献代码！请提交 Pull Request 或报告问题。

## 许可证

该项目使用 MIT 许可证。详情请参阅 LICENSE 文件。
