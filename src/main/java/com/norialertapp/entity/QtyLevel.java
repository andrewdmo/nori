package com.norialertapp.entity;
import javax.persistence.*;
import java.util.List;

/**
 * Created by katherine_celeste on 9/30/16.
 */

@Entity
public class QtyLevel {

    @Id
    @GeneratedValue
    private Long id;

    private Long product_id;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="qtyLevelID")
    private List<level> productLevels;


 //   private HashMap<String, Integer> levels;


}
