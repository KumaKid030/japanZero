package co.jp.netwisdom.dto;

import java.util.ArrayList;
import java.util.List;

public class UserInfoHobbyDto {
	//用户名
	private String username;
	//密码
	private String password;
	//性别
	private String sex;
	//专业
	private String major;
	//简介
	private String intro;
	//爱好
	private List<HobbyDto> hobbyList = new ArrayList<HobbyDto>();
	//
	private String hobbys;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public List<HobbyDto> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<HobbyDto> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public String getHobbys() {
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	
	public UserInfoHobbyDto(String username, String password, String sex, String major, String intro) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.major = major;
		this.intro = intro;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
