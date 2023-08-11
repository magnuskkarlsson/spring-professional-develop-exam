package se.mkk.springprofessionaldevelopexam.section4testing;

public class Person {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
