package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Blah;

public class BlahDAOJdbcImpl implements BlahDAO{

	private DataSource dataSource;
		
	public BlahDAOJdbcImpl (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Blah> getBlahs(Blah blah) {
		
		Connection conn = null;
		SQLException ex = null;
		PreparedStatement stmt = null;
		List<Blah> blahs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT date,txt FROM t_blah WHERE NAME = ?");
			stmt.setString(1, blah.getName());
			ResultSet rs = stmt.executeQuery();
			blahs = new ArrayList<Blah>();
	while(rs.next()) {
				blahs.add(new Blah(blah.getName(),rs.getTimestamp(1),rs.getString(2)));
			}
		} catch(SQLException e){
			ex = e;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					ex = e;
				}
			}
		}
	if(ex != null) {
		throw new RuntimeException(ex);
	}
		return blahs;
	}
	@Override
	public void addBlah(Blah blah) {
		Connection conn = null;
		SQLException ex = null;
		PreparedStatement stmt = null;
		
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("INSERT INTO t_blah(name,date,txt)VALUES(?,?,?)");
			stmt.setString(1, blah.getName());
			stmt.setTimestamp(2, new Timestamp(blah.getDate().getTime()));
			stmt.setString(3, blah.getTxt());
			stmt.executeUpdate();
		} catch(SQLException e){
			ex = e;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					ex = e;
				}
			}
		}
	if(ex != null) {
		throw new RuntimeException(ex);
	}
	}
	@Override
	public void deleteBlah(Blah blah) {
		Connection conn = null;
		SQLException ex = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("DELETE FROM t_blah WHERE date = ?");
			stmt.setTimestamp(1, new Timestamp(blah.getDate().getTime()));
			stmt.executeUpdate();
		} catch(SQLException e){
			ex = e;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					ex = e;
				}
			}
		}
	if(ex != null) {
		throw new RuntimeException(ex);
	}
		
	}

}
