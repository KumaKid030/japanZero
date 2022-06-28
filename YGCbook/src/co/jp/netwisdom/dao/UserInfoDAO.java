package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserInfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	public boolean save(UserInfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro) " +
						" values(?,?,?,?,?)";
		Object[] values = new Object[]{
			userinfo.getUsername(),
			userinfo.getPassword(),
			userinfo.getSex(),
			userinfo.getMajor(),
			userinfo.getIntro(),
		};
		
		
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return (row == 1);
	}

	
	public List<UserInfoHobby> findUserInfoAndHobby(String username, String sex, String major) {
		String sql = "select userinfo.username,password,sex,major,intro,hobby "
				+ "from userinfo left join hobby on userinfo.username = hobby.username where ";
		//用户名
		if(!"".equals(username)){
			sql = sql + " username =" + "'" + username + "' and";
		}
		//性别
		sql = sql + " sex =" + "'" + sex + "'";
		//专业
		if(!"".equals(major)){
			sql = sql + " and major =" + "'" + major + "'";
		}
		
			
		List<UserInfoHobby> list = new Vector<UserInfoHobby>();
		try {
			list = template.selete(sql, new UserInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}

