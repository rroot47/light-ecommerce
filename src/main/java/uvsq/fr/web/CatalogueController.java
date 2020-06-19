package uvsq.fr.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uvsq.fr.dao.ProductRepository;
import uvsq.fr.entities.Products;

import javax.print.attribute.standard.MediaTray;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class CatalogueController {

    private ProductRepository productRepository;

    public CatalogueController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/photoProducts/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Products p=productRepository.findById(id).get();//pour recuperer le produit
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Images/prodlap/"+p.getPhotoName()));

    }

    @PostMapping(path="/uploadPhoto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void uploadPhoto(MultipartFile file, @PathVariable("id") Long id) throws Exception{
        Products p=productRepository.findById(id).get();
        //p.setPhotoName(file.getOriginalFilename());//le nom original
        p.setPhotoName(id+".jpeg");//pour la photo avec id du produit pour etre sur il est unique
        Files.write(Paths.get(System.getProperty("user.home")+"/Images/prodlap/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);

    }
}
