package builders;

import java.time.LocalDateTime;
import java.util.List;

import model.DeliveryType;
import model.Order;
import model.OrderItem;
import model.PaymentMethod;

public class OrderBuilder implements IOrderBuilder {
    private String orderId;
    private String customerName;
    private String phone;
    private List<OrderItem> items;
    //optional 
    private DeliveryType deliveryType = DeliveryType.PICKUP;
    private String deliveryAddress    = "";
    private PaymentMethod paymentMethod = PaymentMethod.CASH;
    private LocalDateTime scheduledTime = null;
    private String couponCode           = "";
    private boolean giftWrap            = false;
    private boolean cutleryRequired     = true;
    private int loyaltyPointsToRedeem   = 0;
    private boolean rushOrder           = false;
    private String specialInstructions  = "";

   

    public OrderBuilder(String orderId, String customerName, String phone, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phone = phone;
        this.items = items;
    }

    @Override
    public void setdeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public void setdeliveryAddress(String address) {
        this.deliveryAddress = address;
    }

    @Override
    public void setpaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void setscheduledTime(LocalDateTime time) {
        this.scheduledTime = time;
    }

    @Override
    public void setcouponCode(String code) {
        this.couponCode = code;
    }

    @Override
    public void setgiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    @Override
    public void setcutleryRequired(boolean cutlery) {
        this.cutleryRequired = cutlery;
    }

    @Override
    public void setloyaltyPoints(int points) {
        this.loyaltyPointsToRedeem = points;
    }

    @Override
    public void setrushOrder(boolean rush) {
        this.rushOrder = rush;
    }

    @Override
    public void setspecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }

    @Override
    public Order build() {
        
        return new Order(orderId,customerName,phone,deliveryType,deliveryAddress,paymentMethod,scheduledTime,couponCode,
            giftWrap,cutleryRequired,loyaltyPointsToRedeem,rushOrder,items,specialInstructions
        );
    }
    
    
}
