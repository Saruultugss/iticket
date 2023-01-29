package com.saruul.iticket.form;

import lombok.Data;

@Data
public class TicketCategoryForm {
    private Long id;
    private String name;
    private Integer amount;
    private Integer price;
    private Integer max;
    private String description;
}
