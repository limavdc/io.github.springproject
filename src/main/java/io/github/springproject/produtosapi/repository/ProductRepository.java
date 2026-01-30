package io.github.springproject.produtosapi.repository;


import io.github.springproject.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/// Classes que vão fazer operação no banco de dados

/// é um repository de produto por isso passa assim JpaRepository<Product, e aqui é a classe que representa o ID String>
public interface ProductRepository extends JpaRepository<Product, String> {


    List<Product> findByNome(String nome);
}
