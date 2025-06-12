// put inside com.spring.ai; package to work with this 

//package com.spring.ai;
//
//
//import org.springframework.web.bind.annotation.*;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/diagram")
//public class DiagramController {
//
//    private final CodeDiagramGenerator diagramService;
//
//
//
//    public DiagramController(CodeDiagramGenerator diagramService) {
//		super();
//		this.diagramService = diagramService;
//	}
//
//	@PostMapping("/generate")
//    public Map<String, String> generateDiagram(@RequestBody String code) {
//        return diagramService.generateCodeDiagram(code);
//    }
//
//    @GetMapping("/test")
//    public Map<String, String> testDiagram() {
//        // Example Java code to test
//        String testCode = """
//        public class OrderService {
//            private final PaymentGateway paymentGateway;
//            private final InventoryService inventory;
//            
//            public Order processOrder(Order order) {
//                if (inventory.checkStock(order)) {
//                    paymentGateway.charge(order);
//                    inventory.updateStock(order);
//                    return order.confirm();
//                }
//                throw new InsufficientStockException();
//            }
//        }
//        """;
//        return diagramService.generateCodeDiagram(testCode);
//    }
//}


