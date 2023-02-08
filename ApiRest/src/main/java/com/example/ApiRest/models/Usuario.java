package com.example.ApiRest.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date CreatedAt;

    @PrePersist
    public void prePresist(){
        CreatedAt = new Date();
    }
}
