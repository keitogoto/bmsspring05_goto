package jp.co.f1.spring.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.f1.spring.bms.entity.Book;
import jp.co.f1.spring.bms.repository.BookRepository;

@Controller
public class BmsController {

	//Repositoryインターフェースを自動インスタンス化
	@Autowired
	private BookRepository bookinfo;
	
	/**
	 * 『/list』へアクセスがあった場合
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		//bookinfoテーブルから全権取得
		Iterable<Book> book_list = bookinfo.findAll();
		
		//Viewに渡す変数をModelに格納
		mav.addObject("book_info", book_list);
		
		//画面に出力するViewを指定
		mav.setViewName("list");
		
		//ModelとView情報を返す
		return mav;
	}
	
}
