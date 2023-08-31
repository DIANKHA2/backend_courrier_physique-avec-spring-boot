package com.webgram.dao;

import com.webgram.entity.Role;
import com.webgram.entity.RoleEnum;
import com.webgram.entity.TypeCourrierEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByLibelle(RoleEnum libelle);
}
