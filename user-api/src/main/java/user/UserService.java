package user;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<User> users = new ArrayList<>(Arrays.asList(
			new User("spring", "Spring Framework", "Spring Framework Description"),
			new User("java", "Core Java", "Java Description"),
			new User("javascript", "Javascript", "Javascript Description")
			));
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUser(String id) {
		return users.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}

	public void addUser(User topic) {
		users.add(topic);
	}

	public void updateUser(String id, User user) {
		User temp = users.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		if(temp != null) users.set(users.indexOf(temp), user);
	}

	public void deleteUser(String id) {
		users.removeIf(t -> t.getId().equals(id));
	}
}
