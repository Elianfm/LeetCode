import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    /*
     * First try was brute force it was suspiciously easy
     * So i realized this problem is about optimization
     * after some thinking i realized that we can keep a list of prefix products
     * 
     * Runtime: 15ms Beats 90.87%
     * Memory: 68.59MB Beats 88.46%
     */

     List<Integer> prefixProd;
     int lastZero;
 
     public ProductOfNumbers() {
         prefixProd = new ArrayList<>();
         prefixProd.add(1);
         lastZero = -1;
     }
 
     public void add(int num) {
         if (num == 0) {
             prefixProd.clear();
             prefixProd.add(1); 
             lastZero = prefixProd.size() - 1;
         } else {
             prefixProd.add(prefixProd.get(prefixProd.size() - 1) * num);
         }
     }
 
     public int getProduct(int k) {
         int size = prefixProd.size();
         if (size - k - 1 < lastZero) {
             return 0;
         }
         return prefixProd.get(size - 1) / prefixProd.get(size - k - 1);
     }
}
