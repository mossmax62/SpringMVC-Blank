package cl.max.acf.spring_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.max.acf.spring_mvc.domain.Product;

@Repository(value = "productDao")
public class JPAProductDao implements ProductDao{
	
	private EntityManager em = null;
	
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Product> getProductsList() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Product p order by p.id").getResultList();
	}

	@Transactional(readOnly=false)
	public void saveProduct(Product prod) {
		// TODO Auto-generated method stub
		em.merge(prod);
	}
	
	

}
