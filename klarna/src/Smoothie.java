import java.util.*;

class Smoothie {

    static class OrderInput {
        private String smoothieName;
        private List<String> ingredientsToBeRemoved;

        OrderInput(String smoothieName, List<String> ingredientsToBeRemoved) {
            this.smoothieName = smoothieName;
            this.ingredientsToBeRemoved = ingredientsToBeRemoved;
        }

        String getSmoothieName() {
            return smoothieName;
        }

        List<String> getIngredientsToBeRemoved() {
            return ingredientsToBeRemoved;
        }

    }

    public static String ingredients(String order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }
        Map<String, List<String>> smoothieToIngredientMap = getSmoothieToIngredientMap();
        String[] orderAndAdditionalIngredients = order.split(",");
        OrderInput orderInput = getOrderInput(orderAndAdditionalIngredients);
        List<String> ingredientsOfSmoothie = getIngredients(smoothieToIngredientMap, orderInput.getSmoothieName());
        return getFinalIngredientList(ingredientsOfSmoothie, orderInput);
    }

    private static OrderInput getOrderInput(String[] orderAndAdditionalIngredients) {
        List<String> ingredientsToBeRemoved = new ArrayList<>();
        for (int i = 1; i < orderAndAdditionalIngredients.length; i++) {
            String inputIngredient = orderAndAdditionalIngredients[i].toLowerCase();
            if (inputIngredient.contains("-")) {
                String ingredientToBeRemoved = inputIngredient.substring(1);
                ingredientsToBeRemoved.add(ingredientToBeRemoved);
            } else {
                throw new IllegalArgumentException("Ingredient cannot be added!");
            }
        }
        String smoothieName = orderAndAdditionalIngredients[0].toLowerCase();
        return new OrderInput(smoothieName, ingredientsToBeRemoved);
    }

    private static List<String> getIngredients(Map<String, List<String>> smoothieToIngredientMap, String smoothieName) {
        List<String> listOfIngredients = smoothieToIngredientMap.getOrDefault(smoothieName, null);
        if (listOfIngredients == null) {
            throw new IllegalArgumentException(String.format("Smoothie name %s is invalid", smoothieName));
        }
        return listOfIngredients;
    }

    private static Map<String, List<String>> getSmoothieToIngredientMap() {
        Map<String, List<String>> smoothieToIngredientMap = new HashMap<>();
        smoothieToIngredientMap.put("classic", Arrays.asList("banana", "honey", "mango", "peach", "pineapple", "strawberry"));
        smoothieToIngredientMap.put("freezie", Arrays.asList("black currant", "blackberry", "blueberry", "frozen yogurt", "grape juice"));
        smoothieToIngredientMap.put("greenie", Arrays.asList("apple juice", "avocado", "green apple", "ice", "lime", "spinach"));
        smoothieToIngredientMap.put("just desserts", Arrays.asList("banana", "cherry", "chocolate", "ice cream", "peanut"));
        return smoothieToIngredientMap;
    }

    private static String getFinalIngredientList(List<String> ingredientsOfSmoothie, OrderInput orderInput) {
        List<String> ingredientsToBeRemoved = orderInput.getIngredientsToBeRemoved();

        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < ingredientsOfSmoothie.size(); index++) {
            String ingredient = ingredientsOfSmoothie.get(index);
            if (ingredientsToBeRemoved.contains(ingredient)) {
                continue;
            }
            if (index == 0 || stringBuilder.length() == 0) {
                stringBuilder.append(String.format("%s", ingredient));
            } else {
                stringBuilder.append(String.format(",%s", ingredient));
            }
        }
        return stringBuilder.toString();
    }
}