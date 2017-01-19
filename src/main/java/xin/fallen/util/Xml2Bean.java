package xin.fallen.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 */
public class Xml2Bean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String xmlDetail;

    public Xml2Bean(String xmlDetail) {
        this.xmlDetail = xmlDetail;
    }

    public Object getBean(Class clazz) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
            Field[] params = clazz.getDeclaredFields();
            for (Field f : params) {
                f.setAccessible(true);
                String key = f.getName();
                String value = getValue(key);
                f.set(obj, value);
            }
        } catch (Exception e) {
            logger.error("对象赋值异常，原因是：{}",e.getMessage());
        }
        return obj;
    }

    public String getValue(String key) {
        SAXReader saxReader = new SAXReader();
        Document doc = null;
        String value = null;
        try {
            doc = saxReader.read(new ByteArrayInputStream(this.xmlDetail.getBytes()));
        } catch (DocumentException e) {
            logger.error("解析xml生成Document异常，原因是：{}",e.getMessage());
        }
        try {
            if (doc != null) {
                List<Element> eleList = doc.selectNodes("//" + key);
                value = eleList.get(0).getTextTrim();
            }
        } catch (Exception e) {
            logger.error("获取value异常，原因是：{}",e.getMessage());
            value = null;
        }
        return value;
    }
}
