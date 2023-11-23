package OOP_HW_4;

public class Box<T extends Fruit> {

    private int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void add(T fruit) {
        weight += fruit.getWeight();
    }

    public void moveTo(Box<? super T> target) {
        target.setWeight(target.getWeight() + this.weight);
        this.weight = 0;
    }

}
