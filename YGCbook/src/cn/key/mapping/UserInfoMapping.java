package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserInfoMapping implements IResultSetMapping{

	@Override
	public UserInfoHobby mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfoHobby userinfohobby = new UserInfoHobby(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
		return userinfohobby;
	}
}
