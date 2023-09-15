package com.onursir.rentACar.DataAccess.abstracts;

import com.onursir.rentACar.Entites.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand,Integer> {

    boolean existsByName(String name); //exists adında fonksiyon oluşturduğumuz için JpaRepo gidip data'da name'i otomatik arıyor.
                                       // bu özel metotlar spring jpa keywords olarak geçer.


}
