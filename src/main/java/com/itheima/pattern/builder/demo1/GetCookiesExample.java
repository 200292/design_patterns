package com.itheima.pattern.builder.demo1;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.CookieStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Executor;

public class GetCookiesExample {
    public static void main(String[] args) {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpGet请求
            HttpGet request = new HttpGet("http://192.168.172.130/pikachu-master/vul/csrf/csrfget/csrf_get.php");

            // 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // 读取响应内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                reader.close();

                // 打印响应内容
                System.out.println(responseContent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

