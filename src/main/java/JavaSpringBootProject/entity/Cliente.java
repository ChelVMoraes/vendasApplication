package JavaSpringBootProject.entity;
import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="nome", length = 100)
    private String nome;

    public Integer getId() {return id; }

    public void setId(Integer id) {this.id = id;  }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome; }
}
