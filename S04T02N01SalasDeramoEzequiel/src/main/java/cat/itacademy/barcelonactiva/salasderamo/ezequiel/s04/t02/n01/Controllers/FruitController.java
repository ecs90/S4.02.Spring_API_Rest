package cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n01.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n01.Model.Respository.FruitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit){
        try {
            Fruit _fruit = fruitRepository
                    .save(new Fruit(fruit.getName(), fruit.getQuantityKg()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> update(@RequestBody Fruit fruit){
        Optional<Fruit> fruitData = fruitRepository.findById(fruit.getId());

        if (fruitData.isPresent()) {
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setQuantityKg(fruit.getQuantityKg());
            return new ResponseEntity<>(fruitRepository.save(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id){
        try {
            fruitRepository.deleteById(Integer.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable String id){
        Optional<Fruit> tutorialData = fruitRepository.findById(Integer.valueOf(id));

        return tutorialData.map(fruit -> new ResponseEntity<>(fruit, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    public List<Fruit> getAll(){
        return fruitRepository.findAll();
    }
}
