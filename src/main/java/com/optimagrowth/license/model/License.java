package com.optimagrowth.license.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class License extends RepresentationModel<License> {

    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;

}
