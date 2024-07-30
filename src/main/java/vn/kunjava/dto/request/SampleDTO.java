package vn.kunjava.dto.request;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SampleDTO implements Serializable {
    private Integer id;
    @EqualsAndHashCode.Include
    private String name;
}
