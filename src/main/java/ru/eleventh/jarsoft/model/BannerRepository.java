package ru.eleventh.jarsoft.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    //    @Query(value = "SELECT b FROM Banner b "
    //        + "LEFT JOIN Request r "
    //        + "ON r.banner=b "
    //        + "WHERE "
    //        + "b.category.name=?1 AND b.deleted=false "
    //        //        + "AND r.ip=?2 AND r.userAgent=?3 "
    //        + "AND r.banner IS NULL "
    //        + "ORDER BY b.price")

    @Query(value = "SELECT b FROM Banner b "
        + "LEFT JOIN Request r "
        + "ON r.banner=b "
        + "WHERE "
        + "b.category.name=?1 AND b.deleted=false "
        //        + "AND r.ip=?2 AND r.userAgent=?3 "
        + "AND r.banner IS NULL "
        + "ORDER BY b.price")
    List<Banner> findOneByCategoryNameOrderByPrice(String categoryName, String ip, String userAgent);
    //    Banner findUnshownBannerInCategory(String categoryName, String ip, String userAgent);
}