import com.Database.Practicedemo.DAO.ProductRepo;
import com.Database.Practicedemo.Model.Product;
import com.Database.Practicedemo.Service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    Logger logger= LoggerFactory.getLogger(ProductControllerTest.class);

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepo prodrepo;

    public static Product prod1 = new Product(101, "Vivo", 10000);
    public static Product prod2 = new Product(102, "Motorola", 20000);
    public static Product prod3 = new Product(103, "Samsung", 40000);
    public static Product prod4 = new Product(104, "Iphone", 70000);

    public static List<Product> products=null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        products= Arrays.asList(prod1, prod2, prod3, prod4);
    }

    @BeforeEach
    public void setUp() {
       MockitoAnnotations.initMocks(this);

    }



    @Test
    public void getAllProducts(){

        logger.info("Running test getAllProducts");
        Mockito.when(prodrepo.findAll()).thenReturn(products);
        List<Product> det = productService.productlist();
        det.forEach(System.out::println);
        Assertions.assertNotNull(det);

    }

    @Test
    public void getProductById(){

        logger.info("Running test getProductById");
        Mockito.when(prodrepo.findById(ArgumentMatchers.anyInt())).
                thenReturn(products.stream().filter(product -> product.getId() == 100).findFirst());

        Product resprod= productService.getProductByID(100);
        System.out.println("Test 2:---->" +resprod);
        Assertions.assertNull(resprod.getProdName());
        //Assertions.assertEquals(resprod, prod1);

    }

}
