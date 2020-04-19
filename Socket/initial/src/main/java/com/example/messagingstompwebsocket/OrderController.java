package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class OrderController {

	 @MessageMapping("/order")
	  @SendTo("/topic/orders")
	  public ReceivedOrder receivedOrder(Order order) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new ReceivedOrder("Order in, " + HtmlUtils.htmlEscape(order.getName()) + "!");
	  }
	
}
