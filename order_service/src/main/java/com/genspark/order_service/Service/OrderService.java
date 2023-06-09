package com.genspark.order_service.Service;

import com.genspark.order_service.Dao.ItemDao;
import com.genspark.order_service.Dao.OrderDao;
import com.genspark.order_service.Entity.MenuItem;
import com.genspark.order_service.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements OrderServiceInt{
    List<MenuItem> listMenu;
    @Autowired
    private ItemDao itemDao;
    List<Order> list;
     LocalDateTime orderDate = LocalDateTime.now();
     @Autowired
    private OrderDao orderDao;
     //@Autowired
    //private OrderItemDao orderItemDao;


    public OrderService() {

    }

    @Override
    public Order addOrder(Order order) {
        return this.orderDao.save(order);
    }

    //@Override
    //public OrderItem addOrderItem(OrderItem orderItem) {
      //  return this.orderItemDao.save(orderItem);
    //}

   // @Override
    //public List<Order> getAllOrder() {
      //  return list;
    //}

    //@Override
    //public List<MenuItem> getItems() {
      //  return listMenu;
    //}

    @Override
    public MenuItem addItem(MenuItem menuItem) {
        return this.itemDao.save(menuItem);
    }

    @Override
    public String deleteItemById(long itemId) {
        this.itemDao.deleteById(itemId);
        return "Deleted Menu Item Successfully";

    }
}
