package com.project_service.project_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", nullable = false, unique = true, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 200)
    private String lastName;

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "cep", nullable = true, length = 9)
    private String cep;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
