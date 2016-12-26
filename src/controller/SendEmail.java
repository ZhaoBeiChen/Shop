package controller;

import model.struct.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;

/**
 * Created by asus-pc on 2016/12/25.
 */
@WebServlet(name = "SendEmail")
public class SendEmail extends HttpServlet {

    protected static String myAccount = "15024911146@163.com";
    protected static String myPasswd = "118223wxm";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userID = request.getParameter("ForgetPW_userID");
        User user = new User();
        user = user.getUserInfo(userID);
        String  email = user.getEmail();
        Properties pros = new Properties();
        pros.setProperty("mail.transport.protocol","smtp");
        pros.setProperty("mail.host", "smtp.163.com");
        pros.setProperty("mail.smtp.auth","true");

        Session session = Session.getDefaultInstance(pros);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccount,"GameShop","UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
            message.setSubject("修改密码","UTF-8");
            message.setContent("<a href='http://localhost:8080/Shop/ResetThePassword.jsp'>请点击这里重置密码</a>","text/html; charset=UTF-8");
            message.setSentDate(new Date());
            message.saveChanges();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            Transport transport = session.getTransport();
            transport.connect(myAccount,myPasswd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("FG_user",userID);
        response.sendRedirect("../Login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
