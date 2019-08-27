package com.offcn.demo5.controller;

import com.offcn.demo5.bean.User;
import com.offcn.demo5.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class UserController {

    @Autowired
    UserService userService;

    /***
     * 获取全部用户信息
     * @return
     */
    @GetMapping("/")
    public String getAll(Model model) {

        List<User> list = userService.getUserList();
        model.addAttribute("page",list);
        return "user/list";
    }

    /***
     * 跳转到新增用户界面
     * @param user
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(User user){
        return "user/userAdd";//跳转到userAdd.html
    }

    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public String add(User user){
        userService.createUser(user);
        return "redirect:/manageruser/";
    }

    /**
     * 跳转到编辑页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id")Long id){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.updateUser(user.getId(), user);
        return "redirect:/manageruser/";//获取列表数据并显示
    }


    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/manageruser/";

    }
}






























