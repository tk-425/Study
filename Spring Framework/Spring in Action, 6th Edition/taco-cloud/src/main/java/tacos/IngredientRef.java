package tacos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientRef {
  private final String ingredient;

  @Override
  public String toString() {
    return "IngredientRef{" +
        "ingredient='" + ingredient + '\'' +
        '}';
  }
}
