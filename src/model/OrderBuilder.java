package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderBuilder {
    String orderId;
    String customerName;
    String phone;
    List<OrderItem> items;
    //optional 
    DeliveryType deliveryType = DeliveryType.PICKUP;
    String deliveryAddress    = "";
    PaymentMethod paymentMethod = PaymentMethod.CASH;
    LocalDateTime scheduledTime = null;
    String couponCode           = "";
    boolean giftWrap            = false;
    boolean cutleryRequired     = true;
    int loyaltyPointsToRedeem   = 0;
    boolean rushOrder           = false;
    String specialInstructions  = "";

   

    public OrderBuilder(String orderId, String customerName, String phone, List<OrderItem> items) {
        this.orderId = requireNonBlank(orderId, "Order id");
        this.customerName = requireNonBlank(customerName, "Customer name");
        this.phone = requireNonBlank(phone, "Phone");

        Objects.requireNonNull(items, "Items cannot be null");
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
    }

    public void setdeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void setdeliveryAddress(String address) {
        this.deliveryAddress = address;
    }

    public void setpaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setscheduledTime(LocalDateTime time) {
        this.scheduledTime = time;
    }

    public void setcouponCode(String code) {
        this.couponCode = code;
    }

    public void setgiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    public void setcutleryRequired(boolean cutlery) {
        this.cutleryRequired = cutlery;
    }

    public void setloyaltyPoints(int points) {
        this.loyaltyPointsToRedeem = points;
    }

    public void setrushOrder(boolean rush) {
        this.rushOrder = rush;
    }

    public void setspecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }

    public Order build() {
        this.couponCode = couponCode.trim().toUpperCase();
        this.loyaltyPointsToRedeem = Math.max(0, loyaltyPointsToRedeem);
        this.specialInstructions = specialInstructions.trim();

        if (this.deliveryType == DeliveryType.DELIVERY) {
            this.deliveryAddress = requireNonBlank(deliveryAddress, "Delivery address");
        } else {
            this.deliveryAddress = deliveryAddress.trim();
        }
        return new Order(this);
    }
    
    private static String requireNonBlank(String value, String fieldName) {
        Objects.requireNonNull(value, fieldName + " cannot be null");
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }
        return trimmed;
    }
}
