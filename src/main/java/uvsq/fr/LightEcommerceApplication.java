package uvsq.fr;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import uvsq.fr.dao.CategoryRepository;
import uvsq.fr.dao.ProductRepository;
import uvsq.fr.entities.Category;
import uvsq.fr.entities.Products;

import java.util.Random;


@SpringBootApplication
public class LightEcommerceApplication  implements CommandLineRunner{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LightEcommerceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Products.class, Category.class);//pour exposer id au demarrage
        categoryRepository.save(new Category(null,"Computers", null,null, null));
        categoryRepository.save(new Category(null,"Printers", null, null, null));
        categoryRepository.save(new Category(null,"Smart Phome", null, null, null));

        Random rnd= new Random();
        categoryRepository.findAll().forEach(c->{

            for (int i = 0; i <10 ; i++) {

                Products p=new Products();
                p.setName(RandomString.make(9));//pour le nom aleatoire des produits
                p.setCurentprice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("Ordi.jpg");
                productRepository.save(p);
            }

        });
    }
}
