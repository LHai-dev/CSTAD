package co.istad.mbanking.api.accounttype;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
    private Integer id;

    private Boolean isDeleted;
    private String name;

}
