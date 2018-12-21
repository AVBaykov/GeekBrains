public class Bowl {

    private int foodLimit;
    private int currentFood;

    public Bowl(int foodLimit) {
        this.foodLimit = foodLimit;
        this.currentFood = foodLimit;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void reduceFood(int appetite) {
        currentFood = currentFood >= appetite ? currentFood - appetite : currentFood;
    }

    public void refill() {
        System.out.println("В миске кончилась еда, но это не беда. Наполняем");
        this.currentFood = foodLimit;
    }
}
