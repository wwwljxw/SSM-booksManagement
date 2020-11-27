package com.forever.controller;

import com.forever.domain.Books;
import com.forever.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BooksService bookService;

    /**
     * 展示所有书籍
     * @param model 所有书籍
     * @return 跳转到所有书籍页面
     */
    @RequestMapping("/selectAllBook")
    public String selectAllBook(Model model){
        List<Books> books = bookService.selectBooks();
        model.addAttribute("books", books);
        return "book/selectAllBook";
    }

    /**
     * @return  跳转到添加书籍页面
     */
    @RequestMapping(value = "/toAddBook")
    public String toAddBook(){
        return "book/addBook";
    }

    /**
     * 添加书籍页面
     * @param book  要添加的书籍
     * @return  返回展示所有书籍页面
     */
    @PostMapping("/addBook")
    public String addBook(Books book){
        bookService.addBook(book);
        return "redirect:/book/selectAllBook";
    }

    /**
     * @return  跳转到更新书籍页面
     */
    @RequestMapping("toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books book = bookService.selectBookById(id);
        model.addAttribute("book",book);
        return "book/updateBook";
    }


    @PostMapping("/updateBook")
    public String updateBook(Books book){
        bookService.updateBook(book);
        return "redirect:/book/selectAllBook";
    }

    @RequestMapping("/delete/{bookid}")
    public String deleteBook(@PathVariable("bookid")int id){
        int i = bookService.deleteBookById(id);

        return "redirect:/book/selectAllBook";
    }
}
