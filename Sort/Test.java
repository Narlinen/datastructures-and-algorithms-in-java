import java.util.Comparator;

class Person {
	String name;
    int age;

	public Person(String name,int age) {
		this.name = name;
	    this.age = age;
	}
}

class cmp implements Comparator<Person> {
    @Override
	public int compare(Person a,Person b) {
	    return a.age - b.age;
	}
}

public class Test {
    public static void main(String[] args) {
	    Person p1 = new Person("小明",10);
		Person p2 = new Person("小红",20);
		Person p3 = new Person("小紫",15);

		Person[] arr = {p1,p2,p3};
        
        for(Person p : arr) {
		    System.out.println(p.name+" "+p.age);
		}

		Sort.<Person>mergeSort(arr,0,arr.length-1,new cmp());

        System.out.println("-----------");

        for(Person p : arr) {
		    System.out.println(p.name+" "+p.age);
		}


        System.out.println("...");
	}
}
