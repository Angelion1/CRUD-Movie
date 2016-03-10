package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import movie.bean.Movie;

public class MovieDao extends BaseDao {

	public static boolean insert(Movie m1) {
		boolean res = false;
		Connection con = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into Movie " +
			" (title, category, movie_year, rating) values " + " (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, m1.getTitle());
			st.setString(i++, m1.getCategory());
			st.setString(i++, m1.getYear());
			st.setString(i++, m1.getRating());
			int n = st.executeUpdate();
			res = n > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeCon(con);
		}
		return res;
	}

	public static Movie search(String title) {
		Movie res = null;
		Connection con = null;
		try {
			con = BaseDao.getCon();
			String sql = "select * from Movie where title = ?";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, title);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				Movie m1 = new Movie();
				m1.setTitle(rs.getString("title"));
				m1.setCategory(rs.getString("category"));
				m1.setYear(rs.getString("movie_year"));
				m1.setRating(rs.getString("rating"));
				res = m1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeCon(con);
		}
		return res;
	}
	
	public static boolean delete(String title) {
		boolean res = false;
		Connection con = null;
		try {
			con = BaseDao.getCon();
			String sql = "delete from Movie where title = ?";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, title);
			int n = st.executeUpdate();
			if(n > 0){
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeCon(con);
		}
		return res;
	}
	
	
	public static boolean isExists(String title){
		boolean res = false;
		if(search(title)!=null){
			res = true;
		}
		return res;
	}

}
