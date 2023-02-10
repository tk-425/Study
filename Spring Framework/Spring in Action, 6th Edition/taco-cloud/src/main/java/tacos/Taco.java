package tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Taco {

  private Long id;
  private Date createdAt = new Date();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @NotNull
  @Size(min = 1, message = "You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;

  @Override
  public String toString() {
    return "Taco{" +
        "id=" + id +
        ", createdAt=" + createdAt +
        ", name='" + name + '\'' +
        ", ingredients=" + ingredients +
        '}';
  }
}
