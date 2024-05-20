package com.tsarankou.clientservice.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String patronymic;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emailList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
