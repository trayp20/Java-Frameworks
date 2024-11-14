package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Check if the database is empty for parts and products
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // Adding sample computer parts using setter methods
            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setName("CPU");
            cpu.setInv(50);
            cpu.setPrice(320.0);
            cpu.setCompanyName("Intel Co");
            cpu.setMinInv(10);
            cpu.setMaxInv(100);
            partRepository.save(cpu);

            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setName("GPU");
            gpu.setInv(30);
            gpu.setPrice(780.0);
            gpu.setCompanyName("Nvidia");
            gpu.setMinInv(5);
            gpu.setMaxInv(50);
            partRepository.save(gpu);

            OutsourcedPart ram = new OutsourcedPart();
            ram.setName("RAM");
            ram.setInv(200);
            ram.setPrice(70.0);
            ram.setCompanyName("Crucial");
            ram.setMinInv(5);
            ram.setMaxInv(200);
            partRepository.save(ram);

            OutsourcedPart ssd = new OutsourcedPart();
            ssd.setName("SSD");
            ssd.setInv(150);
            ssd.setPrice(100.0);
            ssd.setCompanyName("Samsung");
            ssd.setMinInv(5);
            ssd.setMaxInv(200);
            partRepository.save(ssd);

            OutsourcedPart powerSupply = new OutsourcedPart();
            powerSupply.setName("Power Supply");
            powerSupply.setInv(100);
            powerSupply.setPrice(85.0);
            powerSupply.setCompanyName("Corsair");
            powerSupply.setMinInv(5);
            powerSupply.setMaxInv(200);
            partRepository.save(powerSupply);

            // Adding sample computer products
            Product gamingPc = new Product();
            gamingPc.setName("Gaming PC");
            gamingPc.setPrice(1500.0);
            gamingPc.setInv(10);
            productRepository.save(gamingPc);

            Product workstationPc = new Product();
            workstationPc.setName("Workstation PC");
            workstationPc.setPrice(2000.0);
            workstationPc.setInv(5);
            productRepository.save(workstationPc);

            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setPrice(1200.0);
            laptop.setInv(15);
            productRepository.save(laptop);

            Product tablet = new Product();
            tablet.setName("Tablet");
            tablet.setPrice(300.0);
            tablet.setInv(20);
            productRepository.save(tablet);

            Product server = new Product();
            server.setName("Server");
            server.setPrice(5000.0);
            server.setInv(2);
            productRepository.save(server);

            System.out.println("Sample computer inventory added.");
        } else {
            System.out.println("Database already has existing entries.");
        }

//       List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
