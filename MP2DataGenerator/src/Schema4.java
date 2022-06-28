import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class Schema4 {
//	CREATE TABLE Movie(mov_id INT PRIMARY KEY, mov_title CHAR(50), mov_year INT, mov_time INT, mov_lang CHAR(50), mov_dt_rel date, mov_rel_country CHAR(5));

	 public static long insertMovie(int ID, String title,int year, int time, String lang,Date releaseDate, String movieCountry, Connection conn) {
         String SQL = "INSERT INTO Movie(mov_id,mov_title,mov_year,mov_time,mov_lang,mov_dt_rel,mov_rel_country) "
                 + "VALUES(?,?,?,?,?,?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setString(2, title);
                pstmt.setInt(3, year);
                pstmt.setInt(4, time);
                pstmt.setString(5, lang);
                pstmt.setDate(6, releaseDate);
                pstmt.setString(7, movieCountry);

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
	 
//	 CREATE TABLE Reviewer(rev_id INT PRIMARY KEY, rev_name CHAR(30));

	 public static long insertReviewer(int ID, String name, Connection conn) {
         String SQL = "INSERT INTO Reviewer(rev_id,rev_name) "
                 + "VALUES(?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setString(2, name);
            

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
//	 CREATE TABLE Genres(gen_id INT PRIMARY KEY, gen_title CHAR(20));
	 public static long insertGenres(int ID, String title, Connection conn) {
         String SQL = "INSERT INTO Genres(gen_id,gen_title) "
                 + "VALUES(?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setString(2, title);
            

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }

//	 CREATE TABLE Actor(act_id INT PRIMARY KEY, act_fname CHAR(20), act_lname CHAR(20), act_gender CHAR(1));
	 public static long insertActor(int ID, String fName,String lName, String gender, Connection conn) {
         String SQL = "INSERT INTO Actor(act_id,act_fname,act_lname,act_gender) "
                 + "VALUES(?,?,?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setString(2, fName);
                pstmt.setString(3, lName);
                pstmt.setString(4, gender);


             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
//	 CREATE TABLE Director(dir_id INT PRIMARY KEY, dir_fname CHAR(20), dir_lname CHAR(20));
	 public static long insertDirector(int ID, String fName,String lName, Connection conn) {
         String SQL = "INSERT INTO Director(dir_id,dir_fname,dir_lname) "
                 + "VALUES(?,?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setString(2, fName);
                pstmt.setString(3, lName);

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
//	 CREATE TABLE movie_direction(dir_id INT REFERENCES Director, mov_id INT REFERENCES Movie, PRIMARY KEY(dir_id,mov_id));
	 public static long insertMovieDirection(int ID, int movieID, Connection conn) {
         String SQL = "INSERT INTO movie_direction(dir_id,mov_id) "
                 + "VALUES(?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, ID);
                pstmt.setInt(2, movieID);
            

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
//	 CREATE TABLE movie_cast(act_id INT REFERENCES Actor, mov_id INT REFERENCES Movie, role CHAR(30), PRIMARY KEY(act_id, mov_id));

	 public static long insertMovieCast(int actorID, int movieID,String role, Connection conn) {
         String SQL = "INSERT INTO movie_cast(act_id,mov_id,role) "
                 + "VALUES(?,?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, actorID);
                pstmt.setInt(2, movieID);
                pstmt.setString(3, role);

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
	 
//	 CREATE TABLE movie_genres(mov_id INT REFERENCES Movie, gen_id INT REFERENCES genres, PRIMARY KEY(mov_id,gen_id));
	 public static long insertMovieGenres(int movieID, int genreID, Connection conn) {
         String SQL = "INSERT INTO movie_genres(mov_id,gen_id) "
                 + "VALUES(?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, movieID);
                pstmt.setInt(2, genreID);
            

             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
//	 CREATE TABLE Rating(mov_id INT REFERENCES Movie, rev_id INT REFERENCES Reviewer, rev_stars INT, num_o_ratings INT, PRIMARY KEY(mov_id,rev_id));
	 public static long insertRating(int movieID, int reviewID,int stars, int rating, Connection conn) {
         String SQL = "INSERT INTO Rating(mov_id,rev_id,rev_stars,num_o_ratings) "
                 + "VALUES(?,?,?,?);";
      
         long id = 0;
        try{
        	 conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
     
                pstmt.setInt(1, movieID);
                pstmt.setInt(2, reviewID);
                pstmt.setInt(3, stars);
                pstmt.setInt(4, rating);


             int affectedRows = pstmt.executeUpdate();
             System.out.println("Number of affected rows is " + affectedRows);
             // check the affected rows 
             if (affectedRows > 0) {
                 // get the ID back
                 try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                	 System.out.println(rs.next());
                     if (rs.next()) {
                         id = rs.getLong(1);
                         pstmt.close();
                         conn.commit();
                     }
                 } catch (SQLException ex) {
                	 ex.printStackTrace();
                     System.out.println(ex.getMessage());
                 }
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             ex.printStackTrace();
         }
         return id;
     }
	 
	 
	 
	 
	////////////////////////////////////////////////////////// Data Population Methods ////////////////////////////////////////////////////////// 
	 @SuppressWarnings("deprecation")
	public static void populateMovie(Connection conn) {
		 for (int i = 1; i < 100001; i++) {
			 	String movie_title = "Movie"+1;
			 	if(i == 1) {
			 		movie_title = "Eyes Wide Shut";
			 	}
			 	if(i == 2) {
			 		movie_title = "Annie Hall";
			 	}
				if (insertMovie(i, movie_title ,i, i, "EN", new Date(22,1,1999), "US", conn) == 0) {
					System.err.println("insertion of record " + i + " failed");
					break;
				} else
					System.out.println("insertion was successful");
			}
	 }
	 
		public static void populateReviewer(Connection conn) {
			 for (int i = 1; i < 10000; i++) {

					if (insertReviewer(i, "Name" + i, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		public static void populateGenres(Connection conn) {
			 for (int i = 1; i < 100001; i++) {

					if (insertGenres(i, "Gnere" + i, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		public static void populateActor(Connection conn) {
			 for (int i = 1; i < 120001; i++) {
                     String result = "M";
                     if (i > 50000) 
                    	 result = "F";

					if (insertActor(i, "Actor" + i,"Actor" + i,result, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		public static void populateDirector(Connection conn) {
			 for (int i = 1; i < 6001; i++) {
                   	String f_name = "Actor "+i;
                   	String l_name = "Actor "+i+" Last";
                   	if(i == 1) {
                       	f_name = "Woddy";
                       	l_name = "Allen";
                   	}
					if (insertDirector(i, f_name, l_name, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		
		public static void populateMovieDirection(Connection conn) {
			 for (int i = 1; i < 100001; i++) {
				 	Random r = new Random();
				 	
				 	int j = r.nextInt(6001-1)+1;
				 	if(i <= 350) {
				 		j = 1;
				 	}
					if (insertMovieDirection(j, i, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		public static void populateMovieCast(Connection conn) {
			 for (int i = 1; i < 100001; i++) {
				 
				 	String role;
				 	Random r = new Random();
				 	int role_num = r.nextInt(40-10)+10;
				 	role ="Role "+role_num;
                  	if(i==2) {
                  		for(int j = 1; j <= 222 ; j++) {
        					if (insertMovieCast(j,  i,role, conn) == 0) {
        						System.err.println("insertion of record " + i + " failed");
        						break;
        					} else
        						System.out.println("insertion was successful");
                  		}
                  	}
                  	else {
                  		ArrayList<Integer> tmp = new ArrayList<>();
                  		
                  		int actor_count = r.nextInt(4-1)+1;
                  		int actor = r.nextInt(120001-1)+1;
                  		
                  		for(int k = 0; k < actor_count ; k++) {
                  			actor = r.nextInt(120001-1)+1;
                  			while(tmp.contains(actor)) {
                  				actor = r.nextInt(120001-1)+1;
                  			}
                  			tmp.add(actor);
                  			if (insertMovieCast(actor,  i,role, conn) == 0) {
        						System.err.println("insertion of record " + i + " failed");
        						break;
        					} else
        						System.out.println("insertion was successful");
                  		}
    					
                  		
                  	}
                  	
                  	
                  	
                  	
                  	

				}
		 }
		
		public static void populateMovieGenres(Connection conn) {
			 for (int i = 1; i < 100001; i++) {
				 	Random r = new Random();
				 	int genre = r.nextInt(100001-1)+1;
					if (insertMovieGenres(i, genre, conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		
		public static void populateRating(Connection conn) {
			 for (int i = 1; i < 100001; i++) {
                    Random r = new Random();
                    int review = r.nextInt(10000-1)+1;
                    int stars = r.nextInt(11-1)+1;
					if (insertRating(i, review, stars, (stars/10), conn) == 0) {
						System.err.println("insertion of record " + i + " failed");
						break;
					} else
						System.out.println("insertion was successful");
				}
		 }
		
		public static void insertSchema4(Connection connection) {
			populateMovie(connection);			
			populateReviewer(connection);			
			populateGenres(connection);			
			populateActor(connection);			
			populateDirector(connection);			
			populateMovieDirection(connection);			
			populateMovieCast(connection);			
			populateMovieGenres(connection);			
			populateRating(connection);
		}
		
	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/schema4", "postgres",
					"password");
             insertSchema4(connection);




		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
