package com.atguigu.dom4j;

import static org.junit.Assert.*;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.vo.Student;

public class TestDom4j {
	
	@Test
	public void testXpath() throws Exception{
		//获取解析器
		SAXReader reader = new SAXReader();
		//通过解析器加载xml文件
		Document document = reader.read("student.xml");
		
		//查找所有学生
		List list = document.selectNodes("//students/student");
		System.out.println(list.size());
		
		//查找id=01的学生
		Element stu = (Element) document.selectSingleNode("//student[@id=03]");
		String name = stu.element("name").getText();
		String age = stu.elementText("age");
		String sex = stu.elementText("sex");
		String id = stu.attributeValue("id");
		
		Student student = new Student(name, Integer.parseInt(age), sex);
		System.out.println(id+"--"+student);
	}

	@Test
	public void testDom4j() throws Exception {
		//获取解析器
		SAXReader reader = new SAXReader();
		//通过解析器加载xml文件
		Document document = reader.read("student.xml");
		
		//dom4j的解析操作是从根节点开始的
		Element root = document.getRootElement();
		
		//获取学生信息
		List<Element> elements = root.elements("student");
		for(Element e:elements){
			//获取name标签
			List nameList = e.elements("name");
			Element nameEle = (Element) nameList.get(0);
			String name = nameEle.getText();
			
			//获取age标签的文本信息
			Element ageEle = (Element) e.elements("age").get(0);
			String age = ageEle.getText();
			
			//获取sex标签的文本信息
			Element sexEle = (Element) e.elements("sex").get(0);
			String sex = sexEle.getText();
			
			//获取id属性值 
			String id = e.attributeValue("id");
			
			//查询id=02的学生信息
			if("02".equals(id)){
				Student student = new Student(name, Integer.parseInt(age), sex);
				System.out.println(student);
			}
		}
		
		
		
		
	}

}
