package movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import movie.bean.Movie;
import movie.dao.MovieDao;
import movie.util.Validator;

public class MovieApp {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("----------------Welcome--------------------");
				System.out.println("To add press a");
				System.out.println("To update press u");
				System.out.println("To search press s");
				System.out.println("To delete press d");
				System.out.println("To exit press e");
				String ch = br.readLine();
				if("a".equalsIgnoreCase(ch)){
					Movie m1 = new Movie();
					System.out.println("Title??");
					m1.setTitle(br.readLine());
					if(MovieDao.isExists(m1.getTitle())){
						System.out.println("Already Exists");
						continue;
					}
					System.out.println("Category??");
					m1.setCategory(br.readLine());
					System.out.println("Year??");
					m1.setYear(br.readLine());
					if(!Validator.validateYear(m1.getYear())){
						System.out.println("Invalid Year!!");
						continue;
					}
					System.out.println("Rating??");
					m1.setRating(br.readLine());
					if(!Validator.validateRating(m1.getRating())){
						System.out.println("Invalid rating!!");
						continue;
					}
					if(MovieDao.insert(m1)){
						System.out.println("Done!!");
					}
					else{
						continue;
					}
					
				}
				else if("u".equalsIgnoreCase(ch)){
					//update
				}
				else if("s".equalsIgnoreCase(ch)){					
					System.out.println("Title??");
					Movie m1 = MovieDao.search(br.readLine());
					if(m1 == null){
						System.out.println("Not Found!!");
						continue;
					}
					System.out.println(m1.getTitle() + " : " + m1.getCategory() + " : " + m1.getYear()+ " : " + m1.getRating());
					
				}
				else if("d".equalsIgnoreCase(ch)){
					Movie m1 = new Movie();
					System.out.println("Title??");
					m1.setTitle(br.readLine());
					if(MovieDao.search(m1.getTitle()) == null){
						System.out.println("Does Not Exist!!");
						continue;
					}
					if(MovieDao.delete(m1.getTitle())){
						System.out.println("Done!!");
					}
				}
				else if("e".equalsIgnoreCase(ch)){
					break;
				}
				else{
					System.out.println("Invalid option!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
