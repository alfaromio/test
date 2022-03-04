package com.melita.ordertaking.constants;

public class AppCons {
    //Messages
    public static String API_CHECK = "API SERVICE UP AND RUNNING";

    // Constant Values
    public  static String QueueName = "OrderQueue";
    public  static String ExchangeName = "OrderExchange";
    public  static String RoutingKey = "melita_key";


    //Response Code
    public  static String SUCCESS_CODE = "1111";
    public  static String ERROR_CODE = "0000";

    //Response Description
    public  static String SUCCESS_DESC = "Order is recieved and Confirmed";
    public  static String ERROR_DESC = "Order Validation Fail";

    //order status
    public  static String ORDER_STATUS_SUCCESS = "SUCCESS";
    public  static String ORDER_STATUS_IMPR = "INPROCESS";
    public  static String ORDER_STATUS_ERROR = "ERROR";

}
