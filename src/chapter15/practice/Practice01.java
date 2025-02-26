package chapter15.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// 주문 목록에서 상품별 총 판매량 계산
@AllArgsConstructor
@Getter
@ToString
class Order {
	private String product;
	private int quantity;
}

public class Practice01 {
	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(
					new Order("노트북", 5),
					new Order("핸드폰", 6),
					new Order("태블릿", 1),
					new Order("스마트워치", 2),
					new Order("핸드폰", 4),
					new Order("이어폰", 3),
					new Order("노트북", 2)
				);
		
		// 상품별 총 판매량 계산
		// 1) 각 상품별 그룹화(분리)
		// 2) 해당 데이터에서 그룹화 된 요소의 quantity(수량)를 모두 더함 - summingInt
		// >> 총 판매량 계산
		
		Map<String, Integer> productsSales = orders.stream()
				.collect(Collectors.groupingBy(Order::getProduct,
						Collectors.summingInt(Order::getQuantity)));
		
		System.out.println(productsSales);
		
		
		
		
	}
}
