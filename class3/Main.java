public class Main {
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("helloo");
            }
        });
        Thread two = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("world");
            }
        });
        one.start();
        two.start();
    }
}
