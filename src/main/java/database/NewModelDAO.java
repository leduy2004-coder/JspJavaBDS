package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.laptrinhjava.model.NewModel;

public class NewModelDAO implements DAOInterface<NewModel> {

	public static NewModelDAO getInstance() {
		return new NewModelDAO();
	}

	@Override
	public int insert(NewModel t) {
		int ketQua = 0;

		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO news(id, title, categoryid, content)" + "VALUES (" + t.getId() + " , '"
					+ t.getTitle() + "' , " + t.getCategoryId() + " , '" + t.getContent() + "' )";
			ketQua = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi :" + sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ketQua;
	}

	@Override
	public int update(NewModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NewModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NewModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewModel selectById(NewModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NewModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
