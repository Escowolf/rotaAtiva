package com.rotativa.usersapi.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "usuari")
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "acessibilidade")
    private Boolean acessibilidade;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @Column(name = "quantidade_ticket")
    private Integer quantidadeTicket;

    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = { "usuario", "tipoPagamento" }, allowSetters = true)
    private Set<Pagamento> pagamentos = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
    private Set<Transacao> transacoes = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "rel_usuario__veiculos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "veiculos_id")
    )
    private Set<Veiculo> veiculos = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Usuari id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Usuari cpf(String cpf) {
        this.setCpf(cpf);
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Usuari nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAcessibilidade() {
        return this.acessibilidade;
    }

    public Usuari acessibilidade(Boolean acessibilidade) {
        this.setAcessibilidade(acessibilidade);
        return this;
    }

    public void setAcessibilidade(Boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public String getEmail() {
        return this.email;
    }

    public Usuari email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public Usuari senha(String senha) {
        this.setSenha(senha);
        return this;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public Usuari nascimento(LocalDate nascimento) {
        this.setNascimento(nascimento);
        return this;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTicket() {
        return this.quantidadeTicket;
    }

    public Usuari ticket(Integer ticket) {
        this.setTicket(ticket);
        return this;
    }

    public void setTicket(Integer ticket) {
        this.quantidadeTicket = ticket;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public Usuari estado(Boolean estado) {
        this.setEstado(estado);
        return this;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<Pagamento> getPagamentos() {
        return this.pagamentos;
    }

    public void setPagamentos(Set<Pagamento> pagamentos) {
        if (this.pagamentos != null) {
            this.pagamentos.forEach(i -> i.setUsuario(null));
        }
        if (pagamentos != null) {
            pagamentos.forEach(i -> i.setUsuario(this));
        }
        this.pagamentos = pagamentos;
    }

    public Usuari pagamentos(Set<Pagamento> pagamentos) {
        this.setPagamentos(pagamentos);
        return this;
    }

    public Usuari addPagamentos(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        pagamento.setUsuario(this);
        return this;
    }

    public Usuari removePagamentos(Pagamento pagamento) {
        this.pagamentos.remove(pagamento);
        pagamento.setUsuario(null);
        return this;
    }

    public Set<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        if (this.telefones != null) {
            this.telefones.forEach(i -> i.setUsuario(null));
        }
        if (telefones != null) {
            telefones.forEach(i -> i.setUsuario(this));
        }
        this.telefones = telefones;
    }

    public Usuari telefones(Set<Telefone> telefones) {
        this.setTelefones(telefones);
        return this;
    }

    public Usuari addTelefones(Telefone telefone) {
        this.telefones.add(telefone);
        telefone.setUsuario(this);
        return this;
    }

    public Usuari removeTelefones(Telefone telefone) {
        this.telefones.remove(telefone);
        telefone.setUsuario(null);
        return this;
    }

    public Set<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public void setTransacoes(Set<Transacao> transacaos) {
        if (this.transacoes != null) {
            this.transacoes.forEach(i -> i.setUsuario(null));
        }
        if (transacaos != null) {
            transacaos.forEach(i -> i.setUsuario(this));
        }
        this.transacoes = transacaos;
    }

    public Usuari transacoes(Set<Transacao> transacaos) {
        this.setTransacoes(transacaos);
        return this;
    }

    public Usuari addTransacoes(Transacao transacao) {
        this.transacoes.add(transacao);
        transacao.setUsuario(this);
        return this;
    }

    public Usuari removeTransacoes(Transacao transacao) {
        this.transacoes.remove(transacao);
        transacao.setUsuario(null);
        return this;
    }

    public Set<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Usuari veiculos(Set<Veiculo> veiculos) {
        this.setVeiculos(veiculos);
        return this;
    }

    public Usuari addVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
        return this;
    }

    public Usuari removeVeiculos(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuari)) {
            return false;
        }
        return id != null && id.equals(((Usuari) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            ", acessibilidade='" + getAcessibilidade() + "'" +
            ", email='" + getEmail() + "'" +
            ", senha='" + getSenha() + "'" +
            ", nascimento='" + getNascimento() + "'" +
            ", ticket=" + getTicket() +
            ", estado='" + getEstado() + "'" +
            "}";
    }
}
