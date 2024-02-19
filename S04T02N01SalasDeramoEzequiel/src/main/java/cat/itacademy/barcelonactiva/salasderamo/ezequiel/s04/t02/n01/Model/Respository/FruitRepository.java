package cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n01.Model.Respository;

import cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n01.Model.Domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
