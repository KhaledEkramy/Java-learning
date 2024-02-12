import java.util.Comparator;

public class Student {
    public final String name ;
    public final Integer ID ;
    public final Integer age ;
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final class ByName implements Comparator<Student>{
        public int compare(Student first, Student second){
            return first.name.compareTo(second.name) ;
        }
    }
    public static final Comparator<Student> BY_AGE = new ByAge();
    public static final class ByAge implements Comparator<Student>{
        public int compare(Student first, Student second){
            return first.age - second.age ;
        }
    }
    public static final Comparator<Student> BY_ID = new ById() ;
    public static final class ById implements Comparator<Student>{
        public int compare(Student first, Student second){
            return first.ID - second.ID ;
        }
    }
    public Student(String name, Integer id, Integer age){
        this.name =  name ;
        this.ID = id ;
        this.age = age ;
    }

    @Override
    public String toString(){
        return this.name + "\t" + this.ID + "\t" + this.age + "\n" ;
    }

}
