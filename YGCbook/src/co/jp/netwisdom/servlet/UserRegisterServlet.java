package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;

public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//姓名
		String username = request.getParameter("username");
		//密码
		String password = request.getParameter("password");
		//性别
		String sex = request.getParameter("sex");
		//专业
		String major = request.getParameter("major");
		//简介
		String intro = request.getParameter("intro");
		//爱好（多选项，相当于数组）
		String[] hobbyArray =  request.getParameterValues("hobby");
		
		List hobbyList = new ArrayList();
		
		for(int i=0;i<hobbyArray.length;i++){
			Hobby hobbyObject = new Hobby();
			hobbyObject.setUsername(username);
			hobbyObject.setHobby(hobbyArray[i]);
			hobbyList.add(hobbyObject);
		}
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		HobbyDAO hobbyDAO = new HobbyDAO();
		

		//用户信息表登录
		if(userinfoDAO.save(new UserInfo(username,password,sex,major,intro))){
			System.out.println("用户信息表插入成功！！！");
		}else{
			System.out.println("用户信息表插入失败？？？");
		}
		//用户爱好表登录
		if(hobbyDAO.save(hobbyList)){
			System.out.println("用户爱好表插入成功！！！");
		}else{
			System.out.println("用户爱好表插入失败？？？");
		}
		
		
		//request.setAttribute("admin", admin);
		request.getRequestDispatcher("/background/sysAdmin/UserInfoSuccess.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}