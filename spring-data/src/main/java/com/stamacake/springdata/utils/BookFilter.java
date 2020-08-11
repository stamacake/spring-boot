package com.stamacake.springdata.utils;

import com.stamacake.springdata.entities.Book;
import com.stamacake.springdata.repositories.specifications.BookSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class BookFilter {
    private Specification<Book> spec;

    public BookFilter(Map<String, String> params) {
        spec = Specification.where(null);
        if (params.containsKey("fantastic") ) {
            spec = spec.or(BookSpecifications.genreEqual("Фантастика"));
        }
        if (params.containsKey("fantasy") ) {
            spec = spec.or(BookSpecifications.genreEqual("Фэнтези"));
        }
        if (params.containsKey("mystery") ) {
            spec = spec.or(BookSpecifications.genreEqual("Детектив"));
        }
        if (params.containsKey("maxPrice")) {
            spec = spec.and(BookSpecifications.priceLesserOrEqualsThan(Integer.parseInt(params.get("maxPrice"))));
        }

        if (params.containsKey("minPrice")) {
            spec = spec.and(BookSpecifications.priceGreaterOrEqualsThan(Integer.parseInt(params.get("minPrice"))));
        }

        if (params.containsKey("titlePart")) {
            spec = spec.and(BookSpecifications.titleLike(params.get("titlePart")));
        }

//        if (params.containsKey("fantasy") && params.containsKey("mystery") && params.containsKey("fantastic")) {
//            spec = spec.and(BookSpecifications.genreEqual("Фэнтези")).or(BookSpecifications.genreEqual("Детектив")).or(BookSpecifications.genreEqual("Фантастика"));
//        }else
//        if (params.containsKey("fantasy") && params.containsKey("mystery")) {
//            spec = spec.and(BookSpecifications.genreEqual("Фэнтези")).or(BookSpecifications.genreEqual("Детектив"));
//        }else
//        if (params.containsKey("fantasy") && params.containsKey("fantastic")) {
//            spec = spec.and(BookSpecifications.genreEqual("Фэнтези")).or(BookSpecifications.genreEqual("Фантастика"));
//        } else
//        if (params.containsKey("fantasy") ) {
//            spec = spec.and(BookSpecifications.genreEqual("Фэнтези"));
//        } else
//        if (params.containsKey("mystery") && params.containsKey("fantastic")) {
//            spec = spec.and(BookSpecifications.genreEqual("Детектив")).or(BookSpecifications.genreEqual("Фантастика"));
//        } else
//        if (params.containsKey("mystery") ) {
//            spec = spec.and(BookSpecifications.genreEqual("Детектив"));
//        }
//        else
//        if (params.containsKey("fantastic") ) {
//            spec = spec.and(BookSpecifications.genreEqual("Фантастика"));
//        }
//






    }
}
