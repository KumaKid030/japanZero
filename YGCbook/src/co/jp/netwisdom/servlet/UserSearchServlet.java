package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserInfoHobbyDto;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//姓名
		String username = request.getParameter("username");
		//性别
		String sex = request.getParameter("sex");
		//专业
		String major = request.getParameter("major");
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		List<UserInfoHobby> list = userinfoDAO.findUserInfoAndHobby(username, sex, major);
		
		List<UserInfoHobbyDto> dtos = new ArrayList<UserInfoHobbyDto>();
		Map<String, String> UserNameMap = new HashMap<String, String>();
		//标识dto是否被创建
		List<String> UserNames = new ArrayList<String>();
		
		System.out.println("用户信息如下:");
		for(UserInfoHobby userinfohobby:list){
			//当用户名不存在时，证明大的dto未创建
			if(!UserNames.contains(userinfohobby.getUsername())){
				UserInfoHobbyDto dto = new UserInfoHobbyDto(userinfohobby.getUsername(),
						userinfohobby.getPassword(),userinfohobby.getSex(),
						userinfohobby.getMajor(),userinfohobby.getIntro());
				//将创建的大的dto加到画面展示List里去
				dtos.add(dto);
				//将用户名加到用户名List里去
				UserNames.add(userinfohobby.getUsername());
				//将爱好加入子dto中
				if(userinfohobby.getHobby()!=null){
					dto.getHobbyList().add(new HobbyDto(userinfohobby.getHobby()));
				}
			}else{
				//取得以往添加过的大的dto
				for(UserInfoHobbyDto temp : dtos){
					if(temp.getUsername().equals(userinfohobby.getUsername())){
						//将爱好加入子dto中
						if(userinfohobby.getHobby()!=null){
							temp.getHobbyList().add(new HobbyDto(userinfohobby.getHobby()));
						}
					}
				}
			}
		}
		
		request.setAttribute("dtos",dtos);
		
		
		for(UserInfoHobbyDto result : dtos){
			System.out.println("--------------------------------");
			System.out.println("姓名:" + result.getUsername());
			System.out.println("密码:" + result.getPassword());
			System.out.println("性别:" + result.getSex());
			System.out.println("专业:" + result.getMajor());
			System.out.println("简介:" + result.getIntro());
			System.out.print("爱好:");
			
			StringBuffer sb = new StringBuffer("");
			
			for(HobbyDto hobbyDto : result.getHobbyList()){
				if(hobbyDto.getHobby() !=null){
					sb.append(hobbyDto.getHobby() + ",");
				}
			}
		
			result.setHobbys(sb.toString().replace("0","足球").replace("1","篮球").replace("2","网球"));
			if(!"".equals(result.getHobbys())){
				if(",".equals(result.getHobbys().substring(result.getHobbys().length()-1))){
					result.setHobbys(result.getHobbys().substring(0,result.getHobbys().length()-1));
				}else{		
					result.setHobbys(result.getHobbys());
				}
			}
			System.out.println("");
		}	
		//
		System.out.println("向画面进行表示");
		

		
		//HobbyDAO hobbyDAO = new HobbyDAO();
		

		/*//用户信息表登录
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
		}*/
		
		
		
		request.getRequestDispatcher("/userSearch.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}