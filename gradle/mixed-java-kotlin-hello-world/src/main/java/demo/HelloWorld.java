package demo;

public class HelloWorld {
    public static void main(String[] args) {
        final KotlinGreetingJoiner example = new KotlinGreetingJoiner(new Greeter("Hi"));

        example.addName("Harry");
        example.addName("Ron");
        example.addName(null);
        example.addName("Hermione");

        System.out.println(example.getJoinedGreeting());
    }
}
