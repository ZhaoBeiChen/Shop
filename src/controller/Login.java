package controller;
import model.struct.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/16.
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String result = "";
        String userName = req.getParameter("userID");
        String passWord = req.getParameter("password");

        if((userName=="")||(userName==null)||(userName.length()>30)){
            result = "请输入用户名（不能超过30个字符！）";
            req.setAttribute("message",result);
            resp.sendRedirect("../Login.jsp");
        }
        else if((passWord=="")||(passWord==null)||(passWord.length()>20)){
            result = "请输入密码（不能超过20个字符！）";
            req.setAttribute("message",result);
            resp.sendRedirect("../Login.jsp");
        }
        else {
            User userCheck = new User();
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("message", result);
            session.setAttribute("status", "no");
            int check = userCheck.LoginCheck(userName, passWord);
            if (check == 1) {
                userCheck = userCheck.getUserInfo(userName);
                session.setAttribute("password", userCheck.getPaswsword());
                if(userCheck.getSex().equals("1"))
                    session.setAttribute("sex", "Male");
                else session.setAttribute("sex", "Female");
                session.setAttribute("phone", userCheck.getPhoneNumber());
                session.setAttribute("email", userCheck.getEmail());
                session.setAttribute("address", userCheck.getAddress());
                session.setAttribute("status", "yes");
                resp.sendRedirect("../"+session.getAttribute("NowPage")+".jsp");
            } else if (check == 0) {
                result = "密码有误，请重新输入！";
                req.setAttribute("message", result);
                resp.sendRedirect("../Login.jsp");
            } else if (check == -1) {
                result = "该用户不存在，请先注册！";
                req.setAttribute("messahe", result);
                resp.sendRedirect("../Login.jsp");
            } else if (check == -2) {
                result = "数据库连接出错,请通知管理员解决！";
                req.setAttribute("messahe", result);
                resp.sendRedirect("../Login.jsp");
            } else {
                result = "未知错误发生！请通知管理员解决！";
                req.setAttribute("messahe", result);
                resp.sendRedirect("../Login.jsp");
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
