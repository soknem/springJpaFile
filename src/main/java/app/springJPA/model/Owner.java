package app.springJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Owner {
    @Id
    private  int id;
    @OneToMany
    public List<Product> product;
}
