package com.ura.wechat.utils;

import com.ura.common.utils.SysIOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Documented;
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
   * @param request
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
}
