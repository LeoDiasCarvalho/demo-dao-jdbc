/**
 * 
 */
package model.dao;

import model.dao.impl.SellerDaoJDBC;

/**
 * @author leo_dias
 *
 */
public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
