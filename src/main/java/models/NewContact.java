package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class NewContact {
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}
