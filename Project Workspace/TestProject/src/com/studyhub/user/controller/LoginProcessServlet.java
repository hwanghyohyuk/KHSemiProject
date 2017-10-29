package com.studyhub.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studyhub.user.model.service.UserService;
import com.studyhub.common.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginprocess")
public class LoginProcessServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private UserService uService;
   private User user;
   
   /**
    * @see HttpServlet#HttpServlet()
    */
   public LoginProcessServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      String userEmail = request.getParameter("email");
      String userPwd = request.getParameter("pwd");
      uService = new UserService();
      user = uService.loginCheck(userEmail, userPwd);
      RequestDispatcher view = null;
      if (user != null) {
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
         System.out.println("Session ID : " + session.getId());
        
         if(userEmail.equals("admin@admin.com")){
            view = request.getRequestDispatcher("/views/admin/MainDashBoard.jsp");
            view.forward(request, response);
         }else{
            response.sendRedirect("/studyhub/main");
         }         
      }else{
        view = request.getRequestDispatcher("/views/user/userError.jsp");
		request.setAttribute("messageheader", "로그인 오류");
		request.setAttribute("message", "이메일 혹은 비밀번호를 확인해주세요.");
		view.forward(request, response);
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}