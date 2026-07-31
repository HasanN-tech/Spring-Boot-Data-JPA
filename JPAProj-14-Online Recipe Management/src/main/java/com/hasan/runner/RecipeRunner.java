package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.RecipeBook;
import com.hasan.repository.RecipeBookRepository;
import com.hasan.services.RecipeBookService;

@Component
public class RecipeRunner implements CommandLineRunner {

	@Autowired
	private RecipeBookService rs;

	@SuppressWarnings("unused")
	@Autowired
	private RecipeBookRepository repo;

	public List<RecipeBook> listOfRecipeBooks() {
		RecipeBook recipe1 = new RecipeBook("Paneer Butter Masala", "Indian",
				List.of("Paneer", "Butter", "Tomato", "Onion", "Cream", "Spices"),
				List.of("Use fresh paneer for better taste", "Cook on low flame after adding cream",
						"Do not overcook the paneer"));

		RecipeBook recipe2 = new RecipeBook("Veg Fried Rice", "Chinese",
				List.of("Rice", "Carrot", "Beans", "Capsicum", "Soy Sauce", "Spring Onion"),
				List.of("Use cooled rice for best texture", "Cook vegetables on high flame",
						"Do not add too much soy sauce"));

		RecipeBook recipe3 = new RecipeBook("Margherita Pizza", "Italian",
				List.of("Pizza Dough", "Tomato Sauce", "Mozzarella Cheese", "Basil", "Olive Oil"),
				List.of("Preheat the oven properly", "Use fresh mozzarella cheese",
						"Bake at high temperature for a crispy crust"));

		RecipeBook recipe4 = new RecipeBook("Chicken Biryani", "Indian",
				List.of("Chicken", "Basmati Rice", "Yogurt", "Onion", "Biryani Masala", "Saffron"),
				List.of("Marinate chicken for at least 2 hours", "Use long-grain basmati rice",
						"Cook on dum for authentic flavor"));

		RecipeBook recipe5 = new RecipeBook("Chocolate Cake", "Dessert",
				List.of("Flour", "Cocoa Powder", "Sugar", "Eggs", "Butter", "Baking Powder"),
				List.of("Do not overmix the batter", "Preheat the oven before baking",
						"Allow the cake to cool before frosting"));
		return List.of(recipe1, recipe2, recipe3, recipe4, recipe5);
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.saveAll(listOfRecipeBooks());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> IO.println(rs.addData(new RecipeBook("Java", "NIT", List.of("SQL", "MYSQl", "Oracle"),
					List.of("eat", "sleep", "repeat"))));

			case 2 -> IO.println(rs.byId(3L));
			
			case 3 -> IO.println(rs.updateIngredients(2L, List.of("a","b","c")));
			
			case 4 -> IO.println(rs.delete(5L));
			
			case 5 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
