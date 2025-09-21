package br.com.felipefogal.projetoWebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "enderecos")
public class Endereco {
    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("rua")
    private String rua;

    @JsonProperty("numero")
    private long numero;

    @Nullable
    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("tipo_endereco")
    private String tipoEndereco;
}
