package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class RecipeBook {
	@Id
	@SequenceGenerator(name = "recipies", sequenceName = "recipe_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
	private Long recipeId;

	@NonNull
	@Column(length = 30)
	private String recipeName;

	@NonNull
	@Column(length = 20)
	private String cuisine;
	
	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ingredients",joinColumns = @JoinColumn(referencedColumnName = "recipeId",name = "id"))
	private List<String> ingerdients;

	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tips",joinColumns = @JoinColumn(referencedColumnName = "recipeId",name = "tips"))
	private List<String> cookingTips;


}
