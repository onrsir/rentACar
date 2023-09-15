package com.onursir.rentACar.DataAccess.abstracts;

import com.onursir.rentACar.Entites.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDao extends JpaRepository<Model,Integer> {
}
