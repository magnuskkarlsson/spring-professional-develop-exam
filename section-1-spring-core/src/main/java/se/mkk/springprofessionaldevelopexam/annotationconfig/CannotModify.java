package se.mkk.springprofessionaldevelopexam.annotationconfig;

public class CannotModify {

    public void postConstruct() {
        System.out.println("***** BEAN init *****");
    }

    public void preDestroy() {
        System.out.println("***** BEAN destroy *****");
    }
}
