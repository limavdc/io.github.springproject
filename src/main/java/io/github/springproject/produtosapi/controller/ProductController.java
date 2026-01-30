package io.github.springproject.produtosapi.controller;
import io.github.springproject.produtosapi.model.Product;
import io.github.springproject.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

///Esta classe Recebe as requisições

@RestController //Vai receber requisicoes rest com essa anotacao
@RequestMapping("products") //Qual é a url base do controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping //tudo que vc recebe ou envia de um servidor rest é chamado de recurso
    public Product save(@RequestBody Product product) {
        System.out.println("Produto Recebido: " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("{id}")
    public Product obtainById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    //colocou void pois nao ira retornar nada nao ta fazendo nenhuma pesquisa em product
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String id) {
            productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> search(@RequestParam("nome") String nome) {
       return productRepository.findByNome(nome);
    }
}
