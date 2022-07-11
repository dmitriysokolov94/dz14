package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.exeption.NotFoundException;

public class ProductRepositoryTest {

    Product book1 = new Book(6, "Шелкопряд", 700, "Иванов Иван");
    Product book2 = new Book(14, "великий гэтсби", 900, "Фрэнсис Скотт");
    Product book3 = new Book(16, "12 стульев", 850, "Катаев Евгений");

    Product smartphone1 = new Smartphone(8, "iPhone 13 Pro Max", 170_000, "APPLE");
    Product smartphone2 = new Smartphone(20, "Galaxy S22 Ultra", 120_000, "SAMSUNG");
    Product smartphone3 = new Smartphone(21, "P50 Pro", 100_000, "HUAWEI");


    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(6);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3, smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonexistentId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(50);
        });
    }
}