package cn.tedu.ems.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;

/**
 * 持久层接口
 *
 */
@Repository("userDAO")
public interface UserDAO {
	public User findByUsername(String uname); 
	
}






