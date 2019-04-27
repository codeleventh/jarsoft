package ru.eleventh.jarsoft.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findTopByCategoryNameOrderByPrice(String categoryName);
}