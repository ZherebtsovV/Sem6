package OOP_HW_4;

public class Program {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box(); 
        Box<Orange> orangeBox = new Box(); 
        Box<GoldenApple> goldenAppleBox = new Box(); 
        Box<Fruit> fruinBox = new Box(); 

        appleBox.add(new Apple(1)); 
        appleBox.add(new GoldenApple(4)); 

        System.out.println(appleBox.getWeight()); //5

        orangeBox.add(new Orange(10));
        fruinBox.add(new Orange(11));
        goldenAppleBox.add(new GoldenApple(2));

        System.out.println(goldenAppleBox.getWeight()); //2
        System.out.println(orangeBox.getWeight()); //21

        goldenAppleBox.moveTo(appleBox); 
        orangeBox.moveTo(fruinBox); 

        System.out.println(goldenAppleBox.getWeight()); 
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight()); 
        System.out.println(fruinBox.getWeight()); 

        // 3.*
        // for (GoldenApple apple: goldenAppleBox) { // должно работать

        // }
    }
    
}
