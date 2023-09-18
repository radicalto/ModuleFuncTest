package com.book.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class githubLogin {
    private static String GITHUB_CLIENT_ID = "2275f34245f60fb42136";
    private static String GITHUB_CLIENT_SECRET = "c8840dce5ef7cacadabd479890a0146360078666";
    private static String GITHUB_REDIRECT_URL = "http://127.0.0.1:8080/githubCallback";

    private static String accessTokenUrl = "https://github.com/login/oauth/access_token?client_id=2275f34245f60fb42136&client_secret=c8840dce5ef7cacadabd479890a0146360078666";
    private static  String userInfoUrl = "https://api.github.com/user";
    @RequestMapping("/gitLogin")
    public void gitLogin(HttpServletResponse response) throws Exception {
        // Github认证服务器地址
        String url = "https://github.com/login/oauth/authorize";
        // 生成并保存state，忽略该参数有可能导致CSRF攻击
        String state = "nihaogithub";
        // 传递参数response_type、client_id、state、redirect_uri
        String param = "response_type=code&" + "client_id=" + GITHUB_CLIENT_ID + "&state=" + state + "&redirect_uri=" + GITHUB_REDIRECT_URL;

        // 1、请求Github认证服务器
        response.sendRedirect(url + "?" + param);
    }


//    @RequestMapping("/githubCallback")
//    public String tologin(@RequestParam("code") String code){
//        System.out.println(code);
//        Map<String,String> map=new HashMap<>();
//        map.put("code",code);
//        map.put("redirect_uri","http://localhost:8080/githubCallback");
//        RestTemplate request=new RestTemplate();
//        accessTokenUrl+="&code="+code;
//        String s=request.postForObject(accessTokenUrl,String.class, String.class,map);
//        System.out.println("accessTokenUrl返回的数据:"+s);
//        //获取用户信息
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        String[] str=s.split("&");
//        String access_token=str[0].substring(str[0].indexOf("="));
//        System.out.println("access_token:"+access_token);
//        String reqJsonStr = "{\"access_token\":\""+access_token+"\"}";
//        HttpEntity<String>  entity = new HttpEntity<String>(reqJsonStr,headers);
//        ResponseEntity<Map> resp = request.exchange(userInfoUrl+access_token, HttpMethod.GET, entity, Map.class);
//        System.out.println("用户信息:"+resp.toString());
//        return "login";
//    }

    @RequestMapping("/githubCallback")
    @ResponseBody
    public String tologin(@RequestParam("code") String code) throws IOException {
        System.out.println(code);
        Map<String,String> map=new HashMap<>();
        map.put("code",code);
        map.put("redirect_uri","http://localhost:8080/githubCallback");
        RestTemplate request=new RestTemplate();
        accessTokenUrl+="&code="+code;
        String s=request.postForObject(accessTokenUrl,String.class, String.class,map);
        System.out.println("accessTokenUrl返回的数据:"+s);
        //获取用户信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String[] str=s.split("&");
        String access_token=str[0].substring(str[0].indexOf("="));
        System.out.println("access_token:"+access_token);
        // 获取访问令牌
        OkHttpClient httpClient = new OkHttpClient();
        // 使用访问令牌进行 API 请求
        String url=userInfoUrl+"?"+"access_token="+access_token;
        Request apiRequest = new Request.Builder()
                .url(userInfoUrl)
                .addHeader("Authorization", "token " + access_token.replace("=",""))
                .build();

        Response apiResponse = httpClient.newCall(apiRequest).execute();

        System.out.println(apiResponse.body().string());
        return null;
//        // 4. 使用令牌获取GitHub用户信息
//        String apiUrl = "https://api.github.com/user";
//        HttpURLConnection apiConnection = (HttpURLConnection) new URL(apiUrl).openConnection();
//        apiConnection.setRequestProperty("Authorization", "Bearer " + access_token);
//
//        if (apiConnection.getResponseCode() == 200) {
//            BufferedReader apiReader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
//            String line;
//            StringBuilder apiResponse = new StringBuilder();
//            while ((line = apiReader.readLine()) != null) {
//                apiResponse.append(line);
//            }
//            apiReader.close();
//
//            // 处理用户数据
//            System.out.println("GitHub用户信息：");
//            System.out.println(apiResponse.toString());
//            return apiResponse.toString();
//            // 在这里执行第三方登录逻辑或其他操作
//        } else {
//            return "无法访问GitHub API。";
//        }
    }

    @RequestMapping("/toLogin")
    public String Login() {
        return "login";
    }
}
