class test{

public static void main(String[] args) {
    int res = 0;
    int n = 9;
        while(n != 0){
            res++;
            System.out.println(n-1);
            
            n = n & (n-1);
        }
        System.out.println(res);
}
}
  