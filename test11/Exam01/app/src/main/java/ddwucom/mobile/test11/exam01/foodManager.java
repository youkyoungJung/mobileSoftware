package ddwucom.mobile.test11.exam01;

import java.util.ArrayList;

public class foodManager{

        ArrayList<Food> foodList;

    public foodManager(){

        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
    public void deleteFood(int index){
        foodList.remove(index);
    }
    public void addFood(Food food){
        foodList.add(food);
    }

}
