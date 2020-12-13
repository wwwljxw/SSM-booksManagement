package com.forever.controller;



import com.forever.dao.TypeMapper;
import com.forever.domain.Admin;
import com.forever.domain.Reader;
import com.forever.domain.Type;
import com.forever.service.AdminService;
import com.forever.service.ReaderService;
import com.forever.util.AjaxResult;
import com.forever.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderService readerService;

    /**
     *  跳转到用户注册
     */
    @RequestMapping("/register")
    public String register(){
        return "/register";
    }

    /**
     *  跳转到添加书籍页面
     */
    @RequestMapping("/addBook")
    public String addBook(Model model){
        List<Type> types = typeMapper.selectList(null);
        model.addAttribute("type", types);
        return "/book/addBook";
    }

    /**
     *  跳转到书籍分类
     */
    @RequestMapping("/bookType")
    public String bookType(){
        return "/book/bookType";
    }

    /**
     *  跳转到添加读者页面
     */
    @RequestMapping("/addReader")
    public String addReader(){
        return "/reader/addReader";
    }

    /**
     *  跳转到读者管理
     */
    @RequestMapping("/readerIndex")
    public String readerIndex(){
        return "/readerIndex";
    }

    /**
     *  跳转到书籍管理系统首页
     */
    @RequestMapping("/index")
    public String getIndex(Model model){
        List<Type> types = typeMapper.selectList(null);
        model.addAttribute("type", types);
        return "/index";
    }

    /**
     *  跳转到用户登录
     */
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }


    /**
     * 用户登录
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult doLogin(String name, String password, Integer access, HttpSession httpSession){
      AjaxResult ajaxResult = new AjaxResult();

        try {
//            管理员登录
            if (access.equals(0)){
                Admin admin = adminService.doLogin(name, password);
                if (admin != null){
                    httpSession.setAttribute(Const.ADMIN,admin);
                    ajaxResult.setStatus(0);
                }else {
                    ajaxResult.setStatus(2);
                    ajaxResult.setMessage("用户名或密码错误");
                }
            }else {
//                读者登录
                Reader reader = readerService.doLogin(name, password);
                if (reader != null){
                    httpSession.setAttribute(Const.READER,reader);
                    ajaxResult.setStatus(1);
                }else {
                    ajaxResult.setStatus(2);
                    ajaxResult.setMessage("用户名或密码错误");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setStatus(3);
            ajaxResult.setMessage("服务器异常，请晚些时候再登录！");
        }
        return ajaxResult;
    }

    /**
     *  退出登录
     * @return  返回登录页面
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/frontIndex")
    public String frontIndex(Model model){
        List<Type> types = typeMapper.selectList(null);
        model.addAttribute("type", types);
        return "/frontIndex";
    }

    @RequestMapping("/listDisBackAdmin")
    public String listDisBackAdmin(){
        return "/listDisBackAdmin";
    }

    @RequestMapping("/listDisBack")
    public String listDisBack(){
        return "/listDisBack";
    }

    /**
     * 跳转到修改密码
     */
    @RequestMapping("/toAlterPwd")
    public String alterPwd(){
        return "/alterPwd";
    }
}