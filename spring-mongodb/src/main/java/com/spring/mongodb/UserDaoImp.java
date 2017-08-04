package com.spring.mongodb;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;

public class UserDaoImp implements UserDao {

	private MongoTemplate mongoTemplate;   

	public List<User> findAll() {
		return getMongoTemplate().find(new Query(), User.class);   
	}

	public void findAndModify(String id) {
		getMongoTemplate().updateFirst(new Query(Criteria.where("id").is(id)), new Update().inc("age", 3));

	}

	public List<User> findByRegex(String regex) {
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);   
		Criteria criteria = new Criteria("name").regex(pattern.toString());   
		return getMongoTemplate().find(new Query(criteria), User.class);   
	}

	public User findOne(String id) {
		return getMongoTemplate().findOne(new Query(Criteria.where("id").is(id)), User.class);   

	}

	public void insert(User User) {
		getMongoTemplate().insert(User);   
	}

	public void removeAll() {
		List<User> list = this.findAll();   
		if(list != null){   
		    for(User User : list){   
		        getMongoTemplate().remove(User);   
		    }   
		}   
	}
	
	public void removeOne(String id) {
		Criteria criteria = Criteria.where("id").in(id);   
        if(criteria != null){   
			Query query = new Query(criteria);   
			if(query != null && getMongoTemplate().findOne(query, User.class) != null)   
				getMongoTemplate().remove(getMongoTemplate().findOne(query, User.class));   
        }   
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
