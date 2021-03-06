package org.thankjava.toolkit3d.utils.xml;

import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * XML2JavaBean
* 依赖于 maven[com.thoughtworks.xstream:xstream]
* <p>Function: XMLBeanUtil</p>
* <p>Description: </p>
* @author zhaoxy@thankjava.com
* @date 2016年4月18日 上午10:13:07
* @version 1.0
 */
public class XMLBeanUtil {

	private static final String ENCODING = "utf-8";
	
	/**
	 * 将xml转java对象
	* <p>Function: xml2Bean</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2016年8月12日 下午3:14:40
	* @version 1.0
	* @param xmlRoot xml根节点名
	* @param xml
	* @param clazz 对应的java对象
	* @param isIgnoreUnkonwnEles 是否容错（如果不允许容错，xml报文中有的节点 java对象中没有将抛异常）
	* @return
	 */
	public static <T> T xml2Bean(String xmlRoot, String xml,Class<T> clazz,boolean isIgnoreUnkonwnEles) {
		XStream xStream = new XStream(new DomDriver(ENCODING));
		if(isIgnoreUnkonwnEles){
			xStream.ignoreUnknownElements();
		}
		xStream.alias(xmlRoot, clazz);
		@SuppressWarnings("unchecked")
		T t = (T) xStream.fromXML(xml);
		return t;
	}
	
	public static <T> T xml2Bean(Map<String, Class<?>> classMap, String xmlStr,Class<T> clazz,boolean isIgnoreUnkonwnEles) {
		XStream xStream = new XStream(new DomDriver(ENCODING));
		if(isIgnoreUnkonwnEles){
			xStream.ignoreUnknownElements();
		}
		for (String key : classMap.keySet()) {
			xStream.alias(key, classMap.get(key));
		}
		@SuppressWarnings("unchecked")
		T t = (T) xStream.fromXML(xmlStr);
		return t;
	}

	public static String bean2Xml(Object obj) {
		XStream xStream = new XStream(new DomDriver(ENCODING));
		String xml = xStream.toXML(obj);
		return xml;
	}
}
