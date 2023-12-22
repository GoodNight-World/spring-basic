package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // qualifier를 사용한 어노테이션을 만들어 이 어노테이션이 붙은 것들 끼리 매칭되어 의존성 주입이 일어난다.
//@Primary // 스프링 컨테이너에서 의존성 주입을 할 때 주입할 수 있는 bean이 2개이상 일 경우, 이것에 우선 순위를 주어 주입 시킨다.
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
