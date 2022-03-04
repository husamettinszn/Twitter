public class IntString {
    public static void main(String[] args) {

        String sayi = "12.00€";
        String a = sayi.replace("€", "");
        System.out.println(a);
        double sa = Double.valueOf(a);
        System.out.println(sa);

    }
    String sayi = "12.00€";
    String a = sayi.replace("€", "");
        System.out.println(a);
    double sa = Double.valueOf(a);
        System.out.println(sa);
}
