package alex.tir.cloud_storage_back.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @Column(updatable = false)
    @SequenceGenerator(name = "id_sequence_generator", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_generator")
    @ToString.Include
    private Long id;
}
