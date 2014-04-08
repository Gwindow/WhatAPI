package api.user;

import api.user.recent.UserRecents;

/**
 * All information about a user's profile, contains their user info and recent torrents
 */
public class UserProfile {
	private User user;
	private UserRecents userRecents;

	public static UserProfile fromId(int id){
		UserProfile p = new UserProfile();
		p.user = User.fromId(id);
		p.userRecents = UserRecents.recentsForUser(id);
		return p;
	}

	public User getUser(){
		return user;
	}

	public UserRecents getUserRecents(){
		return userRecents;
	}

	public boolean getStatus(){
		return user != null && user.getStatus() && userRecents != null && userRecents.getStatus();
	}

	@Override
	public String toString(){
		return "UserProfile [status=" + (getStatus() ? "true" : "false") + ", user=" + user
			+ ", userRecents=" + userRecents + "]";
	}
}
