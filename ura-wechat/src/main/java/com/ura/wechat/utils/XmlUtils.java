package com.ura.wechat.utils;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.ura.common.utils.SysIOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class XmlUtils {

  /**
   * 解析微信发来的请求（XML） xml示例 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
   * <FromUserName><![CDATA[FromUser]]></FromUserName>
   * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
   * <Event><![CDATA[CLICK]]></Event>
   * <EventKey><![CDATA[EVENTKEY]]></EventKey> </xml>
   *
   * @param request
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public static Map<String, String> parseXmlToMap(HttpServletRequest request){
    Map<String, String> map = new HashMap<>();
    InputStream inputStream = null;
    try {
      inputStream = request.getInputStream();
      SAXReader reader = new SAXReader();
      Document document = reader.read(inputStream);
      Element root = document.getRootElement();
      List<Element> elementList = root.elements();
      for (Element element: elementList) {
        map.put(element.getName(), element.getText());
      }
    } catch (IOException | DocumentException e){
      e.printStackTrace();
    }
    return map;
  }

  /**
   * 解析微信发来的请求（XML） xml示例 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
   * <FromUserName><![CDATA[FromUser]]></FromUserName>
   * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
   * <Event><![CDATA[CLICK]]></Event>
   * <EventKey><![CDATA[EVENTKEY]]></EventKey> </xml>
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public static Map<String, String> parseStreamToMap(InputStream inputStream) throws Exception{
    Map<String, String> map = new HashMap<>();
    try {
      SAXReader reader = new SAXReader();
      Document document = reader.read(inputStream);
      Element root = document.getRootElement();
      List<Element> elementList = root.elements();
      for (Element element :
              elementList) {
        map.put(element.getName(), element.getText());
      }
    } catch (DocumentException e){
      e.printStackTrace();
    }
    return  map;
  }

  /**
   * 使用dom4将xml文件中的数据转换成TreeMap<Object,Object>
   *
   * @param xml xml格式的字符串
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws SAXException
   */
  public static TreeMap<String, Object> parseXmlToTreeMap(String xml, String encoding) throws ParserConfigurationException, IOException, SAXException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputStream inputStream = SysIOUtils.toInputStream(xml, encoding);
    org.w3c.dom.Document document = builder.parse(inputStream);

    NodeList allNodes = document.getFirstChild().getChildNodes();
    Node node;
    TreeMap<String, Object> map = new TreeMap<>();
    int i = 0;
    while (i < allNodes.getLength()){
      node = allNodes.item(i);
      if (node instanceof org.w3c.dom.Element){
        map.put(node.getNodeName(), node.getTextContent());
      }
      i++;
    }
    return map;
  }

  /**
   * 使用dom4将xml文件中的数据转换成Map<String,Object>
   *
   * @param xml xml格式的字符串
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws SAXException
   */
  public static Map<String, Object> parseXmlToMap(String xml, String encoding) throws ParserConfigurationException, IOException, SAXException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputStream is = SysIOUtils.toInputStream(xml, encoding);
    org.w3c.dom.Document document = builder.parse(is);

    NodeList allNodes = document.getFirstChild().getChildNodes();
    Node node;
    Map<String, Object> hashMap = new HashMap<>();
    int i = 0;
    while(i < allNodes.getLength()){
      node = allNodes.item(i);
      if (node instanceof org.w3c.dom.Element){
        hashMap.put(node.getNodeName(), node.getTextContent());
      }
      i++;
    }
    return hashMap;
  }

  /**
   * 示例 <xml> <return_code><![CDATA[SUCCESS]]></return_code>
   * <return_msg><![CDATA[OK]]></return_msg>
   * <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
   * <mch_id><![CDATA[10000100]]></mch_id>
   * <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>
   * <openid><![CDATA[oUpF8uMuAJO_M2pxb1Q9zNjWeS6o]]></openid>
   * <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>
   * <result_code><![CDATA[SUCCESS]]></result_code>
   * <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>
   * <trade_type><![CDATA[JSAPI]]></trade_type> </xml>
   *
   * 将xml数据(<![CDATA[SUCCESS]]>格式)映射到java对象中
   *
   * @param xml
   *            待转换的xml格式的数据
   * @param t
   *            待转换为的java对象
   * @return
   */
  public static <T> T getObjectFromXML(String xml, Class<T> t){
    XStream xstream = XStreamFactory.init(true);
    xstream.alias("xml", t);
    xstream.ignoreUnknownElements();// 忽略新增字段
    return t.cast(xstream.fromXML(xml));
  }

  /**
   * 将java对象转换为xml(<![CDATA[SUCCESS]]>格式)
   *
   * @param obj
   * @return
   */
  public static String toXml(Object obj){
    String result = "";
    XStream xstream = XStreamFactory.init(true);
    xstream.alias("xml", obj.getClass());
    result = xstream.toXML(obj);
    return result;
  }
  /**
   * 将java对象转换为xml文件,并去除 _ 应用场景是 去除实体中有_划线的实体, 默认会有两个_,调用该方法则会去除一个
   *
   * @param object
   * @return
   */
  public static String toSplitXml(Object object){
    String result = "";
    XStream xstream = XStreamFactory.initSplitLine();
    xstream.alias("xml", object.getClass());
    result = xstream.toXML(object);
    return result;
  }

  /**
   * XStream 工厂类
   */
  static class XStreamFactory{
    private static final String START_CDATA = "<![CDATA[";
    private static final String END_CDATA = "]]>";

    /**
     * 是否启用<![CDATA[]]>
     * @param flag true表示启用， false不启用
     * @return
     */
    static XStream init(boolean flag){
      XStream xstream = null;
      if (flag){
        xstream = new XStream(new XppDriver(){
          @Override
          public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out){
              @Override
              protected void writeText(QuickWriter writer, String text) {
                if (!text.startsWith(START_CDATA)){
                  text = START_CDATA + text + END_CDATA;
                }
                writer.write(text);
              }
            };
          }
        });
      } else {
        xstream = new XStream();
      }
      return xstream;
    }

    /**
     * 用于处理在实体对象中带有_的属性,如果用上述方法，会出现有两个__,导致结果不正确! 属性中有_的属性一定要有该方法
     *
     * @return 返回xstream 对象 new DomDriver("UTF-8", new
     *         XmlFriendlyNameCoder("-_", "_")
     */
    public static XStream initSplitLine(){
      XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
      return xstream;
    }
  }
}

