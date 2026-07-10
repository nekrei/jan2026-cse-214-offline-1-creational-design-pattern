package builders;

import java.time.LocalDateTime;

import model.DeliveryType;
import model.Order;
import model.PaymentMethod;

public interface IOrderBuilder {
    void setdeliveryType(DeliveryType deliveryType);
    void setdeliveryAddress(String address);
    void setpaymentMethod(PaymentMethod paymentMethod);
    void setscheduledTime(LocalDateTime time);
    void setcouponCode(String code);
    void setgiftWrap(boolean giftWrap);
    void setcutleryRequired(boolean cutlery);
    void setloyaltyPoints(int points);
    void setrushOrder(boolean rush);
    void setspecialInstructions(String instructions);
    Order build();
}
