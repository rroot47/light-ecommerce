package uvsq.fr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uvsq.fr.entities.Products;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Products, Long> {

    @RestResource(path = "/selectedProducts")
    public List<Products> findBySelectedIsTrue();//pour retourne les produits selectionner

    @RestResource(path = "/productsByKyword")
    public List<Products> findByNameContains(@Param("mc") String mc);//pour chercher un produits avec un mot clé

    @RestResource(path = "/promotionProducts")
    public List<Products> findByPromotionIsTrue();//pour retourne les produits en promotion

    @RestResource(path = "/disponobleProducts")
    public List<Products> findByAvailableIsTrue();//pour retourne les produits disponible

    //chercherProducts;

   /*@Query("select p from Products p where p.name like :x")
     public List<Products> chercher(@Param("x") String mc);

    */
}
