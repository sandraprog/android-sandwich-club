package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            Sandwich sandwich = new Sandwich();
            JSONObject sandwichJsonObject = new JSONObject(json);

            sandwich.setImage(sandwichJsonObject.getString("image"));
            sandwich.setDescription(sandwichJsonObject.getString("description"));
            sandwich.setPlaceOfOrigin(sandwichJsonObject.getString("placeOfOrigin"));

            JSONObject nameJsonObject = sandwichJsonObject.getJSONObject("name");
            sandwich.setMainName(nameJsonObject.getString("mainName"));

            JSONArray alsoKnownAsJsonArray = nameJsonObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);

            JSONArray ingredientsJsonArray = sandwichJsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredients.add(ingredientsJsonArray.getString(i));
            }
            sandwich.setIngredients(ingredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
