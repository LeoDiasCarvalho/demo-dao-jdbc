/**
 * 
 */
package aplications;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 * @author leo_dias
 *
 */
public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: findById ===");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("=== Test 2: findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== Test 3: findAll ===");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 4: insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido novo id: " + newSeller.getId());
		
		
		System.out.println();
		System.out.println("=== Test 5: upDate ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.upDate(seller);
		System.out.println("Update completo!");
		
		System.out.println();
		System.out.println("=== Test 5: upDate ===");
		System.out.print("Digite o id a ser excluido: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completo!");
		sc.close();
		
	}

}
