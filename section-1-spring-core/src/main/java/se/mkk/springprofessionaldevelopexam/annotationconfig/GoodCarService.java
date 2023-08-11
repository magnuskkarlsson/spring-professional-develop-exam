package se.mkk.springprofessionaldevelopexam.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("good")
public class GoodCarService implements CarService {
    private final int rating;

    @Autowired
    public GoodCarService(@Value("${param5.int}") int rating) {
        this.rating = rating;
    }

    @Override
    public int getStatus() {
        return rating;
    }
}
