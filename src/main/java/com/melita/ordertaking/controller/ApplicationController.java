package com.melita.ordertaking.controller;

import com.melita.ordertaking.config.MessagingConfig;
import com.melita.ordertaking.constants.REST_URI;
import com.melita.ordertaking.constants.AppCons;
import com.melita.ordertaking.domain.OrderTakeRequest;
import com.melita.ordertaking.domain.ResponseHeader;
import com.melita.ordertaking.dto.OrderStatus;
import com.melita.ordertaking.service.TakeOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(REST_URI.MAIN)
public class ApplicationController {
	@Autowired
	TakeOrderService takeOrderService;

	@GetMapping(REST_URI.TEST)
		public String chekAPI() {
			return AppCons.API_CHECK;
	}

	@Autowired
	RabbitTemplate template;

	@PostMapping(REST_URI.TAKEORDER)
	public ResponseHeader bookOrder(@RequestBody OrderTakeRequest orderRequest){
		OrderStatus orderStatus = null;
		ResponseHeader responseHeader = null;
		try {
			//validate orderRequest
			boolean isValid = takeOrderService.validateOrderRequet(orderRequest);

			if (isValid) {
				orderStatus = new OrderStatus(orderRequest, AppCons.ORDER_STATUS_IMPR, AppCons.SUCCESS_DESC);
				responseHeader = new ResponseHeader(AppCons.SUCCESS_CODE, AppCons.SUCCESS_DESC);
			} else {
				orderStatus = new OrderStatus(orderRequest, AppCons.ORDER_STATUS_ERROR, AppCons.ERROR_DESC);
				responseHeader = new ResponseHeader(AppCons.ERROR_CODE, AppCons.ERROR_DESC);
			}

			template.convertAndSend(AppCons.ExchangeName, AppCons.RoutingKey, orderStatus);
		}catch(Exception ex){
			responseHeader = new ResponseHeader(AppCons.ERROR_CODE, ex.getMessage());
			// we can set log4j and print the error log also.
		}
		return responseHeader;

		// inside this method we can inert try catch statememnts to catch various errors. And then set the
	}


}
