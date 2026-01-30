package io.github.springproject.produtosapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


///  POJO -> Plain Old Java Object
///  Modelo de negocios
/// @Column(name = "id") essa anotacao define que vai ser uma coluna no banco de dados ai caso o nome for diferente da tabela criada coloca (name = "id")


@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;


}
