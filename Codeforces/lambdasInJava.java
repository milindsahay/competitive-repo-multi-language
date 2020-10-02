
package learnJava;

/*
javac -version
javac LambdaInJava.java -d ClassFiles
java -cp ClassFiles learnJava.LambdaInJava
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.Random;


class LambdaDemo {
    public void workingWithLambda() {
        String[] friends = { "Peter", "Paul", "Mary" };
        
// Lamdba Expression : (first, second) -> first.length() - second.length()
//		Takes Two Arguments And Return One Value
//			Arguments and Return Value's Type Will Be Inference
//			From Type of Data It Will Be Invoked.
//		e.g. In This case
// 			first and second will be String Type
//	        Return Type Will Be Int        
//		Can Be Passed To Function
        Arrays.sort(friends,
                (first, second) -> first.length() - second.length() );

        System.out.println(Arrays.toString(friends));
        ArrayList<String> enemies = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));

// Lamdba Expression : e -> e == null
//		Takes One Arguments And Return One Value
//			Arguments and Return Value's Type Will Be Inference
//			From Type of Data It Will Be Invoked.
//		e.g. In This case
// 			e will be String Type
//	        Return Type Will Be Bool
//		Can Be Passed To Function
        enemies.removeIf( e -> e == null );
        System.out.println(enemies);        
    }
}


class MethodReferenceDemo {
    public void workingWithMethodReferences() {
        String[] strings = { "Mary", "had", "a", "little", "lamb" };

        // :: Function References Access Operator 
        // Passing Reference of compareToIgnoreCase Function
        Arrays.sort(strings, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strings));

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));

		// :: Function References Access Operator 
		// Passing Reference of isNull Function
        list.removeIf(Objects::isNull);
        
        // :: Function References Access Operator 
        // Passing Reference of println Function
        list.forEach(System.out::println);
    }
}

//___________________________________________________________________________
// import java.util.ArrayList;

class Employee {
    private String name;
    private double salary;
        
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public Employee(String name) { this(name, 0); }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

class ConstructorReferenceDemo {
    public static void workingWithConstructorReference() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Paul");
        names.add("Mary");
        // ::new Is Constuctor Reference 
        
        Employee[] employees = names.stream().map( Employee::new ).toArray(Employee[]::new );

        for (Employee e : employees) {
        	System.out.println(e.getName());
        	System.out.println(e.getSalary());
        }
    }
}

//______________________________________________________________

@FunctionalInterface
interface FuncInterface { 	
	void abstractFun(int x);  // An abstract function 
} 

class FuncInterfaceDemo { 
	public void workingWithFunctionalInterfaces() { 
		FuncInterface object = (int x) -> System.out.println(2*x); 
		object.abstractFun(5); 
	} 
} 

//______________________________________________________________

class FunctionalInterfaceDemo {	
	interface FunctionalInterface1 { 
		int operation(int a, int b);
	} 

	interface FunctionalInterface2 { 
		void sayMessage(String message); 
	} 

	// Higher Order Function
	private int calculate(int a, int b, FunctionalInterface1 fobj)  { 
		return fobj.operation(a, b); 
	} 

	public void workingWithFunctionalInterfaces() {
		FunctionalInterface1 add = (int x, int y) -> x + y; 
		FunctionalInterface1 multiply = (int x, int y) -> x * y; 
		
		FunctionalInterfaceDemo object = new FunctionalInterfaceDemo(); 
		
		System.out.println("Addition is " + 
						object.calculate(6, 3, add)); 
		System.out.println("Multiplication is " + 
						object.calculate(6, 3, multiply)); 
		
		FunctionalInterface2 fobject = message ->System.out.println("Hello "
												+ message); 
		fobject.sayMessage("Geek"); 
	}

} 

//_____________________________________________________

class Person {
    private String first;
    private String middle;
    private String last;

    public Person(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }
    
    public String getFirstName() {
        return first;
    }
    
    public String getMiddleName() {
        return middle;
    }
    
    public String getLastName() {
        return last;
    }
    
    public String getName() {
        if (middle == null) {
            return first + " " + last;
        }
        else {
            return first + " " + middle + " " + last;
        }
    }
    
    public String toString() {
        return getName();
    }
}

class ComparatorDemo {
    public static void workingWithComparatorDemo() {
        Person[] people = {
                new Person("George", "Washington"),
                new Person("John", "Adams"),
                new Person("Thomas", "Jefferson"),
                new Person("James", "Madison"),
                new Person("James", "Monroe"),
                new Person("John", "Quincy", "Adams"),
                new Person("Andrew", "Jackson"),
                new Person("Martin", "van Buren"),
                new Person("William", "Henry", "Harrison"),
                new Person("John", "Tyler"),
                new Person("James", "Knox", "Polk"),
                new Person("Zachary", "Taylor"),
                new Person("Millard", "Fillmore"),
                new Person("Franklin", "Pierce"),
                new Person("James", "Buchanan"),
                new Person("Abraham", "Lincoln"),
                new Person("Andrew", "Johnson"),
                new Person("Ulysses", "S.", "Grant"),
                new Person("Rutherford", "Birchard", "Hayes"),
                new Person("James", "Abram", "Garfield"),
                new Person("Grover", "Cleveland"),
                new Person("Benjamin", "Harrison"),
                new Person("Grover", "Cleveland"),
                new Person("William", "McKinley"),
                new Person("Theodore", "Roosevelt"),
                new Person("William", "Howard", "Taft"),
                new Person("Woodrow", "Wilson"),
                new Person("Warren", "Gamaliel", "Harding"),
                new Person("Calvin", "Coolidge"),
                new Person("Herbert", "Hoover"),
                new Person("Franklin", "Delano", "Roosevelt"),
                new Person("Harry", "S.", "Truman"),
                new Person("Dwight", "David", "Eisenhower"),
                new Person("John", "Fitzgerald", "Kennedy"),
                new Person("Lyndon", "Baines", "Johnson"),
                new Person("Richard", "Mulhouse", "Nixon"),
                new Person("Gerald", "Ford"),
                new Person("James", "Earl", "Carter"),
                new Person("Ronald", "Reagan"),
                new Person("George", "Herbert Walker", "Bush"),
                new Person("William", "Jefferson", "Clinton"),
                new Person("George", "Walker", "Bush"),
                new Person("Barack", "Hussein", "Obama")
        };
                
        Arrays.sort(people, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(people));
        
        Arrays.sort(people,
                Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName));
        System.out.println(Arrays.toString(people));
        
        Arrays.sort(people, Comparator.comparing(Person::getName,
                (s, t) -> s.length() - t.length()));
        
        Arrays.sort(people, Comparator.comparingInt( 
        	p -> p.getName().length() ));
        
        System.out.println(Arrays.toString(people));
        
        Arrays.sort(people, comparing(Person::getMiddleName,
                nullsFirst(naturalOrder())));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, comparing(Person::getName,
                reverseOrder()));
        System.out.println(Arrays.toString(people));
    }
}

//_____________________________________________________

class HigherOrderFunctions {
	// Higher Order Function
	// 		Function Returning Function 
    public Comparator<String> compareInDirecton(int direction) {
        return (x, y) -> direction * x.compareTo(y);
    }
    
    // Higher Order Function
    // 		Function Taking Function Argument
    // 		Function Returning Function

    public Comparator<String> reverse(Comparator<String> comp) {
        return (x, y) -> -comp.compare(x, y);
    }
    
    public void workingWithHigherOrderFunctions() {
        String[] words = { "Mary", "had", "a", "little", "lamb" };
        Arrays.sort(words, compareInDirecton(-1));
        System.out.println(Arrays.toString(words));

        Arrays.sort(words, reverse(String::compareToIgnoreCase));
        System.out.println(Arrays.toString(words));        
    }
}

//_____________________________________________________
// import java.util.Random;

interface IntSequence {
    boolean hasNext();
    int next();
}

class AnonymousClassDemo {
    private static Random generator = new Random();

    public IntSequence randomInts(int low, int high) {
    	// Annonymous Classes : Class Without Name
        return new IntSequence() {
            public int next() { 
            	return low + generator.nextInt(high - low + 1); 
            }

            public boolean hasNext() { return true; }
        };

        // Compiler Will Generate Following Code For Above Lines
        // class TempIntSequence implements IntSequence {
        //     public int next() { 
        //     	return low + generator.nextInt(high - low + 1); 
        //     }

        //     public boolean hasNext() { return true; }        	
        // }

	    // IntSequence tempObjectIntSequence = new TempIntSequence();
        // return tempObjectIntSequence;
    }

    public void workingWithAnonymousClass() {
        //IntSequence dieTosses = tempObjectIntSequence.randomInts(1, 6);
        IntSequence dieTosses = randomInts(1, 6);
        for (int i = 0; i < 10; i++) System.out.println(dieTosses.next());

        // IntSequence something = new IntSequence(); // Error
    }
}

//_____________________________________________________

class LocalClassDemo {
    private Random generator = new Random();

    public IntSequence randomInts(int low, int high) {
        // Local Classes
        class RandomSequence implements IntSequence {
            public int next() { return low + generator.nextInt(high - low + 1); }
            public boolean hasNext() { return true; }
        }

        return new RandomSequence();
    }

    public void workingWithLocalClasses() {
        IntSequence dieTosses = randomInts(1, 6);
        for (int i = 0; i < 10; i++) System.out.println(dieTosses.next());
    }
}

//_____________________________________________________

class LambdaInJava {
	public static void playWithLocalClasses()  {
		LocalClassDemo object = new LocalClassDemo();
		object.workingWithLocalClasses();
	} 

	public static void playWithHigherAnonymousClassDemo()  {
		AnonymousClassDemo object = new AnonymousClassDemo();
		object.workingWithAnonymousClass();
	} 

	public static void playWithHigherOrderFunctions()  {
		HigherOrderFunctions object = new HigherOrderFunctions();
		object.workingWithHigherOrderFunctions();
	} 

	public static void playWithComparatorDemo()  {
		ComparatorDemo object = new ComparatorDemo();
		object.workingWithComparatorDemo();
	} 

	public static void playWithFunctionalInterfacesAgain()  {
		FunctionalInterfaceDemo object = new FunctionalInterfaceDemo();
		object.workingWithFunctionalInterfaces();
	} 

	public static void playWithFunctionalInterfaces() {
		FuncInterfaceDemo object = new FuncInterfaceDemo();
		object.workingWithFunctionalInterfaces();
	}

	public static void playWithConstructorReference() {
		ConstructorReferenceDemo object = new ConstructorReferenceDemo();
		object.workingWithConstructorReference();
	}

	public static void playWithFunctionReferences() {
		MethodReferenceDemo object = new MethodReferenceDemo();
		object.workingWithMethodReferences();
	}

	public static void playWithLambdaDemo() {
		LambdaDemo object = new LambdaDemo();
		object.workingWithLambda();
	}

	public static void main(String[] args) {
        System.out.println("\nFunction : playWithLambdaDemo");
        playWithLambdaDemo();

        System.out.println("\nFunction : playWithFunctionReferences");
        playWithFunctionReferences();
        
        System.out.println("\nFunction : playWithConstructorReference");
        playWithConstructorReference();

        System.out.println("\nFunction : playWithFunctionalInterfaces");
        playWithFunctionalInterfaces();
        
        System.out.println("\nFunction : playWithFunctionalInterfacesAgain");
        playWithFunctionalInterfacesAgain();
        
        System.out.println("\nFunction : playWithComparatorDemo");
        playWithComparatorDemo();

        System.out.println("\nFunction : playWithHigherOrderFunctions");
        playWithHigherOrderFunctions();
        
        System.out.println("\nFunction : playWithHigherAnonymousClassDemo");
        playWithHigherAnonymousClassDemo();

        System.out.println("\nFunction : playWithLocalClasses");
        playWithLocalClasses();
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
	}
}


