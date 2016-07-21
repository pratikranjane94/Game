package com.game.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.game.dto.GameInfo;

@Repository(value="GameDaoImp")
public class GameDaoImp implements GameDao {

	//creating session factory
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	//getting all data of package name with download link
	public List<GameInfo> checkLink(String packageName) {
		session=sessionFactory.openSession(); 	//creating session
		
		Query query=session.createQuery("from GameInfo where packageName=?");
		query.setString(0, packageName);
		
		List<GameInfo> link=query.list(); //all data is fetched related to package name
		if(link!=null && link.size()>0)
			return link;
		else
			return null;
	}

}
