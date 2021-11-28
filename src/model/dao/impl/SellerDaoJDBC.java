/**
 * 
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import banco.BancoException;
import banco.Conexao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 * @author leo_dias
 *
 */
public class SellerDaoJDBC implements SellerDao{
	
	// fazendo a dependencia com a conexao com o banco de dados
	private Connection conexao;
	
	public SellerDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Seller obj) {
		
	}

	@Override
	public void upDate(Seller obj) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("SELECT seller.*,department.Name as DepName "
                                         + "FROM seller INNER JOIN department "
                                         + "ON seller.DepartmentId = department.Id "
                                         + "WHERE seller.Id = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Seller seller = new Seller();
				seller.setId(rs.getInt("Id"));
				seller.setName(rs.getString("Name"));
				seller.setEmail(rs.getString("Email"));
				seller.setBaseSalary(rs.getDouble("BaseSalary"));
				seller.setBirthDate(rs.getDate("BirthDate"));
				seller.setDepartment(dep);
				
				return seller;
			}
			return null;
		}
		catch(SQLException e) {
			throw new BancoException(e.getMessage());
		}
		finally {
			Conexao.FechamentoStatement(st);
			Conexao.FechamentoResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}

}
