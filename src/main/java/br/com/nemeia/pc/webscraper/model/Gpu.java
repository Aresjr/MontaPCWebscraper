package br.com.nemeia.pc.webscraper.model;

import br.com.nemeia.pc.webscraper.enums.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
public class Gpu {

    private Integer code;
    private String name;
    private GpuManufacturer manufacturer;
    private String image;
    private Double price;
    private Double oldPrice;
    private String maxInstallment;
    private Double priceWithDiscount;
    private Integer rating;
    private Integer ratingCount;
    private Boolean available;
    private String thumbnail;
    @JsonIgnore
    private Store store;

}
