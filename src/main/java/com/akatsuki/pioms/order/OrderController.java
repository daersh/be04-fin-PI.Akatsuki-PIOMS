package com.akatsuki.pioms.order;

import com.akatsuki.pioms.order.service.OrderService;
import com.akatsuki.pioms.order.vo.OrderListVO;
import com.akatsuki.pioms.order.vo.OrderVO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>발주 API</h1>
 * <br>
 * <h2>공통</h2>
 * 1. 상세 조회(/order/{orderId})<br>
 * 2.

 * <br><h2>관리자</h2>
 * 1. 모든 가맹점 발주 목록 조회(order/admin/{adminId}/orders)<br>
 * 2. 모든 가맹점 미처리된 발주 조회(order/admin/{adminId}/orders/unchecked)<br>
 * 3. 발주 승인(order/{orderId}/accept)<br>
 * 4. 발주 반려(order/{orderId}/deny)<br>

 * <br><h2>점주</h2>
 * 1. 발주 목록 조회(order/franchise/{franchiseId}/orders)<br>
 * 2. 신청 대기중인 발주 조회(order/franchise/orders/unchecked)<br>
 * 3. 거부 된 발주 조회(order/franchise/orders/denied)<br>
 * 4. 발주 신청하기(order/franchise)
 * */


@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * <h2>모든 가맹점 발주 목록 조회</h2>
     * */
    @GetMapping("/admin/{adminId}/orders")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderListVO> getFranchisesOrderList(@PathVariable int adminId){
        OrderListVO orderListVO = orderService.getFranchisesOrderList(adminId);
        return ResponseEntity.ok().body(orderListVO);
    }

    @GetMapping("/admin/{adminId}/unchecked-orders")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderListVO> getFranchisesUncheckedOrderList(@PathVariable int adminId){
        OrderListVO orderListVO = orderService.getFranchisesUncheckedOrderList(adminId);
        return ResponseEntity.ok().body(orderListVO);
    }


    /**
     * <h2>발주 생성</h2>
     * */
    @PostMapping("order/franchise")
    public ResponseEntity postFranchiseOrder(@RequestParam(name = "order") OrderVO order){
        orderService.postFranchiseOrder(order);
        return ResponseEntity.ok().build();
    }




}
