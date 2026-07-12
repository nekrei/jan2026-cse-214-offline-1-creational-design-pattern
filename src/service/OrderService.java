package service;

import model.DeliveryType;
import model.MenuItem;
import model.Order;
import model.OrderBuilder;
import model.OrderItem;
import model.PaymentMethod;
import model.Size;

import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.List;


/**
 * Coordinates order creation.
 *
 * Several methods below repeat long Order constructor calls with many optional
 * parameters. That is intentional assignment material for refactoring.
 */
public class OrderService {
    private int nextNumber = 1001;

    public OrderItem createOrderItem(MenuItem item, int quantity, Size size, boolean extraCheese, boolean spicy, String note) {
        return new OrderItem(item, quantity, size, extraCheese, spicy, note);
    }

    public Order createDeliveryOrder(String customerName,
                                     String phone,
                                     String address,
                                     List<OrderItem> items,
                                     String couponCode,
                                     boolean rushOrder,
                                     String specialInstructions) {
        OrderBuilder builder = new OrderBuilder(nextOrderId(), customerName, phone, items);
        builder.setdeliveryType(DeliveryType.DELIVERY);
        builder.setdeliveryAddress(address);
        builder.setcouponCode(couponCode);
        builder.setrushOrder(rushOrder);
        builder.setspecialInstructions(specialInstructions);
        return builder.build();
    }

    public Order createPickupOrder(String customerName, String phone, List<OrderItem> items) {
        OrderBuilder builder = new OrderBuilder(nextOrderId(), customerName, phone, items);
        builder.setdeliveryType(DeliveryType.PICKUP);
        builder.setcutleryRequired(true);
        return builder.build();
    }

    public Order createScheduledGiftOrder(String customerName,
                                          String phone,
                                          String address,
                                          List<OrderItem> items,
                                          LocalDateTime scheduledTime) {
        OrderBuilder builder = new OrderBuilder(nextOrderId(), customerName, phone, items);
        builder.setdeliveryType(DeliveryType.DELIVERY);
        builder.setdeliveryAddress(address);
        builder.setscheduledTime(scheduledTime);
        builder.setpaymentMethod(PaymentMethod.CARD);
        builder.setcouponCode("WELCOME10");
        builder.setgiftWrap(true);
        builder.setcutleryRequired(false);
        builder.setloyaltyPoints(25);
        builder.setrushOrder(false);
        builder.setspecialInstructions("Please call before delivery");
        return builder.build();
    }

    public Order createSampleFamilyOrder(MenuCatalog catalog) {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(catalog.findByCode("P01"), 2, Size.LARGE, true, false, "half spicy"));
        items.add(new OrderItem(catalog.findByCode("B02"), 3, Size.MEDIUM, true, true, ""));
        items.add(new OrderItem(catalog.findByCode("D02"), 4, Size.MEDIUM, false, false, "less sugar"));
        items.add(new OrderItem(catalog.findByCode("S02"), 2, Size.LARGE, false, true, ""));
        OrderBuilder builder = new OrderBuilder(nextOrderId(), "Sample Family", "01711111111", items);
        builder.setdeliveryType(DeliveryType.DELIVERY);
        builder.setdeliveryAddress("House 25, Road 4, Dhanmondi");
        builder.setpaymentMethod(PaymentMethod.MOBILE_BANKING);
        builder.setcouponCode("FAMILY15");
        builder.setcutleryRequired(true);
        builder.setloyaltyPoints(50);
        builder.setrushOrder(true);
        builder.setspecialInstructions("Deliver together");
        return builder.build();
    }

    private String nextOrderId() {
        return "FF-" + nextNumber++;
    }
}

