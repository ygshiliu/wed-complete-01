package com.atguigu.dom;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.atguigu.vo.Student;

public class TestDom {
	

	//解析所有学生信息
	@Test
	public void parseAll() throws Exception {
		//获取解析器对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//通过解析器对象加载xml文件
		Document document = builder.parse("student.xml");
		
		//xml是自定义标签，这里的id属性没有实际上的意义
		//也就说，xml解析是不能通过getElementById()来获取对象的
		//Element stu = document.getElementById("01");
		
		//获取学生信息
		NodeList list = document.getElementsByTagName("student");
		for(int i=0;i<list.getLength();i++){
			//通过下标来获取对象
			Element item = (Element) list.item(i);
			
			//获取name
			NodeList nameList = item.getElementsByTagName("name");
			Element nameEle = (Element) nameList.item(0);
			String name = nameEle.getTextContent();
			
			//获取age
			String age = item.getElementsByTagName("age").item(0).getTextContent();
			
			//获取sex
			String sex = item.getElementsByTagName("sex").item(0).getTextContent();
			
			//查询id=03的学生信息
			//获取 id 属性值 
			String id = item.getAttribute("id");
			if("03".equals(id)){
				Student student = new Student(name, Integer.parseInt(age), sex);
				System.out.println(student);
			}
		}
		
	}

}
