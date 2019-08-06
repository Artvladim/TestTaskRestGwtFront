package netcracker.homework.testTask.service;

import netcracker.homework.testTask.dao.ProductDao;
import netcracker.homework.testTask.dao.ShopDao;
import netcracker.homework.testTask.dto.ProductDto;
import netcracker.homework.testTask.dto.ShopDto;
import netcracker.homework.testTask.mapper.ProductMapper;
import netcracker.homework.testTask.mapper.ShopMapper;
import netcracker.homework.testTask.repository.ProductRepository;
import netcracker.homework.testTask.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service //вся бизнес-логика (все алгоритмика)
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopRepository shopRepository;

    public List<ProductDto> retrieveAll() {
        List<ProductDao> productDaoList = productRepository.findAll();
        return productMapper.mapCollectionToDto(productDaoList);
    }

    public List<ProductDto> retrieveByProductId(Integer id) {
        List<ProductDao> productDaoList = productRepository.findAll(); //сходил в базу, вытащил все продукты из базы

        List<ProductDao> filteredProductsByProductId = new ArrayList<>(); //куда мы кладем отфильтрованные заказы
        for (ProductDao productDao : productDaoList) {
            if (productDao.getId() == id) {
                filteredProductsByProductId.add(productDao);
            }
        }

        return productMapper.mapCollectionToDto(filteredProductsByProductId); //преобразование данных из таблицы в json (мапинг dao в dto)
    }

    public List<ShopDto> retrieveShopsWhereProductsAre(Integer productId) {
        List<ShopDao> shopDaoList = shopRepository.findAll(); //сходил в базу, вытащил все продукты из базы
        List<ShopDao> filteredShopsByProductId = new ArrayList<>(); //куда мы кладем отфильтрованные заказы
        for (ShopDao shopDao : shopDaoList) {
            Set<ProductDao> products = shopDao.getProducts();
            boolean contains = false;
            for (ProductDao productDao : products) {
                if(productDao.getId().equals(productId)) {
                    contains = true;
                }

            }
            if (contains) {
                filteredShopsByProductId.add(shopDao);
            }
        }
        return shopMapper.mapCollectionToDto(filteredShopsByProductId);
    }
}
