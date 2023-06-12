package com.devsuperior.DesafioCrudClientes.dto;

import com.devsuperior.DesafioCrudClientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDto {

    private Long id;
    @Size(min=3, max=80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    private String cpf;
    @PositiveOrZero(message = "Valor inválido")
    private Double income;
    @PastOrPresent(message = "Data inválida")
    private LocalDate birthDate;
    @PositiveOrZero(message = "Valor inválido")
    private Integer children;

    public ClientDto(){
    }
    public ClientDto(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDto(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public Double getIncome() {
        return income;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Integer getChildren() {
        return children;
    }
}

