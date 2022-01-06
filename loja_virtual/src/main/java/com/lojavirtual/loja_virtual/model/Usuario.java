package com.lojavirtual.loja_virtual.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private long id;

    private String login;

    private String senha;

    @Temporal(TemporalType.DATE)
    private Date dataAtualSenha;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_acesso",
    uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"}, name = "unique_acesso_user"),

    joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
    foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),

    inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
    foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Acesso> acessos = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //~> Autoridades sao os acessos, ou seja ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO
        return this.acessos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}