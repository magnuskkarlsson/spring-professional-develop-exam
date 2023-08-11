package se.mkk.springprofessionaldevelopexam.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("lazy")
@Lazy
public class LazyCarService implements CarService {
    private final int rating;

    @Autowired
    public LazyCarService(@Value("${param6.int}") int rating) {
        this.rating = rating;
    }

    @Override
    public int getStatus() {
        return rating;
    }
}
