package util;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//返回document
	public Document getDocument(String path){
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(path);
			return document;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//回写xml
	public void xmlWriters(String path,Document document){
		OutputFormat format = OutputFormat.createPrettyPrint();
        //设置xml文档的编码为utf-8
        format.setEncoding("utf-8");
        FileOutputStream out;
        try {
            //创建一个输出流对象
            out = new FileOutputStream(path);
            //创建一个dom4j创建xml的对象
            XMLWriter writer = new XMLWriter(out, format);
            //调用write方法将doc文档写到指定路径
            writer.write(document);
            writer.close();
            System.out.println("生成XML文件成功");
        } catch (IOException e) {
            System.out.println("生成XML文件失败");
            e.printStackTrace();
        }
	}

}
