package com.kartavya.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kartavya.app.entity.Post;
import com.kartavya.app.entity.User;
import com.kartavya.app.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	//CRUD
	
	public String createUser(User user) {
	    if (user.getPosts() != null) {
	        for (Post post : user.getPosts()) {
	            post.setUser(user);        // set back-reference
	            post.setPostId(0);         // force insert instead of update
	        }
	    }
	    repo.save(user); // cascade will save posts
	    return "User Created.";
	}

	
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
	}
	
	public String editUser(	int id,
							User newUser) {
		User old = repo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
		old.setUserName(newUser.getUserName());
		old.setEmail(newUser.getEmail());
		old.setFollowers(newUser.getFollowers());
		old.setFollowings(newUser.getFollowings());
	
		if (newUser.getPosts() != null) {
		    old.getPosts().clear(); // remove old posts if needed
		    for (Post post : newUser.getPosts()) {
		        post.setUser(old);   // reassign user
		   }
		}
		old.setPosts(newUser.getPosts());
		repo.save(old);
		
		return "User's data changed successfully";
	}

	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "User Deleted";
	}

	public String deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
		return "All users are deletted";
	}

	
}
