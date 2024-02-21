package cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n02.Model.Repository;

import cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n02.Model.Domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
