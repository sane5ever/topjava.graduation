package ru.javaops.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.restaurantvoting.model.Restaurant;

import java.util.Optional;

@Transactional(readOnly = true)
@RepositoryRestResource(path = RestaurantRepository.URL/*, excerptProjection = RestaurantDefaultProjection.class*/)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    String URL = "restaurants";

    @RestResource(rel = "by-name", path = "by-name")
    Optional<Restaurant> findByNameIgnoreCase(String name);
}
