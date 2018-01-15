package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;

/**
 * 测试BookDaoImple实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午10:23:02
 */
public class TestBookDao {
	
	private BookDao bd = new BookDaoImpl();
	
	@Test
	public void testfindBookByPrice(){
		Page<Book> page = new Page<Book>(null, 0, 0, 0, 3, 4);
		bd.findBookByPrice(page,10,20);
		System.out.println(page);
		
	}
	
	@Test
	public void testfindBook(){
		Page<Book> page = new Page<Book>(null, 0, 0, 0, 3, 4);
		bd.findBook(page);
		System.out.println(page);
	}
	@Test
	public void testSaveBook() {
		Book book = new Book(null, "时间简史", "霍金", 30.0, 100, 100);
		int count = bd.saveBook(book);
		System.out.println(count);
	}

	@Test
	public void testDeleteBook() {
		String id = "2";
		bd.deleteBook(id);
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book(1, "时间简史1", "霍金1", 40.0, 200, 200);
		int count = bd.updateBook(book);
		System.out.println(count);
	}

	@Test
	public void testGetBook() {
		String id = "1";
		Book book = bd.getBook(id);
		System.out.println(book);
	}

	@Test
	public void testGetAllBook() {
		List<Book> list = bd.getAllBook();
		System.out.println(list);
	}

}
