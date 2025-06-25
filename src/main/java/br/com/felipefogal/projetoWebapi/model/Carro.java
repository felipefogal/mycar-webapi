package br.com.felipefogal.projetoWebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carros")
public class Carro {

    @Id
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("fabricante")
    private String fabricante;

    @JsonProperty("anoFabricacao")
    private String anoFabricacao;

    @JsonProperty("anoModelo")
    private String anoModelo;

    @JsonProperty("quilometragem")
    private Long quilometragem;

    @JsonProperty("cor")
    private String cor;

    @JsonProperty("opcionais")
    private String opcionais;

    @JsonProperty("motorizacao")
    private String motorizacao;

    @JsonProperty("preco")
    private String preco;
}
