package jsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserDatasource {

	public User getByUsernameAndPassword(String username, String password){
		
		try(FileReader fileReader = new FileReader(new File("d://user.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				
				// username,password,firstname,lastname,age
				String [] cols = line.split(",");
				
				if (cols[0].equals(username) && cols[1].equals(password)) {
					
					User user = new User();
					
					user.setUsername(cols[0]);
					user.setPassword(cols[1]);
					user.setFirstName(cols[2]);
					user.setLastName(cols[3]);
					user.setAge(Integer.parseInt(cols[4]));
					
					return user;
				}
			}
			
			// fileReader.close();
			// bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}