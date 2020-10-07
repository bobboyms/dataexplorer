package br.com.next.dataexplorer.modeldto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto {

    private Long id;
    private String name;
    private String age;

}
