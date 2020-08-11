package com.stamacake.springdata.repositories.specifications;


import com.stamacake.springdata.entities.Book;
import com.stamacake.springdata.entities.Genre;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {
    public static Specification<Book> priceGreaterOrEqualsThan(int minPrice) {

        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);  // where b.price >= minPrice
    }

    public static Specification<Book> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice); // where b.price <= maxPrice
    }

    public static Specification<Book> titleLike(String titlePart) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart)); // where b.title like %titlePart%
    }

    public static Specification<Book> genreEqual(String genre){
        Genre genre1;
        if(genre.equals("Фэнтези")){
            genre1=Genre.FANTASY;
        } else
        if(genre.equals("Фантастика")){
            genre1=Genre.FANTASTIC;
        } else
        if(genre.equals("Детектив")){
            genre1=Genre.MYSTERY;
        } else throw new RuntimeException("Отсутствует жанр");
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("genre"),genre1); // where b.title like %titlePart%

    }

}
