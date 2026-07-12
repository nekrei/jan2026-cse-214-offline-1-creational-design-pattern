package directors;

import java.time.LocalDateTime;

import model.DeliveryType;
import model.OrderBuilder;
import model.PaymentMethod;

public class Director {
    private OrderBuilder builder;

    public Director(OrderBuilder builder) {
        this.builder = builder;
    }

    public void buildDeliveryOrder(String adress, String coupon, boolean rushOrder, String specialInstructions) {
        builder.setdeliveryType(DeliveryType.DELIVERY);
        builder.setdeliveryAddress(adress);
        builder.setcouponCode(coupon);
        builder.setrushOrder(rushOrder);
        builder.setspecialInstructions(specialInstructions);
    }

    public void buildPickupOrder() {
        builder.setdeliveryType(DeliveryType.PICKUP);
        builder.setcutleryRequired(true);
    }
    
    public void buildScheduledGiftOrder(String address, LocalDateTime scheduledTime) {
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
    }

    public void buildSampleFamilyOrder() {
        builder.setdeliveryType(DeliveryType.DELIVERY);
        builder.setdeliveryAddress("House 25, Road 4, Dhanmondi");
        builder.setpaymentMethod(PaymentMethod.MOBILE_BANKING);
        builder.setcouponCode("FAMILY15");
        builder.setcutleryRequired(true);
        builder.setloyaltyPoints(50);
        builder.setrushOrder(true);
        builder.setspecialInstructions("Deliver together");
    }
}
