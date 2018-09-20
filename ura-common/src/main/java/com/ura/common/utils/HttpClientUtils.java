package com.ura.common.utils;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtils {
  public final static int connTimeout = 10000;
  public final static int readTimeout = 10000;
  public final static String charset = "UTF-8";
  private static HttpClient client = null;

  static {
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    cm.setMaxTotal(128);
    cm.setDefaultMaxPerRoute(128);
    client = HttpClients.custom().setConnectionManager(cm).build();
  }

  /**
   * 创建SSL连接
   * @return
   * @throws GeneralSecurityException
   */
  private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException{
    try {
      SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
        @Override
        public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
          return true;
        }
      }).build();

      SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {
        @Override
        public void verify(String s, SSLSocket sslSocket) throws IOException {
        }

        @Override
        public void verify(String s, X509Certificate x509Certificate) throws SSLException {
        }

        @Override
        public void verify(String s, String[] strings, String[] strings1) throws SSLException {

        }

        @Override
        public boolean verify(String s, SSLSession sslSession) {
          return true;
        }
      });

      return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    } catch (GeneralSecurityException e) {
      throw e;
    }
  }

  @SuppressWarnings("unused")
  private static String getCharsetFromResponse(HttpResponse response) {
    if (response.getEntity() != null && response.getEntity().getContentType() != null && response.getEntity().getContentType().getValue() != null) {
      String contentType = response.getEntity().getContentType().getValue();
      if (contentType.contains("charset=")) {
        return contentType.substring(contentType.indexOf("charset=") + 8);
      }
    }
    return null;
  }

  /**
   * 发送一个 Post 请求, 使用指定的字符集编码.
   * @param url           url
   * @param body         RequestBody
   * @param mimeType     例如 application/xml "application/x-www-form-urlencoded" a=1&b=2&c=3
   * @param charset      编码
   * @param connTimeout  建立链接超时时间,毫秒
   * @param readTimeout  响应超时时间,毫秒.
   * @return
   * @throws ConnectTimeoutException  建立链接超时异常
   * @throws SocketTimeoutException   响应超时
   * @throws Exception
   */
  public static String _post(String url, String body, String mimeType, String charset, Integer connTimeout, Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception {
    HttpClient client = null;
    HttpPost post = new HttpPost(url);
    String result = "";
    try {
      if (StringUtils.isNotBlank(body)) {
        HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, charset));
        post.setEntity(entity);
      }
      Builder customReqConf = RequestConfig.custom();
      if (connTimeout != null) {
        customReqConf.setConnectTimeout(connTimeout);
      }
      if (readTimeout != null) {
        customReqConf.setSocketTimeout(readTimeout);
      }
      post.setConfig(customReqConf.build());

      HttpResponse res;
      if (url.startsWith("https")) {// 执行 https请求
        client = createSSLInsecureClient();
        res = client.execute(post);
      } else {  // http 请求
        client = HttpClientUtils.client;
        res = client.execute(post);
      }
      result = IOUtils.toString(res.getEntity().getContent(), charset);
    } finally {
      post.releaseConnection();
      if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
        ((CloseableHttpClient) client).close();
      }
    }
    return result;
  }

  /**
   * 提交form表单
   * @param url
   * @param params
   * @param headers
   * @param connTimeout
   * @param readTimeout
   * @return
   * @throws ConnectTimeoutException
   * @throws SocketTimeoutException
   * @throws Exception
   */
  public static String _postForm(String url, Map<String, String> params, Map<String, String> headers, Integer connTimeout, Integer readTimeout) throws ConnectTimeoutException,
          SocketTimeoutException, Exception {
    HttpClient client = null;
    HttpPost post = new HttpPost(url);
    try {
      if (params != null && !params.isEmpty()) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = params.entrySet();
        for (Map.Entry<String, String> entry:
                entrySet){
          formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        post.setEntity(entity);
      }

      if (headers != null && !headers.isEmpty()) {
        for (Map.Entry<String, String> entry:
                headers.entrySet()){
          post.addHeader(entry.getKey(), entry.getValue());
        }
      }

      Builder customReqConf = RequestConfig.custom();
      if (connTimeout != null) {
        customReqConf.setConnectTimeout(connTimeout);
      }
      if (readTimeout != null) {
        customReqConf.setSocketTimeout(readTimeout);
      }
      post.setConfig(customReqConf.build());
      HttpResponse res = null;
      if (url.startsWith("https")) {
        client = createSSLInsecureClient();
        res = client.execute(post);
      } else {
        client = HttpClientUtils.client;
        res = client.execute(post);
      }
      return IOUtils.toString(res.getEntity().getContent(), "UTF-8");
    } finally {
      post.releaseConnection();
      if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
        ((CloseableHttpClient) client).close();
      }
    }
  }
  public static String post(String url, String parameterStr) throws ConnectTimeoutException, SocketTimeoutException, Exception{
    return _post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
  }

  public static String post(String url, String parameterStr, String charset, Integer connTimeout, Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception{
    return _post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
  }

  public static String post(String url, Map<String, String> params, Integer connTimeout, Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception{
    return _postForm(url, params, null, connTimeout, readTimeout);
  }


  /**
   * 发送一个 GET 请求
   * @param url           请求url
   * @param charset       字符编码
   * @param connTimeout   连接过期时间
   * @param readTimeout   socket连接时间
   * @return
   * @throws ConnectTimeoutException
   * @throws SocketTimeoutException
   * @throws Exception
   */
  public static String _get(String url, String charset, Integer connTimeout, Integer readTimeout) throws ConnectTimeoutException,SocketTimeoutException, Exception {
    HttpClient client = null;
    HttpGet get = new HttpGet(url);
    String result = "";
    try {
      Builder customReqConf = RequestConfig.custom();
      if (connTimeout != null) {
        customReqConf.setConnectTimeout(connTimeout);
      }
      if (readTimeout != null) {
        customReqConf.setSocketTimeout(readTimeout);
      }
      get.setConfig(customReqConf.build());

      HttpResponse res = null;

      if (url.startsWith("https")) {
        client = createSSLInsecureClient();
        res = client.execute(get);
      } else {
        client = HttpClientUtils.client;
        res = client.execute(get);
      }
      result = IOUtils.toString(res.getEntity().getContent(), charset);
    } finally {
      get.releaseConnection();
      if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
        ((CloseableHttpClient) client).close();
      }
    }
    return result;
  }

  public static String get(String url) throws Exception{
    return _get(url, charset, null, null);
  }

  public static String get(String url, String charset) throws Exception{
    return _get(url, charset, connTimeout, readTimeout);
  }
}
