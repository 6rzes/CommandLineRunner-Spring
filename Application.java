        package com.company;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));


            System.out.println("WSZYSCY");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer.toString());
            }

            System.out.println("JEDEN");
            Customer customer = repository.findOne(1L);
            System.out.println(customer);

            System.out.println("WYSZUKANY");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                System.out.println(bauer.toString());
            }

        };
    }

}