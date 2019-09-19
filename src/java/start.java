public class start {
    public static void main(String args[]) {

        networkTools nt = new networkTools();
        String tata = nt.GET("http://www.example.com/");
        System.out.println(tata);

    }
}
