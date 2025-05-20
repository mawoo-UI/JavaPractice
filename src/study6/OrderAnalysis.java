package study6;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderAnalysis {
	public static void main(String[] args) {
		// 샘플 데이터 생성
        List<Order> orders = createSampleOrders();
        
        // 1. 카테고리별 총 매출액 계산
        Map<String, Double> salesByCategory = orders.stream()
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.summingDouble(Product::getPrice)
            ));
        
        System.out.println("카테고리별 매출액: " + salesByCategory);
        
        // 2. 월별 총 주문 금액 계산
        Map<Month, Double> salesByMonth = orders.stream()
                .collect(Collectors.groupingBy(
                    order -> order.getOrderDate().getMonth(),
                    Collectors.summingDouble(Order::getTotalPrice)
                ));
        System.out.println("월별 매출액: " + salesByMonth);
        
        // 3. 가장 많이 주문한 고객 찾기
        Map.Entry<String, Long> topCustomer = orders.stream()
        		.collect(Collectors.groupingBy(
        				Order::getCustomerName,
        				Collectors.counting()
        				))
        		.entrySet().stream()
        		.max(Map.Entry.comparingByValue())
        		.orElse(null);
        
        if (topCustomer != null) {
			System.out.println("최다 주문 고객: " + topCustomer.getKey() + "(" + topCustomer.getValue() + "회");
			
		} 
        
        // 4. 평균 주문 금액이 5만원 이상인 고객 목록
        Map<String, Double> avgOrderByCustomer = orders.stream()
        		.collect(Collectors.groupingBy(
        				Order::getCustomerName,
        				Collectors.averagingDouble(Order::getTotalPrice)
        				));
        
        List<String> vipCustomers = avgOrderByCustomer.entrySet().stream()
        		.filter(entry -> entry.getValue() >= 50000)
        		.map(Map.Entry::getKey)
        		.collect(Collectors.toList());
        
        System.out.println("VIP 고객 목록: " + vipCustomers);
	}
	
	private static List<Order> createSampleOrders() {
        // 샘플 상품 생성
        Product p1 = new Product("전자제품", "스마트폰", 85000);
        Product p2 = new Product("전자제품", "노트북", 120000);
        Product p3 = new Product("의류", "티셔츠", 25000);
        Product p4 = new Product("의류", "청바지", 45000);
        Product p5 = new Product("식품", "과일세트", 35000);
        Product p6 = new Product("식품", "커피", 15000);
        
        // 샘플 주문 생성
        List<Order> orders = new ArrayList<>();
        
        orders.add(new Order("O001", "김철수", Arrays.asList(p1, p3), LocalDate.of(2023, 3, 10)));
        orders.add(new Order("O002", "이영희", Arrays.asList(p2, p4), LocalDate.of(2023, 3, 15)));
        orders.add(new Order("O003", "박민수", Arrays.asList(p5, p6), LocalDate.of(2023, 4, 2)));
        orders.add(new Order("O004", "김철수", Arrays.asList(p3, p4, p6), LocalDate.of(2023, 4, 10)));
        orders.add(new Order("O005", "정수정", Arrays.asList(p1, p2), LocalDate.of(2023, 4, 20)));
        orders.add(new Order("O006", "이영희", Arrays.asList(p5), LocalDate.of(2023, 5, 5)));
        orders.add(new Order("O007", "김철수", Arrays.asList(p2, p6), LocalDate.of(2023, 5, 15)));
        
        return orders;
		
	}
}
