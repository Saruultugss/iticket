package com.saruul.iticket.form;

import lombok.Data;

@Data
public class TicketBuy {
    private Long customerId;
    private Long ticketCategoryId;
    private int count;
}
